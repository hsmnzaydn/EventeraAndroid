package com.eventera.hsmnzaydn.eventeraandroid.ui.RegisterActivity;

import android.content.res.ColorStateList;
import android.os.Bundle;
import android.support.v4.widget.ImageViewCompat;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.eventera.hsmnzaydn.eventeraandroid.R;
import com.eventera.hsmnzaydn.eventeraandroid.data.DataManager;
import com.eventera.hsmnzaydn.eventeraandroid.data.network.model.RegisterObject;
import com.eventera.hsmnzaydn.eventeraandroid.eventbus.RegisterObjectEvent;
import com.eventera.hsmnzaydn.eventeraandroid.ui.RegisterActivityStepTwo.RegisterActivityStepTwo;
import com.eventera.hsmnzaydn.eventeraandroid.ui.base.BaseActivity;
import com.eventera.hsmnzaydn.eventeraandroid.utility.Utils;

import org.greenrobot.eventbus.EventBus;

import javax.inject.Inject;

import butterknife.BindColor;
import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegisterActivity extends BaseActivity implements RegisterActivityMvpView {

    @Inject
    DataManager dataManager;

    @BindView(R.id.activity_register_female_button)
    Button femaleButton;

    @BindView(R.id.activity_register_male_button)
    Button maleButton;

    @BindColor(R.color.transparent)
    int transparentColor;
    @BindColor(R.color.colorPrimaryDark)
    int primaryDarkColor;

    @BindColor(R.color.black)
    int blackColor;
    @BindColor(R.color.white)
    int whiteColor;
    @BindColor(R.color.green)
    int greenColor;


    @BindView(R.id.activity_register_female_imageView)
    ImageView femaleImage;

    @BindView(R.id.activity_register_female_linear_layout)
    LinearLayout femaleLinearLayout;

    @BindView(R.id.activity_register_male_linear_layout)
    LinearLayout maleLinearLayout;

    @BindView(R.id.activity_register_male_imageView)
    ImageView maleImageView;


    @BindView(R.id.activity_register_email_edit_text)
    EditText emailEditText;
    @BindView(R.id.activity_register_job_edit_text)
    EditText jobEditText;
    @BindView(R.id.activity_register_adress_edit_text)
    EditText adressEditText;
    @BindView(R.id.activity_register_age_edit_text)
    EditText ageEditText;

    @BindView(R.id.activity_register_step_two_button)
    Button stepTwo;

    @BindColor(R.color.darker_grey)
    int darker_gray;

    @BindString(R.string.title_register)
    String title;

    private String sex="Female";

    RegisterActivityPresenter registerActivityPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        registerActivityPresenter = new RegisterActivityPresenter(this, dataManager);
        setTitle(title);
        Utils.openKeyboard(emailEditText, this);

        ageEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                stepTwo.setBackgroundColor(darker_gray);
                if (emailEditText.getText().toString() != null && jobEditText.getText().toString() != null && adressEditText.getText().toString() != null && ageEditText.getText().toString() != null) {
                    stepTwo.setBackgroundColor(greenColor);
                }
            }
        });
    }


    @OnClick(R.id.activity_register_female_button)
    public void clickToFemaleButton() {

        changeColorOfFemaleButton();
    }


    @OnClick(R.id.activity_register_male_button)
    public void clickToMaleButton() {

        changeColorOfMaleButton();
    }

    @OnClick(R.id.activity_register_female_imageView)
    public void clickToFemaleImage() {
        changeColorOfFemaleButton();

    }

    @OnClick(R.id.activity_register_male_imageView)
    public void clickToMaleImage() {
        changeColorOfMaleButton();
    }


    @OnClick(R.id.activity_register_step_two_button)
    public void clickToStepTwo() {

        registerActivityPresenter.register(emailEditText.getText().toString(), jobEditText.getText().toString(), adressEditText.getText().toString(), ageEditText.getText().toString(), sex.toUpperCase());
    }


    public void changeColorOfFemaleButton() {
        femaleLinearLayout.setBackgroundColor(primaryDarkColor);
        femaleButton.setBackgroundColor(primaryDarkColor);
        maleButton.setBackgroundColor(transparentColor);
        femaleButton.setTextColor(whiteColor);
        maleButton.setTextColor(blackColor);
        maleLinearLayout.setBackgroundColor(transparentColor);
        ImageViewCompat.setImageTintList(femaleImage, ColorStateList.valueOf(whiteColor));
        ImageViewCompat.setImageTintList(maleImageView, ColorStateList.valueOf(blackColor));
        sex = femaleButton.getText().toString();
    }

    public void changeColorOfMaleButton() {
        maleLinearLayout.setBackgroundColor(primaryDarkColor);
        femaleLinearLayout.setBackgroundColor(transparentColor);
        femaleButton.setBackgroundColor(transparentColor);
        femaleButton.setTextColor(blackColor);
        maleButton.setTextColor(whiteColor);
        ImageViewCompat.setImageTintList(maleImageView, ColorStateList.valueOf(whiteColor));
        ImageViewCompat.setImageTintList(femaleImage, ColorStateList.valueOf(blackColor));
        sex = maleButton.getText().toString();

    }

    @Override
    public void openRegisterStepTwo() {
        Utils.changeActivity(this, RegisterActivityStepTwo.class);
    }
}
