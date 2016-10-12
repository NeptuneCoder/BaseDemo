package cn.xiaoyun.guide.moudles.guide;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

import com.bigkoo.convenientbanner.CBPageAdapter;
import com.bigkoo.convenientbanner.CBViewHolderCreator;

import java.util.ArrayList;
import java.util.List;

import cn.xiaoyun.guide.libs.ui.XLConvenientBanner;
import cn.xiaoyun.guide.moudles.login.LoginActivity;
import cn.xiaoyun.guide.R;


public class GuideActivity extends AppCompatActivity {
    private XLConvenientBanner xlConvenientBanner;
    private List<Integer> guideImages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // 不显示程序的标题栏
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //不显示系统的标题栏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_guide);
        xlConvenientBanner = (XLConvenientBanner) findViewById(R.id.xl_convenient_banner);
        initView();
    }

    private void initView() {
        guideImages = new ArrayList<>();
        guideImages.add(R.mipmap.guide_one);
        guideImages.add(R.mipmap.guide_two);
        guideImages.add(R.mipmap.guide_three);
        guideImages.add(R.mipmap.guide_four);
        guideImages.add(R.mipmap.guide_five);
        xlConvenientBanner.setPages(
                new CBViewHolderCreator<LocalImageHolderView>() {
                    @Override
                    public LocalImageHolderView createHolder() {
                        return new LocalImageHolderView();
                    }
                }, guideImages);

    }

    private class LocalImageHolderView implements CBPageAdapter.Holder<Integer> {

        private ImageView imageView;
        private Button enterBtn;

        @Override
        public View createView(Context context) {
            View rootView = LayoutInflater.from(GuideActivity.this).inflate(R.layout.guide_fragment, null);
            imageView = (ImageView) rootView.findViewById(R.id.img_back);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            enterBtn = (Button) rootView.findViewById(R.id.btn_sure);
            return rootView;
        }

        @Override
        public void UpdateUI(Context context, int position, Integer data) {
            if (position == guideImages.size() - 1) {
                enterBtn.setVisibility(View.VISIBLE);
                enterBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        onClickEnter();
                    }
                });
            } else {
                enterBtn.setVisibility(View.GONE);
            }
            //TODO 这里有性能问题,需要修复
            imageView.setBackgroundResource(data);
        }
    }

    private void onClickEnter() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

}
