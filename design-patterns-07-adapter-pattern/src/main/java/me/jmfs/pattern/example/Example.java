package me.jmfs.pattern.example;

/**
 * @Author: 囧么肥事
 * @Date: 2023/3/21
 * @Email: jiongmefeishi@163.com
 * @Url("https://gitee.com/jiongmefeishi")
 * @Description: 建造者模式来实现构建不同的电脑
 * <p>
 * 适配器模式(Adapter Pattern)：将一个接口转换成客户希望的另一个接口，使接口不兼容的那些类可以一起工作，其别名为包装器(Wrapper)。
 * 适配器模式既可以作为类结构型模式，也可以作为对象结构型模式。
 * </p>
 */
public class Example {
/*
在以上示例中，Target 接口规定了客户端所需的接口。
Adaptee 类是一个已有的类，其内部定义了一个特定的方法 specificRequest()。

为了能够让客户端使用统一的接口，我们创建了一个适配器类 Adapter，
该类实现了 Target 接口，并将请求转发给 Adaptee 类的 specificRequest() 方法。
在客户端中，我们可以通过实例化一个 Adapter 对象，来使用已有的 Adaptee 类。
这样，客户端便可以使用统一的 request() 方法来调用 Adaptee 类的特定方法 specificRequest() 了。
 */
}

// Target 接口规定了客户端所需的接口
interface Target {
    void request();
}

// Adaptee 类是一个已有的类，其内部定义了一个特定的方法 specificRequest()
class Adaptee {
    void specificRequest() {
        System.out.println("This is a specific request.");
    }
}

// 适配器类 Adapter，该类实现了 Target 接口，并将请求转发给 Adaptee 类的 specificRequest() 方法
class Adapter implements Target {
    private Adaptee adaptee;

    Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void request() {
        adaptee.specificRequest();
    }
}

class Client {
    static void main(String[] args) {
        Adaptee adaptee = new Adaptee();
        Target target = new Adapter(adaptee);
        target.request();
    }
}

