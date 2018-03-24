package com.eventera.hsmnzaydn.eventeraandroid.ui.RegisterActivityStepTwo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.eventera.hsmnzaydn.eventeraandroid.R;
import com.eventera.hsmnzaydn.eventeraandroid.di.DaggerApplication;

import butterknife.BindString;

public class RegisterActivityStepTwo extends AppCompatActivity {

    @BindString(R.string.title_register)
    String title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_step_two);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle(title);



    }
}
