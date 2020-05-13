package com.kwang0.tutorialapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.kwang0.tutorialapp.designpattern.DPActivity;
import com.kwang0.tutorialapp.language.LanguageActivity;
import com.kwang0.tutorialapp.javaE.JavaEActivity;

import java.util.List;

public class MainRVAdapter extends RecyclerView.Adapter<MainRVAdapter.ViewHolder> {

    private Context mContext;
    private List<MainRVContents> mData;

    MainRVAdapter(Context mContext, List<MainRVContents> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View rootView;
        rootView = LayoutInflater.from(mContext).inflate(R.layout.activity_main_rv, parent, false);
        MainRVAdapter.ViewHolder vHolder = new ViewHolder(rootView);
        return vHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        final String s = mData.get(position).s;
        holder.tv.setText(s);

        holder.tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(s.equals("디자인 패턴")) {
                    mContext.startActivity(new Intent(mContext, DPActivity.class));
                } else if(s.equals("언어")) {
                    mContext.startActivity(new Intent(mContext, LanguageActivity.class));
                } else if(s.equals("자바8")) {
                    mContext.startActivity(new Intent(mContext, JavaEActivity.class));
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
