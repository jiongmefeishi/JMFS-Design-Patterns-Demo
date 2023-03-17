package me.jmfs.pattern.factory.concrete;

import me.jmfs.pattern.constant.ArticleCategoryConstant;
import me.jmfs.pattern.factory.AbstractProductFactory;
import me.jmfs.pattern.product.AbstractArticleProduct;
import me.jmfs.pattern.product.concrete.ConcreteAcademicArticleProduct;

/**
 * @Author: 囧么肥事
 * @Date: 2022/9/8
 * @Email: jiongmefeishi@163.com
 * @Url("https://gitee.com/jiongmefeishi")
 * @Description: 学术类文章工厂
 */
public class ConcreteAcademicArticleFactory implements AbstractProductFactory {

    @Override
    public AbstractArticleProduct factory() {
        return new ConcreteAcademicArticleProduct(ArticleCategoryConstant.ACADEMIC_ARTICLE);
    }
}
