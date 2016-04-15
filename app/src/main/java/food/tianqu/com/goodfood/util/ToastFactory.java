package food.tianqu.com.goodfood.util;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import food.tianqu.com.goodfood.R;


/**
 * @ClassName: ToastFactory
 * @Description: TODO()
 * @date zh_m8@163.com 2012-11-5 上午10:10:41
 * @version V2.0
 */
public class ToastFactory {

	/**
	 * @Title: toast
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @param context 上下文对象
	 * @param @param message 显示的消息(String)
	 * @param @param type 提示的类型
	 * @return void 返回类型
	 * @date zh_m8@163.com 2012-11-5 上午10:18:08
	 * @version V2.0
	 */
	public static void toast(Context context, String message, String type) {

		View toastRoot = LayoutInflater.from(context).inflate(R.layout.toast,null);
		Toast toast = new Toast(context);
		toast.setView(toastRoot);
		int resId = R.drawable.toast_info_icon;
		if ("error".equals(type)) {
			resId = R.drawable.toast_error_icon;
		} else if ("failed".equals(type)) {
			resId = R.drawable.toast_failed_icon;
		} else if ("success".equals(type)) {
			resId = R.drawable.toast_success_icon;
		}
		/**
		 * 创建图标资源（用于显示在overlayItem所标记的位置）
		 */
		Drawable marker = context.getResources().getDrawable(resId);
		ImageView im = (ImageView) toastRoot.findViewById(R.id.toast_icon);
		im.setImageDrawable(marker);

		TextView tv = (TextView) toastRoot.findViewById(R.id.toast_msg);
		tv.setText(message);//
		toast.setDuration(Toast.LENGTH_SHORT);// Toast的显示时间不可编辑
		toast.show();
	}
	
	
	public static void toast(Fragment fragment, int message, String type){
		toast(fragment.getActivity(), message, type) ;
	}

	/**
	 * @Title: toast
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @param context 上下文对象
	 * @param @param message 显示的消息来自R.String.*
	 * @param @param type 提示的类型
	 * @return void 返回类型
	 * @date zh_m8@163.com 2012-11-5 上午10:17:35
	 * @version V2.0
	 */

	public static void toast(Context context, int message, String type) {
		View toastRoot = LayoutInflater.from(context).inflate(R.layout.toast,null);
		Toast toast = new Toast(context);
		toast.setView(toastRoot);
		int resId = R.drawable.toast_info_icon;
		if ("error".equals(type)) {
			resId = R.drawable.toast_error_icon;
		} else if ("failed".equals(type)) {
			resId = R.drawable.toast_failed_icon;
		} else if ("success".equals(type)) {
			resId = R.drawable.toast_success_icon;
		}
		/**
		 * 创建图标资源（用于显示在overlayItem所标记的位置）
		 */
		Drawable marker = context.getResources().getDrawable(resId);
		ImageView im = (ImageView) toastRoot.findViewById(R.id.toast_icon);
		im.setImageDrawable(marker);

		TextView tv = (TextView) toastRoot.findViewById(R.id.toast_msg);
		tv.setText(message);// 显示信息
		toast.setDuration(Toast.LENGTH_SHORT);// Toast的显示时间不可编辑
		toast.show();
	}

	
	
	
	public static void toast(Fragment fg, int message, String type, boolean isLastLong) {
		toast(fg.getActivity(),message,type,isLastLong);
	}
	
	/**
	 * @Title: toast
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @param context 上下文对象
	 * @param @param message 显示的消息
	 * @param @param type 提示的类型
	 * @param @param isLastLong 持续时间 ( 注： Toast.LENGTH_SHORT = false
	 *        Toast.LENGTH_LONG = true)
	 * @return void 返回类型
	 * @date zh_m8@163.com 2012-11-5 上午10:15:17
	 * @version V2.0
	 */
	public static void toast(Context context, int message, String type,boolean isLastLong) {

		View toastRoot = LayoutInflater.from(context).inflate(R.layout.toast,
				null);
		Toast toast = new Toast(context);
		toast.setView(toastRoot);

		int resId = R.drawable.toast_info_icon;
		if ("error".equals(type)) {
			resId = R.drawable.toast_error_icon;
		} else if ("failed".equals(type)) {
			resId = R.drawable.toast_failed_icon;
		} else if ("success".equals(type)) {
			resId = R.drawable.toast_success_icon;
		}
		/**
		 * 创建图标资源（用于显示在overlayItem所标记的位置）
		 */
		Drawable marker = context.getResources().getDrawable(resId);
		ImageView im = (ImageView) toastRoot.findViewById(R.id.toast_icon);
		im.setImageDrawable(marker);

		TextView tv = (TextView) toastRoot.findViewById(R.id.toast_msg);
		tv.setText(message);// 显示信息

		if (isLastLong) {
			toast.setDuration(Toast.LENGTH_LONG);// Toast的显示时间不可编辑
		} else {
			toast.setDuration(Toast.LENGTH_SHORT);// Toast的显示时间不可编辑
		}

		toast.show();
	}

	/**
	 * @Title: toast
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @param context 上下文对象
	 * @param @param message 显示的消息
	 * @param @param type 提示的类型
	 * @param @param isLastLong 持续时间 ( 注： Toast.LENGTH_SHORT = false
	 *        Toast.LENGTH_LONG = true)
	 * @return void 返回类型
	 * @date zh_m8@163.com 2012-11-19 上午10:15:17
	 * @version V2.0
	 */
	public static void toast(Context context, String message, String type,boolean isLastLong) {

		View toastRoot = LayoutInflater.from(context).inflate(R.layout.toast,null);
		Toast toast = new Toast(context);
		toast.setView(toastRoot);

		int resId = R.drawable.toast_info_icon;
		if ("error".equals(type)) {
			resId = R.drawable.toast_error_icon;
		} else if ("failed".equals(type)) {
			resId = R.drawable.toast_failed_icon;
		} else if ("success".equals(type)) {
			resId = R.drawable.toast_success_icon;
		}
		/**
		 * 创建图标资源（用于显示在overlayItem所标记的位置）
		 */
		Drawable marker = context.getResources().getDrawable(resId);
		ImageView im = (ImageView) toastRoot.findViewById(R.id.toast_icon);
		im.setImageDrawable(marker);

		TextView tv = (TextView) toastRoot.findViewById(R.id.toast_msg);
		tv.setText(message);// 显示信息

		if (isLastLong) {
			toast.setDuration(Toast.LENGTH_LONG);// Toast的显示时间不可编辑
		} else {
			toast.setDuration(Toast.LENGTH_SHORT);// Toast的显示时间不可编辑
		}

		toast.show();
	}
	
	public static void toast(Fragment fg, String message, String type, boolean isLastLong) {
		toast(fg.getActivity(), message, type,isLastLong);
	}
	
	public static void toast(Fragment fg, String message, String type) {
		toast(fg.getActivity(), message, type,false);
	}



	/**
	 * 成功提示信息
	 *@author mzmz345
	 *@date  2015/8/13 10:43
	 */
	public static void httpSuccessResponseToast(Context context, String message,String tag){
		String tagStr = StringUtil.emptyAll(message)? tag: message ;
		toast(context,tagStr,"success");
	}

	/**
	 * 成功提示信息
	 *@author mzmz345
	 *@date  2015/8/13 10:43
	 */
	public static void httpSuccessResponseToast(Context context, String message,int strRes){
		String tagStr = StringUtil.emptyAll(message)? context.getString(strRes): message ;
		toast(context,tagStr,"success");
	}

	/**
	 * 失败提示信息
	 *@author mzmz345
	 *@date  2015/8/13 10:43
	 */
	public static void httpFailedResponseToast(Context context, String message,String tag){
		String tagStr = StringUtil.emptyAll(message)? tag: message ;
		toast(context,tagStr,"error");
	}

	/**
	 * 失败提示信息
	 *@author mzmz345
	 *@date  2015/8/13 10:43
	 */
	public static void httpFailedResponseToast(Context context, String message,int strRes){
		String tagStr = StringUtil.emptyAll(message)? context.getString(strRes): message ;
		toast(context,tagStr,"error");
	}

	
}
