package food.tianqu.com.goodfood.ui.fragment;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;
import org.json.JSONArray;
import org.json.JSONObject;
import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;
import java.io.File;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import food.tianqu.com.goodfood.BaseFragment;
import food.tianqu.com.goodfood.R;

/**
 * 资讯页面
 */
public class NewsFragment extends BaseFragment{

	private View view;

	private Context mContext;

	@Override
	public View getView(LayoutInflater inflater) {
		view = inflater.inflate(R.layout.fragment_news, null);
		return view;
	}

	@Override
	public void init() {
		mContext = getActivity();
	}

	public NewsFragment() {
		this.mContext = getActivity();
	}



}
