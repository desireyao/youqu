package com.youqu.ui.base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.youqu.R;
import com.youqu.utils.ViewUtil;

/**
 * <pre>
 *     author: Blankj
 *     blog  : http://blankj.com
 *     time  : 2017/03/28
 *     desc  : Fragment－v4基类
 * </pre>
 */
public abstract class BaseFragment extends Fragment {

    private static final String TAG = "BaseFragment";

    private static final String STATE_SAVE_IS_HIDDEN = "STATE_SAVE_IS_HIDDEN";

    protected View mView;
    protected Toolbar mToolbar;

    protected BaseActivity mActivity;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: ");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setRetainInstance(true);
        mView = inflater.inflate(bindLayout(), null);
        Log.d(TAG, "onCreateView--->");
        return mView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initData();
        initView(savedInstanceState, mView);
        Log.d(TAG, "onViewCreated: ");
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d(TAG, "onActivityCreated: ");
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mActivity = (BaseActivity) getActivity();
        Log.d(TAG, "onAttach: ");
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
     * 设置标题，返回icon，默认点击事件
     *
     * @param title
     * @return toolbar
     */
    protected void initTitle(String title, boolean isShowBack, View.OnClickListener listener) {
        mToolbar = (Toolbar) mView.findViewById(R.id.include_toolbar);
        if (mToolbar != null) {
            mActivity.setSupportActionBar(mToolbar);
            mActivity.getSupportActionBar().setDisplayHomeAsUpEnabled(isShowBack);
            mActivity.getSupportActionBar().setDisplayShowTitleEnabled(false);

            if (isShowBack) {
                if (listener != null) {
                    mToolbar.setNavigationOnClickListener(listener);
                } else {
                    mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            mActivity.finish();
                        }
                    });
                }
            }
            TextView tv = (TextView) mToolbar.findViewById(R.id.include_toolbar_title);
            tv.setText(title);
        }

        mToolbar.setPadding(0,ViewUtil.dp2px(getContext(),16), 0, 0);
    }


    @Override
    public void onDestroyView() {
        if (mView != null) {
            ((ViewGroup) mView.getParent()).removeView(mView);
        }
        super.onDestroyView();
        Log.d(TAG, "onDestroyView: ");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean(STATE_SAVE_IS_HIDDEN, isHidden());
    }
}
