package food.tianqu.com.goodfood.ui.view;
import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;

import food.tianqu.com.goodfood.R;
import food.tianqu.com.goodfood.listener.OnRvcClickListener;
import food.tianqu.com.goodfood.util.DensityUtil;

/**
 * TabBottonLayout.java
 * @author sunc<br/>
 * 模拟TAB 效果的layout
 */
public class TabBottonLayout extends LinearLayout implements OnClickListener {

	/**
	 * 控件单击实现
	 */
    private OnRvcClickListener mOnRvcClickListener;
  
	/**
	 * 点击事件中，每个点击的对象对应不同的fragment
	 */
	public LinearLayout lin1, lin2, lin3;
	
	/**
	 * 每个点击事件中分两部分，一个是图片和一个是文字
	 */
	private TextView tv0, tv1, tv2, tv3;

	public LinearLayout getLin1() {
		return lin1;
	}

	public void setLin1(LinearLayout lin1) {
		this.lin1 = lin1;
	}

	public LinearLayout getLin2() {
		return lin2;
	}

	public void setLin2(LinearLayout lin2) {
		this.lin2 = lin2;
	}

	public LinearLayout getLin3() {
		return lin3;
	}

	public void setLin3(LinearLayout lin3) {
		this.lin3 = lin3;
	}

	public static int WJGL = 100001;
    public static int WDYP = 100002;

	/** 
	 * 方法名：TabBottonLayout(Context context, AttributeSet attrs)
	 * 功能：TabBottonLayout构造方法，View初始化
	 * 参数：Context context -上下文, AttributeSet attrs -节点的属性集合
	 * 返回值：
	 * 参考：
	 */
    public TabBottonLayout(Context context, AttributeSet attrs, boolean message) {
        super(context, attrs);
        //自定义布局对象
        LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        setLayoutParams(params);
        setBackgroundColor(getResources().getColor(R.color.color_f8f8f8));
        setPadding(8, 8, 8, 8);
        //设置自定义布局
        LayoutParams paramsTv = new LayoutParams(LayoutParams.WRAP_CONTENT,
                LayoutParams.WRAP_CONTENT);
        paramsTv.setMargins(0, DensityUtil.px2dip(context, 19), 0, DensityUtil.px2dip(context, 24));
        LayoutParams paramsLin = new LayoutParams(LayoutParams.MATCH_PARENT,
                LayoutParams.WRAP_CONTENT, 1);
      //自定义控件
        LinearLayout lin1 = new LinearLayout(context);
        this.lin1 = lin1;
        lin1.setId(0);
        lin1.setLayoutParams(paramsLin);
        //设置横丨布局
        lin1.setOrientation(LinearLayout.VERTICAL);
        //设置重心
        lin1.setGravity(Gravity.CENTER_HORIZONTAL);
        tv1 = new TextView(context);
        tv1.setLayoutParams(paramsTv);
        tv1.setPadding(0, DensityUtil.px2dip(context, 19), 0, DensityUtil.px2dip(context, 24));
        tv1.setBackgroundResource(R.drawable.button_news_click);
        lin1.addView(tv1);
        //设置监听事件
        lin1.setOnClickListener(this);
        addView(lin1);
        //自定义控件
        LinearLayout lin2 = new LinearLayout(context);
        this.lin2 = lin2;
        lin2.setId(Integer.valueOf(1));
        lin2.setLayoutParams(paramsLin);
        //设置横丨布局
        lin2.setOrientation(LinearLayout.VERTICAL);
        //设置重心
        lin2.setGravity(Gravity.CENTER_HORIZONTAL);
        tv2 = new TextView(context);
        tv2.setLayoutParams(paramsTv);
        tv2.setPadding(0, DensityUtil.px2dip(context, 19), 0, DensityUtil.px2dip(context, 24));
        if(message){
            tv2.setBackgroundResource(R.drawable.button_hasmessage);
        }else{
            tv2.setBackgroundResource(R.drawable.button_message);
        }
        lin2.addView(tv2);
        //设置监听事件
        lin2.setOnClickListener(this);
        addView(lin2);
        //自定义控件
        LinearLayout lin3 = new LinearLayout(context);
        this.lin3 = lin3;
        lin3.setId(Integer.valueOf(2));
        lin3.setLayoutParams(paramsLin);
        //设置横丨布局
        lin3.setOrientation(LinearLayout.VERTICAL);
        //设置重心
        lin3.setGravity(Gravity.CENTER_HORIZONTAL);
        tv3 = new TextView(context);
        tv3.setLayoutParams(paramsTv);
        tv3.setPadding(0, DensityUtil.px2dip(context, 19), 0, DensityUtil.px2dip(context, 24));
        tv3.setBackgroundResource(R.drawable.button_mine);
        lin3.addView(tv3);
        //设置监听事件
        lin3.setOnClickListener(this);
        addView(lin3);
    }
    
    /** 
   	 * @实现OnClickListener接口回调方法
   	 * 方法名：onClick(View v)
   	 * 功能：触发mOnRvcClickListener接口onRvcClick方法,监听布局文件
   	 * 参数：View v -点击的View
   	 * 返回值：
   	 * 参考：
   	 */
    @Override
    public void onClick(View v) {
        if (mOnRvcClickListener != null) {
            v.setTag("bottomTab");
            mOnRvcClickListener.onRvcClick(v);
        }
        checkTab(v.getId());
    }

    /** 
   	 * 方法名：checkTab(int tabId)
   	 * 功能：监听布局文件
   	 * 参数：int tabId -Tab页的ID
   	 * 返回值：
   	 * 参考：
   	 */
    public void checkTab(int tabId) {
        changeImage(tabId);//出发点击事件后设置背景
    }

	public void setOnRvcClickListener(OnRvcClickListener mOnRvcClickListener) {
        this.mOnRvcClickListener = mOnRvcClickListener;
    }

	/** 
   	 * 方法名：changeImage(int tabId)
   	 * 功能：当点击TAB按钮时改变背景来模仿TAB效果
   	 * 参数：int tabId -Tab页的ID
   	 * 返回值：
   	 * 参考：
   	 */
    public void changeImage(int tabId) {
        switch (tabId) {
            case 0:
                tv1.setBackgroundResource(R.drawable.button_news_click);
                tv2.setBackgroundResource(R.drawable.button_message);
                tv3.setBackgroundResource(R.drawable.button_mine);
                break;
            case 1:
            	tv1.setBackgroundResource(R.drawable.button_news);
                tv2.setBackgroundResource(R.drawable.button_message_click);
                tv3.setBackgroundResource(R.drawable.button_mine);
                break;
            case 2:
            	tv1.setBackgroundResource(R.drawable.button_news);
                tv2.setBackgroundResource(R.drawable.button_message);
                tv3.setBackgroundResource(R.drawable.button_mine_click);
                break;
        }
    }
}
