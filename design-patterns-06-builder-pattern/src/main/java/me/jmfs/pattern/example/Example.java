package me.jmfs.pattern.example;

/**
 * @Author: 囧么肥事
 * @Date: 2023/3/21
 * @Email: jiongmefeishi@163.com
 * @Url("https://gitee.com/jiongmefeishi")
 * @Description: 建造者模式来实现构建不同的电脑
 * <p>
 */
public class Example {
    /*
    以上代码中，Computer 类代表了最终构建好的电脑对象。
    ComputerBuilder 接口定义了构建过程的抽象方法，每个具体的建造者对象需要实现这些方法来构建电脑的各个部分。
    Director 类负责指导建造者对象按照一定的顺序构建电脑。
    在客户端中，我们可以选择不同的具体建造者对象来构建不同类型的电脑。
    例如，以上代码中使用 DellComputerBuilder 来构建一台 Dell 电脑。
     */
}

class Computer {
    private String cpu;
    private String memory;
    private String hardDisk;
    private String display;

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    public void setHardDisk(String hardDisk) {
        this.hardDisk = hardDisk;
    }

    public void setDisplay(String display) {
        this.display = display;
    }
}

// 建造者抽象接口
interface ComputerBuilder {
    void buildCpu();
    void buildMemory();
    void buildHardDisk();
    void buildDisplay();

    Computer getComputer();
}

// 具体建造者对象
class DellComputerBuilder implements ComputerBuilder {
    private Computer computer = new Computer();

    @Override
    public void buildCpu() {
        computer.setCpu("Intel i5");
    }

    @Override
    public void buildMemory() {
        computer.setMemory("8GB DDR4");
    }

    @Override
    public void buildHardDisk() {
        computer.setHardDisk("1TB HDD");
    }

    @Override
    public void buildDisplay() {
        computer.setDisplay("15.6 inch FHD");
    }

    @Override
    public Computer getComputer() {
        return computer;
    }
}

// 指挥者对象
class Director {
    private ComputerBuilder builder;

    public Director(ComputerBuilder builder) {
        this.builder = builder;
    }

    public void buildComputer() {
        builder.buildCpu();
        builder.buildMemory();
        builder.buildHardDisk();
        builder.buildDisplay();
    }
}

class Client {
    public static void main(String[] args) {
        ComputerBuilder builder = new DellComputerBuilder();
        Director director = new Director(builder);
        director.buildComputer();
        Computer computer = builder.getComputer();
    }
}

