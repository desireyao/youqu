package com.youqu.ui.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.youqu.R;
import com.youqu.utils.StatusBarUtil;

/**
 *
 */
public abstract class BaseActivity extends AppCompatActivity {
    private static final String Tag = "BaseActivity";

    protected View contentView;
    protected BaseActivity mActivity;
    protected Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            mActivity = this;
            initData();
            contentView = LayoutInflater.from(this).inflate(bindLayout(), null);
            setContentView(contentView);
            setStatusBar();

            initView(savedInstanceState);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setActivityIsFullScreen() {
        this.getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
    }

    /**
     * 设置标题，返回icon，默认点击事件
     *
     * @param title
     * @return toolbar
     */
    protected void initTitle(String title) {
        mToolbar = (Toolbar) findViewById(R.id.include_toolbar);
        if (mToolbar != null) {
            TextView tv = (TextView) mToolbar.findViewById(R.id.include_toolbar_title);
            tv.setText(title);
//            mToolbar.setNavigationIcon(R.drawable.icon_toolbar_back);
            mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
//            mToolbar.setOnMenuItemClickListener(this);
        }
    }

    /**
     * 初始化数据
     */
    public abstract void initData();

    /**
     * 绑定布局
     *
     * @return 布局Id
     */
    public abstract int bindLayout();

    /**
     * 初始化view
     */
    public abstract void initView(Bundle savedInstanceState);

    protected void setStatusBar() {
        StatusBarUtil.setColor(this, getResources().getColor(R.color.colorPrimary));
    }
}
