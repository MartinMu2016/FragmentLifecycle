package com.martin.fragment.lifecycle;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.martin.fragment.lifecycle.activity.AttachDetachFragmentsActivity;
import com.martin.fragment.lifecycle.activity.ReplaceFragmentsActivity;
import com.martin.fragment.lifecycle.activity.ShowHideFragmentsActivity;

/**
 * <p>
 * Package Name:com.martin.fragment.lifecycle
 * </p>
 * <p>
 * Class Name:MainActivity
 * <p>
 * Description:API Activity entrance
 * </p>
 *
 * @Author Martin
 * @Version 1.0 2018/11/12 10:35 AM Release
 * @Reviser:
 * @Modification Time:2018/11/12 10:35 AM
 */
public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void replace(View view) {
        startActivity(new Intent(this,ReplaceFragmentsActivity.class));
    }

    public void attach_detach(View view) {
        startActivity(new Intent(this,AttachDetachFragmentsActivity.class));
    }

    public void add_hide(View view) {
        startActivity(new Intent(this,ShowHideFragmentsActivity.class));
    }

}
