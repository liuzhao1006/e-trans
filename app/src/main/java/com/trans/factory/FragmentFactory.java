package com.trans.factory;

import android.support.v4.util.SparseArrayCompat;

import com.trans.baselibrary.base.BaseFragment;
import com.trans.company.fragment.TransHomeFragment;
import com.trans.company.fragment.TransMeFragment;
import com.trans.company.fragment.TransSecurityFragment;
import com.trans.company.fragment.TransSuperviseFragment;

/**
 * 第三方:
 * 作者: 刘朝
 * 日期: 2017/10/14
 * 描述: fragment工厂
 */
public class FragmentFactory {

    static SparseArrayCompat<BaseFragment> map = new SparseArrayCompat<BaseFragment>();//

    public static BaseFragment getFragment(int position) {

        BaseFragment fragment = map.get(position);
        if (fragment == null) {
            switch (position) {
                case 0:
                    fragment = new TransHomeFragment();
                    break;
                case 1:
                    fragment = new TransSuperviseFragment();
                    break;
                case 2:
                    fragment = new TransSecurityFragment();
                    break;
                case 3:
                    fragment = new TransMeFragment();
                    break;
                default:
                    break;
            }
            map.put(position, fragment);
        }

        return fragment;
    }


    // 移除所有
    public static void removeAllFragment() {
        if (map != null && map.size() > 0) {
            map.clear();
        }
    }

    // 拿到列表
    public static SparseArrayCompat<BaseFragment> getTransFragment() {
        if (map != null && map.size() > 0) {
            return map;
        }

        return null;
    }
}
