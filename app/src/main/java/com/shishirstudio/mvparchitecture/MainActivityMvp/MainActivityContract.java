package com.shishirstudio.mvparchitecture.MainActivityMvp;

/**
 * Created by Shishir on 02/06/2018.
 */

public interface MainActivityContract {

    interface MainView {
        void initiateViews();
        void showProgress();
        void hideProgress();
        void setUsernameError();
        void setPasswordError();
        void showValidateFinished();
    }

    interface Presenter {
        void validateCredentials(String username, String password);
        void onDestroy();
    }

    interface MainViewInterector {
        interface OnFinishedListener {
            void onUsernameError();
            void onPasswordError();
            void onSuccess();
        }
        void validate(String username, String password, OnFinishedListener listener);
    }
}
