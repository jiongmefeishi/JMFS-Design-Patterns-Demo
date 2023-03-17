package me.jmfs.pattern.product.concrete;

import me.jmfs.pattern.product.AbstractArticleProduct;

/**
 * @Author: 囧么肥事
 * @Date: 2022/8/30
 * @Email: jiongmefeishi@163.com
 * @Url("https://gitee.com/jiongmefeishi")
 * @Description: 文章抽象实现类 -> 具体的学术类文章产品
 */
public class ConcreteAcademicArticleProduct implements AbstractArticleProduct {

    private String articleCategory;

    public ConcreteAcademicArticleProduct(String articleCategory) {
        this.articleCategory = articleCategory;
    }

    @Override
    public void showArticleCategory() {
        System.out.println(this.getClass().getSimpleName() + " " + this.articleCategory);
    }
}
