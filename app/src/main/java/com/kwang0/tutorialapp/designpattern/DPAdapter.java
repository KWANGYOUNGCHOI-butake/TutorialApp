package com.kwang0.tutorialapp.designpattern;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.kwang0.tutorialapp.MainRVAdapter;
import com.kwang0.tutorialapp.R;
import com.kwang0.tutorialapp.designpattern.mvc.MvcActivity;
import com.kwang0.tutorialapp.designpattern.mvp.MvpActivity;
import com.kwang0.tutorialapp.designpattern.mvp.MvpPresenter;
import com.kwang0.tutorialapp.designpattern.mvvm.MvvmActivity;
import com.kwang0.tutorialapp.javaE.JavaEActivity;
import com.kwang0.tutorialapp.language.LanguageActivity;

import java.util.List;

public class DPAdapter extends RecyclerView.Adapter<DPAdapter.ViewHolder> {

    private Context mContext;
    private List<DPContents> mData;

    DPAdapter(Context mContext, List<DPContents> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View rootView;
        rootView = LayoutInflater.from(mContext).inflate(R.layout.activity_d_p_rv, parent, false);
        DPAdapter.ViewHolder vHolder = new ViewHolder(rootView);
        return vHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final String s = mData.get(position).s;
        holder.tv.setText(s);

        holder.tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(s.equals("MVC")) {
                    mContext.startActivity(new Intent(mContext, MvcActivity.class));
                } else if(s.equals("MVP")) {
                    mContext.startActivity(new Intent(mContext, MvpActivity.class));
                } else if(s.equals("MVVM")) {
                    mContext.startActivity(new Intent(mContext, MvvmActivity.class));
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tv;
        ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv = (TextView) itemView.findViewById(R.id.reuse_tv);
        }
    }
}
