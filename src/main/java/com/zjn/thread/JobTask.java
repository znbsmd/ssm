package com.zjn.thread;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

/**
 * java  定时任务
 */
public class JobTask extends TimerTask {
    /**
     * test timer task
     * @param args
     */
    public static void main(String[] args) {
        Timer timer = new Timer();
        long delay = 2000;
        long interval = 1000;

        // 从现在开始 2 秒钟之后启动，每隔 1 秒钟执行一次
        timer.schedule(new JobTask(), delay, interval);
    }
    @Override
    public void run() {
        System.out.println("Test: " + Calendar.getInstance().getTime());
    }
}
