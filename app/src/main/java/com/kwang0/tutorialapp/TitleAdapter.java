package com.kwang0.tutorialapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.kwang0.tutorialapp.async.AsyncActivity;
import com.kwang0.tutorialapp.async.asynctask.AsyncTaskActivity;
import com.kwang0.tutorialapp.async.coroutines.CoroutinesActivity;
import com.kwang0.tutorialapp.async.rxJava.RxJavaActivity;
import com.kwang0.tutorialapp.designpattern.DPActivity;
import com.kwang0.tutorialapp.designpattern.mvc.MvcActivity;
import com.kwang0.tutorialapp.designpattern.mvp.MvpActivity;
import com.kwang0.tutorialapp.designpattern.mvvm.MvvmActivity;
import com.kwang0.tutorialapp.javaE.JavaEActivity;
import com.kwang0.tutorialapp.javaE.stream.StreamActivity;
import com.kwang0.tutorialapp.language.LanguageActivity;
import com.kwang0.tutorialapp.language.java.JavaActivity;
import com.kwang0.tutorialapp.language.kotlin.KotlinActivity;

import java.util.List;

public class TitleAdapter extends RecyclerView.Adapter<TitleAdapter.ViewHolder> {

    Context mContext;
    List<TitleModel> mData;

    public TitleAdapter(Context mContext, List<TitleModel> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public TitleAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View rootView;
        rootView = LayoutInflater.from(mContext).inflate(R.layout.reuse_layout, parent, false);
        TitleAdapter.ViewHolder vHolder = new ViewHolder(rootView);
        return vHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull TitleAdapter.ViewHolder holder, final int position) {
        final String s = mData.get(position).s;
        holder.tv.setText(s);

        holder.tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mContext instanceof MainActivity) {
                    switch (position) {
                        case 0:
                            mContext.startActivity(new Intent(mContext, DPActivity.class));
                            break;
                        case 1:
                            mContext.startActivity(new Intent(mContext, LanguageActivity.class));
                            break;
                        case 2:
                            mContext.startActivity(new Intent(mContext, JavaEActivity.class));
                            break;
                        case 3:
                            mContext.startActivity(new Intent(mContext, AsyncActivity.class));
                            break;

                    }
                } else if(mContext instanceof DPActivity) {
                    switch (position) {
                        case 0:
                            mContext.startActivity(new Intent(mContext, MvcActivity.class));
                            break;
                        case 1:
                            mContext.startActivity(new Intent(mContext, MvpActivity.class));
                            break;
                        case 2:
                            mContext.startActivity(new Intent(mContext, MvvmActivity.class));
                            break;

                    }
                } else if(mContext instanceof LanguageActivity) {
                    switch (position) {
                        case 0:
                            mContext.startActivity(new Intent(mContext, JavaActivity.class));
                            break;
                        case 1:
                            mContext.startActivity(new Intent(mContext, KotlinActivity.class));
                            break;
                    }
                } else if(mContext instanceof JavaEActivity) {
                    switch (position) {
                        case 0:
                            mContext.startActivity(new Intent(mContext, StreamActivity.class));
                            break;
                    }
                } else if(mContext instanceof AsyncActivity) {
                    switch (position) {
                        case 0:
                            mContext.startActivity(new Intent(mContext, AsyncTaskActivity.class));
                            break;
                        case 1:
                            mContext.startActivity(new Intent(mContext, RxJavaActivity.class));
                            break;
                        case 2:
                            mContext.startActivity(new Intent(mContext, CoroutinesActivity.class));
                            break;
                    }
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv;
        ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv = (TextView) itemView.findViewById(R.id.reuse_tv);
        }
    }
}
