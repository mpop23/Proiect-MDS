package com.example.mihaipop.firebaseapp;

/**
 * Created by Gabriel on 05.06.2017.
 */

import android.content.Context;
import android.widget.Toast;

/**
 * Utility class for use within the application.
 */
public class Util {

    /**
     * @param context
     * @param text    The message to be displayed to the user (i.e. a information)
     */
    public static void showMessage(Context context, String text) {
        Toast mToast = Toast.makeText(context, text, Toast.LENGTH_LONG);
        mToast.show();
    }

}
