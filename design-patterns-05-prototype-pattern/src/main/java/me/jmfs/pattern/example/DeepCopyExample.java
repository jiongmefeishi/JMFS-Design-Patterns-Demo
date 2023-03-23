package me.jmfs.pattern.example;

import java.io.*;

/**
 * @Author: 囧么肥事
 * @Date: 2023/3/23
 * @Email: jiongmefeishi@163.com
 * @Url("https://gitee.com/jiongmefeishi")
 * @Description: 深拷贝：值类型和引用类型都复制
 * <p>
 * 在深克隆中，无论原型对象的成员变量是值类型还是引用类型，都将复制一份给克隆对象，
 * 深克隆将原型对象的所有引用对象也复制一份给克隆对象。
 * 简单来说，在深克隆中，除了对象本身被复制外，对象所包含的所有成员变量也将复制
 * <p>
 * <p>
 * 在Java语言中，如果需要实现深克隆，可以通过序列化(Serialization)等方式来实现。序列化就是将对象写到流的过程，
 * 写到流中的对象是原有对象的一个拷贝，而原对象仍然存在于内存中。
 * 通过序列化实现的拷贝不仅可以复制对象本身，而且可以复制其引用的成员对象
 * <p>
 * 因此通过序列化将对象写到一个流中，再从流里将其读出来，可以实现深克隆。
 * 需要注意的是能够实现序列化的对象其类必须实现Serializable接口，否则无法实现序列化操作
 * <p>
 * 示例：深克隆技术来实现工作周报和附件对象的复制，由于要将附件对象和工作周报对象都写入流中，因此两个类均需要实现Serializable接口
 */
public class DeepCopyExample {

    //附件类
    static class Attachment implements Serializable {
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

    // 工作周报类WeeklyLog不再使用Java自带的克隆机制，而是通过序列化来从头实现对象的深克隆，我们需要重新编写clone()方法

    //工作周报类
    static class WeeklyLog implements Serializable {
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

        //使用序列化技术实现深克隆
        public WeeklyLog deepClone() throws IOException, ClassNotFoundException, OptionalDataException {
            //将对象写入流中
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(this);
            //将对象从流中取出
            ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bis);
            return (WeeklyLog) ois.readObject();
        }
    }

    public static void main(String args[]) {
        WeeklyLog log_previous, log_new = null;
        log_previous = new WeeklyLog(); //创建原型对象
        Attachment attachment = new Attachment(); //创建附件对象
        log_previous.setAttachment(attachment);  //将附件添加到周报中
        try {
            log_new = log_previous.deepClone(); //调用深克隆方法创建克隆对象
        } catch (Exception e) {
            System.err.println("克隆失败！");
        }
        //比较周报
        System.out.println("周报是否相同？ " + (log_previous == log_new));
        //比较附件
        System.out.println("附件是否相同？ " + (log_previous.getAttachment() == log_new.getAttachment()));
    }

//    周报是否相同？  false
//    附件是否相同？  false
//    从输出结果可以看出，由于使用了深克隆技术，附件对象也得以复制，因此用“==”比较原型对象的附件和克隆对象的附件时输出结果均为false。
//    深克隆技术实现了原型对象和克隆对象的完全独立，对任意克隆对象的修改都不会给其他对象产生影响，是一种更为理想的克隆实现方式。
}
