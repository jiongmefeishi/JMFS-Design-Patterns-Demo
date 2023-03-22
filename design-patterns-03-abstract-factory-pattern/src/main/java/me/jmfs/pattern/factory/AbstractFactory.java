package me.jmfs.pattern.factory;

import me.jmfs.pattern.product.AbstractProductA;
import me.jmfs.pattern.product.AbstractProductB;

/**
 * @Author: 囧么肥事
 * @Date: 2023/3/21
 * @Email: jiongmefeishi@163.com
 * @Url("https://gitee.com/jiongmefeishi")
 * @Description:
 *
 * AbstractFactory（抽象工厂）：它声明了一组用于创建一族产品的方法，每一个方法对应一种产品
 */
public abstract class AbstractFactory {

    // 工厂方法1-创建抽象产品A
    public abstract AbstractProductA createAbstractProductA();

    // 工厂方法2-创建抽象产品B
    public abstract AbstractProductB createAbstractProductB();

}
