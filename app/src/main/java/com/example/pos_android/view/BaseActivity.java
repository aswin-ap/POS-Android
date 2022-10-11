package com.example.pos_android.view;


import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Window;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pos_android.R;

public class BaseActivity extends AppCompatActivity {

    private static final String TAG = BaseActivity.class.getSimpleName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

// This is for showing the progress
    public Dialog mLoadingDialog;

    public void showLoadingDialog(Context context) {
        mLoadingDialog = new Dialog(context);
        mLoadingDialog.setCancelable(false);
        mLoadingDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        mLoadingDialog.setContentView(R.layout.dialogue_loading_layout);
        mLoadingDialog.getWindow().setBackgroundDrawableResource(
                android.R.color.transparent);

        mLoadingDialog.show();

    }

    // This is for hiding the progress
    public void hideLoadingDialog() {
        if (mLoadingDialog != null && mLoadingDialog.isShowing()) {
            mLoadingDialog.cancel();
            mLoadingDialog.getWindow().closeAllPanels();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    protected void onPause() {
         super.onPause();
    }

}
