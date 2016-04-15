package food.tianqu.com.goodfood;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Toast;
import org.xutils.x;

/***************************************************************************
 * 
 * 生命周期 场景演示 :
 * 
 * 切换到该Fragment
 * onAttach-onCreate-onCreateView-onActivityCreated-onStart-onResume
 * 
 * 屏幕灭掉 onPause-onSaveInstanceState-onStop
 * 
 * 屏幕解锁 onStart-onResume
 * 
 * 切换到其他Fragment onPause-onStop-onDestroyView
 * 
 * 切换回本身的Fragment onCreateView-onActivityCreated-onStart-onResume
 * 
 * 回到桌面 onPause-onSaveInstanceState-onStop
 * 
 * 回到应用 onStart-onResume
 * 
 * 退出应用 onPause-onStop-onDestroyView-onDestroy-onDetach
 ***************************************************************************/

public abstract class BaseFragment extends Fragment {

	/**
	 * 
	 * @param inflater
	 * @return 需要显示的view
	 */
	public abstract View getView(LayoutInflater inflater);

	/**
	 * 程序入库/UI控件注入
	 */
	public abstract void init();

	/**
	 * Toast输出
	 * 
	 * @param text
	 */
	public static void ShowToast(String text) {
		//CustomToast.showToast(AppManag.getContext(), text, 1000);
		Toast.makeText(BaseApplication.getContext(), text, Toast.LENGTH_LONG).show();
	}

	/**
	 * Toast输出
	 * 
	 * @param
	 */
	public static void ShowToast(int resId) {
		// CustomToast.showToast(App.getContext(), resId, 1000);
		// Toast.makeText(App.getContext(), resId, Toast.LENGTH_LONG).show();
	}

	public static void ShowToast(CharSequence text) {
//		 Toast.makeText(App.getContext(), text, Toast.LENGTH_LONG).show();
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContext(getActivity());
		pageName = this.getActivity().getTitle().toString();
	}

	private View view;
	private Context context;
	public String pageName;

	public void setContext(Context context) {
		this.context = context;
	}

	public Context getContext() {
		return context;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		if (view == null) {
			view = getView(inflater);
		}
		// 缓存的view需要判断是否已经被加过parent，
		// 如果有parent需要从parent删除，要不然会发生这个view已经有parent的错误。
		ViewGroup parent = (ViewGroup) view.getParent();
		if (parent != null) {
			parent.removeView(view);
		}
		x.view().inject(this, inflater, container);
		init();
		loadData();
		return view;
	}

	/**
	 * 
	 */
	public void loadData() {

	}

	/**
	 * Dialog 封装
	 * 
	 * @param context
	 * @param theme
	 * @param layoutResID
	 * @return mDialog
	 */
	public static Dialog initDialog(Context context, int theme, int layoutResID) {
		Dialog mDialog = new Dialog(context, theme);
		mDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
		mDialog.setContentView(layoutResID);
		mDialog.setCanceledOnTouchOutside(false);// 点击其他区域dialog不消失
		// mDialog.setTitle(titleName);
		return mDialog;
	}

	// Umeng 对处理事件的统计
	public void onResume() {
		super.onResume();
		// MobclickAgent.onResume(this.getContext()); // 统计页面
	}

	public void onPause() {
		super.onPause();
		// MobclickAgent.onPause(this.getContext()); // 统计页面
	}

}
