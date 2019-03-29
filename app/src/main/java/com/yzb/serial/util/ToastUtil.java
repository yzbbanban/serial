package com.yzb.serial.util;

import android.os.Looper;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.yzb.serial.R;
import com.yzb.serial.app.SerialApplication;


/**
 * Created by brander on 2017/9/21.
 */

public class ToastUtil {
    private static Toast toast;//实现不管我们触发多少次Toast调用，都只会持续一次Toast显示的时长

    /**
     * 短时间显示Toast【居下】
     *
     * @param msg 显示的内容-字符串
     */
    public static void showShortToast(String msg) {
        if (SerialApplication.getAppContext() != null) {
            if (toast == null) {
                toast = Toast.makeText(SerialApplication.getAppContext(), msg, Toast.LENGTH_SHORT);
            } else {
                toast.setText(msg);
            }
            toast.show();
        }
    }

    /**
     * 短时间显示Toast【居中】
     *
     * @param msg 显示的内容-字符串
     */
    public static void showShortToastCenter(String msg) {
        if (SerialApplication.getAppContext() != null) {
            if (toast == null) {
                toast = Toast.makeText(SerialApplication.getAppContext(), msg, Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0, 0);
            } else {
                toast.setText(msg);
            }
            toast.show();
        }
    }

    /**
     * 短时间显示Toast【居上】
     *
     * @param msg 显示的内容-字符串
     */
    public static void showShortToastTop(String msg) {
        if (SerialApplication.getAppContext() != null) {
            if (toast == null) {
                toast = Toast.makeText(SerialApplication.getAppContext(), msg, Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.TOP, 0, 0);
            } else {
                toast.setText(msg);
            }
            toast.show();
        }
    }

    /**
     * 长时间显示Toast【居下】
     *
     * @param msg 显示的内容-字符串
     */
    public static void showLongToast(String msg) {
        if (SerialApplication.getAppContext() != null) {
            if (toast == null) {
                toast = Toast.makeText(SerialApplication.getAppContext(), msg, Toast.LENGTH_LONG);
            } else {
                toast.setText(msg);
            }
            toast.show();
        }
    }

    /**
     * 长时间显示Toast【居中】
     *
     * @param msg 显示的内容-字符串
     */
    public static void showLongToastCenter(String msg) {
        if (SerialApplication.getAppContext() != null) {
            if (toast == null) {
                toast = Toast.makeText(SerialApplication.getAppContext(), msg, Toast.LENGTH_LONG);
                toast.setGravity(Gravity.CENTER, 0, 0);
            } else {
                toast.setText(msg);
            }
            toast.show();
        }
    }

    /**
     * 长时间显示Toast【居上】
     *
     * @param msg 显示的内容-字符串
     */
    public static void showLongToastTop(String msg) {
        if (SerialApplication.getAppContext() != null) {
            if (toast == null) {
                toast = Toast.makeText(SerialApplication.getAppContext(), msg, Toast.LENGTH_LONG);
                toast.setGravity(Gravity.TOP, 0, 0);
            } else {
                toast.setText(msg);
            }
            toast.show();
        }
    }
//
//    /**
//     * 显示
//     */
//    public static void ToastShow(String msg) {
//        View view = LayoutInflater.from(SerialApplication.getAppContext()).inflate(R.layout.toast_tms, null);
//        TextView text = (TextView) view.findViewById(R.id.textToast);
//        if (toast == null) {
//            toast = new Toast(SerialApplication.getAppContext());
//            toast.setGravity(Gravity.TOP, 0, 0);
//        }
//        text.setText(msg);
//        toast.setDuration(Toast.LENGTH_SHORT); // Toast显示的时间
//        toast.setView(view);
//        toast.show();
//    }

    public static void ToastShow(String msg) {

        Toast.makeText(SerialApplication.getAppContext(), msg, Toast.LENGTH_SHORT).show();
    }

}
