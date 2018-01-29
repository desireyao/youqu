package com.youqu.ui.base;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.readystatesoftware.systembartint.SystemBarTintManager;
import com.youqu.R;
import com.youqu.utils.StatusBarUtil;
import com.youqu.utils.ViewUtil;

/**
 *
 */
public abstract class BaseActivity extends AppCompatActivity {
    public static String TAG = "";

    protected View contentView;
    protected BaseActivity mActivity;
    protected Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TAG = this.getClass().getSimpleName();

        mActivity = this;
        initWindow();
        contentView = LayoutInflater.from(this).inflate(bindLayout(), null);
        setContentView(contentView);

        initData();
        initView(savedInstanceState);
    }

    public void setTransParentBarMode() {
        Window mWindow = getWindow();
        mWindow.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        SystemBarTintManager mTintManager = new SystemBarTintManager(this);
        mTintManager.setStatusBarTintColor(Color.TRANSPARENT);
        mTintManager.setStatusBarTintEnabled(true);
    }

    /**
     * 设置标题，返回icon，默认点击事件
     *
     * @param title
     * @return toolbar
     */
    protected void initTitle(String title,boolean isShowBackIcon) {
        mToolbar =  findViewById(R.id.include_toolbar);
        if (mToolbar != null) {
            setSupportActionBar(mToolbar);
            getSupportActionBar().setDisplayHomeAsUpEnabled(isShowBackIcon);
            getSupportActionBar().setDisplayShowTitleEnabled(false);
            TextView tv = mToolbar.findViewById(R.id.include_toolbar_title);
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

//        mToolbar.setPadding(0, ViewUtil.getStatusBarHeight(this),0,0);
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

    public void initWindow() {

    }

    protected void setStatusBar() {
        StatusBarUtil.setColor(this, getResources().getColor(R.color.colorPrimary));
    }
}
