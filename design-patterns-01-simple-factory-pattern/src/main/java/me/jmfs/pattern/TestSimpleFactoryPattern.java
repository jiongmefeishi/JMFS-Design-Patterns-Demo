package me.jmfs.pattern;

import me.jmfs.pattern.constant.ArticleCategoryConstant;
import me.jmfs.pattern.factory.ArticleSimpleFactory;
import me.jmfs.pattern.product.AbstractArticleProduct;

/**
 * @Author: 囧么肥事
 * @Date: 2022/8/30
 * @Email: jiongmefeishi@163.com
 * @Url("https://gitee.com/jiongmefeishi")
 * @Description: 测试简单工厂模式
 */
public class TestSimpleFactoryPattern {

    public static void main(String[] args) {
        AbstractArticleProduct article = ArticleSimpleFactory.factory(ArticleCategoryConstant.SCIENCE_ARTICLE);
        assert article != null;
        article.showArticleCategory();
    }
}
