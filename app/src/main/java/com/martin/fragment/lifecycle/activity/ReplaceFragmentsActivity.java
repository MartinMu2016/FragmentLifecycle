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
 * Package Name:com.martin.fragment.lifecycle
 * </p>
 * <p>
 * Class Name:ReplaceFragmentsActivity
 * <p>
 * Description:Replace方法
 * </p>
 *
 * @Author Martin
 * @Version 1.0 2018/11/12 10:27 AM Release
 * @Reviser:
 * @Modification Time:2018/11/12 10:27 AM
 */
public class ReplaceFragmentsActivity extends AppCompatActivity {

    Fragment currentFragment;
    Fragment1 fragment1 = new Fragment1();
    Fragment2 fragment2 = new Fragment2();

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
                        currentFragment = fragment1;
                        break;
                    case R.id.bottom_radio2:
                        ToastUtil.showToast(getApplicationContext(),"radio2");
                        currentFragment = fragment2;
                        break;
                }
                getSupportFragmentManager().beginTransaction()
                                           .replace(R.id.fl_main_content, currentFragment)
                                           .commit();
            }
        });
    }

}
