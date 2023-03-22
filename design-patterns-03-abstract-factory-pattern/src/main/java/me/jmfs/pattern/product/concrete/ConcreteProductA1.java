package me.jmfs.pattern.product.concrete;

import me.jmfs.pattern.product.AbstractProductA;

/**
 * @Author: 囧么肥事
 * @Date: 2023/3/21
 * @Email: jiongmefeishi@163.com
 * @Url("https://gitee.com/jiongmefeishi")
 * @Description: 抽象产品A的具体产品
 */
public class ConcreteProductA1 extends AbstractProductA {
    @Override
    public void printProductName() {
        System.out.println("我是抽象产品A的具体产品实例1");
    }
}
