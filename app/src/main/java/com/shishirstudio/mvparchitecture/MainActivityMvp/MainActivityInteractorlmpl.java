package com.shishirstudio.mvparchitecture.MainActivityMvp;

import android.os.Handler;
import android.text.TextUtils;

/**
 * Created by Shishir on 02/06/2018.
 */

public class MainActivityInteractorlmpl implements MainActivityContract.MainViewInterector {

    @Override
    public void validate(final String username, final String password, final OnFinishedListener listener) {

        // Mock Validate. I'm creating a handler to delay the answer a couple of seconds
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (TextUtils.isEmpty(username)) {
                    listener.onUsernameError();
                    return;
                }
                if (TextUtils.isEmpty(password)) {
                    listener.onPasswordError();
                    return;
                }
                listener.onSuccess();
            }
        }, 2000);
    }
}
