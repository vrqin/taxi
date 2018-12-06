package com.speedtalk.utils;


import org.apache.log4j.Logger;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel.MapMode;
import java.text.SimpleDateFormat;


public class TimeFileOpr {
    private static final int SIZE = 8;
    private MappedByteBuffer buffer;
    /*  15 */   private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    private String fileName;


    public TimeFileOpr(String fileName) {
        /*  20 */
        this.fileName = fileName;

        try {
            /*  23 */
            this.buffer = new RandomAccessFile(this.fileName, "rw").getChannel()
                    /*  24 */.map(MapMode.READ_WRITE, 0L, 8L);

        } catch (FileNotFoundException e) {
            /*  28 */
            ExcepPrinter.print(e);

        } catch (IOException e) {
            /*  32 */
            ExcepPrinter.print(e);

        }

    }


    public static void main(String[] args) {

    }


    public String getFileName() {
        /*  37 */
        return this.fileName;

    }


    public void setFileName(String fileName) {
        /*  41 */
        this.fileName = fileName;

    }


    public long getTime(Logger log) {
        /*  56 */
        long oldTime = read();
        /*  57 */
        if (oldTime == 0L) {

            try {
                /*  61 */
                String configDate = (String) LoadXmlConfig.getConfigHash().get("init-time");
                /*  62 */
                oldTime = this.sdf.parse(configDate).getTime();
                /*  63 */
                write(oldTime);
                /*  64 */
                if (log != null)
                    /*  65 */
                    log.debug("从配置文件初始化扫描时间点：" + configDate);

                else
                    /*  67 */           System.out.println("从配置文件初始化扫描时间点：" + configDate);

            } catch (Exception e) {
                /*  71 */
                ExcepPrinter.print(e);
                /*  72 */
                oldTime = System.currentTimeMillis();
                /*  73 */
                write(oldTime);
                /*  74 */
                if (log != null) {
                    /*  75 */
                    log.debug("！！！初始化扫描数据的开始时间产生异常,已用当前系统时间初始化！请确认配置文件存在<init-time>项，并且格式为yyyy-MM-dd hh:mm:ss！如果当前系统时间不符合要求，请执行clearTime.sh脚本后，重启服务！");

                } else {
                    /*  79 */
                    System.out.println("！！！初始化扫描数据的开始时间产生异常,已用当前系统时间初始化！请确认配置文件存在<init-time>项，并且格式为yyyy-MM-dd hh:mm:ss！如果当前系统时间不符合要求，请执行clearTime.sh脚本后，重启服务！");

                }

            }

        }

        /*  84 */
        return oldTime;

    }


    public void updateTime(long time) {
        /* 122 */
        write(time);

    }


    private void write(long time) {
        /* 127 */
        this.buffer.putLong(time);
        /* 128 */
        this.buffer.flip();

    }


    public long read() {
        /* 133 */
        long data = this.buffer.getLong();
        /* 134 */
        this.buffer.clear();
        /* 135 */
        return data;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\STutils\
 * Qualified Name:     com.speedtalk.utils.TimeFileOpr
 * JD-Core Version:    0.6.0
 */