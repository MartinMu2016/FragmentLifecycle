package com.martin.fragment.lifecycle;

import android.content.Context;
import android.widget.Toast;

/**
 * <p>
 * Package Name:com.martin.fragment.lifecycle
 * </p>
 * <p>
 * Class Name:ToastUtil
 * <p>
 * Description:Toast kit
 * </p>
 *
 * @Author Martin
 * @Version 1.0 2018/11/12 10:30 AM Release
 * @Reviser:
 * @Modification Time:2018/11/12 10:30 AM
 */
public class ToastUtil {

    public static void showToast(Context context,String toast) {
        Toast.makeText(context, toast, Toast.LENGTH_SHORT).show();
    }
}
