package com.snipex.shantu.androidarchitecturecomponentsdatabindingjava;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.snipex.shantu.androidarchitecturecomponentsdatabindingjava.databinding.ListEachRowPostBinding;
import com.snipex.shantu.androidarchitecturecomponentsdatabindingjava.model.Post;

import java.util.ArrayList;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.ViewHolder> {


    private LayoutInflater layoutInflater;
    private Context _context;
    private ArrayList<Post> postArrayList;

    public PostAdapter(Context _context, ArrayList<Post> postArrayList) {
        this._context = _context;
        this.postArrayList = postArrayList;
    }

    @NonNull
    @Override
    public PostAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(parent.getContext());
        }

        ListEachRowPostBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.list_each_row_post, parent, false);

        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull PostAdapter.ViewHolder viewHolder, int position) {

        Post post=postArrayList.get(position);
        viewHolder.binding.setPost(post);
    }

    @Override
    public int getItemCount() {
        return postArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ListEachRowPostBinding binding;

        public ViewHolder(ListEachRowPostBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
