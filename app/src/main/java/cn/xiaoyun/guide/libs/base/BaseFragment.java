package cn.xiaoyun.guide.libs.base;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.view.View;

/**
 * Created by yh on 16/5/4.
 */
public class BaseFragment extends Fragment {
    protected View rootView;
    protected Activity mActivity;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.mActivity = activity;
    }


}
