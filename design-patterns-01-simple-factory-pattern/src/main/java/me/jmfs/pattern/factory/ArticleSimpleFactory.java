package me.jmfs.pattern.factory;

import me.jmfs.pattern.product.concrete.ConcreteAcademicArticleProduct;
import me.jmfs.pattern.product.concrete.ConcreteScienceArticleProduct;
import me.jmfs.pattern.constant.ArticleCategoryConstant;
import me.jmfs.pattern.product.AbstractArticleProduct;

/**
 * @Author: 囧么肥事
 * @Date: 2022/8/30
 * @Email: jiongmefeishi@163.com
 * @Url("https://gitee.com/jiongmefeishi")
 * @Description: 文章实例简单工厂
 */
public class ArticleSimpleFactory {

    /**
     * 根据文章类型参数，返回文章产品实例
     * @param articleCategoryName 文章类型
     * @return 具体文章产品类型实例
     */
    public static AbstractArticleProduct factory(String articleCategoryName){
        if (ArticleCategoryConstant.SCIENCE_ARTICLE.equals(articleCategoryName)) {
            return new ConcreteScienceArticleProduct(articleCategoryName);
        } else if (ArticleCategoryConstant.ACADEMIC_ARTICLE.equals(articleCategoryName)) {
            return new ConcreteAcademicArticleProduct(articleCategoryName);
        } else {
            return null;
        }
    }
}
