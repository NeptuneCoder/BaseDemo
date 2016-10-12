package cn.xiaoyun.guide;

import android.app.Application;

import cn.xiaoyun.guide.libs.utils.ShareUtils;


/**
 * User: YangHai (1454025171@qq.com)
 * Date: 2016-10-12
 * Time: 21:24
 */
public class GuideApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        ShareUtils.init(this);
    }
}
