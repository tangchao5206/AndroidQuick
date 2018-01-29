package com.sdwfqin.quickseed.ui.home;

import android.content.Intent;
import android.os.Build;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.sdwfqin.quicklib.base.BaseFragment;
import com.sdwfqin.quicklib.module.WebViewActivity;
import com.sdwfqin.quicklib.module.qrbarscan.QrBarScanActivity;
import com.sdwfqin.quickseed.R;
import com.sdwfqin.quickseed.base.Constants;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 描述：首页
 *
 * @author 张钦
 * @date 2018/1/15
 */
public class HomeFragment extends BaseFragment {

    @BindView(R.id.status_view)
    View mStatusView;
    @BindView(R.id.home_msg)
    ImageView mHomeMsg;
    @BindView(R.id.home_title_tv)
    TextView mHomeTitleTv;

    @Override
    protected int getLayout() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initEventAndData() {

        if (Build.VERSION.SDK_INT < 19) {
            mStatusView.setVisibility(View.GONE);
        } else {
            mStatusView.getLayoutParams().height = Constants.STATUS_HEIGHT;
        }

        mHomeTitleTv.setText("首页");

    }

    @Override
    protected void lazyLoad() {

    }

    @OnClick({R.id.a, R.id.b})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.a:
                startActivity(WebViewActivity.newInstance(mContext, "https://www.baidu.com"));
                break;
            case R.id.b:
                startActivity(new Intent(mContext, QrBarScanActivity.class));
                break;
        }
    }
}
