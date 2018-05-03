package com.jerry.module.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

/**
 * Created with IntelliJ IDEA.
 * User: Jerry
 * Date: 2018/5/3
 * Time: 14:26
 * Description:
 */
public abstract class BaseFragment extends Fragment {

    private View mRootView;

    /**
     * 获取页面布局文件
     *
     * @return
     */
    public abstract int getLayoutResId();

    /**
     * 初始化
     *
     * @param savedInstanceState
     */
    public abstract void init(Bundle savedInstanceState);

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mRootView = inflater.inflate(getLayoutResId(), container, false);
        ButterKnife.bind(this, mRootView);
        init(savedInstanceState);
        return mRootView;
    }
}
