package com.zoujuequn.baseproject.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.zoujuequn.baseproject.R;

import java.util.Set;

/**
 * <pre>
 *     author: Zou Juequn
 *     desc  : IntentUtils类
 *     email:15695947865@139.com
 * </pre>
 */
public class IntentUtils {

	public static void gotoActivity(Context context, Class<?> gotoClass ) {
		Intent intent = new Intent();
		intent.setClass(context, gotoClass);
		context.startActivity(intent);
		((Activity) context).overridePendingTransition(R.anim.enter_exit, R.anim.enter_enter);
	}
	
	public static void gotoActivityToTopAndFinish(Context context, Class<?> gotoClass) {
		Intent intent = new Intent();
		intent.setClass(context, gotoClass);
		intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		context.startActivity(intent);
		((Activity) context).finish();
		((Activity) context).overridePendingTransition(R.anim.enter_exit, R.anim.enter_enter);
	}
	
	public static void gotoActivityToTopAndFinish(Context context, Class<?> gotoClass , Bundle bundle) {
		Intent intent = new Intent();
		intent.putExtras(bundle);
		intent.setClass(context, gotoClass);
		intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		context.startActivity(intent);
		((Activity) context).finish();
		((Activity) context).overridePendingTransition(R.anim.enter_exit, R.anim.enter_enter);
	}
	
	public static void gotoActivity(Context context, Class<?> gotoClass, Bundle bundle) {
		Intent intent = new Intent();
		intent.setClass(context, gotoClass);
		intent.putExtras(bundle);
		context.startActivity(intent);
		((Activity) context).overridePendingTransition(R.anim.enter_exit, R.anim.enter_enter);
	}
	
	public static void gotoActivityForResult(Context context, Class<?> gotoClass, int requestCode) {
		Intent intent = new Intent();
		intent.setClass(context, gotoClass);
		((Activity) context).startActivityForResult(intent, requestCode);
		((Activity) context).overridePendingTransition(R.anim.enter_exit, R.anim.enter_enter);
	}
	
	public static void gotoActivityForResult(Context context, Class<?> gotoClass, Bundle bundle, int requestCode) {
		Intent intent = new Intent();
		intent.setClass(context, gotoClass);
		intent.putExtras(bundle);
		((Activity) context).startActivityForResult(intent, requestCode);
		((Activity) context).overridePendingTransition(R.anim.enter_exit, R.anim.enter_enter);
	}
	
	public static void gotoActivityAndFinish(Context context, Class<?> gotoClass) {
		Intent intent = new Intent();
		intent.setClass(context, gotoClass);
		context.startActivity(intent);
		((Activity) context).finish();
		((Activity) context).overridePendingTransition(R.anim.enter_exit, R.anim.enter_enter);
	}
	

	public static void gotoActivityAndFinish(Context context, Class<?> gotoClass, Bundle bundle) {
		Intent intent = new Intent();
		intent.setClass(context, gotoClass);
		intent.putExtras(bundle);
		context.startActivity(intent);
		((Activity) context).finish();
		((Activity) context).overridePendingTransition(R.anim.enter_exit, R.anim.enter_enter);
	}
	

	public static void gotoActivityToTop(Context context, Class<?> gotoClass) {
		Intent intent = new Intent();
		intent.setClass(context, gotoClass);
		intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		context.startActivity(intent);
		((Activity) context).overridePendingTransition(R.anim.enter_exit, R.anim.enter_enter);
	}
	

	public static void gotoActivityToTop(Context context, Class<?> gotoClass, Bundle bundle) {
		Intent intent = new Intent();
		intent.setClass(context, gotoClass);
		intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		intent.putExtras(bundle);
		context.startActivity(intent);
		((Activity) context).overridePendingTransition(R.anim.enter_exit, R.anim.enter_enter);
	}
	
	/**
	 * @updateTime 2017.2.10
	 * @createAuthor Zou Juequn
	 */
	public static String getIntentInfo(Intent intent){
		StringBuilder builder = new StringBuilder();
		Bundle bd = intent.getExtras();
		Set<String> set = bd.keySet();
		for(String key:set){
			builder.append("[");
			builder.append(key+":");
			builder.append(bd.get(key));
			builder.append("]");
		}
		return builder.toString();
	}
	
}
