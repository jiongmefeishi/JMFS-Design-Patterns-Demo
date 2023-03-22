package me.jmfs.pattern.factory.concrete;

import me.jmfs.pattern.factory.AbstractFactory;
import me.jmfs.pattern.product.AbstractProductA;
import me.jmfs.pattern.product.AbstractProductB;
import me.jmfs.pattern.product.concrete.ConcreteProductA2;
import me.jmfs.pattern.product.concrete.ConcreteProductB2;

/**
 * @Author: 囧么肥事
 * @Date: 2023/3/21
 * @Email: jiongmefeishi@163.com
 * @Url("https://gitee.com/jiongmefeishi")
 * @Description: https://www.bookstack.cn/read/design-pattern-java/%E5%B7%A5%E5%8E%82%E4%B8%89%E5%85%84%E5%BC%9F%E4%B9%8B%E5%B7%A5%E5%8E%82%E6%96%B9%E6%B3%95%E6%A8%A1%E5%BC%8F%EF%BC%88%E4%BA%8C%EF%BC%89.md
 *
 * ConcreteFactory（具体工厂）：它实现了在抽象工厂中声明的创建产品的方法，生成一组具体产品，这些产品构成了一个产品族，每一个产品都位于某个产品等级结构中。
 *
 * 抽象工厂的具体实现工厂2，负责生产2类型的一类特色产品
 */
public class ConcreteFactory2 extends AbstractFactory {

    @Override
    public AbstractProductA createAbstractProductA() {
        return new ConcreteProductA2();
    }

    @Override
    public AbstractProductB createAbstractProductB() {
        return new ConcreteProductB2();
    }
}
