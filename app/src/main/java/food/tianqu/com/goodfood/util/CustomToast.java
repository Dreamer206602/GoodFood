package food.tianqu.com.goodfood.util;

import android.content.Context;
import android.os.Handler;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class CustomToast {
	private static Toast mToast;
	private static Handler mHandler = new Handler();
	private static Runnable r = new Runnable() {
		public void run() {
			mToast.cancel();
		}
	};

	public static void showToast(Context mContext, String text, int duration) {
		mHandler.removeCallbacks(r);
		if (mToast != null)
			mToast.setText(text);
		else
			mToast = Toast.makeText(mContext, text, Toast.LENGTH_SHORT);
		mHandler.postDelayed(r, duration);

		mToast.show();
	}

	public static void showImageToast(Context mContext, String text,int image){

		mToast = Toast.makeText(mContext,
				text, Toast.LENGTH_LONG);
		mToast.setGravity(Gravity.CENTER, 0, 0);
		LinearLayout toastView = (LinearLayout) mToast.getView();
		ImageView imageCodeProject = new ImageView(mContext);
		imageCodeProject.setImageResource(image);
		toastView.addView(imageCodeProject, 0);
		mToast.show();

	}

	public static void showToast(Context mContext, int resId, int duration) {
		showToast(mContext, mContext.getResources().getString(resId), duration);
	}
}
