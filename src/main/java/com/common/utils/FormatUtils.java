package com.common.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.apache.logging.log4j.core.util.datetime.FastDateFormat;



public class FormatUtils {
    public static Date parseDateTime(String text) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(text);
        } catch (Exception e) {
            return null;
        }
    }

    public static Date parseDateTimeMs(String text) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").parse(text);
        } catch (Exception e) {
            return null;
        }
    }
    public static Date parseDateTime(String text, String pattern) {
        SimpleDateFormat fmt = new SimpleDateFormat(pattern);
        try {
            return fmt.parse(text);
        } catch (Exception e) {
            return null;
        }
    }
    public static Date parseDateTime(String text, String pattern, Locale locale) {
        SimpleDateFormat fmt = new SimpleDateFormat(pattern, locale);
        try {
            return fmt.parse(text);
        } catch (Exception e) {
            return null;
        }
    }

//    public static String fmtDateTime(Date dt, String pattern) {
//        if (dt == null) return "";
//        return DateFormatUtils.format(dt, pattern);
//    }

    public static FastDateFormat fmt_DateTime = FastDateFormat.getInstance("yyyy-MM-dd HH:mm:ss");

    public static String fmtDateTime(Date dt) {
        if(dt==null)
        return "";
        return fmt_DateTime.format(dt);
    }

    public static String fmtDateTimeMS(Date dt) {
        if(dt==null)
        return "";
        return FastDateFormat.getInstance("yyyy-MM-dd HH:mm:ss.SSS").format(dt);
    }

    public static String fmtDate(Date dt) {
        if(dt==null)return "";
        return new SimpleDateFormat("yyyy-MM-dd").format(dt);
    }

    public static String fmtTime(Date dt) {
        return FastDateFormat.getInstance("HH:mm:ss").format(dt);
    }


    public static String fmtLongDate(Date dt){
        return new SimpleDateFormat("yyyy-MM-dd EEE", Locale.CHINA).format(dt);
    }


    public static FastDateFormat fmt_ShortDateTime = FastDateFormat.getInstance("MM-dd HH:mm");

    public static String fmtShortDateTime(Date dt) {
        return fmt_ShortDateTime.format(dt);
    }

    public static FastDateFormat fmt_ShortDate = FastDateFormat.getInstance("MM-dd");

    public static String fmtShortDate(Date dt) {
        return fmt_ShortDate.format(dt);
    }

    public static FastDateFormat fmt_ShortTime = FastDateFormat.getInstance("HH:mm");

    public static String fmtShortTime(Date dt) {
        return fmt_ShortTime.format(dt);
    }



    public static CharSequence quote(int id) {
        return "'" + id + "'";
    }

    public static Date parseDate(String dayCode) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(dayCode);
        } catch (Exception e) {
            return null;
        }
    }
    
    public static Date parseDate(String text, String pattern, Locale locale) {
        SimpleDateFormat fmt = new SimpleDateFormat(pattern, locale);
        try {
            return fmt.parse(text);
        } catch (Exception e) {
            return null;
        }
    }

    public static void main(String[] args){
        String x = "2017-04-29 00:00:00";
        //FormatUtils.f
    }
}