package food.tianqu.com.goodfood.util;
import java.text.DecimalFormat;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class StringUtil {

	public static final String DEFAULT_RULE = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";


	/**随机生成length位rule内的字符
	 * @param length 生成字符长度
	 * @param rule 生成字符范围*/
	public static String getRandomString(int length, String rule){
		int rLength = rule.length();
		StringBuilder stringBuilder = new StringBuilder();
		for(int i=0;i<length; i++){
			int randNum = new Random().nextInt(rLength);
			stringBuilder.append(rule.charAt(randNum));
		}

		return stringBuilder.toString();
	}

	/**
	 * 过滤特殊字符
	 * 
	 * @param str
	 *            String
	 */
	public String StringFilter(String str) throws PatternSyntaxException {
		str = str.replaceAll("【", "[").replaceAll("】", "]")
				.replaceAll("！", "!").replaceAll("，", ",");// 替换全角符号
		String regEx = "[『』（）]"; // 清除掉特殊字符
		Pattern p = Pattern.compile(regEx);
		Matcher m = p.matcher(str);
		return m.replaceAll("").trim();
	}

	
	/**
	 * 手机号码验证
	 * 
	 * @param mobile
	 *            手机号码
	 */
	public static boolean isMobile(String mobile) {
		Pattern p = Pattern.compile("^((1[0-9]))\\d{9}$");
		
		Matcher m = p.matcher(mobile);
		return m.matches();
	}

	/**
	 * 是否数字
	 * @param str
	 */
	public static boolean isNum(String str) {
		Pattern p = Pattern.compile("^\\d$");

		Matcher m = p.matcher(str);
		return m.matches();
	}

	
	/**
	 * 手机号码验证
	 */
    public static boolean isMobileNO(String mobiles){
        Pattern p = Pattern.compile("^((1[0-9]))\\d{9}$");
        Matcher m = p.matcher(mobiles);
        System.out.println(m.matches()+"---");
        return m.matches();  
    }  
    /**
     * 判断是否为中英文字符或数字
     * @param uName
     * @return
     */
    public static boolean isEnorCh(String uName){
    	Pattern p = Pattern.compile("^[\u4e00-\u9fa5_a-zA-Z0-9]+$");
        Matcher m = p.matcher(uName);
        System.out.println(m.matches()+"---");
        return m.matches(); 
    }

	/**
	 * 自定义空值判断["",NULL,"null"]
	 */
	public static boolean empty(String str) {
		if (null == str || "".equals(str)) {
			return true;
		} else {
			str = str.trim();// 去除空格
			str = str.toLowerCase();
			if ("null".equals(str) || "".equals(str) ) {
				return true;
			}
		}
		return false;
	}

	
	public static boolean isUserEmpty(int uid){
		if(uid==0) {
			return true;
		}else{
			return false;
		}
	}
	
	public static String getRealStr(String str,String defaultStr){
		String resultStr = defaultStr;
		if(!empty(str)){
			resultStr = str;
		}
		return resultStr;
	}
	
	
	
	
	public static boolean responseNull(String str) {
		if (null == str || "".equals(str)) {
			return true;
		} else {
			str = str.trim();// 去除空格
			str = str.toLowerCase();
			if ("null".equals(str) || "".equals(str) ) {
				return true;
			}
		}
		return false;
	}
	
	
	
	/**
	 * 自定义空值判断["0","",NULL,"null"]
	 */
	public static boolean emptyAll(String str) {
		
		if (null == str || "".equals(str)) {
			return true;
		} else {
			str = str.trim();// 去除空格
			str = str.toLowerCase();
			if ("null".equals(str) || "".equals(str) || "0".equals(str) ) {
				return true;
			}
		}
		return false;
	}
	
	
	

	/**
	* @Title: isNetResponse
	* @Description: TODO(网络异常错误)
	* @param   @param str
	* @param   @return    设定文件
	* @return boolean    返回类型
	* @date   zh_m8@163.com  2012-12-20 上午10:06:03 
	* @version V2.0   
	*/
	public static boolean  isNetResponse(String str){
		if (null == str) {
			return false;
		} else {
			str = str.trim();// 去除空格
			str = str.toLowerCase();
			if ("null".equals(str)) {
				return false;
			}
		}
		return true;
	}
	
	
	/**
	 * @Title: strLength
	 * @Description: TODO(获取字符串的长度，如果有中文，则每个中文字符计为2位)
	 * @param @param value
	 * @param @return 指定的字符串
	 * @return int 返回类型
	 * @date zh_m8@163.com 2012-11-1 上午10:25:59
	 * @version V2.0
	 */
	public static int strLength(String value) {
		int valueLength = 0;
		if (value != null) {
			String chinese = "[\u0391-\uFFE5]";
			/* 获取字段值的长度，如果含中文字符，则每个中文字符长度为2，否则为1 */
			for (int i = 0; i < value.length(); i++) {
				/* 获取一个字符 */
				String temp = value.substring(i, i + 1);
				/* 判断是否为中文字符 */
				if (temp.matches(chinese)) {
					/* 中文字符长度为2 */
					valueLength += 2;
				} else {
					/* 其他字符长度为1 */
					valueLength += 1;
				}
			}
		}
		return valueLength;
	}

	
	
	/**  
     * 半角转换为全角  
     *   
     * @param input  
     * @return  
     */  
	private static String ToDBC(String input) {
		char[] c = input.toCharArray();
		for (int i = 0; i < c.length; i++) {
			if (c[i] == 12288) {
				c[i] = (char) 32;
				continue;
			}
			if (c[i] > 65280 && c[i] < 65375)
				c[i] = (char) (c[i] - 65248);
		}
		return new String(c);
	}

	/**
	 * 去除特殊字符或将所有中文标号替换为英文标号
	 * 
	 * @param str
	 * @return
	 */
	private static String stringFilter(String str) {
		str = str.replaceAll("【", "[").replaceAll("】", "]")
				.replaceAll("！", "!").replaceAll("：", ":");// 替换中文标号
		String regEx = "[『』]"; // 清除掉特殊字符
		Pattern p = Pattern.compile(regEx);
		Matcher m = p.matcher(str);
		return m.replaceAll("").trim();
	}

	
	/**
	* @Title: toTextView
	* @Description: TODO(解决TextView自动换行的)
	* @param   @param str
	* @param   @return    设定文件
	* @return String    返回类型
	* @date   zh_m8@163.com  2012-11-9 上午11:50:32 
	* @version V2.0   
	*/
	public static String toTextView(String str){
		return ToDBC(stringFilter(str));
	}
	
	
	public static int toInt(String str){
		try{
			return Integer.parseInt(str);
		}catch(Exception e){
			return 0;
		}
	}
	

	public static boolean isEmailNo(String mobiles) {
		Pattern pattern = Pattern.compile(
				"^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$");
		Matcher matcher = pattern.matcher(mobiles);
		return matcher.matches();
	}
	
	
	
	public static String trimmy(String str)
	{
		String dest = "";
		if (str != null)
		{
			str = str.replaceAll("-", "");
			str = str.replaceAll("\\+", "");
			dest = str;
		}
		return dest;
	}
	
	
	public static String getLength(String distance) {
		if(StringUtil.empty(distance)){
			return "0";
		}
		
		float lenMeter = Float.valueOf(distance.trim());
		float dis = (float) lenMeter / 1000;
		DecimalFormat fnum = new DecimalFormat("##0.0");
		String dstr = fnum.format(dis);
		return dstr;
	}
	
	
	public static String byte2Mb(float byteNum) {
		String fileSizeStr = null;
		double sizeMb = byteNum / (1024*1024);
		// 取小数点儿后两位
		DecimalFormat df = new DecimalFormat("###.00");
		DecimalFormat df1 = new DecimalFormat("0.00");
		
		if (sizeMb <= 1) {
			fileSizeStr = df1.format(sizeMb);
		} else {
			fileSizeStr = df.format(sizeMb);
		}
		return fileSizeStr+"M";
	}
}