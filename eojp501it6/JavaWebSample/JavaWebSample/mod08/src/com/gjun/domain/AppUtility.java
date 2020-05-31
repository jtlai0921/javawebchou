package com.gjun.domain;

import java.util.Calendar;

public class AppUtility {
	//回應現在的民國日期
	public static String chineseDate() {
		Calendar calendar=Calendar.getInstance();
		int year=calendar.get(Calendar.YEAR)-1911;
		int month=calendar.get(Calendar.MONTH)+1;
		String m=(month+"").length()==2?month+"":"0"+month;
		int day=calendar.get(Calendar.DAY_OF_MONTH);
		String d=(day+"").length()==2?day+"":"0"+day;
		return year+"/"+m+"/"+d;
	}

}
