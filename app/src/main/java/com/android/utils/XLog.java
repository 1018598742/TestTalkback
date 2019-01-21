package com.android.utils;

import android.os.Environment;
import android.util.Log;

import com.android.talkback.BuildConfig;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class XLog {
    private static final boolean isDebug = BuildConfig.DEBUG;


    public static void itest(String tag, String message) {
        if (message == null) {
            return;
        }
        if (isDebug) {
            Log.i(tag, message);
        }
    }

    public static void itest(String message) {
        if (message == null) {
            return;
        }
        if (isDebug) {
            Log.i("My_Test", message);
        }
    }

    public static void i(String tag, String message) {
        if (message == null) {
            return;
        }
        if (isDebug) {
            Log.i(tag, message);
        }
    }

    public static void d(String tag, String message) {
        if (message == null) {
            return;
        }
        Log.d(tag, message);
    }

    public static void w(String tag, String message) {
        if (message == null) {
            return;
        }
        if (isDebug) {
            Log.w(tag, message);
        }
    }

    public static void w1(final String tag, final String message) {
        if (message == null) {
            return;
        }
//        if (isDebug) {
//            Log.w(tag, message);
//            Observable.create(new ObservableOnSubscribe<String>() {
//                @Override
//                public void subscribe(ObservableEmitter<String> emitter) throws Exception {
//                    writeLog(tag, message);
//                }
//            }).subscribeOn(Schedulers.newThread()).subscribe();
//        }
    }

    public static void e(String tag, String message) {
        if (message == null) {
            return;
        }

        if (isDebug) {
            Log.e(tag, message);
        }
    }

    private static void writeLog(String tag, String message) {
//        if (!BuildConfig.LOG_ENABLE) {
//            return;
//        }
        FileOutputStream fos = null;
        try {
            File file = new File(Environment.getExternalStorageDirectory(), "logs");
            if (!file.exists()) {
                file.mkdirs();
            }
            fos = new FileOutputStream(new File(file, "mdm_log.txt"), true);
            fos.write(String.format(Locale.CHINA, "%s-%s: %s \n", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA).format(new Date()), tag, message).getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fos != null) {
                    fos.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
