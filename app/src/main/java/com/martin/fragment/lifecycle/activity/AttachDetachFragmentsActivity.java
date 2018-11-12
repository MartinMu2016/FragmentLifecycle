package com.martin.fragment.lifecycle.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioGroup;

import com.martin.fragment.lifecycle.R;
import com.martin.fragment.lifecycle.ToastUtil;
import com.martin.fragment.lifecycle.fragment.Fragment1;
import com.martin.fragment.lifecycle.fragment.Fragment2;

/**
 * <p>
 * Package Name:com.martin.fragment.lifecycle.activity
 * </p>
 * <p>
 * Class Name:AttachDetachFragmtentsActivity
 * <p>
 * Description:add()-->detach()-->attach()
 * </p>
 *
 * @Author Martin
 * @Version 1.0 2018/11/12 11:03 AM Release
 * @Reviser: 
 * @Modification Time:2018/11/12 11:03 AM
 */
public class AttachDetachFragmentsActivity extends AppCompatActivity {


    Fragment currentFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.bottom);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.bottom_radio1:
                        ToastUtil.showToast(getApplicationContext(),"radio1");
                        replaceFragment("radio1");
                        break;
                    case R.id.bottom_radio2:
                        ToastUtil.showToast(getApplicationContext(),"radio2");
                        replaceFragment("radio2");
                        break;
                }
            }
        });
    }

    private void replaceFragment(String tag) {
        if (currentFragment != null) {
            getSupportFragmentManager().beginTransaction().detach(currentFragment).commit();
        }
        currentFragment = getSupportFragmentManager().findFragmentByTag(tag);
        if (currentFragment == null) {
            switch (tag) {
                case "radio1":
                    currentFragment = new Fragment1();
                    break;
                case "radio2":
                    currentFragment = new Fragment2();
                    break;
            }
            getSupportFragmentManager().beginTransaction().add(R.id.fl_main_content, currentFragment, tag).commit();
        }else {
            getSupportFragmentManager().beginTransaction().attach(currentFragment).commit();
        }
    }

}
