package com.shishirstudio.mvparchitecture.MainActivityMvp;

/**
 * Created by Shishir on 02/06/2018.
 */

public class MainAcitvityPresenterlmpl implements MainActivityContract.Presenter, MainActivityContract.MainViewInterector.OnFinishedListener {


    MainActivityContract.MainView view;
    MainActivityContract.MainViewInterector interector;

    public MainAcitvityPresenterlmpl(MainActivityContract.MainView view, MainActivityContract.MainViewInterector interector) {
        this.view = view;
        this.interector = interector;
    }

    @Override
    public void validateCredentials(String username, String password) {
        if (view != null) {
            view.showProgress();
            interector.validate(username, password, this);
        }

    }

    @Override
    public void onDestroy() {
        if (view != null) {
            view = null;
        }
    }

    @Override
    public void onUsernameError() {
        if (view != null) {
            view.setUsernameError();
            view.hideProgress();
        }
    }

    @Override
    public void onPasswordError() {
        if (view != null) {
            view.setPasswordError();
            view.hideProgress();
        }
    }

    @Override
    public void onSuccess() {
        if (view != null) {
            view.showValidateFinished();
            view.hideProgress();
        }
    }
}
