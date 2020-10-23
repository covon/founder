package com.founder.utils;

import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * copyright Founder 2012
 * 
 * @date 2012/07/02 V1.0新規作成
 * 
 * @author xuwei
 * @version V1.0
 * @brief 数値変換クラスの定義
 * 
 * @since 1.0
 * @todo なし
 */
public class NumberUtils {
	/**
	 * 何もしないコンストラクタ。
	 */
	protected NumberUtils() {
	}

	/**
	 * 妥当性数字を判定し（０−９）、true又はfalseを返す
	 *
	 * @param number 変換する文字列
	 * @return boolean 有効な時、trueを返し、他のはfalseを返す。
	 */
	public static boolean checkNumberValid(String number) {
		number = StringUtils.nvl(number);
		if ("".equals(number)) {
			return false;
		}
		boolean bDot = false; // 単一点の判断フラグ
		int nChar;
		for (int i = 0; i < number.length(); i++) {
			nChar = number.charAt(i);
			if (nChar == '-' && number.length() == 1) {
				// "-"の場合、Falseとする。
				return false;
			}
			if (nChar == '-' && i == 0) {
				continue;
			} else if (nChar == '-' && i != 0) {
				return false;
			}
			if (nChar > '9') {
				return false;
			}
			if ((nChar < '0') && (nChar != ',') && (nChar != '.')) {
				return false;
			}
			// 一つ点のみがある、trueを返し、他のはfalseを返す
			if (nChar == '.') {
				// 単一点がある、trueを返し、他のはfalseを返す
				if (!bDot) {
					bDot = true;
					continue;
				} else {
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * 数字のチェック
	 *
	 * @param s 数字の文字列
	 * @return boolean
	 */
	public static boolean checkIntNumberValid(String s) {
		if (s == null || s.length() == 0) {
			return false;
		}
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) < '0' || s.charAt(i) > '9') {
				return false;
			}
		}
		return true;
	}

	/**
	 * 数字のチェック
	 *
	 * @param s 数字の文字列
	 * @return boolean
	 */
	public static boolean checkIntValid(String s) {
		if (checkIntNumberValid(s)) {
			if (s.length() > 1 && s.startsWith("0")) {
				return false;
			}

			return true;
		}
		return false;

	}

	/**
	 * StringタイプをIntタイプに変換する
	 *
	 * @param str 文字列
	 * @return int intの文字列 2003/11/07 新規作成 zhanjc
	 */
	public static int convertToInt(String str) {
		int result = 0;
		try {
			str = str.trim();
			result = Integer.parseInt(str);
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
		return result;
	}

	/**
	 * Stirng型转成Integer
	 *
	 * @param munStr String対象参数
	 * @return munInt Integer型
	 */

	public static Integer convertToInteger(String munStr) {
		Integer munInt = null;
		if (!"".equals(StringUtils.nvl(munStr))) {
			munInt = Integer.valueOf(munStr);
		}
		return munInt;
	}

	/**
	 * Stirng型转成BigDecimal
	 *
	 * @param munStr String対象参数
	 * @return munBig BigDecimal型
	 */

	public static BigDecimal convertToBigDecimal(String munStr) {
		return convertToBigDecimal(munStr, false);
	}

	/**
	 * Stirng型转成BigDecimal
	 *
	 * @param munStr String対象参数
	 * @param autoZero munStr为null时返回0
	 * @return munBig BigDecimal型
	 */

	public static BigDecimal convertToBigDecimal(String munStr, boolean autoZero) {
		BigDecimal munBig = null;
		if (!"".equals(StringUtils.nvl(munStr))) {
			munBig = new BigDecimal(munStr);
		} else {
			if (autoZero) {
				munBig = new BigDecimal(0);
			}
		}
		return munBig;
	}

	public static String convertLongToStr(Long munStr, boolean autoZero, int divideValue) {
		if (munStr == null) {
			if (autoZero)
				return "0";
			else
				return "";
		}
		return String.valueOf(munStr / divideValue);
	}

	/**
	 * StringタイプをLongタイプに変換する
	 *
	 * @param str 文字列
	 * @return Long Longの文字列 2003/11/07 新規作成 zhanjc
	 */
	public static long convertToLong(String str) {
		long result = 0;
		try {
			str = str.trim();
			result = Long.parseLong(str);
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
		return result;
	}

	/**
	 * StringタイプをLongタイプに変換する（異常なし）
	 *
	 * @param str 文字列
	 * @param autoZero
	 * @return Long Longの文字列
	 */
	public static Long convertToLong(String str, boolean autoZero) {
		Long result = null;

		str = StringUtils.nvl(str).trim();
		if ("".equals(str)) {
			result = autoZero ? 0l : null;
		} else {
			try {
				result = Long.parseLong(str);
			} catch (NumberFormatException ex) {
				result = autoZero ? 0l : null;
			}
		}

		return result;
	}

	/**
	 * StringタイプをFloatタイプに変換する
	 *
	 * @param str 文字列
	 * @return Float Floatの文字列 2003/11/07 新規作成 zhanjc
	 */
	public static float convertToFloat(String str) {
		float result = 0;
		try {
			str = str.trim();
			result = Float.parseFloat(str);
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
		return result;
	}

	/**
	 * StringタイプをFloatタイプに変換する
	 *
	 * @param str 文字列
	 * @return Float Floatの文字列 2003/11/07 新規作成 zhanjc
	 */
	public static int convertMokoSizeToInt(String size) {
		BigDecimal sizeBefore = NumberUtils.convertToBigDecimal(size, true);
		BigDecimal convertSize = sizeBefore.multiply(new BigDecimal(100));
		return convertSize.intValue();

	}

	/**
	 * StringタイプをFloatタイプに変換する
	 *
	 * @param str 文字列
	 * @return Float Floatの文字列 2003/11/07 新規作成 zhanjc
	 */
	public static long convertMokoSizeToLong(String size) {
		BigDecimal sizeBefore = NumberUtils.convertToBigDecimal(size, true);
		BigDecimal convertSize = sizeBefore.multiply(new BigDecimal(100));
		return convertSize.longValue();

	}

	/**
	 * StringタイプをFloatタイプに変換する
	 * 
	 * @param str 文字列
	 * @return Float Floatの文字列 2003/11/07 新規作成 zhanjc
	 */
	public static float convertToFloatForNull(String str) {
		if ("".equals(StringUtils.nvl(str))) {
			str = "0";
		}
		float result = 0;
		try {
			str = str.trim();
			result = Float.parseFloat(str);
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
		return result;
	}

	/**
	 * StringタイプをIntegerタイプに変換する
	 *
	 * @param str　文字列
	 * @param autoZero
	 * @return Integer
	 */
	public static Integer convertToInteger(String str, boolean autoZero) {
		Integer result = null;

		str = StringUtils.nvl(str).trim();
		if ("".equals(str)) {
			result = autoZero ? 0 : null;
		} else {
			try {
				result = Integer.parseInt(str);
			} catch (NumberFormatException ex) {
				result = autoZero ? 0 : null;
			}
		}

		return result;
	}

	/**
	 * StringタイプをIntタイプに変換する
	 *
	 * @param value 文字列
	 * @param flag 変換フラグ： true : valueはNULL又は空文字列の場合、SystemExceptionを投げる false : valueはNULL又は空文字列の場合、0を返す
	 * @return int 変換した文字列
	 */
	public static int parseInt(String value, boolean flag) {
		if (!flag) {
			if (value == null || "".equals(value.trim())) {
				return 0;
			}
		}

		try {
			return Integer.parseInt(value.trim());
		} catch (NumberFormatException ex) {
			if (flag) {
				throw ex;
			} else {
				return 0;
			}
		}
	}

	/**
	 * String類型からlong類型に変換する
	 *
	 * @param value 文字列
	 * @param flag 変換のフラグ： true : valueはNULL又は空文字列の場合、WarningException例外を呼び出す false : valueはNULL又は空文字列の場合、0を返す
	 * @return long 変換後文字列
	 */
	public static long parseLong(String value, boolean flag) {
		if (!flag) {
			if (value == null || "".equals(value.trim())) {
				return 0;
			}
		}

		try {
			return Long.parseLong(value.trim());
		} catch (NumberFormatException ex) {
			if (flag) {
				throw ex;
			} else {
				return 0;
			}
		}
	}

	/**
	 * 入力値lがnullの場合、0Lを返す
	 *
	 * @param l 長整型対象
	 * @return long 長整型値
	 */
	public static long nvl(Long l) {
		if (l == null) {
			return 0L;
		}

		return l.longValue();
	}

	/**
	 * 入力値iがnullの場合、0を返す
	 *
	 * @param i 整型対象
	 * @return int 整型値
	 */
	public static int nvl(Integer i) {
		if (i == null) {
			return 0;
		}

		return i.intValue();
	}

	/**
	 *
	 * @param value
	 * @param intLength 整數位長度
	 * @param decimalLength 小數位長度
	 * @return
	 */
	public static boolean checkNumberFormat(String value, int intLength, int decimalLength) {
		if (intLength <= 0) {
			return false;
		}
		if (decimalLength < 0) {
			return false;
		}
		String regNumberFomat;
		if (decimalLength == 0) {
			regNumberFomat = "^[0-9]{1," + intLength + "}?$";
		} else {
			regNumberFomat = "^[0-9]{1," + intLength + "}+(\\.[0-9]{1," + decimalLength + "})?$";
		}
		Pattern p = Pattern.compile(regNumberFomat);
		Matcher m = p.matcher(value);

		return m.matches();
	}

	/**
	 * 
	 * <pre>
	 *  9999999.9999999円-->9999000円
	 * </pre>
	 * 
	 * @param number
	 * @return
	 */
	public static long floorSenYen(double number) {
		return new BigDecimal(number / 1000).setScale(0, BigDecimal.ROUND_HALF_UP).longValue() * 1000;
	}

	/**
	 *
	 * @param value
	 * @param intLength 整數位長度
	 * @param decimalLength 小數位長度
	 * @return
	 */
	public static boolean checkNegativeNumberFormat(String value, int intLength, int decimalLength) {
		if (intLength <= 0) {
			return false;
		}
		if (decimalLength < 0) {
			return false;
		}
		String regNumberFomat;
		if (decimalLength == 0) {
			regNumberFomat = "^-[0-9]{1," + intLength + "}?$";
		} else {
			regNumberFomat = "^-[0-9]{1," + intLength + "}+(\\.[0-9]{1," + decimalLength + "})?$";
		}
		Pattern p = Pattern.compile(regNumberFomat);
		Matcher m = p.matcher(value);

		return m.matches();
	}

	/**
	 * 将36进制的数字（字符串形式）转换为十进制的数字 进制在2-36之间
	 * 
	 * @param str 其它进制的数字（字符串形式）
	 * @param base 指定的进制
	 * @return
	 */
	public static long otherToBasicNum(String str) {
		long num = 0l;
		if (str != null && !"".equals(str)) {
			num = Long.parseLong(str, 36);
		}

		return num;
	}

	public static int objToInt(Object obj) {
		if (obj != null) {
			if (obj instanceof Integer) {
				return ((Integer) obj).intValue();
			} else if (obj instanceof Long) {
				return ((Long) obj).intValue();
			} else if (obj instanceof Float) {
				return ((Float) obj).intValue();
			} else if (obj instanceof Double) {
				return ((Double) obj).intValue();
			} else if (obj instanceof BigDecimal) {
				return ((BigDecimal) obj).intValue();
			}
			return convertToInt(obj.toString());
		}
		return 0;
	}
	
	public static String objToString(Object obj) {
		if (obj != null) {
			if (obj instanceof Integer) {
				return StringUtils.toString((Integer) obj);
			} else if (obj instanceof Long) {
				return StringUtils.toString((Long) obj);
			} else if (obj instanceof Float) {
				return String.valueOf((Float) obj);
			} else if (obj instanceof Double) {
				return String.valueOf((Double) obj);
			} else if (obj instanceof BigDecimal) {
				return StringUtils.toString((BigDecimal) obj);
			}
			return obj.toString();
		}
		return "0";
	}
}
