package me.jmfs.pattern.product.concrete;

import me.jmfs.pattern.product.AbstractProductB;

/**
 * @Author: 囧么肥事
 * @Date: 2023/3/21
 * @Email: jiongmefeishi@163.com
 * @Url("https://gitee.com/jiongmefeishi")
 * @Description: 抽象产品B的具体产品
 */
public class ConcreteProductB2 extends AbstractProductB {

    @Override
    public void printProductName() {
        System.out.println("我是抽象产品B的具体产品实例2");

    }
}
