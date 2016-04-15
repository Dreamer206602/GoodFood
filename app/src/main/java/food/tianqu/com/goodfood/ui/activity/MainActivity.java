package food.tianqu.com.goodfood.ui.activity;

import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.widget.LinearLayout;

import java.util.ArrayList;

import food.tianqu.com.goodfood.AppManager;
import food.tianqu.com.goodfood.BaseActivity;
import food.tianqu.com.goodfood.R;
import food.tianqu.com.goodfood.adapter.MainFragmentAdapter;
import food.tianqu.com.goodfood.listener.OnRvcClickListener;
import food.tianqu.com.goodfood.ui.fragment.MessageFragment;
import food.tianqu.com.goodfood.ui.fragment.MineFragment;
import food.tianqu.com.goodfood.ui.fragment.NewsFragment;
import food.tianqu.com.goodfood.ui.view.HorizontalInnerViewPager;
import food.tianqu.com.goodfood.ui.view.TabBottonLayout;
import food.tianqu.com.goodfood.ui.view.TitleBarView;

public class MainActivity extends BaseActivity implements OnRvcClickListener,OnPageChangeListener {


	/**
	 * 上下文
	 */
	private Context mContext;
	
   /**
     * 页面底端布局View
    */
	private TabBottonLayout tb;

	/**
	 * 资讯
	 */
	public static Fragment newsFragment;
	
	/**
	 * 消息
	 */
	public static Fragment messageFragment;
	
	/**
	 * 我的
	 */
	public static Fragment mineFragment;

	/**
	 * Fragment的操作工具
	 */
	public static FragmentTransaction trasection;
	
   /**
    * 底部菜单栏
    */
    private LinearLayout layout;
 
   /**
    * application中的单例
    */
    private AppManager app;
 
   /**
    * 是否双击退出
    */
	private boolean isExit;
	
	/**
	 * ViewPager
	 */
    private HorizontalInnerViewPager mViewPager;
	
    /**
     * viewpaper List容器
     */
    private ArrayList<Fragment> fragmentList;
    
    /**
	 * 页面顶部TitleBar
	 */
	TitleBarView tbv;

	int count = 0;

	long firClick =  0;

	long secClick;
	@Override
	public void onRvcClick(View v) {
		String tag = (String) v.getTag();
        if ("bottomTab".equals(tag)) {
            mViewPager.setCurrentItem(v.getId());
			if(v.getId()==0){
				tbv.setVisibility(View.VISIBLE);
				initNewsTitleBar();
			}
			if(v.getId()==Integer.valueOf(1)){
				tbv.setVisibility(View.VISIBLE);
				initMsgTitleBar();
			}
			if(v.getId()==Integer.valueOf(2)){
				tbv.setVisibility(View.GONE);
			}
        }
	}
	@Override
	public void init(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		setContentView(R.layout.activity_main);
		mContext = this;
		mViewPager = (HorizontalInnerViewPager) findViewById(R.id.mViewPager);
		//底部菜单栏
		tb = new TabBottonLayout(this, null,true);
		
		tbv = (TitleBarView) findViewById(R.id.topbar);
		//把new的底部菜单栏假如到控件中显示出来
		layout = ((LinearLayout)findViewById(R.id.linear));
		layout.addView(tb);
		//为底部和顶部菜单栏设置监听
		tb.setOnRvcClickListener(this);
		InitViewPager();
		initNewsTitleBar();
	}
	
	/* 
     * 初始化ViewPager 
     */  
    private void InitViewPager(){
        fragmentList = new ArrayList<Fragment>();
        if (newsFragment == null)
        	newsFragment = new NewsFragment();
        if (messageFragment == null)
        	messageFragment = new MessageFragment();
        if (mineFragment == null)
        	mineFragment = new MineFragment();
        fragmentList.add(newsFragment);
        fragmentList.add(messageFragment);
        fragmentList.add(mineFragment);
        //给ViewPager设置适配器  
        mViewPager.setAdapter(new MainFragmentAdapter(getSupportFragmentManager(), fragmentList));
        
        mViewPager.setCurrentItem(0);
        
        mViewPager.setOffscreenPageLimit(3);
        
        mViewPager.setOnPageChangeListener(this);//页面变化时的监听器
    }

	private void initMsgTitleBar() {
		tbv.setTvCenterText(R.string.tab_message);
		tbv.setTitleBackgroundResource(R.color.color_FF0000);
		tbv.setImgRightOneResourceGone();
	}

    private void initNewsTitleBar() {
		tbv.setTvCenterText(R.string.tab_message);
		tbv.setTitleBackgroundResource(R.color.color_FF0000);
		tbv.setImgRightOneResourceGone();
	}

    @Override
	public void onPageScrollStateChanged(int arg0) {
		// TODO Auto-generated method stub

	}
	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {
		// TODO Auto-generated method stub

	}
	@Override
	public void onPageSelected(int arg0) {
		// TODO Auto-generated method stub
		tb.checkTab(arg0);
		if(arg0==0){
			tbv.setVisibility(View.VISIBLE);
			initNewsTitleBar();
		}
		if(arg0==Integer.valueOf(1)){
			tbv.setVisibility(View.VISIBLE);
			initMsgTitleBar();
		}
		if(arg0==Integer.valueOf(2)){
			tbv.setVisibility(View.GONE);
		}
	}

	@Override
	protected void onRestart(){
		super.onRestart();
	}
}
