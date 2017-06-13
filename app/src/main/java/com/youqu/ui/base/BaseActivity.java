package com.youqu.ui.base;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.youqu.R;

/**
 * <pre>
 *     author: Blankj
 *     blog  : http://blankj.com
 *     time  : 2016/10/24
 *     desc  : Activity基类
 * </pre>
 */
public abstract class BaseActivity extends AppCompatActivity {

    private boolean isFullScreen = false;

    private boolean isSteepStatusBar = false;

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
            if (isFullScreen) {
                this.getWindow().setFlags(
                        WindowManager.LayoutParams.FLAG_FULLSCREEN,
                        WindowManager.LayoutParams.FLAG_FULLSCREEN);
                requestWindowFeature(Window.FEATURE_NO_TITLE);
            }
            if (isSteepStatusBar) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                    getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//                    getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
                }
            }
            setContentView(contentView);
            initView(savedInstanceState, contentView);
        } catch (Exception e) {
            e.printStackTrace();
        }
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
    public abstract void initView(Bundle savedInstanceState, final View view);

    /**
     * 设置是否全屏
     *
     * @param isFullScreen 是否全屏
     */
    public void setFullScreen(boolean isFullScreen) {
        this.isFullScreen = isFullScreen;
    }

    /**
     * 设置是否沉浸状态栏
     *
     * @param isSteepStatusBar 是否沉浸状态栏
     */
    public void setSteepStatusBar(boolean isSteepStatusBar) {
        this.isSteepStatusBar = isSteepStatusBar;
    }
}
