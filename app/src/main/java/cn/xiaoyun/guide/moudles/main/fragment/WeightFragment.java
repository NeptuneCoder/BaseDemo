package cn.xiaoyun.guide.moudles.main.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cn.xiaoyun.guide.R;
import cn.xiaoyun.guide.libs.base.BaseFragment;

/**
 * User: YangHai (1454025171@qq.com)
 * Date: 2016-10-12
 * Time: 22:55
 */
public class WeightFragment extends BaseFragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.frament_weight, null);
        return rootView;
    }
}
