package me.jmfs.pattern.example;

/**
 * @Author: 囧么肥事
 * @Date: 2023/3/21
 * @Email: jiongmefeishi@163.com
 * @Url("https://gitee.com/jiongmefeishi")
 * @Description: 以简单工厂模式创建不同的图表类产品示例
 */
public class Example {
}

//抽象图表接口：抽象产品类
interface ChartProduct {
    public void display();
}
//柱状图类：具体产品类
class HistogramChartProduct implements ChartProduct {
    public HistogramChartProduct() {
        System.out.println("创建柱状图！");
    }
    public void display() {
        System.out.println("显示柱状图！");
    }
}
//饼状图类：具体产品类
class PieChartProduct implements ChartProduct {
    public PieChartProduct() {
        System.out.println("创建饼状图！");
    }
    public void display() {
        System.out.println("显示饼状图！");
    }
}
//折线图类：具体产品类
class LineChartProduct implements ChartProduct {
    public LineChartProduct() {
        System.out.println("创建折线图！");
    }
    public void display() {
        System.out.println("显示折线图！");
    }
}
//图表工厂类：工厂类
class ChartFactory {
    //静态工厂方法
    public static ChartProduct getChart(String type) {
        ChartProduct chartProduct = null;
        if (type.equalsIgnoreCase("histogram")) {
            chartProduct = new HistogramChartProduct();
            System.out.println("初始化设置柱状图！");
        }
        else if (type.equalsIgnoreCase("pie")) {
            chartProduct = new PieChartProduct();
            System.out.println("初始化设置饼状图！");
        }
        else if (type.equalsIgnoreCase("line")) {
            chartProduct = new LineChartProduct();
            System.out.println("初始化设置折线图！");
        }
        return chartProduct;
    }
}