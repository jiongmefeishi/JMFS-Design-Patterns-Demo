package me.jmfs.pattern.factory.concrete;

import me.jmfs.pattern.constant.ArticleCategoryConstant;
import me.jmfs.pattern.factory.AbstractProductFactory;
import me.jmfs.pattern.product.AbstractArticleProduct;
import me.jmfs.pattern.product.concrete.ConcreteScienceArticleProduct;

/**
 * @Author: 囧么肥事
 * @Date: 2022/9/8
 * @Email: jiongmefeishi@163.com
 * @Url("https://gitee.com/jiongmefeishi")
 * @Description: 科学类文章工厂
 */
public class ConcreteScienceArticleFactory implements AbstractProductFactory {

    @Override
    public AbstractArticleProduct factory() {
        return new ConcreteScienceArticleProduct(ArticleCategoryConstant.SCIENCE_ARTICLE);
    }
}
