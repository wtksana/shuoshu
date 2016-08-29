package com.shuoshu.util;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.math.NumberUtils;

import java.math.BigDecimal;

/**
 * 工具类-BigDecimal算法
 * 
 * @author zyz
 * @version 2.0
 * @since 2014年1月28日
 */
public class BigDecimalUtils {
	private static int DEF_DIV_SCALE = 2; // 默认精确的小数位

	/**
	 * 提供精确的加法运算。
	 * 
	 * @param params
	 *            加数和被加数
	 * @return 和
	 */
	public static BigDecimal add(BigDecimal... params) {
		BigDecimal b1 = new BigDecimal(0);
		for (BigDecimal param : params) {
			if(null!=param){
				b1 = b1.add(param);
			}
		}
		return b1;
	}

	/**
	 * 提供精确的减法运算。
	 * 
	 * @param v1
	 *            被减数
	 * @param v2
	 *            减数
	 * @return 两个参数的差
	 */
	public static BigDecimal sub(BigDecimal v1, BigDecimal v2) {
		return v1.subtract(v2);
	}

	/**
	 * 提供精确的乘法运算。
	 * 
	 * @param params
	 *            被乘数
	 * @param params
	 *            乘数
	 * @return 两个参数的积
	 */
	public static BigDecimal mul(BigDecimal... params) {
		BigDecimal b1 = new BigDecimal(1);
		for (BigDecimal param : params) {
			b1 = b1.multiply(param);
		}
		return round(b1);
	}
	
	/**
	 * 提供精确的乘法运算。
	 * 
	 * @param precise 是否精确计算
	 * @param params
	 *            被乘数
	 * @param params
	 *            乘数
	 * @return 两个参数的积
	 */
	public static BigDecimal mul(boolean precise, BigDecimal... params) {
		BigDecimal b1 = new BigDecimal(1);
		for (BigDecimal param : params) {
			b1 = b1.multiply(param);
		}
		if(precise) return b1;
		return round(b1);
	}

	/**
	 * 提供（相对）精确的除法运算，当发生除不尽的情况时，精确到 小数点以后2位，以后的数字四舍五入。
	 * 
	 * @param v1
	 *            被除数
	 * @param v2
	 *            除数
	 * @return 两个参数的商
	 */
	public static BigDecimal div(BigDecimal v1, BigDecimal v2) {
		return div(v1, v2, DEF_DIV_SCALE);
	}
	/**
	 * 是否整除
	 * @param v1
	 *            被除数
	 * @param v2
	 *            除数
	 * @return 两个参数的商
	 */
	public static boolean modZero(BigDecimal v1, BigDecimal v2) {
		return  v1.subtract(v2.multiply(v1.divideToIntegralValue(v2))).doubleValue()== NumberUtils.DOUBLE_ZERO;
	}
	/**
	 * 提供（相对）精确的除法运算。当发生除不尽的情况时，由scale参数指 定精度，以后的数字四舍五入。
	 * 
	 * @param v1
	 *            被除数
	 * @param v2
	 *            除数
	 * @param scale
	 *            表示表示需要精确到小数点以后几位。
	 * @return 两个参数的商
	 */
	public static BigDecimal div(BigDecimal v1, BigDecimal v2, int scale) {
		if (scale < 0) {
			throw new IllegalArgumentException("The scale must be a positive integer or zero");
		}
		return v1.divide(v2, scale, BigDecimal.ROUND_HALF_DOWN);
	}
	
	public static BigDecimal remain(BigDecimal v1, BigDecimal v2){
		return v1.divideAndRemainder(v2)[1];
	}

	/**
	 * 提供精确的小数位四舍五入处理。
	 * 
	 * @param v
	 *            需要四舍五入的数字
	 * @param scale
	 *            小数点后保留几位
	 * @return 四舍五入后的结果
	 */
	public static BigDecimal round(BigDecimal v, int scale) {
		if (scale < 0) {
			throw new IllegalArgumentException("The scale must be a positive integer or zero");
		}
		BigDecimal one = new BigDecimal("1");
		return v.divide(one, scale, BigDecimal.ROUND_HALF_DOWN);
	}

	/**
	 * 提供精确的小数位四舍五入处理。按照默认的精确位数
	 * 
	 * @param v
	 *            需要四舍五入的数字
	 * @return 四舍五入后的结果
	 */
	public static BigDecimal round(BigDecimal v) {
		BigDecimal one = new BigDecimal("1");
		return v.divide(one, DEF_DIV_SCALE, BigDecimal.ROUND_HALF_DOWN);
	}

	/**
	 * 提供精确的小数位四舍五入处理。
	 * 
	 * @param v
	 *            需要四舍五入的数字字符串
	 * @param scale
	 *            小数点后保留几位
	 * @return 四舍五入后的结果
	 */
	public static BigDecimal round(String v, int scale) {
		if (scale < 0) {
			throw new IllegalArgumentException("The scale must be a positive integer or zero");
		}
		BigDecimal b = new BigDecimal(v);
		BigDecimal one = new BigDecimal("1");
		return b.divide(one, scale, BigDecimal.ROUND_HALF_DOWN);
	}

	/**
	 * 提供精确的小数位处理，去掉保留位数后的数字
	 * 
	 * @param v
	 *            需要处理的数字
	 * @param scale
	 *            小数点后保留几位
	 * @return 去掉保留位数后的结果
	 */
	public static BigDecimal decimal(BigDecimal v, int scale) {
		if (scale < 0) {
			throw new IllegalArgumentException("The scale must be a positive integer or zero");
		}
		BigDecimal one = new BigDecimal("1");
		return v.divide(one, scale, BigDecimal.ROUND_DOWN);
	}

	/**
	 * 提供精确的小数位(2位)四舍五入处理。
	 * 
	 * @param v
	 *            需要四舍五入的数字字符串
	 *            小数点后保留2位
	 * @return 四舍五入后的结果
	 */
	public static BigDecimal round(String v) {
		BigDecimal i = new BigDecimal(0);
		if (StringUtils.isBlank(v)) {
			return i;
		}
		BigDecimal b = new BigDecimal(v);
		BigDecimal one = new BigDecimal("1");
		return b.divide(one, 2, BigDecimal.ROUND_HALF_UP);
	}
	
	/**
	 * 校验非负数
	 * @author  FangJun
	 * @date 2016年7月27日
	 * @param amount 数额
	 * @return 非负数（true),反之
	 */
	public static  boolean validAmount(BigDecimal amount){
	      if(amount==null){
	    	  return false;
	      }
	      if(amount.compareTo(BigDecimal.ZERO) >0){
	    	  return true;
	      }
		
		return false;
	}
	
	/**
	 * 
	 *  方法说明
	 * @author xhf
	 * @date 2016年8月11日
	 * @param amount
	 * @return
	 */
	public static BigDecimal valueOf(String amount){
		BigDecimal result = null;
		if(StringUtils.isNotBlank(amount)){
			result = new BigDecimal(amount);
		}
		return result;
	}
	
	/**
	 * 如果值为null返回0
	 * @author QianPengZhan
	 * @date 2016年8月12日
	 * @param amount
	 * @return
	 */
	public static BigDecimal defaultIfNull(BigDecimal amount){
		return ObjectUtils.defaultIfNull(amount, BigDecimal.ZERO);
	}
}
