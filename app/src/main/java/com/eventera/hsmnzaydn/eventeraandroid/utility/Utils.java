package com.eventera.hsmnzaydn.eventeraandroid.utility;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.eventera.hsmnzaydn.eventeraandroid.R;
import com.eventera.hsmnzaydn.eventeraandroid.data.network.model.CommonResponse;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.gson.Gson;

import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import retrofit2.Response;


/**
 * Created by hsmnzaydn on 05.01.2018.
 */

public class Utils {


    public static String getCurrentLanguage(){

        return Locale.getDefault().getLanguage();
    }

    public static void setCurrentLanguage(Activity activity,String languageCode){
        Locale locale = null;
        languageCode=languageCode.toLowerCase();
        if(languageCode.equals("tr")){
                locale= new Locale("tr","TR");
        }
       else{
            locale= new Locale("en_US");

        }

        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        activity.getBaseContext().getResources().updateConfiguration(config,
                activity.getBaseContext().getResources().getDisplayMetrics());
    }

    public static ProgressDialog showLoadingDialog(Context context) {
        ProgressDialog progressDialog = new ProgressDialog(context);
        progressDialog.show();
        if (progressDialog.getWindow() != null) {
            progressDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        }
        progressDialog.setContentView(R.layout.progress_dialog);
        progressDialog.setIndeterminate(true);
        progressDialog.setCancelable(false);
        progressDialog.setCanceledOnTouchOutside(false);
        return progressDialog;
    }

    public static void changeActivity(Activity activity,Class<?> goClass){
        Intent intent=new Intent(activity,goClass);
        activity.startActivity(intent);
    }

    public static String getUdid(Context activity) {
        String udid = Settings.Secure.getString(activity.getContentResolver(),
                Settings.Secure.ANDROID_ID);

        return udid;
    }

    public static String getAppVersion(Context context) {
        PackageManager manager = context.getPackageManager();
        try {
            PackageInfo info = manager.getPackageInfo(context.getPackageName(), 0);
            return String.valueOf(info.versionCode);

        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static String getPnsToken(Context context){
        return FirebaseInstanceId.getInstance().getToken();
    }

    public static String getVersionOfApp(){
       return String.valueOf(Build.VERSION.SDK_INT);
    }



    public static void shareToOtherPlartforms(Activity activity,String title,String text){
        Intent shareIntent = new Intent();
        shareIntent.setAction(Intent.ACTION_SEND);
        shareIntent.putExtra(Intent.EXTRA_SUBJECT, title);
        shareIntent.putExtra(Intent.EXTRA_TEXT, text);
        shareIntent.setType("text/plain");
        shareIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        activity.startActivity(Intent.createChooser(shareIntent, title));
    }
    public static void openLink(Activity activity,String link) {
        activity.finish();
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(link));
        activity.startActivity(myIntent);
    }

    public static String longToddMMMyyyy(long date) {
        String dateString = new SimpleDateFormat("dd MMM yyyy").format(new Date(date));
        return dateString;
    }

    public static String longTohhmm(long date) {
        String dateString = new SimpleDateFormat("HH:mm").format(new Date(date));
        return dateString;
    }

    public static String longToddMMyyyy(long date) {
        String dateString = new SimpleDateFormat("dd/MM/yyyy").format(new Date(date));
        return dateString;
    }

    public static String longTodd(long date) {
        String dateString = new SimpleDateFormat("dd").format(new Date(date));
        return dateString;
    }

    public static String longToMMM(long date) {
        String dateString = new SimpleDateFormat("MMM").format(new Date(date));
        return dateString;
    }

    public static void showEmptyTextView(Activity activity, List<?> list,String text){

        if(list == null || list.size() == 0){
            TextView tv1 = new TextView(activity);
            tv1.setText(text);
            tv1.setGravity(Gravity.CENTER);
            tv1.setTextColor(activity.getResources().getColor(R.color.red));
            tv1.setTextSize(20);

            LinearLayout ll = new LinearLayout(activity);
            ll.setOrientation(LinearLayout.VERTICAL);
            ll.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.FILL_PARENT));
            ll.setGravity(Gravity.CENTER);
            ll.addView(tv1);

            activity.setContentView(ll);
        }

    }



    public static CommonResponse errorHandler(Response<?> response){
        CommonResponse errorResponse = null;
        try {
            Gson gson = new Gson();
             errorResponse= gson.fromJson(response.errorBody().string(), CommonResponse.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return errorResponse;

    }

    public static boolean checkInternet(Activity activity) {
        ConnectivityManager cm =
                (ConnectivityManager) activity.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        return netInfo != null && netInfo.isConnectedOrConnecting();
    }



    //Get url image
    public static void getImage(Activity activity, String imageUrl, final ImageView imageView, final Integer placeHolder){
        if(placeHolder != null){
            Picasso.with(activity).load(Constant.BASE_URL+imageUrl).fit().centerCrop().placeholder(placeHolder).error(placeHolder).into(imageView);
        }
        else {
            Picasso.with(activity).load(Constant.BASE_URL+imageUrl).fit().centerCrop().placeholder(R.drawable.action_loading_image).error(placeHolder).into(imageView);
        }
    }





}
