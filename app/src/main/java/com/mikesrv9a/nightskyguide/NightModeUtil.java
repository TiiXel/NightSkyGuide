package com.mikesrv9a.nightskyguide;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.preference.PreferenceManager;
import android.view.Menu;

public class NightModeUtil {

    static public boolean isEnabled(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean("night_mode", false);
    }

    static public void colorizeOptionMenu(Context context, Menu menu) {
        if (isEnabled(context)) {
            for (int count = 0; count < menu.size(); count++) {
                Drawable drawable = menu.getItem(count).getIcon();
                if (drawable != null) {
                    drawable.mutate();
                    drawable.setColorFilter(context.getResources().getColor(R.color.colorNightAccent), PorterDuff.Mode.MULTIPLY);
                }
            }
        }
    }
}
