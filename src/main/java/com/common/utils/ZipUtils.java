package com.common.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/**
 * @author lgl
 */
public class ZipUtils {
	//private static String encode =  "ISO-8859-1";
	private static String encode =  "utf-8";
	
	
	// 压缩
	public static String compress(String str) throws IOException {
		if (str == null || str.length() == 0) {
			return str;
		}
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		GZIPOutputStream gzip = new GZIPOutputStream(out);
		gzip.write(str.getBytes());
		gzip.close();
		//进行base64编码，否则在XML中传输会有问题
		return Base64.encode(out.toByteArray());//out.toString(encode);
	}

	// 压缩
	public static byte[] compressObject(Object obj) throws IOException {
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		GZIPOutputStream gzipos = new GZIPOutputStream(bos);
		ObjectOutputStream oos = new ObjectOutputStream(gzipos);
		
		oos.writeObject(obj);
		oos.flush();
		
		gzipos.close();
		return bos.toByteArray();
	}

	// 解压缩
	public static String uncompress(String str) throws IOException {
		if (str == null || str.length() == 0) {
			return str;
		}
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		ByteArrayInputStream in = new ByteArrayInputStream(Base64.decode(str)
				 		 );
		GZIPInputStream gunzip = new GZIPInputStream(in);
		byte[] buffer = new byte[256];
		int n;
		while ((n = gunzip.read(buffer)) >= 0) {
			out.write(buffer, 0, n);
		}
		return out.toString();
	}

	// 解压缩
	public static Object uncompressObject(byte[] byteArray) throws IOException, ClassNotFoundException {
		if (byteArray == null || byteArray.length == 0) {
			return null;
		}
		
		ByteArrayInputStream bis = new ByteArrayInputStream(byteArray);
		GZIPInputStream gzipis = new GZIPInputStream(bis);
		ObjectInputStream ois = new ObjectInputStream(gzipis);
		
		return ois.readObject();
	}

	// 测试方法
	public static void main(String[] args) throws IOException, ClassNotFoundException {
//
////		// 测试字符串
////		String str = "中文";
////
////		System.out.println("原长度：" + str.length());
////
////		System.out.println("压缩后：" + ZipUtils.compress(str).length());
////
////		System.out
////				.println("解压缩：" + ZipUtils.uncompress(ZipUtils.compress(str)));
//		// 测试字符串
//		BaseWSBean bean = new BaseWSBean();
//		List list = new ArrayList();
//		list.add("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
//		list.add("bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb");
//		list.add("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
//		list.add("bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb");
//		bean.setList(list);
//
//		ByteArrayOutputStream bos = new ByteArrayOutputStream();
//		ObjectOutputStream oos = new ObjectOutputStream(bos);
//		
//		oos.writeObject(bean);
//		oos.flush();
//		
//		System.out.println("原长度：" + bos.toByteArray().length);
//		oos.close();
//		bos.close();
//
//		System.out.println("压缩后：" + ZipUtils.compressObject(bean).length);
//
//		System.out.println("解压缩：" + ZipUtils.uncompressObject(ZipUtils.compressObject(bean)));
	}
}
