package food.tianqu.com.goodfood;
import android.app.Application;
import android.content.Context;


/**
 * BaseApplication.java
 * @author sunc<br/>
 * 系统组件Application
 */
public class BaseApplication extends Application {

    public  static boolean DEBUG = true;  // 开发环境为true

    private static BaseApplication mContext;

    /*
	 * 全局上下文
	 */
    public static Context getContext() {
        return mContext;
    }

    public static BaseApplication getInstance() {

        return mContext;

    }
    /**
	 * @覆盖父类实现onCreate()方法
	 * 方法名：onCreate()
	 * 功能：创建Application
	 * 参数：
	 * 返回值：
	 * 参考：@see android.app.Application#onCreate()
	 */
    @Override
    public void onCreate() {

        super.onCreate();
        mContext = this;
    }

}
