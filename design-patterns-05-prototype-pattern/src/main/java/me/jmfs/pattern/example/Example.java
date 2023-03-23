package me.jmfs.pattern.example;

/**
 * @Author: 囧么肥事
 * @Date: 2023/3/21
 * @Email: jiongmefeishi@163.com
 * @Url("https://gitee.com/jiongmefeishi")
 * @Description: 原型模式来实现工作周报的快速创建
 * <p>
 * WeeklyLog充当具体原型类，Object类充当抽象原型类，clone()方法为原型方法
 */
public class Example {

    // 工作周报WeeklyLog：具体原型类，考虑到代码的可读性和易理解性，只列出部分与模式相关的核心代码
    static class WeeklyLog implements Cloneable {

        private String name;
        private String date;
        private String content;

        // 最重要的一点就是实现 clone() ,这里利用原生克隆
        @Override
        protected WeeklyLog clone() {

            Object object = null;
            try {
                object = super.clone();
                return (WeeklyLog) object;
            } catch (CloneNotSupportedException e) {
                System.out.println("不支持克隆");
            }
            return null;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }
    }

    public static void main(String args[]) {
        WeeklyLog log_previous = new WeeklyLog();  //创建原型对象
        log_previous.setName("张无忌");
        log_previous.setDate("第12周");
        log_previous.setContent("这周工作很忙，每天加班！");
        System.out.println("****周报****");
        System.out.println("周次：" + log_previous.getDate());
        System.out.println("姓名：" + log_previous.getName());
        System.out.println("内容：" + log_previous.getContent());
        System.out.println("--------------------------------");
        WeeklyLog log_new;
        log_new = log_previous.clone(); //调用克隆方法创建克隆对象
        log_new.setDate("第13周");
        System.out.println("****周报****");
        System.out.println("周次：" + log_new.getDate());
        System.out.println("姓名：" + log_new.getName());
        System.out.println("内容：" + log_new.getContent());
    }
}


