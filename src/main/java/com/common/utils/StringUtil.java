package com.common.utils;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.sql.Date;
import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.util.StringUtils;

public class StringUtil {
	
	/**
	 * 去掉字符串两端的空格，NULL时返回"" 
	 * @param s
	 * @return
	 */
	public static String trim(String s){
		return s==null ? "" : s.trim() ;		
	}
	
	/**
	 * 将日期转成字串，NULL时返回""
	 * @param d
	 * @return
	 */
	public static String dateToString(Date d){
		
		return d==null ? "" : d.toString() ;		
	}
	
	/**
	 * 将小数转成百分数字串
	 * @param f
	 * @return
	 */
	public static String floatToPercent(float f){		 
		long l = (long) (f*10000) ;
				
		if(l%10 > 4){
			f = (f*100 + 0.1f) ;
		}else{
			f = f*100 ;
		}	
		String s = String.valueOf(f) ;
		int dot = s.indexOf(".") ;
		
		s = s.substring(0, (dot + 3 > s.length()) ? s.length() : dot + 3);
		if(s.endsWith(".00")){
			s = s.substring(0, dot) ;
		}
		
		return s + "%";				
	}
	
	/**
	 * 将小数转成百分数字串
	 * @param f
	 * @return
	 */
	public static String doubleToPercent(double f){		 
		long l = (long) (f*10000) ;
				
		if(l%10 > 4){
			f = (f*100 + 0.1d) ;
		}else{
			f = f*100 ;
		}	
		String s = String.valueOf(f) ;
		int dot = s.indexOf(".") ;
		
		s = s.substring(0, (dot + 3 > s.length()) ? s.length() : dot + 3);
		if(s.endsWith(".00")){
			s = s.substring(0, dot) ;
		}
		
		return s + "%";				
	}
	
	/**
	 * 将小数转成百分数字串
	 * @param val
	 * @return
	 */
	public static String bigDecimalToPercent(BigDecimal val) {
		val = val.multiply(BigDecimal.valueOf(100)).setScale(2, BigDecimal.ROUND_HALF_UP);
		return new DecimalFormat("0.00").format(val) + "%";
	}
	
//	/**
//	 * 将小数转成货币字串，转成小数后2~6位; 
//	 * @param val
//	 * @param precision 精度，小于2取2位，大于6只取6位
//	 * @return
//	 */
//	public static String bigDecimalToMoney(BigDecimal val, int precision) {
//		if(precision < 2){ 
//			precision = 2 ;
//		}
//		else if(precision > 6){
//			precision = 6 ;
//		}
//		val = val.setScale(precision, BigDecimal.ROUND_HALF_UP);
//		return new DecimalFormat("#0." + StringUtils.repeat("0", precision)).format(val);
//	}
	
	/**
	 * 将小数转成货币字串，转成小数后2~6位; 
	 * @param f
	 * @param precision 精度，小于2取2位，大于6只取6位
	 * @return
	 */
	public static String floatToMoney(float f, int precision){	
		if(precision < 2){ 
			precision = 2 ;
		}
		else if(precision > 6){
			precision = 6 ;
		}
		String _times = "10" ;		
		String afterPrecisionBit = "0." ;
		for(int i=0; i<precision; i++){
			_times += "0" ;			
			if(i>0){ //四舍五入前一位
				afterPrecisionBit  += "0" ;	
			}			
		}		
		int times = Integer.parseInt(_times) ; 

		//四舍五入位
		long precisionBit = (long) (f*(times)) ;
				
		if(precisionBit%10 > 4){//进位
			afterPrecisionBit += "1" ;			
			f += (Float.parseFloat(afterPrecisionBit)) ;
		}
		
		String s = String.valueOf(f) ;
		int dot = s.indexOf(".")  ;
		
		String afterDot = s.substring(dot) ;
		
		int len = precision - (afterDot.length() -1) ;
		if(len>0){
			for(int i=0; i<len; i++){
				s += "0" ;
			}			
			return s ;
		}
		
		return s.substring(0, dot+precision+1) ;		
	}
	
	public String Html2Text(String   str,String token) {   
		  String   sRet=str;   
		  while(sRet.indexOf(token.equals("") ? "<":token)>=0)   
		  {   
			  String   str1   =   "";   
		      String   str2   =   "";   
		      str1   =   sRet.substring(0,sRet.indexOf(token.equals("") ? "<":token));   
		      str2   =   sRet.substring(sRet.indexOf(token.equals("") ? "<":token)+1,sRet.length());	      
		      str2 = str2.substring(str2.indexOf(">")+1);
		      
		      sRet   =   str1   +   str2;   
		  }
		  System.out.println(sRet);
		  return   sRet;  	  
	} 
	
	
	/**
	 * 清除字符串中的回车、换行、TAB键
	 * @param str
	 * @return
	 */
	public static String replaceBlank(String str) {
		String dest = "";
		if (str != null) {
			Pattern p = Pattern.compile("\\s*|\t|\r|\n");
			Matcher m = p.matcher(str);
			dest = m.replaceAll("");
		}
		return dest;
	}
	
	/**
	 * 字符串+1方法，该方法将其结尾的整数+1,适用于任何以整数结尾的字符串,不限格式，不限分隔符。
	 * 
	 * @author zxcvbnmzb
	 * @param str 要+1的字符串
	 * @return +1后的字符串
	 * @exception NumberFormatException
	 */
	public static String addOne(String str) {
		String[] strs = str.split("[^0-9]");// 根据不是数字的字符拆分字符串
		String numStr = strs[strs.length - 1];// 取出最后一组数字
		if (!StringUtils.isEmpty(numStr)) {// 如果最后一组没有数字(也就是不以数字结尾)
			int n = numStr.length();// 取出字符串的长度
			long num = Long.parseLong(numStr) + 1;// 将该数字加一
			String added = String.valueOf(num);
			n = Math.min(n, added.length());
			// 拼接字符串
			return str.subSequence(0, str.length() - n) + added;
		} else {
			return str + "1";
		}
	}
//	
//	public static void main(String[] args) {
//		System.out.println(bigDecimalToMoney(BigDecimal.valueOf(620148969), 2));
//	}
}
