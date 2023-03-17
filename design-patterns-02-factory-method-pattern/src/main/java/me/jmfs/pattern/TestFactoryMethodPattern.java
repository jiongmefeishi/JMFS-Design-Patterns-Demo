package me.jmfs.pattern;

import me.jmfs.pattern.factory.concrete.ConcreteAcademicArticleFactory;
import me.jmfs.pattern.factory.concrete.ConcreteScienceArticleFactory;
import me.jmfs.pattern.product.AbstractArticleProduct;

/**
 * @Author: 囧么肥事
 * @Date: 2022/9/8
 * @Email: jiongmefeishi@163.com
 * @Url("https://gitee.com/jiongmefeishi")
 * @Description: 测试工厂方法模式
 */
public class TestFactoryMethodPattern {

    public static void main(String[] args) {
        AbstractArticleProduct articleProduct = new ConcreteScienceArticleFactory().factory();
        articleProduct.showArticleCategory();

        AbstractArticleProduct academicProduct = new ConcreteAcademicArticleFactory().factory();
        academicProduct.showArticleCategory();
    }
}
