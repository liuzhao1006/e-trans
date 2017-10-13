package com.trans.company;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.Guideline;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.trans.R;
import com.trans.baselibrary.base.BaseActivity;
import com.trans.baselibrary.widget.NoScrollViewPager;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 企业端首页
 */
public class CompanyActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener{

    @BindView(R.id.home)
    RadioButton home;
    @BindView(R.id.supervise)
    RadioButton supervise;
    @BindView(R.id.security)
    RadioButton security;
    @BindView(R.id.me)
    RadioButton me;
    @BindView(R.id.mRadioGroup)
    RadioGroup mRadioGroup;
    @BindView(R.id.guideline)
    Guideline guideline;
    @BindView(R.id.mViewPager)
    NoScrollViewPager mViewPager;
    @BindView(R.id.company)
    ConstraintLayout company;

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.activity_company;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        ButterKnife.bind(this);
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(adapter);
        mRadioGroup.setOnCheckedChangeListener(this);
        mRadioGroup.check(R.id.home);
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        home.setChecked(true);
                        mRadioGroup.check(R.id.home);
                        break;
                    case 1:
                        supervise.setChecked(true);
                        mRadioGroup.check(R.id.supervise);
                        break;
                    case 2:
                        security.setChecked(true);
                        mRadioGroup.check(R.id.security);
                        break;
                    case 3:
                        me.setChecked(true);
                        mRadioGroup.check(R.id.me);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId){
            case R.id.home:
                mViewPager.setCurrentItem(0, false);
                break;
            case R.id.supervise:
                mViewPager.setCurrentItem(1, false);
                break;
            case R.id.security:
                mViewPager.setCurrentItem(2, false);
                break;
            case R.id.me:
                mViewPager.setCurrentItem(3, false);
                break;
            default:
                break;
        }
    }

   class ViewPagerAdapter extends FragmentPagerAdapter{

        private String[] mTables;
       public ViewPagerAdapter(FragmentManager fm) {
           super(fm);
           mTables = getResources().getStringArray(R.array.tab_company);
       }

       @Override
       public CharSequence getPageTitle(int position) {
           return mTables[position];
       }

       @Override
       public Fragment getItem(int position) {
           return null;
       }

       @Override
       public int getCount() {
           return mTables.length;
       }
   }
}
