package com.jerry.module.application;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Jerry
 * Date: 2018/5/3
 * Time: 14:37
 * Description:
 */
public class ActivityCollector {

    /**
     * 用来存放Activity的集合
     */
    private static final List<Activity> mActivities = new ArrayList<>();

    /**
     * 添加一个Activity到集合中
     *
     * @param activity
     */
    public static void addActivity(Activity activity) {
        mActivities.add(activity);
    }

    /**
     * 从集合中移除一个Activity
     *
     * @param activity
     */
    public static void removeActivity(Activity activity) {
        activity.finish();
        mActivities.remove(activity);
    }

    /**
     * 取得栈顶的Activity
     *
     * @return
     */
    public static Activity getTopActivity() {
        if (mActivities.isEmpty()) {
            return null;
        } else {
            return mActivities.get(mActivities.size() - 1);
        }
    }

    /**
     * 移除栈内所有Activity
     */
    public static void removeAllActivity() {
        for (Activity activity : mActivities) {
            activity.finish();
        }
        mActivities.clear();
    }
}
