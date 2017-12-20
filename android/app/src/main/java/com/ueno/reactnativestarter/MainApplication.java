package com.ueno.reactnativestarter;

import android.app.Application;

import com.reactnativenavigation.NavigationApplication;
import com.microsoft.codepush.react.CodePush;
import com.lugg.ReactNativeConfig.ReactNativeConfigPackage;

import com.facebook.react.ReactApplication;
import io.invertase.firebase.RNFirebasePackage;
import io.invertase.firebase.analytics.RNFirebaseAnalyticsPackage;
import io.sentry.RNSentryPackage;
import com.facebook.react.ReactNativeHost;
import com.facebook.react.ReactPackage;
import com.facebook.react.shell.MainReactPackage;
import com.facebook.soloader.SoLoader;

import java.util.Arrays;
import java.util.List;

public class MainApplication extends NavigationApplication {

    @Override
    public boolean isDebug() {
        return BuildConfig.DEBUG;
    }

    protected List<ReactPackage> getPackages() {
        return Arrays.<ReactPackage>asList(
          new CodePush(BuildConfig.CODE_PUSH_DEPLOYMENT_KEY_ANDROID, MainApplication.this, BuildConfig.DEBUG),
          new ReactNativeConfigPackage(),
          new RNSentryPackage(MainApplication.this),
          new RNFirebasePackage(),
          new RNFirebaseAnalyticsPackage()
        );
    }

    @Override
    public List<ReactPackage> createAdditionalReactPackages() {
        return getPackages();
    }
}