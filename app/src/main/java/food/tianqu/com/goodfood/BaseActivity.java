package food.tianqu.com.goodfood;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import food.tianqu.com.goodfood.ui.view.LoadingDialog;
import food.tianqu.com.goodfood.util.CustomToast;
import food.tianqu.com.goodfood.util.StringUtil;


@SuppressLint("NewApi")
public abstract class BaseActivity extends FragmentActivity {
	public String pageName;

	public String TAG = "tq_food";

	/*
	 * 重写父类方法
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if (savedInstanceState == null) {
			pageName = this.getClass().getSimpleName();
			requestWindowFeature(Window.FEATURE_NO_TITLE);// 取消标题
			getWindow().setSoftInputMode(
					WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
			AppManager.getAppManager().addActivity(this);
			init(savedInstanceState);
		} else {
			finish();
		}
	}


	public void finshAllActivity() {
		AppManager.getAppManager().finishAllActivity();
	}

	/**
	 * 
	 */
	public void loadData() {

	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
	}

	/**
	 * Dialog 封装
	 * 
	 * @param context
	 * @param layoutResID
	 * @return mDialog
	 */
	public static Dialog initDialog(Context context, int theme, int layoutResID) {
		Dialog mDialog = new Dialog(context, theme);
		mDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
		mDialog.setContentView(layoutResID);
		mDialog.setCanceledOnTouchOutside(false);// 点击其他区域dialog消失
		// mDialog.setTitle(titleName);
		return mDialog;
	}

	/**
	 *提交进度框
	 */
	public static LoadingDialog initLoadingDialog(Context context){
		LoadingDialog postDataPgb = new LoadingDialog(context);
		postDataPgb.setCanceledOnTouchOutside(false);
		postDataPgb.setLoadText(R.string.aheady_pbg_post_save);
		return postDataPgb;
	}
	/**
	 * 程序入库/UI控件注入
	 */
	public abstract void init(Bundle savedInstanceState);

	public void ShowToast(String text) {
		CustomToast.showToast(this, text, 1000);
	}

	public void ShowToast(int resId) {
		CustomToast.showToast(this, resId, 1000);
	}

	public void ShowImageToast(String text,int image){
		CustomToast.showImageToast(this,text,image);
	}

	/**
	 * ProgressDialog 封装
	 * 
	 * @param context
	 * @param style
	 * @param message
	 * @return mProgressDialog
	 */
	public static ProgressDialog initProgressDialog(Context context, int style,
			String message) {
		ProgressDialog mProgressDialog = new ProgressDialog(context);
		mProgressDialog.setCanceledOnTouchOutside(false);
		mProgressDialog.setProgressStyle(style);
		mProgressDialog.setMessage(message);
		return mProgressDialog;
	}

	public Bitmap takeScreenShot() {
		View view = getWindow().getDecorView();
		view.setDrawingCacheEnabled(true);

		view.buildDrawingCache();

		Bitmap b1 = view.getDrawingCache();

		// 获取状态栏高度
		Rect frame = new Rect();
		getWindow().getDecorView().getWindowVisibleDisplayFrame(frame);
		int statusBarHeight = frame.top;

		DisplayMetrics dm = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(dm);
		// 获取屏幕长和高
		int width = dm.widthPixels;
		int height = dm.heightPixels;
		// 去掉标题栏
		Bitmap b = Bitmap.createBitmap(b1, 0, statusBarHeight, width, height
				- statusBarHeight);
		view.destroyDrawingCache();
		return b;
	}
	
	/**
	 * 
	 * @return 窗口宽度
	 */
	public int getWindowWidth() {
		DisplayMetrics dm = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(dm);
		return dm.widthPixels;
	}

	/**
	 * 获取屏幕高度
	 * 
	 * @return Pixels
	 */
	public int getWindowHeight() {
		DisplayMetrics dm = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(dm);
		return dm.heightPixels;
	}
	@Override
	protected void onResume(){
		super.onResume();
	}

	protected ProgressDialog mProgressDialog;

	public ProgressDialog showProgress(String title, String message) {
		return showProgress(title, message, -1);
	}

	public ProgressDialog showProgress(String title, String message, int theme) {
		if (mProgressDialog == null) {
			if (theme > 0)
				mProgressDialog = new ProgressDialog(this, theme);
			else
				mProgressDialog = new ProgressDialog(this);
			mProgressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
			mProgressDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
			mProgressDialog.setCanceledOnTouchOutside(false);// 不能取消
			mProgressDialog.setIndeterminate(true);// 设置进度条是否不明确
		}

		if (!StringUtil.responseNull(title))
			mProgressDialog.setTitle(title);
		mProgressDialog.setMessage(message);
		mProgressDialog.show();
		return mProgressDialog;
	}

	public void hideProgress() {
		if (mProgressDialog != null) {
			mProgressDialog.dismiss();
		}
	}

	@Override
	protected void onRestart(){
		super.onRestart();
	}

}
