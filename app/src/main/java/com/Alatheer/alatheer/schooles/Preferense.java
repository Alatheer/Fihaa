package com.Alatheer.alatheer.schooles;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Elashry on 2/16/2018.
 */

public class Preferense {

    Context context;

    public Preferense(Context context) {
        this.context = context;
    }

    public void CreateSharedPref(String id ,String user_type) {
        SharedPreferences pref = context.getSharedPreferences("id", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("user_type",user_type);
        editor.putString("user_id", id);

        editor.apply();

    }

    public void clear() {
        SharedPreferences pref = context.getSharedPreferences("id", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.clear();
        editor.apply();
    }

    /*public void CreateSharedPrefParent(String id ) {
        SharedPreferences pref = context.getSharedPreferences("id", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("parent_id", id);

        editor.apply();

    }

    public void clearParent() {
        SharedPreferences pref = context.getSharedPreferences("id", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.clear();
        editor.apply();
    }*/
}
