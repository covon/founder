package com.founder.utils;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

/**
 * copyright Founder 2017
 * 
 * @date 2017/05/18 V1.0新規作成
 *
 * @version V1.0
 * @brief String変換処理Utilityクラスの定義.
 *
 * @since 1.0
 */
public class StringUtils {
	/** TEL */
	private static final String TEL = "tel";

	/** ZIP */
	private static final String ZIP = "zip";

	/** エンコードの形式 */
	private static final String ENCODE = "UTF-8";

	private static String SUB_LINE = "_";

	/** 半角記号 - */
	public static String halfKgou = "!@#$&-_+/[\\]., ";

	/**
	 * The empty String {@code ""}.
	 * 
	 * @since 2.0
	 */
	public static final String EMPTY = "";

	/**
	 * Represents a failed index search.
	 * 
	 * @since 2.1
	 */
	public static final int INDEX_NOT_FOUND = -1;

	/**
	 * <p>
	 * The maximum size to which the padding constant(s) can expand.
	 * </p>
	 */
	private static final int PAD_LIMIT = 8192;

	/**
	 * A regex pattern for recognizing blocks of whitespace characters.
	 */
	private static final Pattern WHITESPACE_BLOCK = Pattern.compile("\\s+");

	/** 格式化の文字列定数 */
	private static final String FORMAT_TEXT = "#,###.#################################";

	/**
	 * 二つStringオブジェクトの内容を比べる
	 *
	 * @param s1 文字列１
	 * @param s2 文字列２
	 * @return 二つの文字列の内容は相同の場合、trueを返し、他のはfalseを返す 2003/11/07 新規作成 zhanjc
	 */
	public static boolean isEqual(String s1, String s2) {
		if (s1 == null) {
			s1 = "";
		}
		if (s2 == null) {
			s2 = "";
		}

		return (s1.equals(s2));
	}

	/**
	 * if a CharSequence is null.return empty ("")
	 * 
	 * @param input the CharSequence
	 * @return
	 */
	public static String nvl(String input) {
		if (input == null) {
			return "";
		}

		return input;
	}

	/**
	 * Checks if a CharSequence is empty ("") or null. StringUtils.isEmpty(null) = true StringUtils.isEmpty("") = true
	 * StringUtils.isEmpty(" ") = false StringUtils.isEmpty("bob") = false StringUtils.isEmpty("  bob  ") = false
	 * 
	 * @param cs the CharSequence to check, may be null
	 * @return if the CharSequence is empty or null
	 */
	// public static boolean isEmpty(CharSequence cs) {
	// return cs == null || cs.length() == 0;
	// }

	public static boolean isEmpty(String cs) {
		return cs == null || cs.length() == 0;
	}

	/**
	 * <p>
	 * Checks if a CharSequence is not empty ("") and not null.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.isNotEmpty(null)      = false
	 * StringUtils.isNotEmpty("")        = false
	 * StringUtils.isNotEmpty(" ")       = true
	 * StringUtils.isNotEmpty("bob")     = true
	 * StringUtils.isNotEmpty("  bob  ") = true
	 * </pre>
	 *
	 * @param cs the CharSequence to check, may be null
	 * @return if the CharSequence is not empty and not null
	 */
	// public static boolean isNotEmpty(CharSequence cs) {
	// return !StringUtils.isEmpty(cs);
	// }

	public static boolean isNotEmpty(String cs) {
		return !StringUtils.isEmpty(cs);
	}

	/**
	 * <p>
	 * Checks if a CharSequence is whitespace, empty ("") or null.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.isBlank(null)      = true
	 * StringUtils.isBlank("")        = true
	 * StringUtils.isBlank(" ")       = true
	 * StringUtils.isBlank("bob")     = false
	 * StringUtils.isBlank("  bob  ") = false
	 * </pre>
	 *
	 * @param cs the CharSequence to check, may be null
	 * @return if the CharSequence is null, empty or whitespace
	 */
	public static boolean isBlank(CharSequence cs) {
		int strLen;
		if (cs == null || (strLen = cs.length()) == 0) {
			return true;
		}
		for (int i = 0; i < strLen; i++) {
			if (Character.isWhitespace(cs.charAt(i)) == false) {
				return false;
			}
		}
		return true;
	}

	/**
	 * <p>
	 * Checks if a CharSequence is not empty (""), not null and not whitespace only.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.isNotBlank(null)      = false
	 * StringUtils.isNotBlank("")        = false
	 * StringUtils.isNotBlank(" ")       = false
	 * StringUtils.isNotBlank("bob")     = true
	 * StringUtils.isNotBlank("  bob  ") = true
	 * </pre>
	 *
	 * @param cs the CharSequence to check, may be null
	 * @return if the CharSequence is not empty and not null and not whitespace
	 */
	public static boolean isNotBlank(CharSequence cs) {
		return !StringUtils.isBlank(cs);
	}

	// Replacing
	// -----------------------------------------------------------------------
	/**
	 * <p>
	 * Replaces a String with another String inside a larger String, once.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.replaceOnce(null, *, *)        = null
	 * StringUtils.replaceOnce("", *, *)          = ""
	 * StringUtils.replaceOnce("any", null, *)    = "any"
	 * StringUtils.replaceOnce("any", *, null)    = "any"
	 * StringUtils.replaceOnce("any", "", *)      = "any"
	 * StringUtils.replaceOnce("aba", "a", null)  = "aba"
	 * StringUtils.replaceOnce("aba", "a", "")    = "ba"
	 * StringUtils.replaceOnce("aba", "a", "z")   = "zba"
	 * </pre>
	 *
	 * @see #replace(String text, String searchString, String replacement, int max)
	 * @param text text to search and replace in, may be null
	 * @param searchString the String to search for, may be null
	 * @param replacement the String to replace with, may be null
	 * @return the text with any replacements processed,
	 */
	public static String replaceOnce(String text, String searchString, String replacement) {
		return replace(text, searchString, replacement, 1);
	}

	/**
	 * <p>
	 * Replaces all occurrences of a String within another String.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.replace(null, *, *)        = null
	 * StringUtils.replace("", *, *)          = ""
	 * StringUtils.replace("any", null, *)    = "any"
	 * StringUtils.replace("any", *, null)    = "any"
	 * StringUtils.replace("any", "", *)      = "any"
	 * StringUtils.replace("aba", "a", null)  = "aba"
	 * StringUtils.replace("aba", "a", "")    = "b"
	 * StringUtils.replace("aba", "a", "z")   = "zbz"
	 * </pre>
	 *
	 * @see #replace(String text, String searchString, String replacement, int max)
	 * @param text text to search and replace in, may be null
	 * @param searchString the String to search for, may be null
	 * @param replacement the String to replace it with, may be null
	 * @return the text with any replacements processed,
	 */
	public static String replace(String text, String searchString, String replacement) {
		return replace(text, searchString, replacement, -1);
	}

	/**
	 * <p>
	 * Replaces a String with another String inside a larger String, for the first {@code max} values of the search
	 * String.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.replace(null, *, *, *)         = null
	 * StringUtils.replace("", *, *, *)           = ""
	 * StringUtils.replace("any", null, *, *)     = "any"
	 * StringUtils.replace("any", *, null, *)     = "any"
	 * StringUtils.replace("any", "", *, *)       = "any"
	 * StringUtils.replace("any", *, *, 0)        = "any"
	 * StringUtils.replace("abaa", "a", null, -1) = "abaa"
	 * StringUtils.replace("abaa", "a", "", -1)   = "b"
	 * StringUtils.replace("abaa", "a", "z", 0)   = "abaa"
	 * StringUtils.replace("abaa", "a", "z", 1)   = "zbaa"
	 * StringUtils.replace("abaa", "a", "z", 2)   = "zbza"
	 * StringUtils.replace("abaa", "a", "z", -1)  = "zbzz"
	 * </pre>
	 *
	 * @param text text to search and replace in, may be null
	 * @param searchString the String to search for, may be null
	 * @param replacement the String to replace it with, may be null
	 * @param max maximum number of values to replace, or {@code -1} if no maximum
	 * @return the text with any replacements processed,
	 */
	public static String replace(String text, String searchString, String replacement, int max) {
		if (isEmpty(text) || isEmpty(searchString) || replacement == null || max == 0) {
			return text;
		}
		int start = 0;
		int end = text.indexOf(searchString, start);
		if (end == INDEX_NOT_FOUND) {
			return text;
		}
		int replLength = searchString.length();
		int increase = replacement.length() - replLength;
		increase = increase < 0 ? 0 : increase;
		increase *= max < 0 ? 16 : max > 64 ? 64 : max;
		StringBuilder buf = new StringBuilder(text.length() + increase);
		while (end != INDEX_NOT_FOUND) {
			buf.append(text.substring(start, end)).append(replacement);
			start = end + replLength;
			if (--max == 0) {
				break;
			}
			end = text.indexOf(searchString, start);
		}
		buf.append(text.substring(start));
		return buf.toString();
	}

	/**
	 * 前ゼロを付加した結果を返する
	 *
	 * @param val ゼロフォーマット値
	 * @param length 変換したintからゼロフォーマット用文字数を生成する
	 * @return String 前ゼロを付加した文字列
	 */
	public static String addPreZero(Object val, int length) {
		if (val == null) {
			val = "";
		}
		String result = val.toString();
		int strLen = result.length();
		if (strLen < length) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < length - strLen; i++) {
				sb.append('0');
			}
			sb.append(val);
			result = sb.toString();
		} else {
			result = result.substring(0, length);
		}

		return result;
	}

	/**
	 * <pre>
	 * toString
	 *
	 * </pre>
	 * 
	 * @param object
	 * @return
	 */
	public static String toString(Integer object) {
		if (object == null) {
			return "";
		} else {
			return object.toString();
		}
	}

	/**
	 * <pre>
	 * toString
	 *
	 * </pre>
	 * 
	 * @param object
	 * @return
	 */
	public static String toString(Long object) {
		if (object == null) {
			return "";
		} else {
			return object.toString();
		}
	}

	/**
	 * <pre>
	 * toString
	 *
	 * </pre>
	 * 
	 * @param object
	 * @return
	 */
	public static String toString(Date object) {
		if (object == null) {
			return "";
		} else {
			return object.toString();
		}
	}

	/**
	 * <pre>
	 * toString
	 *
	 * </pre>
	 * 
	 * @param object
	 * @return
	 */
	public static String toString(BigDecimal object) {
		if (object == null) {
			return "";
		} else {
			return object.toString();
		}
	}

	/**
	 * 左、右スペス(半角と全角)を削除する
	 *
	 * @param val String 変換文字列
	 * @return String 変換した文字列
	 */
	public static String trimSpc(String val) {
		if (val == null) {
			return "";
		} else {
			val = val.trim();
		}
		// 左スペス(半角と全角)数の変数
		int iHead = 0;
		// 左スペス(半角と全角)数を計算する
		for (int i = 0; i < val.length(); i++) {
			if (val.charAt(i) == ' ' || val.charAt(i) == '　') {
				iHead++;
			} else {
				break;
			}
		}
		// 右スペス(半角と全角)を削除した文字列を返す
		String valUse = val.substring(iHead);
		if (null != valUse) {
			int iEnd = valUse.length();
			for (int i = valUse.length() - 1; i >= 0; i--) {
				if (valUse.charAt(i) == ' ' || valUse.charAt(i) == '　') {
					iEnd--;
				} else {
					break;
				}
			}
			valUse = valUse.substring(0, iEnd);
		}
		return valUse;
	}

	/**
	 * コーマ区切りで、文字列から文字列を抜き出し、配列にして返す
	 *
	 * @param str 文字列
	 * @return String[] 変換後文字列アレー
	 */
	public static String[] str2Array(String str) {
		return str2Array(str, ",");
	}

	/**
	 * 文字列から文字列を抜き出し、配列にして返す
	 *
	 * @param str 文字列
	 * @param sep 区切り文字(群)
	 * @return String[] 変換後文字列 2003/11/06 新規作成 zhanjc
	 */
	public static String[] str2Array(String str, String sep) {
		StringTokenizer token = null;
		String[] array = null;

		// check
		if (str == null || sep == null) {
			return null;
		}

		// get string array
		token = new StringTokenizer(str, sep);
		array = new String[token.countTokens()];
		for (int i = 0; token.hasMoreTokens(); i++) {
			array[i] = token.nextToken();
		}

		return array;
	}

	/**
	 * 文字配列から文字列を抽出して組合し、文字列にして返す
	 *
	 * @param str 文字列
	 * @return String 変換後文字列
	 */
	public static String array2String(String[] str) {
		int num = 0;
		StringBuffer result = new StringBuffer("");

		// check
		if (str == null) {
			return "";
		}

		// 文字列を組合
		num = str.length;
		for (int i = 0; i < num; i++) {
			if (str[i] != null) {
				result.append(str[i]);
			}
		}

		return result.toString();
	}

	/**
	 * 文字配列から文字列を抽出して組合し、文字列にして返す
	 *
	 * @param str 文字列
	 * @param sep 区切り文字
	 * @return String 変換後文字列
	 */
	public static String array2String(String[] str, String sep) {
		int num = 0;
		StringBuffer result = new StringBuffer("");

		// check
		if (str == null) {
			return "";
		}

		// 文字列を組合
		num = str.length;
		for (int i = 0; i < num; i++) {
			if (str[i] != null) {
				result.append(sep);
				result.append(str[i]);
			}
		}

		String resultStr = result.toString();
		if (resultStr.length() > 0) {
			resultStr = resultStr.substring(1);
		}
		return resultStr;
	}



	/**
	 * 文字列が半角のみかをチェックする
	 *
	 * @param txt チェック文字列
	 * @return boolean 空文字列の場合は、trueを返し、<br>
	 *         文字列はShift_JISのエンコードに変換失敗の場合、falseを返す<br>
	 */
	public static boolean isHalf(String txt) {
		if (txt == null) {
			return true;
		}
		try {
			txt = txt.replaceAll("\\?", "");

			byte[] b = txt.getBytes(ENCODE);
			for (int i = 0; i < b.length; i++) {
				if ((b[i] & 0x80) == 0x80) {
					// 判定：b[i]は0xA0-0xDFの範囲に存在するか。この範囲は半角カナ文字のみ
					if (!(((byte) 0xA0) <= b[i] && b[i] <= ((byte) 0xDf))) {
						// 全角文字の１バイト目
						return false;
					}
				} else if (b[i] == 0x3F) {
					return false;
				}
			}
			return true;
		} catch (UnsupportedEncodingException e) {
			// logger.debug(e.getMessage());
			return false;
		}
	}

	/**
	 * 文字列が半角英数字記号カナのみかをチェックする
	 *
	 * @param txt チェック文字列
	 * @return boolean 空文字列の場合は、trueを返し、<br>
	 *         文字列はShift_JISのエンコードに変換失敗の場合、falseを返す<br>
	 */
	public static boolean isEnNumKanaKgouHalf(String txt) {
		if (txt == null) {
			return true;
		}
		try {
			byte[] b = txt.getBytes(ENCODE);
			for (int i = 0; i < b.length; i++) {
				if (!(((byte) 0xA0) <= b[i] && b[i] <= ((byte) 0xDf) || (0x20 <= b[i] && b[i] <= 0x7E))) {
					return false;
				}
			}
			return true;
		} catch (UnsupportedEncodingException e) {
			// logger.debug(e.getMessage());
			return false;
		}
	}

	/**
	 * 文字列が半角記号のみかをチェックする
	 *
	 * @param txt チェック文字列
	 * @return boolean 空文字列の場合は、trueを返し、<br>
	 *         文字列はShift_JISのエンコードに変換失敗の場合、falseを返す<br>
	 */
	public static boolean isKgou(String txt) {
		if (txt == null) {
			return true;
		}

		// 判定：パラメーターは（!@#$&-_+/\. , 半角スペース）の範囲に存在であるか。この範囲は半角記号文字のである
		// !#$%&'()*+,-./:;<=>?@[\\]^_`{|}~
		if (halfKgou.indexOf(txt) != -1) {
			return true;
		}

		return false;
	}

	/**
	 * 文字列が半角記号のみかをチェックする
	 *
	 * @param txt チェック文字列
	 * @return boolean 空文字列の場合は、trueを返し、<br>
	 *         文字列はShift_JISのエンコードに変換失敗の場合、falseを返す<br>
	 */
	public static boolean isAllKgou(String txt) {
		if (txt == null) {
			return true;
		}
		StringBuffer checkText = null;
		boolean result = true;
		// 判定：パラメーターは（!@#$&-_+/\. , 半角スペース）の範囲に存在であるか。この範囲は半角記号文字のである
		// !#$%&'()*+,-./:;<=>?@[\\]^_`{|}~
		checkText = new StringBuffer(txt);
		for (int i = 0; i < checkText.length(); i++) {
			String subcheckText = checkText.substring(i, i + 1);
			if (!isKgou(subcheckText)) {
				result = false;
			}
		}

		return result;
	}

	/**
	 * 数字を-0 ----> 0のようなフォーマットで変換し、変換した文字列を返す
	 *
	 * @param number 変換する文字列
	 * @return String 変換した文字列
	 */
	private static String convertToValid(String number) {
		if (number.trim().equals("-0")) {
			return "0";
		} else {
			return number;
		}
	}

	/**
	 * 全部ゼロ又はnullの場合 空文字列にして返す
	 *
	 * @param val 変換する文字列
	 * @return 空文字列 valは全部ゼロ又はnull又は空文字列の場合 空文字列にして返す
	 */
	public static String filteZero(String val) {
		if (val == null || "".equals(val.trim())) {
			return "";
		}
		if (!NumberUtils.checkIntNumberValid(val)) {
			return "";
		}
		val = new Long(val.trim()).toString();

		return val;
	}

	/**
	 * 数字文字列を9999999.99 ----> 9,999,999.99のようなフォーマットに変換する
	 *
	 * @param number 数字の文字列
	 * @return String 変換後の文字列
	 */
	public static String formatNumber(String number) {
		// 整数処理のフラグはfalseに固定し、関数を呼び出す
		try {
			return formatNumber(number, false);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 数字を9999999.99 ----> 9,999,999のようなフォーマットに変換する
	 *
	 * @param number 数字の文字列
	 * @param formatToLong 書式の制御フラグ
	 * @return String 変換した文字列
	 */
	public static String formatNumber(String number, boolean formatToLong) {
		try {
			return formatNumber(number, formatToLong, false);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 数字文字列を9999999.99 ----> 9,999,999.99のようなフォーマットに変換する
	 *
	 * @param number 数字文字列
	 * @param formatToLong 小数を整数に変換する
	 * @param nullToZero 空白文字列がゼロに変換処理のフラグ：trueの場合、変換する、falseの場合、変換しない
	 * @return String 変換した文字列
	 */
	public static String formatNumber(String number, boolean formatToLong, boolean nullToZero) {
		// ゼロが空白文字列に変換処理のフラグはfalseに固定し、関数を呼び出す
		try {
			return formatNumber(number, formatToLong, nullToZero, false);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 数字を9999999.99 ----> 9,999,999.99のようなフォーマットに変換する
	 *
	 * @param number 数字の文字列
	 * @param formatToLong 小数を整数に変換する
	 * @param nullToZero 空白文字列がゼロに変換処理のフラグ：trueの場合、変換する、falseの場合、変換しない
	 * @param zeroToNull ゼロが空白文字列に変換処理のフラグ：trueの場合、変換する、falseの場合、変換しない
	 * @return String 変換した文字列
	 */
	public static String formatNumber(String number, boolean formatToLong, boolean nullToZero, boolean zeroToNull) {
		if (number == null || number.trim().equals("")) {
			if (nullToZero) {
				return "0";
			} else {
				return "";
			}
		}
		// 数字の文字列が０または-0の場合、zeroToNullによって、""或いは"0"を返す
		if (number.trim().equals("0") || number.trim().equals("-0")) {
			if (zeroToNull) {
				return "";
			} else {
				return "0";
			}
		}
		// 数字値の検査関数を呼び出す
		if (!NumberUtils.checkNumberValid(number)) {
			return number.trim();
		}
		String sFormatNumber = "";
		double dbNum;
		// 数字の文字列を指定した形式で数値に変換する
		NumberFormat defForm = new DecimalFormat(FORMAT_TEXT);
		try {
			dbNum = Double.parseDouble(number);
			if (formatToLong) {
				dbNum = Math.round(dbNum);
			}
			sFormatNumber = defForm.format(dbNum); // 書式化
		} catch (NumberFormatException numEx) {
			try {
				// 99,9999,9 --> 99,999,999
				Number numNumber = NumberFormat.getNumberInstance().parse(number);
				dbNum = Double.parseDouble(String.valueOf(numNumber));
				if (formatToLong) {
					dbNum = Math.round(dbNum);
				}
				sFormatNumber = defForm.format(dbNum);
			} catch (ParseException pEx) {
				pEx.printStackTrace();
			}
		}
		return convertToValid(sFormatNumber);
	}

	/**
	 * 数字を906 --> 906%のようなフォーマットに変換する
	 *
	 * @param number 文字列
	 * @return String 変換した文字列
	 */
	public static String formatPercentNumber(String number) {
		// ヌル又は空文字列の場合、""を返す
		if (number == null || number.trim().equals("")) {
			return "";
		}
		// 数字の文字列は0又は-0の場合、0を返す
		if (number.trim().equals("0") || number.trim().equals("-0")) {
			return "0";
			// 数字文字列の末に、%を追加して返す。
		} else if (NumberUtils.checkNumberValid(number)) {
			return number + "%";
		} else {
			return number.trim();
		}
	}

	/**
	 * 数字を90600 --> 90600.00のようなフォーマットに変換する
	 *
	 * @param number 文字列
	 * @return String 変換した文字列
	 */
	public static String formatDecimalNumber(String number, int decimalWidth) {
		String result = "";
		// ヌル又は空文字列の場合、""を返す
		if (number == null || number.trim().equals("")) {
			result = "0";
			return result;
		} else
			result = number;

		String format = "#";
		if (decimalWidth == 0) {
			format = "#";
		} else if (decimalWidth == 1) {
			format = "0.0";
		} else if (decimalWidth == 2) {
			format = "0.00";
		} else if (decimalWidth == 3) {
			format = "0.000";
		}

		DecimalFormat rateformat = new DecimalFormat(format);
		return rateformat.format(new BigDecimal(result));

	}

	/**
	 * 数字を90600 --> 90600.00のようなフォーマットに変換する RoundingMode.DOWN
	 * 
	 * @param number 文字列
	 * @return String 変換した文字列
	 */
	public static String formatDecimalNumberExp(String number, int decimalWidth) {
		String result = "";
		// ヌル又は空文字列の場合、""を返す
		if (number == null || number.trim().equals("")) {
			result = "0";
			return result;
		} else
			result = number;

		String format = "#";
		if (decimalWidth == 0) {
			format = "#";
		} else if (decimalWidth == 1) {
			format = "0.0";
		} else if (decimalWidth == 2) {
			format = "0.00";
		} else if (decimalWidth == 3) {
			format = "0.000";
		}

		DecimalFormat rateformat = new DecimalFormat(format);

		rateformat.setRoundingMode(RoundingMode.DOWN);
		return rateformat.format(new BigDecimal(result));
	}

	/**
	 * 数字をZZ.ZZ ----> Z9.999のようなフォーマットに変換する
	 *
	 * @param rate 数字の文字列
	 * @return String 変換した文字列
	 */
	public static String formatRate(String rate) {
		if (rate == null || "".equals(rate.trim())) {
			return "";
		}
		if (!NumberUtils.checkNumberValid(rate)) {
			return rate.trim();
		} else {
			DecimalFormat rateformat = new DecimalFormat("#,##0.000");
			try {
				double numericrate = Double.parseDouble(rate.trim()) + 0.0000000001;
				rate = rateformat.format(numericrate);
				if ("0.000".equals(rate)) {
					return " ";
				} else if (rate.substring(rate.length() - 3, rate.length()).equals("000")) {
					rate = rate.substring(0, rate.length() - 3) + "0";
				} else {
					while (rate.endsWith("0")) {
						rate = rate.substring(0, rate.length() - 1);
					}
				}
			} catch (Exception ex) {
				throw new RuntimeException(ex);
			}
		}
		if (rate != null && !"".equals(rate.trim())) {
			rate = rate + "%";
		}
		return rate;
	}

	/**
	 * 郵便番号をフォーマットに変換する。<br>
	 *
	 * @param postNum 入力フォーム
	 * @return String 変換後文字列
	 */
	public static String formatPostNum(String[] postNum) {
		if (postNum == null) {
			return "";
		}
		StringBuffer result = new StringBuffer();
		for (int i = 0; i < postNum.length; i++) {
			if (postNum[i] == null || postNum[i].trim().equals("")) {
				return "";
			}
			if (i != 0) {
				result.append("-");
			}
			result.append(postNum[i]);
		}
		return result.toString();
	}

	/**
	 * 郵便番号をフォーマットに変換する。<br>
	 *
	 * @param postNum 入力フォーム
	 * @return String 変換した文字列 2003/11/10 新規作成 zhanjc
	 */
	public static String formatPostNum(String postNum) {
		if (postNum == null || postNum.length() != 7) {
			return postNum;
		}
		return postNum.trim().substring(0, 3) + "-" + postNum.trim().substring(3, 7);
	}

	/**
	 * 郵便番号をフォーマットに変換する。<br>
	 *
	 * @param postNum 入力フォーム
	 * @return String 変換した文字列
	 */
	public static String[] formatPostNumToArray(String postNum) {
		String[] postNumArray = { "", "" };
		if (postNum == null || postNum.length() != 7) {
		} else {
			postNumArray[0] = postNum.trim().substring(0, 3);
			postNumArray[1] = postNum.trim().substring(3, 7);
		}
		return postNumArray;
	}

	/**
	 * 読点を削除します
	 *
	 * @param input
	 * @return
	 */
	public static String removeComma(String input) {
		if (StringUtils.isBlank(input)) {
			return input;
		} else {
			return input.replaceAll(",", "");
		}
	}

	public static String removePoint(String input) {
		if (StringUtils.isBlank(input)) {
			return input;
		} else {
			return input.replaceAll("\\.", "");
		}
	}

	public static String removeSlash(String input) {
		if (StringUtils.isBlank(input)) {
			return input;
		} else {
			return input.replaceAll("/", "");
		}
	}

	/**
	 * SQL分に使用されるため、List〈String〉から読点で分けた文字列に転換します。 e.g<br>
	 * List&lt;String&gt; list=new ArrayList&lt;String&gt();<br>
	 * list.add("first");<br>
	 * list.add("second");<br>
	 * Stirng str="'first','second'"<br>
	 *
	 * @param inputList 入力のList型
	 * @return String
	 */
	public static String listToSQLString(List<String> inputList) {
		StringBuffer output = new StringBuffer();
		for (int i = 0; i < inputList.size(); i++) {
			output.append("'");
			output.append(inputList.get(i));
			output.append("',");
		}

		if (output.length() > 0) {
			output.delete(output.length() - 1, output.length());
		}

		return output.toString();
	}

	/**
	 * SQL分に使用されるため、List〈String〉から読点で分けた文字列に転換します。 e.g<br>
	 * List&lt;String&gt; list=new ArrayList&lt;String&gt();<br>
	 * list.add("first");<br>
	 * list.add("second");<br>
	 * Stirng str="'first','second'"<br>
	 *
	 * @param inputList 入力のList型
	 * @return String
	 */
	public static String listToString(List<String> inputList) {
		StringBuffer output = new StringBuffer();
		for (int i = 0; i < inputList.size(); i++) {
			output.append(inputList.get(i));
			output.append(",");
		}
		if (output.length() > 0) {
			output.delete(output.length() - 1, output.length());
		}
		return output.toString();
	}

	/**
	 * Stringから読点で分けたListに転換します。 e.g<br>
	 * Stirng str="'first','second'"<br>
	 *
	 * @param str 入力のstring型
	 * @return List<String>
	 */
	public static List<String> stringToList(String str) {
		List<String> outputList = new ArrayList<String>();
		if (!"".equals(StringUtils.nvl(str))) {
			if (str.trim().indexOf(",") > 0) {
				String[] arry = str.trim().split(",");
				for (int i = 0; i < arry.length; i++) {
					outputList.add(arry[i]);
				}
			} else if (str.length() > 0) {
				outputList.add(str);
			}
		}
		return outputList;
	}
	
	public static List<String> stringToList(String str,String regex) {
		List<String> outputList = new ArrayList<String>();
		if (!"".equals(StringUtils.nvl(str)) && !"".equals(StringUtils.nvl(regex))){
			if(str.trim().indexOf(regex) > 0){
				String[] arry = str.trim().split(regex);
				for(int i=0;i<arry.length;i++){
					outputList.add(arry[i]);
				}
			}else if(str.length() > 0){
				outputList.add(str);
			}
		}
		return outputList;
	}

	/**
	 * srcにsubStrを含むか
	 * 
	 * @param src 文字列
	 * @param subStr　 検索文字列
	 * @return
	 */
	public static boolean isContains(String src, String subStr) {
		if (src != null && subStr != null && src.contains(subStr)) {
			return true;
		}
		return false;
	}

	/**
	 * 整数の前ゼロを削除した結果を返する
	 *
	 * @param number longに変換後、この値をからゼロフォーマット用文字数を生成する
	 * @return String 前ゼロを削除した文字列
	 */
	public static String decreasePreZero(String number) {
		String result = number;
		// ヌル又は空文字列の場合、""を返す
		if (number == null) {
			return "";
		}
		number = number.trim();
		if ("".equals(number)) {
			return "";
		}
		if ("0".equals(number) || "-0".equals(number)) {
			return "0";
		}
		// 数字値の検査関数を呼び出す
		if (NumberUtils.checkNumberValid(number)) {
			// 数字を通貨のフォーマットに変換する
			long numNumber = 0;
			numNumber = Long.parseLong(number);
			result = String.valueOf(numNumber);
		}
		return result;
	}

	/**
	 * <pre>
	 * 文字列の数値＋１を返す
	 *
	 * </pre>
	 * 
	 * @param input
	 * @return input + 1の文字列
	 */
	public static String plusOne(String input) {
		return StringUtils.addPreZero(NumberUtils.convertToInteger(input) + 1, input.length());
	}

	/**
	 * <pre>
	 * 挿入ソート
	 *           パラメータがIntegerのリスト
	 * </pre>
	 * 
	 * @param oldList Integerのリスト
	 * @param sortFlg true:昇順 false:降順
	 * @return ソート後リスト
	 */
	public static List<String> sortList(List<String> oldList, boolean sortFlg) {
		List<String> tlist = new ArrayList<String>();
		for (int i = 0; i < oldList.size(); i++) {
			if (tlist.size() == 0) {
				tlist.add(oldList.get(0));
			} else {
				boolean b = false;
				for (int j = 0; j < tlist.size(); j++) {
					if ((sortFlg && Integer.parseInt(oldList.get(i)) >= Integer.parseInt(tlist.get(j)))
							|| (!sortFlg && Integer.parseInt(oldList.get(i)) < Integer.parseInt(tlist.get(j)))) {
						b = true;
					} else {
						tlist.add(j, oldList.get(i));
						b = false;
						break;
					}
				}
				if (b) {
					tlist.add(oldList.get(i));
				}
			}
		}
		return tlist;
	}

	/**
	 * JAVAのBlank文字をHTML表示文字に変換する
	 * 
	 * @param inputStr
	 * @return
	 */
	public static String escapeBlankStr(String inputStr) {
		if (inputStr == null)
			return null;
		return inputStr.replaceAll(" ", "&nbsp;&nbsp;");
	}

	/**
	 * @param input
	 * 
	 * @return String.
	 */
	public static String ToSBC(String input) {
		if (input == null)
			return input;
		char c[] = input.toCharArray();
		for (int i = 0; i < c.length; i++) {
			if (c[i] == ' ') {
				c[i] = '\u3000';
			} else if (c[i] < '\177') {
				c[i] = (char) (c[i] + 65248);

			}
		}
		return new String(c);
	}

	/**
	 * 全角アルファベットを半角アルファベットに変換する
	 * 
	 * @param s
	 * @return
	 */
	public static String zenkakuAlphabetToHankaku(String s) {
		if (s == null)
			return null;
		StringBuffer sb = new StringBuffer(s);
		for (int i = 0; i < sb.length(); i++) {
			char c = sb.charAt(i);
			if (c >= 'ａ' && c <= 'ｚ') {
				sb.setCharAt(i, (char) (c - 'ａ' + 'a'));
			} else if (c >= 'Ａ' && c <= 'Ｚ') {
				sb.setCharAt(i, (char) (c - 'Ａ' + 'A'));
			}
		}
		return sb.toString();
	}

	/**
	 * 半角アルファベットを全角アルファベットに変換する
	 * 
	 * @param s
	 * @return
	 */
	public static String hankakuAlphabetToZenkakuAlphabet(String s) {
		if (s == null)
			return null;
		StringBuffer sb = new StringBuffer(s);
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c >= 'a' && c <= 'z') {
				sb.setCharAt(i, (char) (c - 'a' + 'ａ'));
			} else if (c >= 'A' && c <= 'Z') {
				sb.setCharAt(i, (char) (c - 'A' + 'Ａ'));
			}
		}
		return sb.toString();
	}

	/**
	 * 全角数字を半角数字に変換する
	 * 
	 * @param s
	 * @return
	 */
	public static String hankakuNumberToZenkakuNumber(String s) {
		if (s == null)
			return null;
		StringBuffer sb = new StringBuffer(s);
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c >= '0' && c <= '9') {
				sb.setCharAt(i, (char) (c - '0' + '０'));
			}
		}
		return sb.toString();
	}

	/**
	 * 全角数字を半角に変換します。
	 * 
	 * @param s 変換元文字列
	 * @return 変換後文字列
	 */
	public static String zenkakuNumToHankaku(String s) {
		if (s == null)
			return null;
		StringBuffer sb = new StringBuffer(s);
		for (int i = 0; i < sb.length(); i++) {
			char c = sb.charAt(i);
			if (c >= '０' && c <= '９') {
				sb.setCharAt(i, (char) (c - '０' + '0'));
			}
		}
		return sb.toString();
	}

	public static String changTextShowName(String index, String replaceNm) {

		if (!"".equals(StringUtils.nvl(index)) && !"".equals(StringUtils.nvl(replaceNm))) {
			switch (index) {
			case "1":
				return "第一" + replaceNm;
			case "2":
				return "第二" + replaceNm;
			case "3":
				return "第三" + replaceNm;
			case "4":
				return "第四" + replaceNm;
			case "5":
				return "第五" + replaceNm;
			case "6":
				return "第六" + replaceNm;
			case "7":
				return "第七" + replaceNm;
			case "8":
				return "第八" + replaceNm;
			case "9":
				return "第九" + replaceNm;
			case "10":
				return "第十" + replaceNm;
			}
		}

		return "";

	}

	/**
	 * 将元数据前补零，补后的总长度为指定的长度，以字符串的形式返回
	 * 
	 * @param sourceDate
	 * @param formatLength
	 * @return 重组后的数据
	 */
	public static String frontCompWithZore(int sourceDate, int formatLength) {
		/*
		 * 0 指前面补充零 formatLength 字符总长度为 formatLength d 代表为正数。
		 */
		String newString = String.format("%0" + formatLength + "d", sourceDate);
		return newString;
	}
}
