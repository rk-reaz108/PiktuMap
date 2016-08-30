package com.example.piktotestmap.utils;
 

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class SharedPreferenceHelper {
	// App Preferences
	private static final String PREFS_FILE_NAME = "AppPreferences";	

	public static Boolean getBoolean(final Context ctx,String key) {
		return ctx.getSharedPreferences(SharedPreferenceHelper.PREFS_FILE_NAME,
				Context.MODE_PRIVATE).getBoolean(key, true);
	}


	public static void setBoolean(final Context ctx,String key, Boolean flag) {
		final SharedPreferences prefs = ctx.getSharedPreferences(
				SharedPreferenceHelper.PREFS_FILE_NAME, Context.MODE_PRIVATE);
		final Editor editor = prefs.edit();
		editor.putBoolean(key, flag);
		editor.commit();
	}

}
