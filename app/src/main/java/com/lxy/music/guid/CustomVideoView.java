package com.lxy.music.guid;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.Toast;
import android.widget.VideoView;

/**
 * 引导页 播放控件
 * Created by lxy on 2017/4/16.
 */

public class CustomVideoView extends VideoView {

    public CustomVideoView(Context context) {
        super(context);
    }

    public CustomVideoView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomVideoView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int widthSize = MeasureSpec.getSize(widthMeasureSpec);//测量宽高，一般情况下等于控件真是宽高，最终宽高在layout方法中确定
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);

        setMeasuredDimension(widthSize, heightSize);
    }

    /**
     * 开始播放
     *
     * @param uri 播放路径
     */
    public void startPlay(Uri uri) {
        if (uri == null) {
            Toast.makeText(this.getContext(), "播放路径不正确", Toast.LENGTH_SHORT).show();
            return;
        }

        setVideoURI(uri);
        start();

        setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                //设置循环播放
                mp.setLooping(true);
            }
        });

        setOnErrorListener(new MediaPlayer.OnErrorListener() {
            @Override
            public boolean onError(MediaPlayer mp, int what, int extra) {

                return true;
            }
        });

    }

}
