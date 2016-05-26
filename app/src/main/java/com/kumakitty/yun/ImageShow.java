package com.kumakitty.yun;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

public class ImageShow extends AppCompatActivity {
    ImageView iv;
    ImageLoader imageLoader=ImageLoader.getInstance();
    DisplayImageOptions options = new DisplayImageOptions.Builder()
            //.showImageOnLoading(R.drawable.ic_stub) // 设置图片下载期间显示的图片
            //.showImageForEmptyUri(R.drawable.ic_empty) // 设置图片Uri为空或是错误的时候显示的图片
            // .showImageOnFail(R.drawable.ic_error) // 设置图片加载或解码过程中发生错误显示的图片
            .cacheInMemory(true) // 设置下载的图片是否缓存在内存中
            .cacheOnDisk(true) // 设置下载的图片是否缓存在SD卡中
            //.displayer(new RoundedBitmapDisplayer(20)) // 设置成圆角图片
            .build(); // 构建完成


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_show);
        Intent intent=getIntent();
        iv= (ImageView) findViewById(R.id.imageiv);
        showImage(intent.getStringExtra("url"));
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    private void showImage(String  url){
        imageLoader.displayImage(url,iv,options);
       // PicassoLoader.createLoader(iv, urllarge[position]).attach();
    }

}
