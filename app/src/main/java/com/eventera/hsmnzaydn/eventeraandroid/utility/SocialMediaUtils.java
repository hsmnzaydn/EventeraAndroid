package com.eventera.hsmnzaydn.eventeraandroid.utility;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.Uri;


/**
 * Created by hsmnzaydn on 18.10.2017.
 */

public class SocialMediaUtils {

    private Activity activity;

    public SocialMediaUtils(Activity activity) {
        this.activity = activity;
    }

    public void openTwitterApp(String accountAdress) {
        Uri uri = Uri.parse("http://www.twitter.com/" + accountAdress);
        Intent i = new Intent(Intent.ACTION_VIEW, uri);
        i.setPackage("com.twitter.android");
        try {
            activity.startActivity(i);
        } catch (Exception e) {

            activity.startActivity(new Intent(Intent.ACTION_VIEW,
                    Uri.parse("http://www.twitter.com/" + accountAdress)));
        }

    }


    public void openInstagramApp(String accountAdress) {
        Uri uri = Uri.parse("http://instagram.com/_u/" + accountAdress);


        Intent i = new Intent(Intent.ACTION_VIEW, uri);

        i.setPackage("com.instagram.android");

        try {
            activity.startActivity(i);
        } catch (Exception e) {

            activity.startActivity(new Intent(Intent.ACTION_VIEW,
                    Uri.parse("http://instagram.com/" + accountAdress)));
        }

    }


    public void openFacebookApp(String accountAdress) {
        activity.startActivity(newFacebookIntent(activity.getPackageManager(), "https://www.facebook.com/" + accountAdress));

    }

    public void openLinkendinApp(String accountAdress) {
        Uri uri = Uri.parse("http://www.linkedin.com/in/" + accountAdress);


        Intent i = new Intent(Intent.ACTION_VIEW, uri);

        i.setPackage("com.twitter.android");

        try {
            activity.startActivity(i);
        } catch (Exception e) {

            activity.startActivity(new Intent(Intent.ACTION_VIEW,
                    Uri.parse("http://www.linkedin.com/in/" + accountAdress)));
        }
    }


    /*public void openEmailApp(String mailAdress) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/html");
        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{mailAdress});
        activity.startActivity(Intent.createChooser(intent, activity.getString(R.string.utility_send_mail)));
    }
    */

    public Intent newFacebookIntent(PackageManager pm, String url) {
        Uri uri = Uri.parse(url);
        try {
            ApplicationInfo applicationInfo = pm.getApplicationInfo("com.facebook.katana", 0);
            if (applicationInfo.enabled) {

                uri = Uri.parse("fb://facewebmodal/f?href=" + url);
            }
        } catch (PackageManager.NameNotFoundException ignored) {
        }
        return new Intent(Intent.ACTION_VIEW, uri);
    }

    public void callPhone(String phoneNumber) {
        Uri call = Uri.parse("tel:" + phoneNumber);
        Intent surf = new Intent(Intent.ACTION_DIAL, call);
        activity.startActivity(surf);
    }

    public void openBrowser(String matchedText) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(matchedText));
        activity.startActivity(browserIntent);
    }

}



