package com.youqu.ui.fragments;

import android.os.Bundle;
import android.view.View;

import com.youqu.R;
import com.youqu.ui.base.BaseFragment;

/**
 * <pre>
 *     author: Blankj
 *     blog  : http://blankj.com
 *     time  : 17/02/02
 *     desc  :
 * </pre>
 */
public class FragmentTwo extends BaseFragment {

    public static FragmentTwo newInstance() {
        Bundle args = new Bundle();
        FragmentTwo fragment = new FragmentTwo();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void initData() {

    }

    @Override
    public int bindLayout() {
        return R.layout.fragment_two;
    }

    @Override
    public void initView(Bundle savedInstanceState, View view) {

    }

}
