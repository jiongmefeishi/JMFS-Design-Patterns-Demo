package me.jmfs.pattern.factory;


import me.jmfs.pattern.product.Product;

/**
 * @Author: 囧么肥事
 * @Date: 2023/3/17
 * @Email: jiongmefeishi@163.com
 * @Url("https://gitee.com/jiongmefeishi")
 * @Description: https://www.bookstack.cn/read/design-pattern-java/%E5%B7%A5%E5%8E%82%E4%B8%89%E5%85%84%E5%BC%9F%E4%B9%8B%E5%B7%A5%E5%8E%82%E6%96%B9%E6%B3%95%E6%A8%A1%E5%BC%8F%EF%BC%88%E4%BA%8C%EF%BC%89.md
 *
 * Factory（抽象工厂）：在抽象工厂类中，声明了工厂方法(Factory Method)，用于返回一个产品。
 * 抽象工厂是工厂方法模式的核心，所有创建对象的工厂类都必须实现该接口。
 */
public interface Factory {
    public Product factoryMethod();
}
