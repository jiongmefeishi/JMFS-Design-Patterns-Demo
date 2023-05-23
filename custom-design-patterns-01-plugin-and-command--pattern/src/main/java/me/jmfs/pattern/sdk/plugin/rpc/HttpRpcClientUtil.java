package me.jmfs.pattern.sdk.plugin.rpc;

import com.google.common.base.Strings;
import org.apache.commons.io.IOUtils;
import org.apache.http.Consts;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;

import java.io.IOException;
import java.io.InputStream;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: 囧么肥事
 * @Date: 2023/5/10
 * @Email: jiongmefeishi@163.com
 * @Url("https://gitee.com/jiongmefeishi")
 * @Description: HttpRpcClientUtil
 */
public class HttpRpcClientUtil {
    private static final String ENCODING = "UTF-8";
    private static final String EMPTY_PAYLOAD = "-";
    public static final String FORM_CONTENT_TYPE = "application/x-www-form-urlencoded";
    public static final String JSON_CONTENT_TYPE = "application/json";
    private static final String CONTENT_TYPE_HEADER = "Content-Type";
    private static final String USER_AGENT = "AHAS Gateway 1.2.3";
    private static final int MAX_SIMULTANEOUS_CONNECTIONS = 100;
    private static final int FULL_CONNECTION_TIMEOUT_S = 30;
    private static final int CONNECTION_TIMEOUT_MS = 3_000;
    private static final int SOCKET_TIMEOUT_MS = FULL_CONNECTION_TIMEOUT_S * 1000;
    private static final ConnectionsSupervisor SUPERVISOR = new ConnectionsSupervisor();
    private static HttpRpcClientUtil instance;
    private static HttpClient httpClient;

    public HttpRpcClientUtil() {
        CookieStore cookieStore = new BasicCookieStore();
        RequestConfig requestConfig = RequestConfig.custom()
            .setSocketTimeout(SOCKET_TIMEOUT_MS)
            .setConnectTimeout(CONNECTION_TIMEOUT_MS)
            .setConnectionRequestTimeout(CONNECTION_TIMEOUT_MS)
            .setCookieSpec(CookieSpecs.STANDARD)
            .build();

        PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager();

        connectionManager.setMaxTotal(MAX_SIMULTANEOUS_CONNECTIONS);
        connectionManager.setDefaultMaxPerRoute(MAX_SIMULTANEOUS_CONNECTIONS);

        httpClient = HttpClients.custom()
            .setConnectionManager(connectionManager)
            .setDefaultRequestConfig(requestConfig)
            .setDefaultCookieStore(cookieStore)
            .setUserAgent(USER_AGENT)
            .build();
    }

    public static HttpRpcClientUtil getInstance() {
        if (instance == null) {
            instance = new HttpRpcClientUtil();
        }

        return instance;
    }

    private static Map<String, String> getHeaders(Header[] headers) {
        Map<String, String> result = new HashMap<>();
        for (Header header : headers) {
            result.put(header.getName(), header.getValue());
        }

        return result;
    }

    private HttpRpcClientResponse call(HttpRequestBase request) throws IOException {
        try {
            SUPERVISOR.addRequest(request);
            HttpResponse response = httpClient.execute(request);
            try (InputStream content = response.getEntity().getContent()) {
                String result = IOUtils.toString(content, ENCODING);
                Map<String, String> responseHeaders = getHeaders(response.getAllHeaders());
                return new HttpRpcClientResponse(response.getStatusLine().getStatusCode(), result, responseHeaders);
            } finally {
                SUPERVISOR.removeRequest(request);
            }
        } catch (SocketException e) {
            throw e;
        }
    }

    private String getRequestPayload(HttpRequestBase request) throws IOException {
        if (!(request instanceof HttpPost)) {
            return EMPTY_PAYLOAD;
        }

        HttpPost postRequest = (HttpPost)request;
        if (postRequest.getEntity() == null) {
            return EMPTY_PAYLOAD;
        }

        if (!Strings.isNullOrEmpty(postRequest.getEntity().getContentType().getValue())) {
            String contentType = postRequest.getEntity().getContentType().getValue();
            if (contentType.contains("multipart/form-data")) {
                return EMPTY_PAYLOAD;
            }
        }

        return IOUtils.toString(postRequest.getEntity().getContent(), StandardCharsets.UTF_8);
    }

    public HttpRpcClientResponse get(String url) throws IOException {
        return get(url, FORM_CONTENT_TYPE);
    }

    public HttpRpcClientResponse get(String url, String contentType) throws IOException {
        HttpGet request = new HttpGet(url);
        request.setHeader(CONTENT_TYPE_HEADER, contentType);
        return call(request);
    }

    public HttpRpcClientResponse post(String url) throws IOException {
        return post(url, null);
    }

    public HttpRpcClientResponse post(String url, String body) throws IOException {
        return post(url, body, FORM_CONTENT_TYPE);
    }

    public HttpRpcClientResponse post(String url, String body, String contentType) throws IOException {
        HttpPost request = new HttpPost(url);
        request.setHeader(CONTENT_TYPE_HEADER, contentType);
        if (body != null) {
            request.setEntity(new StringEntity(body, ENCODING));
        }

        return call(request);
    }

    public HttpRpcClientResponse post(URIBuilder builder) throws Throwable {
        if (builder == null) {
            return null;
        }

        HttpPost request = new HttpPost(builder.build());
        return call(request);
    }

    public HttpRpcClientResponse post(URIBuilder builder, List<? extends NameValuePair> postParamList)
        throws Throwable {
        HttpPost request = new HttpPost(builder.build());
        if (postParamList != null) {
            request.setEntity(new UrlEncodedFormEntity(postParamList, Consts.UTF_8));
        }
        return call(request);
    }

}
