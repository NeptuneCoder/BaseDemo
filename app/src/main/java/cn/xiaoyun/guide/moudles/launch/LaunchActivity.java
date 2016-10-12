package cn.xiaoyun.guide.moudles.launch;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import cn.xiaoyun.guide.moudles.login.LoginActivity;
import cn.xiaoyun.guide.moudles.main.MainActivity;
import cn.xiaoyun.guide.R;
import cn.xiaoyun.guide.libs.utils.ShareUtils;
import cn.xiaoyun.guide.moudles.guide.GuideActivity;

public class LaunchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);
        boolean isOpen = ShareUtils.getBoolean("isFirstOpen", true);
        if (isOpen) {
            //标记app已经不是第一次打开了.
            ShareUtils.saveBoolean("isFirstOpen", false);
            //TODO  进入到引导页里面去
            Intent intent = new Intent(this, GuideActivity.class);
            startActivity(intent);
        } else {
            //TODO  进入到主界面
            boolean isLogin = false;
            if (isLogin) {
                //TODO 进入主界面
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
            } else {
                //TODO 进入到登陆页面
                Intent intent = new Intent(this, LoginActivity.class);
                startActivity(intent);
            }
        }
        this.finish();
    }
}
