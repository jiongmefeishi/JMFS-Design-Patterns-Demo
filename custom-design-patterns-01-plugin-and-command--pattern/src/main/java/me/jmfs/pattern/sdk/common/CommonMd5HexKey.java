package me.jmfs.pattern.sdk.common;

import cn.hutool.crypto.digest.DigestUtil;
import com.google.common.base.Strings;

/**
 * @Author: 囧么肥事
 * @Date: 2023/5/17
 * @Email: jiongmefeishi@163.com
 * @Url("https://gitee.com/jiongmefeishi")
 * @Description: md5 hex key
 */
public class CommonMd5HexKey {

    /**
     * @return 根据入参生成唯一key
     */
    public static String generatorMd5HexKey(String... keys) {
        StringBuilder builder = new StringBuilder();
        for (String key: keys) {
            if (!Strings.isNullOrEmpty(key)) {
                builder.append(key);
            }
        }
        return DigestUtil.md5Hex(builder.toString());
    }

}
