package com.hpdeveloper.kotlinmvvm.adapters;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hpdeveloper.kotlinmvvm.BR;
import com.hpdeveloper.kotlinmvvm.R;
import com.hpdeveloper.rxkotlinmvvm.model.AndroidOS;

import java.util.ArrayList;
import java.util.List;

public class AndroidOSAdapter extends RecyclerView.Adapter<AndroidOSAdapter.ViewHolder> {

    private List<AndroidOS> mAndroidList = new ArrayList<>();

    public void updateData(List<AndroidOS> androidList) {
        mAndroidList = androidList;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.getBinding().setVariable(BR.AndroidOS, mAndroidList.get(position));
    }

    @Override
    public int getItemCount() {
        return mAndroidList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        private ViewDataBinding binding;

        private ViewHolder(View view) {
            super(view);
            binding = DataBindingUtil.bind(view);
        }

        private ViewDataBinding getBinding() {
            return binding;

        }
    }
}
