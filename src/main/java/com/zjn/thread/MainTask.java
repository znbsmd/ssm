package com.zjn.thread;

public class MainTask {

    /**
     * java多线程同步锁的使用
     * 示例：开启三个线程 并发执行200 条任务
     * */
    public static void main(String[] args) {
        //实例化站台对象
        JavaTask jt1=new JavaTask("任务1");
        JavaTask jt2=new JavaTask("任务2");
        JavaTask jt3=new JavaTask("任务3");

        jt1.start();
        jt2.start();
        jt3.start();
    }


}
