package com.willkernel.app.javadesignmode.utils;

import android.os.Environment;
import android.util.Log;

import com.willkernel.app.javadesignmode.BuildConfig;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.text.SimpleDateFormat;
import java.util.Locale;

/**
 * A good convention is to declare a TAG constant in your class
 * private static final String TAG = "MyActivity"
 * that when you're building the string to pass into Log.d,
 * the compiler uses a StringBuilder and at least three allocations occur
 * the StringBuilder itself, the buffer, and the String object.
 * Realistically, there is also another buffer allocation and copy, and even more pressure on the gc.
 * That means that if your log message is filtered out, you might be doing significant work and incurring significant overhead.
 */
@SuppressWarnings({"unused", "PointlessBooleanExpression"})
public class LogWK {
    private static final boolean debug = true;
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd HH:mm:ss", Locale.CHINA);
    private static final String WK_LOGO = "\nwillkernel^_^ ";

    public static void show(String tag, String msg) {
        if (!debug)
            return;
        Log.println(Log.ERROR, tag, msg);
    }

    public static void showSave(String tag, String msg) {
        if (!debug)
            return;
        Log.println(Log.ERROR, tag, msg);
        saveLog(tag, msg);
    }

    public static void show(int priority, String tag, String msg) {
        if (!debug)
            return;
        Log.println(priority, tag, msg);
        if (priority == Log.ERROR) {
            saveLog(tag, msg);
        }
    }

    private static void saveLog(String tag, String msg) {
        File logDir = new File(Environment.getExternalStorageDirectory(), BuildConfig.APPLICATION_ID + File.separator + "LogWK");
        if (!logDir.exists())
            //noinspection ResultOfMethodCallIgnored
            logDir.mkdirs();
        File logFile = new File(logDir, sdf.format(System.currentTimeMillis()) + ".txt");
        try {
            write(msg, logFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void read(File logFile) throws IOException {
        if (!logFile.exists()) {
            try {
                //noinspection ResultOfMethodCallIgnored
                logFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //读
        FileChannel fic = new FileInputStream(logFile).getChannel();
        ByteBuffer rbb = ByteBuffer.allocateDirect((int) logFile.length());
        int n = fic.read(rbb);//将数据从通道读入字节缓冲中

        //初始化一个字节数组，这个字节数组的长度不能大于这个字节缓冲的limit-position的长度，不然会抛出java.nio.BufferUnderflowException
        byte[] rData = new byte[rbb.position()];
        rbb.flip();
        rbb.get(rData);//将数据从字节缓冲区读入数组
        rbb.clear();
        fic.close();
        System.out.print(WK_LOGO + "read n=" + n);
//        System.out.print(WK_LOGO + new String(rData, "utf-8"));
    }

    private static void write(String msg, File logFile) throws IOException {
        if (!logFile.exists()) {
            try {
                //noinspection ResultOfMethodCallIgnored
                logFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //写
        FileChannel foc = new FileOutputStream(logFile).getChannel();
        byte[] data = msg.getBytes("utf-8");//获取msg的字节数据
        ByteBuffer bb = ByteBuffer.allocateDirect(data.length);//字节缓冲区,allocate(1024),不同方式获取字节缓冲区
        long start = System.currentTimeMillis();
        bb.put(data);// Writes bytes in the given byte array to the current position and increases the position by the number of bytes written.
        bb.flip();// The limit is set to the current position, then the position is set to zero, and the mark is cleared.
        int n = foc.write(bb);
        System.out.print(WK_LOGO + "spend=" + (System.currentTimeMillis() - start) + "  write n=" + n);
        bb.clear();
        foc.close();//关闭通道
//        read(logFile);
    }
}