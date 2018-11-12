package com.martin.fragment.lifecycle;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.martin.fragment.lifecycle.fragment.Fragment1;
import com.martin.fragment.lifecycle.fragment.Fragment2;

public class MainActivity extends AppCompatActivity {

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
                        showToast("radio1");
                        replaceFragment("radio1");
                        break;
                    case R.id.bottom_radio2:
                        showToast("radio2");
                        replaceFragment("radio2");
                        break;
                }
            }
        });
    }

    private void replaceFragment(String tag) {
        if (currentFragment != null) {
            getSupportFragmentManager().beginTransaction().hide(currentFragment).commit();
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
            getSupportFragmentManager().beginTransaction().show(currentFragment).commit();
        }
    }

    public void showToast(String toast) {
        Toast.makeText(getApplicationContext(), toast, Toast.LENGTH_SHORT).show();
    }










}
