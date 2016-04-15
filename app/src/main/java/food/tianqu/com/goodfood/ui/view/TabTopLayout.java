package food.tianqu.com.goodfood.ui.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import food.tianqu.com.goodfood.R;
import food.tianqu.com.goodfood.listener.OnRvcClickListener;


/**
 * TabTopLayout.java
 * 模拟TAB 效果的layout
 */
@SuppressLint("Recycle")
public class TabTopLayout extends LinearLayout implements OnClickListener {

    private OnRvcClickListener mOnRvcClickListener;

	/** 
	 * 方法名：TabTopLayout(Context context, AttributeSet attrs)
	 * 功能：TabTopLayout构造方法，View初始化
	 * 参数：Context context -上下文, AttributeSet attrs -节点的属性集合
	 * 返回值：
	 * 参考：
	 */
    public TabTopLayout(Context context, AttributeSet attrs) {
        super(context, attrs);

        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.action_top_tab);
        int tabId = a.getInteger(R.styleable.action_top_tab_setDefaultTabId, 0);
        int textId = a.getResourceId(R.styleable.action_top_tab_setTabText, 0);
        String text = getResources().getString(textId);
        System.out.println("text================"+text);
        String[] tabTexts = text.split(",");
        //设置布局对象
        LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        setLayoutParams(params);
        setBackgroundColor(getResources().getColor(R.color.color_3399cc));
        setPadding(4, 4, 4, 4);
        LayoutParams paramsTv = new LayoutParams(LayoutParams.WRAP_CONTENT,
                LayoutParams.WRAP_CONTENT);
        LayoutParams paramsIv = new LayoutParams(LayoutParams.MATCH_PARENT, 6);
        paramsIv.setMargins(30, 0, 30, 0);
        LayoutParams paramsIvLine = new LayoutParams(LayoutParams.WRAP_CONTENT,
                LayoutParams.MATCH_PARENT);
        paramsIvLine.setMargins(0, 20, 0, 20);
        LayoutParams paramsLin = new LayoutParams(LayoutParams.MATCH_PARENT,
                LayoutParams.WRAP_CONTENT, 1);

        int num = 0;
        for (int i = 0; i < tabTexts.length; i++) {
            String tabText = tabTexts[i];
            //自定义控件
            LinearLayout lin = new LinearLayout(context);
            lin.setId(i + num);
            lin.setLayoutParams(paramsLin);
            lin.setOrientation(LinearLayout.VERTICAL);
            lin.setGravity(Gravity.CENTER_HORIZONTAL);
            lin.setBackgroundResource(R.color.color_3399cc);
            TextView tv = new TextView(context);
            tv.setLayoutParams(paramsTv);
            tv.setPadding(0, 14, 0, 14);
            tv.setTextSize(16);
            tv.setText(tabText);
            tv.setTextColor(getResources().getColor(R.color.color_f8f8f8));
            ImageView iv = new ImageView(context);
            iv.setImageResource(R.drawable.shape_line_bg);
            iv.setLayoutParams(paramsIv);
            lin.addView(tv);
            //lin.addView(iv);
            lin.setOnClickListener(this);
            addView(lin);
            if (i < tabTexts.length - 1) {
                ImageView ivLine = new ImageView(context);
                ivLine.setId(i + num + 1);
                ivLine.setLayoutParams(paramsIvLine);
                ivLine.setBackgroundResource(R.drawable.bg_line_vertical);
                addView(ivLine);
            }
            num++;
        }
        checkTab(tabId);
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
        v.setTag("TopTab");
        if (mOnRvcClickListener != null) {
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
        for (int i = 0; i < getChildCount(); i++) {
            if (i % 2 != 0) {
                continue;
            }
            ViewGroup child = (ViewGroup) getChildAt(i);
            TextView tv = (TextView) child.getChildAt(0);
            if (child.getId() == tabId) {
                tv.setTextColor(getResources().getColor(R.color.color_f8f8f8));
            } else {
                tv.setTextColor(getResources().getColor(R.color.color_4eb6e6));
            }
        }
    }

    /** 
   	 * 方法名：setmOnRvcClickListener
   	 * 功能：设置OnRvcClickListener接口监听方法
   	 * 参数：OnRvcClickListener mOnRvcClickListener -回调接口
   	 * 返回值：
   	 * 参考：
   	 */
    public void setmOnRvcClickListener(OnRvcClickListener mOnRvcClickListener) {
        this.mOnRvcClickListener = mOnRvcClickListener;
    }
}
