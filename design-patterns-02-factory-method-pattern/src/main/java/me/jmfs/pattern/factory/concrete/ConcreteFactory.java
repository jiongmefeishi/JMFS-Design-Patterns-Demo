package me.jmfs.pattern.factory.concrete;

import me.jmfs.pattern.factory.Factory;
import me.jmfs.pattern.product.Product;
import me.jmfs.pattern.product.concrete.ConcreteProduct;

/**
 * @Author: 囧么肥事
 * @Date: 2023/3/21
 * @Email: jiongmefeishi@163.com
 * @Url("https://gitee.com/jiongmefeishi")
 * @Description: https://www.bookstack.cn/read/design-pattern-java/%E5%B7%A5%E5%8E%82%E4%B8%89%E5%85%84%E5%BC%9F%E4%B9%8B%E5%B7%A5%E5%8E%82%E6%96%B9%E6%B3%95%E6%A8%A1%E5%BC%8F%EF%BC%88%E4%BA%8C%EF%BC%89.md
 *
 * ConcreteFactory（具体工厂）：它是抽象工厂类的子类，实现了抽象工厂中定义的工厂方法，并可由客户端调用，返回一个具体产品类的实例
 */
public class ConcreteFactory implements Factory {

    @Override
    public Product factoryMethod() {
        return new ConcreteProduct();
    }
}
