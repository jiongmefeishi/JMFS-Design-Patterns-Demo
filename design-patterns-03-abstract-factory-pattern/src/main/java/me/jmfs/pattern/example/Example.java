package me.jmfs.pattern.example;

/**
 * @Author: 囧么肥事
 * @Date: 2023/3/21
 * @Email: jiongmefeishi@163.com
 * @Url("https://gitee.com/jiongmefeishi")
 * @Description: 以抽象工厂模式创建不同界面皮肤库
 *
 * Spring 风格库：整体绿色风格皮肤库
 * Summer 风格库：整体红色风格皮肤库
 */
public class Example {
}

// 按钮接口：抽象产品
interface Button {
    public void display();
}

// Spring风格按钮类：具体产品
class SpringButton implements Button{
    @Override
    public void display() {
        System.out.println("显示绿色按钮");
    }
}

// summer风格按钮类：具体产品
class SummerButton implements Button {
    @Override
    public void display() {
        System.out.println("显示红色按钮");
    }
}

// 文本框接口：抽象产品
interface TextField {
    public void display();
}

// Spring风格文本框类：具体产品
class SpringTextField implements TextField {
    @Override
    public void display() {
        System.out.println("显示绿色边框文本框");
    }
}

// Summer风格文本框类：具体产品
class SummerTextField implements TextField {
    @Override
    public void display() {
        System.out.println("显示红色边框文本框");
    }
}

//组合框接口：抽象产品
interface ComboBox {
    public void display();
}

//Spring风格组合框类：具体产品
class SpringComboBox implements ComboBox {
    public void display() {
        System.out.println("显示绿色边框组合框。");
    }
}

//Summer风格组合框类：具体产品
class SummerComboBox implements ComboBox {
    public void display() {
        System.out.println("显示红色边框组合框。");
    }
}

// 界面皮肤工厂接口：抽象工厂
interface SkinFactory{
    public Button createButton();
    public TextField createTextField();
    public ComboBox createComboBox();
}

// Spring风格界面皮肤工厂：具体工厂
class SpringSkinFactory implements SkinFactory {

    @Override
    public Button createButton() {
        return new SpringButton();
    }

    @Override
    public TextField createTextField() {
        return new SpringTextField();
    }

    @Override
    public ComboBox createComboBox() {
        return new SpringComboBox();
    }
}

// Summer风格界面皮肤工厂：具体工厂
class SummerSkinFactory implements SkinFactory {

    @Override
    public Button createButton() {
        return new SummerButton();
    }

    @Override
    public TextField createTextField() {
        return new SummerTextField();
    }

    @Override
    public ComboBox createComboBox() {
        return new SummerComboBox();
    }
}

