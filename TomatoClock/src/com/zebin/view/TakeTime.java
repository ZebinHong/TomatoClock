package com.zebin.view;

import com.zebin.bean.Tomato;
import com.zebin.service.impl.TomatoServiceImpl;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

import javax.swing.*;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class TakeTime {
    TomatoServiceImpl tsi = new TomatoServiceImpl();

    private ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    //设置暂停的变量
    public static boolean isPause=false;
    //一个番茄钟的时长
    public static int workTime = 25*60;
    public static int restTime = 5*60;
    public void takeATomato() {
        //每一秒执行的动作
        Runnable beeper = new Runnable() {
            public void run() {
//                while(isPause){
//                    try {
//                        Thread.sleep(2000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
                workTime--;
                int m = workTime /60;
                int s = workTime %60;
                //设置时间框里的内容
                SimpleFrame.field.setText(String.format("%02d", m)+":"+String.format("%02d",s)+"\n");
            }
        };
        //设置每一秒执行一次beeper
        ScheduledFuture<?> beeperHandle = scheduler.scheduleAtFixedRate(beeper, 1, 1, TimeUnit.SECONDS);
        //执行了25min后关闭
        scheduler.schedule(new Runnable() {
            public void run() {
//                while(isPause){
//                    try {
//                        Thread.sleep(1000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
                SimpleFrame.field.setText("finish!");
                beeperHandle.cancel(true);

                //播放音乐
                playMusic();

                workTime = 60*25;
                tsi.addTomato(new Tomato(0,25,new Date(System.currentTimeMillis()),1,null));
                Object[] options ={ "休息", "继续" };
                int m = JOptionPane.showOptionDialog(null, "您已完成一个番茄钟，是否需要休息？",
                        "完成",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
                if(m==1)
                    new TakeTime().takeATomato();
                else if(m==0)
                    new TakeTime().resting();
            }
        }, 25*60, TimeUnit.SECONDS);
    }

    public void resting() {
        //每一秒执行的动作
        Runnable beeper = new Runnable() {
            public void run() {
                restTime--;
                int m = restTime /60;
                int s = restTime %60;

                //设置时间框里的内容
                SimpleFrame.field.setText(String.format("%02d", m)+":"+String.format("%02d",s)+"\n");
            }
        };
        //设置每一秒执行一次beeper
        ScheduledFuture<?> beeperHandle = scheduler.scheduleAtFixedRate(beeper, 1, 1, TimeUnit.SECONDS);
        //执行了5min后关闭
        scheduler.schedule(new Runnable() {
            public void run() {

                SimpleFrame.field.setText("rested!");
                restTime = 5*60;
                beeperHandle.cancel(true);
                //播放音乐
                playMusic();

                JOptionPane.showMessageDialog(null, "休息完成", "提示",JOptionPane.WARNING_MESSAGE);
            }
        }, 5*60, TimeUnit.SECONDS);
    }
    public void playMusic(){
        // 创建音乐文件输入流对象
        try {
            InputStream in = new FileInputStream("musics/5506.wav");
            // 创建音频流对象
            final AudioStream  audioStream = new AudioStream(in);
            new Thread(new Runnable() {
                @Override
                public void run() {
                    // 使用音频播放器播放声音
                    AudioPlayer.player.start(audioStream);
                }
            }).start();
            Thread.sleep(3000);
            // 停止声音播放
            AudioPlayer.player.stop(audioStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    @Override
//    public void run(){
//        try {
//            while(isPause) {
//                Thread.sleep(2000);
//            }
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
}
