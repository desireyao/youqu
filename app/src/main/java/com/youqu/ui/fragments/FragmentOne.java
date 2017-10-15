package com.youqu.ui.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.bumptech.glide.Glide;
import com.youqu.R;
import com.youqu.adapter.BaseRecyPRAdapter;
import com.youqu.network.NetworkManager;
import com.youqu.network.bean.Jokes;
import com.youqu.network.callback.BaseHttpCallback;
import com.youqu.network.model.CityInfo;
import com.youqu.ui.base.BaseFragment;
import com.youqu.utils.LogUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FragmentOne extends BaseFragment implements BaseRecyPRAdapter.LoadMoreDataListener {

    private static final String TAG = "FragmentOne";

    private int mPage = 1;
    private static final int SIZE = 20;

    private MyRecyViewAdapter mAdapter;
    private List<Jokes.Result.Data> mDataList = new ArrayList<>();

    @BindView(R.id.recyclerview)
    RecyclerView mRecyclerView;

    public static FragmentOne newInstance() {
        Bundle args = new Bundle();
        FragmentOne fragment = new FragmentOne();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void initData() {
        NetworkManager.get(getContext()).getJokes(new BaseHttpCallback<Jokes>() {
            @Override
            public void onSuccess(Jokes data) {
                LogUtils.json(TAG, data.toString());
                List<Jokes.Result.Data> list = data.getResult().getList();
                if (list != null && !list.isEmpty()) {
                    mDataList.addAll(list);
                }

                mAdapter.setData(mDataList);//设置数据
                mAdapter.notifyDataSetChanged();
            }
        }, mPage, SIZE);

    }

    @Override
    public int bindLayout() {
        return R.layout.fragment_one;
    }

    @Override
    public void initView(Bundle savedInstanceState, View view) {
        ButterKnife.bind(this, view);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(),
                LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mAdapter = new MyRecyViewAdapter(getContext(), mRecyclerView);
        mAdapter.setLoadMoreDataListener(this);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void loadMoreData() {
        mPage++;
        NetworkManager.get(getContext()).getJokes(new BaseHttpCallback<Jokes>() {
            @Override
            public void onSuccess(Jokes data) {
//                LogUtils.json(TAG, data.toString());
                if (data == null || data.getResult() == null) {
                    mAdapter.loadComplete();
                    return;
                }

                List<Jokes.Result.Data> list = data.getResult().getList();
                if (list != null && !list.isEmpty()) {
                    mDataList.addAll(list);
                    mAdapter.setData(mDataList);//设置数据
                    mAdapter.notifyDataSetChanged();
                    mAdapter.stopLoadMore();
                } else {
                    mAdapter.loadComplete();
                }
            }
        }, mPage, SIZE);
    }

    class MyRecyViewAdapter extends BaseRecyPRAdapter<Jokes.Result.Data> {

        public MyRecyViewAdapter(Context context, RecyclerView recyclerView) {
            super(context, recyclerView);
        }

        @Override
        public int getLayoutId(int type) {
            return R.layout.item_view;
        }

        @Override
        public void onBindData(BaseViewHolder holder, int position) {
            Log.e(TAG, "onBindData--->" + position);

            if (mDataList == null || mDataList.isEmpty())
                return;

//            TextView tvTitle = (TextView) holder.getView(R.id.tv_title);
//            if (tvTitle != null) {
//                tvTitle.setText(mDataList.get(position).getTitle());
//            }

            TextView tvContent = (TextView) holder.getView(R.id.tv_content);
            tvContent.setText(mDataList.get(position).getSubTitle());

            ImageView img = (ImageView) holder.getView(R.id.img);
            Glide.with(getContext())
                    .load(mDataList.get(position).getThumbnails())
                    .placeholder(R.drawable.img_placeholder)
                    .fitCenter()
                    .into(img);
        }
    }
}
