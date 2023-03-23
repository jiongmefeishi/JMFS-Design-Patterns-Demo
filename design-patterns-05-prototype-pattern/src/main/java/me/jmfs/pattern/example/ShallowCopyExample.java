package me.jmfs.pattern.example;

/**
 * @Author: 囧么肥事
 * @Date: 2023/3/23
 * @Email: jiongmefeishi@163.com
 * @Url("https://gitee.com/jiongmefeishi")
 * @Description: 浅拷贝：拷贝值类型，不拷贝引用类型，复制引用地址，引用类型指向同一个地址
 * <p>
 * 在浅克隆中，如果原型对象的成员变量是值类型，将复制一份给克隆对象；
 * 如果原型对象的成员变量是引用类型，则将引用对象的地址复制一份给克隆对象，也就是说原型对象和克隆对象的成员变量指向相同的内存地址。
 * 简单来说，在浅克隆中，当对象被复制时只复制它本身和其中包含的值类型的成员变量，而引用类型的成员对象并没有复制
 * <p>
 * <p>
 * 以复制周报附件为例
 */
public class ShallowCopyExample {

    //附件类
    static class Attachment {
        private String name; //附件名

        public void setName(String name) {
            this.name = name;
        }

        public String getName() {
            return this.name;
        }

        public void download() {
            System.out.println("下载附件，文件名为" + name);
        }
    }

    //工作周报WeeklyLog
    static class WeeklyLog implements Cloneable {
        //为了简化设计和实现，假设一份工作周报中只有一个附件对象，实际情况中可以包含多个附件，可以通过List等集合对象来实现
        private Attachment attachment;
        private String name;
        private String date;
        private String content;

        public void setAttachment(Attachment attachment) {
            this.attachment = attachment;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public Attachment getAttachment() {
            return (this.attachment);
        }

        public String getName() {
            return (this.name);
        }

        public String getDate() {
            return (this.date);
        }

        public String getContent() {
            return (this.content);
        }

        //使用clone()方法实现浅克隆
        public WeeklyLog clone() {
            Object obj = null;
            try {
                obj = super.clone();
                return (WeeklyLog) obj;
            } catch (CloneNotSupportedException e) {
                System.out.println("不支持复制！");
                return null;
            }
        }
    }

    public static void main(String[] args) {
        WeeklyLog log_previous, log_new;
        log_previous = new WeeklyLog(); //创建原型对象
        Attachment attachment = new Attachment(); //创建附件对象
        log_previous.setAttachment(attachment);  //将附件添加到周报中
        log_new = log_previous.clone(); //调用克隆方法创建克隆对象
        //比较周报
        System.out.println("周报是否相同？ " + (log_previous == log_new));
        //比较附件
        System.out.println("附件是否相同？ " + (log_previous.getAttachment() == log_new.getAttachment()));
    }

//编译并运行程序，输出结果如下：
//
//    周报是否相同？ false
//    附件是否相同？ true
//    由于使用的是浅克隆技术，因此工作周报对象复制成功，通过“==”比较原型对象和克隆对象的内存地址时输出false；但是比较附件对象的内存地址时输出true，说明它们在内存中是同一个对象。

}
