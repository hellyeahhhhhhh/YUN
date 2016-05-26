package com.kumakitty.yun;

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
    ArrayList<String> urlslarge;
    ArrayList<String> urlssmall;
    ArrayList<String> urlsave;
    RequestQueue mQueue;
    ImageLoader imageLoader=ImageLoader.getInstance();

    @Override
    public void onClick(View v) {
        if (mOnItemClickListener != null) {
            //注意这里使用getTag方法获取数据
            mOnItemClickListener.onItemClick(v,(String) v.getTag());
        }
    }

    int bgc;
    private OnRecyclerViewItemClickListener mOnItemClickListener = null;
    DisplayImageOptions options = new DisplayImageOptions.Builder()
            //.showImageOnLoading(R.drawable.ic_stub) // 设置图片下载期间显示的图片
            //.showImageForEmptyUri(R.drawable.ic_empty) // 设置图片Uri为空或是错误的时候显示的图片
            // .showImageOnFail(R.drawable.ic_error) // 设置图片加载或解码过程中发生错误显示的图片
            .cacheInMemory(true) // 设置下载的图片是否缓存在内存中
            .cacheOnDisk(true) // 设置下载的图片是否缓存在SD卡中
            //.displayer(new RoundedBitmapDisplayer(20)) // 设置成圆角图片
            .build(); // 构建完成


    public ItemAdapter(ArrayList<String> urlslarge,ArrayList<String> urlssmall, ArrayList<String> urlsave,Context context) {
        this.urlssmall = urlssmall;
        this.urlslarge = urlslarge;
        this.urlsave = urlsave;
        this.context = context;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        String urlsmall = urlssmall.get(position);
        String urlave = urlsave.get(position);
        String urllarge = urlslarge.get(position);
        View view = holder.itemView;
        ImageView item_iv = (ImageView) view.findViewById(R.id.item_iv);
        item_iv.setBackgroundResource(getAve(urlave));
        imageLoader.displayImage(urlsmall,item_iv,options);
        view.setTag(urllarge);
    }

    private int getAve(String urlsave) {
        mQueue = Volley.newRequestQueue(context);
        StringRequest stringRequest = new StringRequest(urlsave,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("TAG", response);
                        try {
                            bgc=new JSONObject(response).getInt("RGB");
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
        return urlsave.size();
    }

    class viewHolder extends RecyclerView.ViewHolder {
        public viewHolder(View itemView) {
            super(itemView);
        }
    }
    public static interface OnRecyclerViewItemClickListener {
        void onItemClick(View view , String data);
    }
    public void setOnItemClickListener(OnRecyclerViewItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }


}
