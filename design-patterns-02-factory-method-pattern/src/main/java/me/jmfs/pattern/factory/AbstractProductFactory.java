package me.jmfs.pattern.factory;

import me.jmfs.pattern.product.AbstractArticleProduct;

/**
 * @Author: 囧么肥事
 * @Date: 2022/9/8
 * @Email: jiongmefeishi@163.com
 * @Url("https://gitee.com/jiongmefeishi")
 * @Description: 抽象工厂
 */
public interface AbstractProductFactory {

    AbstractArticleProduct factory();
}
