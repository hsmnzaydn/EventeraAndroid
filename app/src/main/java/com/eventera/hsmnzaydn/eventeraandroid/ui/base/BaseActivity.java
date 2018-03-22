package com.eventera.hsmnzaydn.eventeraandroid.ui.base;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;


import com.eventera.hsmnzaydn.eventeraandroid.eventbus.EventB;
import com.eventera.hsmnzaydn.eventeraandroid.ui.DialogPopup.PopupFragment;
import com.eventera.hsmnzaydn.eventeraandroid.utility.Utils;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;


/**
 * Created by hsmnzaydn on 12.01.2018.
 */

public class BaseActivity extends AppCompatActivity implements MvpView,BaseFragment.Callback {
    private ProgressDialog progressDialog;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public void onFragmentAttached() {

    }

    @Override
    public void onFragmentDetached(String tag) {

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }
    @Subscribe
    public void getMessageEvent(EventB messageOTPEvent) {

    }


    @Override
    public void showLoading() {
        progressDialog = Utils.showLoadingDialog(this);
    }

    @Override
    public void dissmisLoading() {
        progressDialog.dismiss();
    }

    @Override
    public void showMessageToast(String text) {
        Toast.makeText(this,text,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showError(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showMessageDialog(String text) {
        PopupFragment.newInstance().show(getSupportFragmentManager(),1,1);

    }

    @Override
    public void killActivity() {
        this.finish();
    }
}
