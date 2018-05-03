package com.jerry.module.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jerry.module.R;
import com.jerry.module.activity.base.BaseActivity;
import com.jerry.module.view.fragment.home.HomeFragment;
import com.jerry.module.view.fragment.home.MessageFragment;
import com.jerry.module.view.fragment.home.MineFragment;

import butterknife.BindView;
import butterknife.OnClick;

public class HomeActivity extends BaseActivity {

    @BindView(R.id.content_layout)
    RelativeLayout mContentLayout;
    @BindView(R.id.home_image_view)
    TextView mHomeView;
    @BindView(R.id.home_layout_view)
    RelativeLayout mHomeLayoutView;
    @BindView(R.id.fish_image_view)
    TextView mPondView;
    @BindView(R.id.pond_layout_view)
    RelativeLayout mPondLayoutView;
    @BindView(R.id.message_image_view)
    TextView mMessageView;
    @BindView(R.id.message_layout_view)
    RelativeLayout mMessageLayoutView;
    @BindView(R.id.mine_image_view)
    TextView mMineView;
    @BindView(R.id.mine_layout_view)
    RelativeLayout mMineLayoutView;
    @BindView(R.id.linearLayout)
    LinearLayout mLinearLayout;

    private Fragment mHomeFragment;
    private Fragment mMessageFragment;
    private Fragment mMineFragment;

    private FragmentManager mFragmentManager;


    @Override
    public int getContentViewResId() {
        return R.layout.activity_main;
    }

    @Override
    public void init(Bundle savedInstanceState) {
        // 添加默认显示的Fragment
        mHomeFragment = new HomeFragment();

        mFragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();

        // 这里replace相当于先remove掉所有的Fragment，然后再add进指定的Fragment
        fragmentTransaction.replace(R.id.content_layout, mHomeFragment);

        fragmentTransaction.commit();
    }

    @OnClick({R.id.home_layout_view, R.id.message_layout_view, R.id.mine_layout_view})
    public void onTabClick(View v) {
        FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();

        switch (v.getId()) {
            case R.id.home_layout_view:
                mHomeView.setBackgroundResource(R.drawable.comui_tab_home_selected);
                mPondView.setBackgroundResource(R.drawable.comui_tab_pond);
                mMessageView.setBackgroundResource(R.drawable.comui_tab_message);
                mMineView.setBackgroundResource(R.drawable.comui_tab_person);

                // 隐藏其他两个Fragment
                hideFragment(mMessageFragment, fragmentTransaction);
                hideFragment(mMineFragment, fragmentTransaction);

                // 将HomeFragment显示出来
                if (mHomeFragment == null) {
                    mHomeFragment = new HomeFragment();
                    fragmentTransaction.add(R.id.content_layout, mHomeFragment);
                } else {
                    fragmentTransaction.show(mHomeFragment);
                }
                break;
            case R.id.message_layout_view:
                mMessageView.setBackgroundResource(R.drawable.comui_tab_message_selected);
                mHomeView.setBackgroundResource(R.drawable.comui_tab_home);
                mPondView.setBackgroundResource(R.drawable.comui_tab_pond);
                mMineView.setBackgroundResource(R.drawable.comui_tab_person);

                // 隐藏其他两个Fragment
                hideFragment(mHomeFragment, fragmentTransaction);
                hideFragment(mMineFragment, fragmentTransaction);

                // 将MessageFragment显示出来
                if (mMessageFragment == null) {
                    mMessageFragment = new MessageFragment();
                    fragmentTransaction.add(R.id.content_layout, mMessageFragment);
                } else {
                    fragmentTransaction.show(mMessageFragment);
                }
                break;
            case R.id.mine_layout_view:
                mMineView.setBackgroundResource(R.drawable.comui_tab_person_selected);
                mHomeView.setBackgroundResource(R.drawable.comui_tab_home);
                mPondView.setBackgroundResource(R.drawable.comui_tab_pond);
                mMessageView.setBackgroundResource(R.drawable.comui_tab_message);

                // 隐藏其他两个Fragment
                hideFragment(mHomeFragment, fragmentTransaction);
                hideFragment(mMessageFragment, fragmentTransaction);

                // 将MineFragment显示出来
                if (mMineFragment == null) {
                    mMineFragment = new MineFragment();
                    fragmentTransaction.add(R.id.content_layout, mMineFragment);
                } else {
                    fragmentTransaction.show(mMineFragment);
                }
                break;
        }

        fragmentTransaction.commit();
    }

    /**
     * 隐藏具体的Fragment
     *
     * @param fragment
     * @param fragmentTransaction
     */
    private void hideFragment(Fragment fragment, FragmentTransaction fragmentTransaction) {
        if (fragment != null) {
            fragmentTransaction.hide(fragment);
        }
    }
}
