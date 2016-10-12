package cn.xiaoyun.guide.moudles.main;

import android.annotation.TargetApi;
import android.os.Build;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;
import java.util.List;

import cn.xiaoyun.guide.R;
import cn.xiaoyun.guide.libs.base.BaseFragment;
import cn.xiaoyun.guide.libs.utils.FragmentAdapter;
import cn.xiaoyun.guide.moudles.main.fragment.InfoFragment;
import cn.xiaoyun.guide.moudles.main.fragment.WeightFragment;

public class MainActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private List<BaseFragment> list;
    private FragmentAdapter adapter;
    private RadioGroup radioGroup;
    private RadioButton rbOne;
    private RadioButton rbTwo;

    @TargetApi(Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup = (RadioGroup) findViewById(R.id.rg);
        rbOne = (RadioButton) findViewById(R.id.rb_one);
        rbTwo = (RadioButton) findViewById(R.id.rb_two);

        viewPager = (ViewPager) findViewById(R.id.view_pager);

        list = new ArrayList<>();
        list.add(new WeightFragment());
        list.add(new InfoFragment());
        adapter = new FragmentAdapter(getSupportFragmentManager(), list);
        viewPager.setAdapter(adapter);
        Log.i("tag", " rb 1= " + R.id.rb_one);
        Log.i("tag", " rb 2= " + R.id.rb_two);


        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                Log.i("tag", " i = " + i);

                switch (i) {
                    case R.id.rb_one:
                        viewPager.setCurrentItem(0);
                        break;
                    case R.id.rb_two:
                        viewPager.setCurrentItem(1);
                        break;
                }
            }
        });

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        rbOne.setChecked(true);
                        break;
                    case 1:
                        rbTwo.setChecked(true);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}
