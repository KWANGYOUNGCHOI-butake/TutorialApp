package com.kwang0.tutorialapp;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Optional;

public class ProgressDialog {
    private Context mContext;

    public ProgressDialog(Context mContext) {
        this.mContext = mContext;
        showProgressDialog(mContext);
    }

    private AlertDialog progress_dialog;
    private ProgressBar pb;
    private TextView tv;

    public AlertDialog getProgress_dialog() {
        return progress_dialog;
    }

    public void setProgress_dialog(AlertDialog progress_dialog) {
        this.progress_dialog = progress_dialog;
    }

    private void showProgressDialog(Context mContext) {
        View progressDialogView = ((LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.dialog_progress, null);
        AlertDialog.Builder progressDialogBuilder = new AlertDialog.Builder(progressDialogView.getContext());
        pb = (ProgressBar) progressDialogView.findViewById(R.id.progress_pb);
        tv = (TextView) progressDialogView.findViewById(R.id.progress_tv);
        progressDialogBuilder.setView(progressDialogView);
        progressDialogBuilder.setCancelable(false);
        progress_dialog = progressDialogBuilder.create();
    }

    public void openProgressDialog() {
//        if(progress_dialog.getWindow() != null){
//            progress_dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
//        }
        progress_dialog.show();
    }

    public void dismissProgressDialog() {
        if(progress_dialog != null) progress_dialog.dismiss();
    }

    public void setText(String s) {
        if(tv != null) tv.setText(s);
    }
}
