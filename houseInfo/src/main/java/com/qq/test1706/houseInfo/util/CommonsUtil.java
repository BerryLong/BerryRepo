package com.qq.test1706.houseInfo.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.UUID;

/**
 * 封装部分方法工具类
 * @author 龙保运
 *
 */
public final class CommonsUtil {

	private static final String CHARS = "1234567890qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM";

	private CommonsUtil() {
		throw new AssertionError();
	}

	/**
	 * 生成x到y的随机数
	 * 
	 * @param x 起始整数
	 * @param y 终止整数
	 * @return 对应的随机整数
	 */
	public static int getRandomInt(int x, int y) {
		return (int) (Math.random() * (y - x) + x);
	}

	/**
	 * 生成字母数字的随机指定个数的字符串组合
	 * 
	 * @return 字符串
	 */
	public static String generateCode(int len) {
		StringBuilder str = new StringBuilder();
		for (int i = 0; i < len; i++) {
			int random = getRandomInt(0, CHARS.length());
			str.append(CHARS.charAt(random));
		}

		return str.toString();
	}

	/**
	 * 根据指定的验证码生成对应的图片
	 * 
	 * @param code     验证码
	 * @param width   图片宽度
	 * @param height  图片高度
	 * @return
	 */
	public static BufferedImage generateCodeImage(String code, int width, int height) {
		BufferedImage codeImage = new BufferedImage(width, height, 1);
		Graphics2D g = (Graphics2D) codeImage.getGraphics();
		g.setColor(Color.decode("#99CCFF"));
		g.fillRect(0, 0, width, height);
		g.setColor(Color.BLUE);
		int size = (width - 10) / code.length();
		g.setFont(new Font("Arial", Font.BOLD, size));
		for (int i = 0; i < code.length(); i++) {
			String str = code.substring(i, i + 1);
			g.drawString(str, 5+size * i, height/2);
		}
		for(int i=0;i<20;i++) {
			g.setColor(Color.decode("#CC66FF"));
			int x1 = getRandomInt(0,width);
			int x2 = getRandomInt(0,width);
			int y1 = getRandomInt(0,width);
			int y2 = getRandomInt(0,width);
			g.drawLine(x1, y1, x2, y2);
		}
		return codeImage;
	}
	
	/**
	 * 获取文件名的后缀
	 * @param filename
	 * @return
	 */
	public static String getFilenameSuffix(String filename) {
		assert filename != null;
		int index = filename.lastIndexOf(".");
		return index > 0 && index < filename.length() - 1  ?
			filename.substring(index)  : "";
	}
	/**
	 * 获取随机唯一文件名
	 * @return
	 */
	public static String getRondomFilename() {
		return UUID.randomUUID().toString();
	}
}
