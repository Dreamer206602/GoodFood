package food.tianqu.com.goodfood.ui.view;

import android.app.Dialog;
import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager.LayoutParams;
import android.widget.TextView;

import food.tianqu.com.goodfood.R;


/**
* @ClassName: LoadingDialog
* @Description: TODO(进度提示对话框)
*/
public class LoadingDialog extends Dialog {

	private Context mContext;
	private LayoutInflater inflater;
	private LayoutParams lp;
	private TextView loadtext;

	public LoadingDialog(Context context) {
		super(context, R.style.loading_dialog);
		this.mContext = context;
		
		inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View layout = inflater.inflate(R.layout.loading_dialog_ll, null);
		loadtext = (TextView) layout.findViewById(R.id.loading_text);
		setContentView(layout);
		
		// 设置window属性
		lp = getWindow().getAttributes();
		lp.gravity = Gravity.CENTER;
		lp.dimAmount = 0.5f; // 去背景遮盖
		lp.alpha = 1.0f;
		getWindow().setAttributes(lp);

	}

	public void setLoadText(String content){
		loadtext.setText(content);
	}
	
	public void setLoadText(int content){
		loadtext.setText(content);
	}
}
