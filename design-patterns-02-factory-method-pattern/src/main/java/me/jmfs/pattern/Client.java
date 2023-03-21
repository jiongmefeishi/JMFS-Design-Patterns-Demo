package me.jmfs.pattern;

import me.jmfs.pattern.constant.ProductEnum;
import me.jmfs.pattern.factory.Factory;
import me.jmfs.pattern.product.Product;

/**
 * @Author: 囧么肥事
 * @Date: 2023/3/21
 * @Email: jiongmefeishi@163.com
 * @Url("https://gitee.com/jiongmefeishi")
 * @Description:
 */
public class Client {
    public static void main(String args[]) {
        Product product;
        product = Factory.factoryMethod(ProductEnum.A); //通过工厂类创建产品对象
        product.methodSame();
        product.methodDiff();
    }
}
