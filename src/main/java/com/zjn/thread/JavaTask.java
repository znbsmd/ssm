package com.zjn.thread;

import java.util.Timer;

/**
 * java 多线程 并发执行任务
 */
public class JavaTask extends Thread {

    // 通过构造方法给线程名字赋值
    public JavaTask(String name) {
        super(name);// 给线程名字赋值
    }
    // 需要执行的总任务数
    private static int taskNum = 200;

    // 创建一个静态钥匙
    private static final Object ob = "aa";
    // 重写run方法，执行任务
    @Override
    public void run() {
        while (taskNum > 0) {
            synchronized (ob) {// 这个很重要，必须使用一个锁，
                // 进去的人会把钥匙拿在手上，出来后才把钥匙拿让出来
                if (taskNum > 0) {
                    System.out.println(getName() + "exec " + taskNum + " task");
                    taskNum--;
                } else {
                    System.out.println("finish");
                }
            }
            try {
                sleep(1000);//休息一秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
