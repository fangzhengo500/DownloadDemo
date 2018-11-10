package com.loosu.downloaddemo;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.loosu.downloaddemo.MyDownloadActivity;
import com.loosu.downloaddemo.QueueDownLoadActivity;
import com.loosu.downloaddemo.R;
import com.loosu.downloaddemo.SimpleDownloadActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_simple_download:
                jump2Activity(SimpleDownloadActivity.class);
                break;
            case R.id.btn_queue_download:
                jump2Activity(QueueDownLoadActivity.class);
                break;
            case R.id.btn_movie_download:
                jump2Activity(MyDownloadActivity.class);
                break;
        }
    }

    private void jump2Activity(Class<? extends Activity> clazz) {
        Intent intent = new Intent(this, clazz);
        startActivity(intent);
    }
}
