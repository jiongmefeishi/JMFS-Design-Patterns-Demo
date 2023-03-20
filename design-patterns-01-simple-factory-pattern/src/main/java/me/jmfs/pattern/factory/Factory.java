package me.jmfs.pattern.factory;

import me.jmfs.pattern.constant.ProductEnum;
import me.jmfs.pattern.product.Product;
import me.jmfs.pattern.product.concrete.ConcreteProductA;
import me.jmfs.pattern.product.concrete.ConcreteProductB;

/**
 * @Author: 囧么肥事
 * @Date: 2023/3/17
 * @Email: jiongmefeishi@163.com
 * @Url("https://gitee.com/jiongmefeishi")
 * @Description: https://www.bookstack.cn/read/design-pattern-java/%E5%B7%A5%E5%8E%82%E4%B8%89%E5%85%84%E5%BC%9F%E4%B9%8B%E7%AE%80%E5%8D%95%E5%B7%A5%E5%8E%82%E6%A8%A1%E5%BC%8F%EF%BC%88%E4%BA%8C%EF%BC%89.md
 *
 * Factory（工厂角色）：
 * 工厂角色即工厂类，它是简单工厂模式的核心，负责实现创建所有产品实例的内部逻辑；
 * 工厂类可以被外界直接调用，创建所需的产品对象；
 * 在工厂类中提供了静态的工厂方法factoryMethod()，它的返回类型为抽象产品类型Product。
 */
public class Factory {

    // 静态工厂方法
    public static Product factoryMethod(ProductEnum productType) {

        Product product = null;
        // 工厂类提供了一个静态工厂方法供客户端使用，根据所传入的参数不同可以创建不同的产品对象
        if (ProductEnum.A.equals(productType)) {
            product = new ConcreteProductA();
            //初始化设置product
        }
        else if (ProductEnum.B.equals(productType)) {
            product = new ConcreteProductB();
            //初始化设置product
        }

        return product;
    }
}
