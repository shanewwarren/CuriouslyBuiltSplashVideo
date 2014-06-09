package com.curiouslybuilt.splashvideo.app;

import android.content.res.Resources;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerTitleStrip;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.VideoView;

public class MainActivity extends FragmentActivity {

    private VideoView mVideoView;
    private ViewPager mViewPager;
    private PagerTitleStrip mPagerTitleStrip;
    private Uri mVideoPath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mVideoView = (VideoView) findViewById(R.id.videoView);
        mVideoView.setOnPreparedListener(OnVideoViewPrepared);
        mVideoView.setOnErrorListener(OnVideoViewError);


        mViewPager = (ViewPager) findViewById(R.id.pager);
        Resources resources = getResources();
        final String[] messages = resources.getStringArray(R.array.splash_page_app_descriptions);

        CircularTextViewPagerAdapter adapter = new CircularTextViewPagerAdapter(getSupportFragmentManager(), messages);
        mViewPager.setAdapter(adapter);
        mViewPager.setCurrentItem(adapter.getFirstPage());
    mViewPager.setOffscreenPageLimit(3);

        //Bind the title indicator to the adapter
        CirclePageIndicator circlePageIndicator = (CirclePageIndicator)findViewById(R.id.titles);
        circlePageIndicator.setViewPager(mViewPager);
        circlePageIndicator.setSnap(true);


    }


    private MediaPlayer.OnErrorListener OnVideoViewError = new MediaPlayer.OnErrorListener() {
        @Override
        public boolean onError(MediaPlayer mediaPlayer, int what, int extra) {

            if (what == MediaPlayer.MEDIA_ERROR_UNKNOWN)
                Log.d("Debug", "MEDIA_ERROR_UNKNOWN");
            else if (what == MediaPlayer.MEDIA_ERROR_SERVER_DIED)
                Log.d("Debug", "MEDIA_ERROR_SERVER_DIED");

            if (extra == MediaPlayer.MEDIA_ERROR_IO)
                Log.d("Debug", "MEDIA_ERROR_IO");
            else if (extra == MediaPlayer.MEDIA_ERROR_MALFORMED)
                Log.d("Debug", "MEDIA_ERROR_MALFORMED");
            else if (extra == MediaPlayer.MEDIA_ERROR_NOT_VALID_FOR_PROGRESSIVE_PLAYBACK)
                Log.d("Debug", "MEDIA_ERROR_NOT_VALID_FOR_PROGRESSIVE_PLAYBACK");
            else if (extra == MediaPlayer.MEDIA_ERROR_TIMED_OUT)
                Log.d("Debug", "MEDIA_ERROR_TIMED_OUT");
            else if (extra == MediaPlayer.MEDIA_ERROR_UNSUPPORTED)
                Log.d("Debug", "MEDIA_ERROR_UNSUPPORTED");

            return false;
        }
    };

    private MediaPlayer.OnPreparedListener OnVideoViewPrepared = new MediaPlayer.OnPreparedListener() {
        @Override
        public void onPrepared(MediaPlayer mediaPlayer) {
            mediaPlayer.setLooping(true);
            mediaPlayer.setVideoScalingMode(MediaPlayer.VIDEO_SCALING_MODE_SCALE_TO_FIT_WITH_CROPPING);
        }
    };

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();

        String path = "android.resource://" + getPackageName() + "/" + R.raw.nature;
        mVideoView.setVideoURI(Uri.parse(path));
        mVideoView.start();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
