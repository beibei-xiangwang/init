package com.beibei.init.common.utils;

import android.content.Context;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by dashen10 on 2015/8/11.
 */
public class ToastUtils {
    private static Toast toast;

    public static void showToast(Context context, String content) {
        if (toast == null) {
            toast = Toast.makeText(context.getApplicationContext(), content, Toast.LENGTH_SHORT);
        } else {
            toast.setText(content);
        }
        toast.show();
    }

    public static void showToast(Context context, int strID) {
        showToast(context, context.getString(strID));
    }

    /**
     * 自定义中部toast
     * @param context
     */
    public static void setDefineToast(Context context,int padding) {
        if (toast == null) {
            toast = Toast.makeText(context, "", Toast.LENGTH_SHORT);
            ViewGroup toastView = (ViewGroup) toast.getView();
            TextView child = new TextView(context.getApplicationContext());
            child.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ScreenUtils.dip2px(context.getApplicationContext(),padding)));
            toastView.addView(child, 0);
            TextView child1 = new TextView(context.getApplicationContext());
            child1.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ScreenUtils.dip2px(context.getApplicationContext(),padding)));
            toastView.addView(child1,2);
            toast.setGravity(Gravity.CENTER, 0, 0);
        }
    }
    /**
     * 自定义中部toast(默认10dp上下内间距)
     * @param context
     */
    public static void setDefineToast(Context context) {
        setDefineToast(context,10);
    }
}
