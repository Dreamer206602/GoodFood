package food.tianqu.com.goodfood.util;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.telephony.TelephonyManager;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class CommonUtil {

	/**
	 * 检测网络是否可用
	 * 
	 * @param context
	 * @return
	 */
	public static boolean isNetWorkConnected(Context context) {
		if (context != null) {
			ConnectivityManager mConnectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
			NetworkInfo mNetworkInfo = mConnectivityManager.getActiveNetworkInfo();
			if (mNetworkInfo != null) {
				return mNetworkInfo.isAvailable();
			}
		}

		return false;
	}

	public static boolean isWifiAvailable(Context ctx) {
		ConnectivityManager manager = (ConnectivityManager) ctx
				.getSystemService(Context.CONNECTIVITY_SERVICE);
		return manager.getNetworkInfo(ConnectivityManager.TYPE_WIFI)
				.isConnected();
	}

	/**
	 * 检测Sdcard是否存在
	 * 
	 * @return
	 */
	public static boolean isExitsSdcard() {
		if (android.os.Environment.getExternalStorageState().equals(android.os.Environment.MEDIA_MOUNTED))
			return true;
		else
			return false;
	}
	
    static String getString(Context context, int resId) {
        return context.getResources().getString(resId);
    }
	
	public static String getTopActivity(Context context) {
		ActivityManager manager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
		List<RunningTaskInfo> runningTaskInfos = manager.getRunningTasks(1);

		if (runningTaskInfos != null)
			return runningTaskInfos.get(0).topActivity.getClassName();
		else
			return "";
	}

	/**
	 * 获取Imei信息
	 * @param context
	 * @return
	 */
	static String getszImei(Context context){
		TelephonyManager TelephonyMgr = (TelephonyManager)context.getSystemService(Context.TELEPHONY_SERVICE);
		String szImei = TelephonyMgr.getDeviceId();
		return szImei;
	}

	/**
	 * 获取Sim Serial Number信息
	 * @param context
	 * @return
	 */
	static String getSerialNum(Context context){
		TelephonyManager tm = (TelephonyManager)context.getSystemService(Context.TELEPHONY_SERVICE);
		String simSerialNumber = tm.getSimSerialNumber();
		return simSerialNumber;
	}

	/**
	 * 获取mac地址信息
	 * @param context
	 * @return
	 */
	static String getMacAddress(Context context){
		WifiManager wm = (WifiManager)context.getSystemService(Context.WIFI_SERVICE);
		String m_szWLANMAC = wm.getConnectionInfo().getMacAddress();
		return m_szWLANMAC;
	}

	/**
	 * 获取BT MAC Address
	 * @param context
	 * @return
	 */
	static String getBTMA(Context context){
		BluetoothAdapter m_BluetoothAdapter = null; // Local Bluetooth adapter
		m_BluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
		String m_szBTMAC = m_BluetoothAdapter.getAddress();
		return m_szBTMAC;
	}

	public static String getDeviceId(Context context){
		String m_szLongID = getszImei(context) + getBTMA(context)
				+ getMacAddress(context)+ getSerialNum(context);
		MessageDigest m = null;
		try {
			m = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		m.update(m_szLongID.getBytes(),0,m_szLongID.length());
        // get md5 bytes
		byte p_md5Data[] = m.digest();
        // create a hex string
		String m_szUniqueID = new String();
		for (int i=0;i<p_md5Data.length;i++) {
			int b =  (0xFF & p_md5Data[i]);
			if (b <= 0xF)
				m_szUniqueID+="0";
         // add number to string
			m_szUniqueID+=Integer.toHexString(b);
		}   // hex string to uppercase
		m_szUniqueID = m_szUniqueID.toUpperCase();
		return m_szUniqueID;
	}

	public static String getDeviceInfo(Context context){
		TelephonyManager tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
		StringBuilder sb = new StringBuilder();
		sb.append("\nDeviceId(IMEI) = " + tm.getDeviceId());
		sb.append("\nDeviceSoftwareVersion = " + tm.getDeviceSoftwareVersion());
		sb.append("\nLine1Number = " + tm.getLine1Number());
		sb.append("\nNetworkCountryIso = " + tm.getNetworkCountryIso());
		sb.append("\nNetworkOperator = " + tm.getNetworkOperator());
		sb.append("\nNetworkOperatorName = " + tm.getNetworkOperatorName());
		sb.append("\nNetworkType = " + tm.getNetworkType());
		sb.append("\nPhoneType = " + tm.getPhoneType());
		sb.append("\nSimCountryIso = " + tm.getSimCountryIso());
		sb.append("\nSimOperator = " + tm.getSimOperator());
		sb.append("\nSimOperatorName = " + tm.getSimOperatorName());
		sb.append("\nSimSerialNumber = " + tm.getSimSerialNumber());
		sb.append("\nSimState = " + tm.getSimState());
		sb.append("\nSubscriberId(IMSI) = " + tm.getSubscriberId());
		sb.append("\nVoiceMailNumber = " + tm.getVoiceMailNumber());
		return sb.toString();
	}

	/**
	 * 动态设置ListView的高度
	 * @param listView
	 */
	public static void setListViewHeightBasedOnChildren(ListView listView) {
		if(listView == null) return;
		ListAdapter listAdapter = listView.getAdapter();
		if (listAdapter == null) {
			// pre-condition
			return;
		}
		int totalHeight = 0;
		for (int i = 0; i < listAdapter.getCount(); i++) {
			View listItem = listAdapter.getView(i, null, listView);
			listItem.measure(0, 0);
			totalHeight += listItem.getMeasuredHeight();
		}
		ViewGroup.LayoutParams params = listView.getLayoutParams();
		params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
		listView.setLayoutParams(params);
	}

	public static Date timeStamp2Date(String timestampString, String formats){
		Long timestamp = Long.parseLong(timestampString)*1000;
		String date = new SimpleDateFormat(formats).format(new Date(timestamp));
		try
		{
			SimpleDateFormat sdf = new SimpleDateFormat(formats);
			return sdf.parse(date);
		}
		catch (ParseException e)
		{
			System.out.println(e.getMessage());
		}
		return null;
	}

	public static String timeStamp2String(String timestampString, String formats){
		Long timestamp = Long.parseLong(timestampString)*1000;
		String date = new SimpleDateFormat(formats).format(new Date(timestamp));
		return date;
	}

	public static int getWidth(Context context){
		WindowManager windowManager = ((Activity)context).getWindowManager();
		Display display = windowManager.getDefaultDisplay();
		return display.getWidth();
	}

	public static int getHeight(Context context){
		WindowManager windowManager = ((Activity)context).getWindowManager();
		Display display = windowManager.getDefaultDisplay();
		return display.getHeight();
	}
}
