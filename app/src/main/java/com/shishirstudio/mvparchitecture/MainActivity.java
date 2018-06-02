package com.shishirstudio.mvparchitecture;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.shishirstudio.mvparchitecture.MainActivityMvp.MainAcitvityPresenterlmpl;
import com.shishirstudio.mvparchitecture.MainActivityMvp.MainActivityContract;
import com.shishirstudio.mvparchitecture.MainActivityMvp.MainActivityInteractorlmpl;

public class MainActivity extends AppCompatActivity implements MainActivityContract.MainView, View.OnClickListener {

    ProgressDialog progressDialog;
    private EditText userNameEt;
    private EditText passwordEt;
    private Button validateButton;
    private MainActivityContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Validating...");
        progressDialog.setCancelable(false);
        presenter = new MainAcitvityPresenterlmpl(this, new MainActivityInteractorlmpl());
    }

    @Override
    public void initiateViews() {
        userNameEt = findViewById(R.id.userNameEt);
        passwordEt = findViewById(R.id.passwordEt);
        validateButton = findViewById(R.id.validateButton);
        validateButton.setOnClickListener(this);
    }

    @Override
    public void showProgress() {
        progressDialog.show();
    }

    @Override
    public void hideProgress() {
        progressDialog.dismiss();
    }

    @Override
    public void setUsernameError() {
        Toast.makeText(this, "Username is empty !", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setPasswordError() {
        Toast.makeText(this, "Password is empty !", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showValidateFinished() {
        Toast.makeText(this, "Validation Successful !", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View view) {
        presenter.validateCredentials(userNameEt.getText().toString(), passwordEt.getText().toString());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }
}
