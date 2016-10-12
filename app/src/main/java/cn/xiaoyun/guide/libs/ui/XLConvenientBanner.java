package cn.xiaoyun.guide.libs.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

import com.bigkoo.convenientbanner.ConvenientBanner;

import cn.xiaoyun.guide.libs.utils.DisplayUtil;


/**
 * Created by zhangll on 16/4/1.
 */
public class XLConvenientBanner extends ConvenientBanner {

    private int defaultX = -999;

    private int downX = defaultX;
    private int currentX;

    public XLConvenientBanner(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                downX = (int) ev.getX();
                break;
            case MotionEvent.ACTION_MOVE:
                currentX = (int) ev.getX();
                break;
            case MotionEvent.ACTION_CANCEL:
            case MotionEvent.ACTION_UP:
                downX = defaultX;
                break;
        }
        return super.dispatchTouchEvent(ev);
    }

    public boolean isGrabbed() {
        return downX != defaultX && Math.abs(downX - currentX) > DisplayUtil.dip2px(getContext(), 1);
    }
}