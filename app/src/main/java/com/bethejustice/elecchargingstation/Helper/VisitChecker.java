package com.bethejustice.elecchargingstation.Helper;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

public class VisitChecker {
    private static final String TAG = "VisitChecker";

    final static String KEY_CHECK_VISIT = "visit";
    final static String KEY_IS_VISITED = "visited";

    private static VisitChecker instance = null;
    private static Context context;


    private static SharedPreferences mSharedPreferences;
    private static SharedPreferences.Editor editor;

    private VisitChecker(Context context){
        this.context = context;
    }

    public static VisitChecker getInstance(Context context){
        if(instance == null){
            instance = new VisitChecker(context);
        }

        return instance;
    }

    public void setSharedPreferences(){
        mSharedPreferences = context.getSharedPreferences(KEY_CHECK_VISIT, Context.MODE_PRIVATE);
        editor = mSharedPreferences.edit();
        editor.putBoolean(KEY_IS_VISITED, false);
        editor.commit();
    }


    public boolean isVisited(){
        Log.d(TAG, "isVisited: started");
            return mSharedPreferences.getBoolean(KEY_IS_VISITED, false);
    }

    public void setVisited(){
        Log.d(TAG, "setVisited: started");
        boolean temp = isVisited();
        if(temp) editor.remove(KEY_IS_VISITED);

        editor.putBoolean(KEY_IS_VISITED, true);
    }
}
