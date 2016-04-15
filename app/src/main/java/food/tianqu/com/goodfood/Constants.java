package food.tianqu.com.goodfood;

import android.os.Environment;

import java.io.File;

public class Constants {

	/**
	 * 时间格式1
	 */
	public static String TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

	/**
	 * 时间格式2
	 */
	public static String TIME_FORMAT2 = "MM/dd";

	/**
	 * 时间格式3
	 */
	public static String TIME_FORMAT3 = "yyyy-MM-dd";

	public static String PREFS_NAME = "TQCLIENT";// sharedpreferences名字

	/**
	 * userId
	 */
	public static String PREFS_USER_ID = "user_id";// sharedpreferences user_id

	/**
	 * mobile
	 */
	public static String PREFS_MOBILE = "mobile";// sharedpreferences user_id

	/**
	 * username
	 */
	public static String PREFS_USER_NAME = "user_name";// sharedpreferences user_id

	/**
	 * password
	 */
	public static String PREFS_USER_PASSWORD = "user_pwd";// sharedpreferences user_id

	/**
	 * password
	 */
	public static String PREFS_LOGIN_PASSWORD = "login_pwd";// sharedpreferences user_id

	/**
	 * token
	 */
	public static String PREFS_TOKEN = "token";// sharedpreferences user_id

	/**
	 * 3G/4G
	 */
	public static String G_WIFI = "3g/4g" ;

	/**
	 * wifi
	 */
	public static String O_WIFI = "wifi" ;

	/**
	 * 消息来源
	 * "1":IOS
	 * "2":android
	 */
	public static String ORIGIN   = "2";

	/**
	 * 请求标识，标识成功
	 */
	public static String RETCODE   = "200";


	/**
	 * 百度地图返回码
	 */
	public static String BDRETCODE   = "0";


	/**
	 * 请求标识，表示已被注册
	 */
	public static String REGISTERED   = "300";

	/**
	 * 高清图片后缀
	 */
	public static String ORIGINAL = "_orgin.jpeg";

	/**
	 * 缩略图片后缀
	 */
	public static String SHORT = ".jpeg";
	
	
	
	
	//http请求url
	public static String URL = "http://121.41.41.99:81/";                                          // url地址

	//http请求url
	public static String URL_FILE = "http://121.41.41.99/";                                          // url地址

	/**
	 * 用户登录
	 */
	public static String URL_USER_LOGIN = URL + "User/login";

	/**
	 * 自动登录
	 */
	public static String URL_AUTO_LOGIN = URL + "User/autoLogin";

	/**
	 * 修改个人信息
	 */
	public static String URL_MODIFY_INFO = URL + "User/modifyInfo";

	/**
	 * 获取绑定银行卡列表
	 */
	public static String URL_BIND_BANK_LIST = URL + "User/bindList";

	/**
	 * 绑定银行卡
	 */
	public static String URL_BIND_BANK = URL + "User/bindBank";

	/**
	 * 好友信息
	 */
	public static String URL_FRIEND_INFO = URL + "User/friendInfo";

	/**
	 * 银行卡提现
	 */
	public static String URL_CASH_REQUEST = URL + "User/cashRequest";

	/**
	 * 银行卡列表
	 */
	public static String URL_LIST_BANK = URL + "User/listBank";

	/**
	 * 修改密码
	 */
	public static String URL_MODIFY_PWD =URL + "User/modifyPassword";

	/**
	 * 近七日影响力
	 */
	public static String URL_ACCOUNT_EFFECT = URL + "User/accountEffect";

	/**
	 * 我的稿费
	 */
	public static String URL_ACCOUNT_PROFIT = URL + "User/accountProfit";

	/**
	 * 第三方登录
	 */
	public static String URL_THIRD_LOGIN = URL + "User/thirdLogin";

	/**
	 * 获取验证码注册
	 */
	public static String URL_MOBILE_REG = URL + "User/mobileReg";

	/**
	 * 获取验证码
	 */
	public static String URL_CHECK_MOBILE = URL + "User/checkMobile";

	/**
	 * 获取最新消息列表
	 */
	public static String URL_MESSAGE_LATESTLIST = URL + "Message/latestList";

	/**
	 * 快讯列表
	 */
	public static String URL_NEWS_LIST = URL + "News/list";

	/**
	 * 我的快讯
	 */
	public static String URL_MY_LOVE = URL + "News/myLove";

	/**
	 * 我的快讯
	 */
	public static String URL_NEWS_MINE = URL + "News/my";

	/**
	 * 快讯表态
	 */
	public static String URL_NEWS_DECLARE = URL + "News/declare";

	/**
	 * 快讯点赞
	 */
	public static String URL_NEWS_DETAILS = URL + "News/detail";

	/**
	 * 快讯收藏
	 */
	public static String URL_NEWS_LOVE = URL + "News/love";

	/**
	 * 取消快讯收藏
	 */
	public static String URL_NEWS_CANCLE_LOVE = URL + "News/cancelLove";

	/**
	 * 举报
	 */
	public static String URL_NEWS_REPORT = URL + "News/report";

	/**
	 * 获取评论列表
	 */
	public static String URL_NEWS_PEPLYLIST = URL + "News/replyList";

	/**
	 * 评论回复
	 */
	public static String URL_NEWS_MSGLIST = URL + "News/msgList";

	/**
	 * 评论点赞
	 */
	public static String URL_NEWS_PRAISE = URL + "News/praise";

	/**
	 * 评论取消点赞
	 */
	public static String URL_NEWS_CANCLE_PRAISE = URL + "News/cancelPraise";

	/**
	 * 发布
	 */
	public static String URL_NEWS_REPLY_SEND = URL + "News/reply";

	/**
	 * 删除
	 */
	public static String URL_NEWS_DELETE = URL + "News/delete";

	/**
	 * 添加快讯
	 */
	public static String URL_ADD_NEWS = URL + "News/add";

	/**
	 * 获取自己详细信息
	 */
	public static String URL_GET_MINE_INFO = URL + "User/info";


	/**
	 * 文件上传
	 */
	public static String URL_UPLOAD = URL_FILE + "upload.php";

	/**
	 * 图片加载
	 */
	public static String URL_DOWNLOAD = URL_FILE +"get.php?id=";

	/**
	 * 百度地址地理位置逆编码
	 */
	public static String URL_GET_AROUND = "http://api.map.baidu.com/geocoder/v2/";

	/**
	 * 百度地址地理位置逆编码参数
	 */
	public static String MCODE = "1D:A8:94:0B:1B:04:A4:3C:45:26:8C:E2:2A:63:7C:4D:90:C7:B9:A8;com.tq.firenews";

	/**
	 * 百度地图AK
	 */
	public static String AK = "BIEDImVQh5Mg2NeCdGkzhm0j";

	/**
	 * 高德地图key
	 */
	public static String  GAODE_KEY = "bf35ff2e0ff9f9b9bdc1c472f7ed3bbd";

	//	 获取程序SD缓存文件夹名称
	public static final String APP_SD_VIDEO_NAME = Environment.getExternalStorageDirectory() + File.separator+"tqVideo";

	//	 获取程序SD缓存文件夹名称
	public static final String APP_SD_FILE_NAME = Environment.getExternalStorageDirectory() + File.separator+"tqClient";
	//图片下载保存地址
	public static final String DOWNLOAD_IMG_DOC_NAME = Environment.getExternalStorageDirectory() + File.separator+"tqClient_download";   //图片下载保存地址

	/**
	 * 每页取15条数据
	 */
	public static final String OFFSET = "15";   //图片下载保存地址
	
}
