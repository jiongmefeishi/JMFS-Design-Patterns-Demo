package me.jmfs.pattern.product.concrete;

import me.jmfs.pattern.product.Product;

/**
 * @Author: 囧么肥事
 * @Date: 2023/3/17
 * @Email: jiongmefeishi@163.com
 * @Url("https://gitee.com/jiongmefeishi")
 * @Description: https://www.bookstack.cn/read/design-pattern-java/%E5%B7%A5%E5%8E%82%E4%B8%89%E5%85%84%E5%BC%9F%E4%B9%8B%E7%AE%80%E5%8D%95%E5%B7%A5%E5%8E%82%E6%A8%A1%E5%BC%8F%EF%BC%88%E4%BA%8C%EF%BC%89.md
 *
 * ConcreteProduct（具体产品角色）：
 * 它是简单工厂模式的创建目标，所有被创建的对象都充当这个角色的某个具体类的实例。
 * 每一个具体产品角色都继承了抽象产品角色，需要实现在抽象产品中声明的抽象方法。
 */
public class ConcreteProductA extends Product {

    //实现业务方法
    @Override
    public void methodDiff() {
        //业务方法的实现
    }
}
