package food.tianqu.com.goodfood.ui.fragment;
import android.app.ProgressDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import food.tianqu.com.goodfood.BaseFragment;
import food.tianqu.com.goodfood.R;
import food.tianqu.com.goodfood.listener.OnRvcClickListener;
import food.tianqu.com.goodfood.ui.view.TitleBarView;

public class MessageFragment extends BaseFragment implements OnRvcClickListener{


	private View view;

	/**
	 * 页面顶部TitleBar
	 */
	TitleBarView tbv;


	private Context mContext;

	private ProgressDialog progressDialog = null;

	@Override
	public void onRvcClick(View v) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public View getView(LayoutInflater inflater) {
		view = inflater.inflate(R.layout.fragment_msg, null);
		return view;
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
	}



	public MessageFragment() {
	}



}
