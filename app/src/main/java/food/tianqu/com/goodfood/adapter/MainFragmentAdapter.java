package food.tianqu.com.goodfood.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class MainFragmentAdapter extends FragmentPagerAdapter {
	ArrayList<Fragment> list;
    public MainFragmentAdapter(FragmentManager fm, ArrayList<Fragment> list) {
        super(fm);  
        this.list = list;  
          
    }  
      
      
    @Override  
    public int getCount() {  
        return list.size();  
    }  
      
    @Override  
    public Fragment getItem(int arg0) {
        return list.get(arg0);  
    }  
}
