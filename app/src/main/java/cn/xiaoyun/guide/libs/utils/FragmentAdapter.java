package cn.xiaoyun.guide.libs.utils;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

import cn.xiaoyun.guide.libs.base.BaseFragment;


/**
 * Created by yh on 16/5/4.
 */
public class FragmentAdapter extends FragmentPagerAdapter {
    private final List<BaseFragment> fragmentList;

    private final String TAG = FragmentAdapter.this.getClass().getSimpleName();

    public FragmentAdapter(FragmentManager fm, List<BaseFragment> fragmentList) {
        super(fm);
        this.fragmentList = fragmentList;
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }


    @Override
    public int getCount() {
        return fragmentList.size();
    }
}
