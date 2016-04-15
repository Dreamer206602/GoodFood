package food.tianqu.com.goodfood.ui.fragment;
import android.view.LayoutInflater;
import android.view.View;
import food.tianqu.com.goodfood.BaseFragment;
import food.tianqu.com.goodfood.R;
import food.tianqu.com.goodfood.listener.OnRvcClickListener;

public class MineFragment extends BaseFragment implements OnRvcClickListener{

	private View view;


	@Override
	public void onRvcClick(View v) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public View getView(LayoutInflater inflater) {
		view = inflater.inflate(R.layout.fragment_mine, null);
		return view;
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
	}

	public MineFragment(){

	}
	
}
