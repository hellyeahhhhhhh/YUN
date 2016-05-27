package com.kumakitty.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.kumakitty.yun.R;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by jesus on 2016/5/24.
 */
public class ItemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements View.OnClickListener {
    Context context;
    ArrayList<String> urls;
    RequestQueue mQueue;
    ImageLoader imageLoader = ImageLoader.getInstance();
    int bgc;
    private OnRecyclerViewItemClickListener mOnItemClickListener = null;

    DisplayImageOptions options = new DisplayImageOptions.Builder()
            .cacheInMemory(true)
            .cacheOnDisk(true)
            .build();

    public ItemAdapter(ArrayList<String> urls, Context context) {
        this.urls = urls;
        this.context = context;
    }




    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        StringBuffer url = new StringBuffer(urls.get(position)).append("?imageView2/2/w/200");
        StringBuffer urlave = new StringBuffer(urls.get(position)).append("?imageAve");
        View view = holder.itemView;
        ImageView item_iv = (ImageView) view.findViewById(R.id.item_iv);
        item_iv.setBackgroundResource(getAve(urlave.toString()));
        imageLoader.displayImage(url.toString(), item_iv, options);
        view.setTag(urls.get(position));
    }

    private int getAve(String url) {
        mQueue = Volley.newRequestQueue(context);
        StringRequest stringRequest = new StringRequest(url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("TAG", response);
                        try {
                            bgc = new JSONObject(response).getInt("RGB");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("TAG", error.getMessage(), error);
            }
        });
        mQueue.add(stringRequest);
        return bgc;
    }

    @Override
    public ItemAdapter.viewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        view.setOnClickListener(this);
        return new viewHolder(view);
    }


    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public int getItemCount() {
        return urls.size();
    }

    class viewHolder extends RecyclerView.ViewHolder {
        public viewHolder(View itemView) {
            super(itemView);
        }
    }

    public static interface OnRecyclerViewItemClickListener {
        void onItemClick(View view, String data);
    }

    public void setOnItemClickListener(OnRecyclerViewItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }
    @Override
    public void onClick(View v) {
        if (mOnItemClickListener != null) {
            mOnItemClickListener.onItemClick(v, v.getTag().toString());
        }
    }

    public void appendItems(ArrayList<String> addurl) {
        int count = getItemCount();
        urls.addAll(addurl);
        notifyItemRangeInserted(count, addurl.size());
    }

}
