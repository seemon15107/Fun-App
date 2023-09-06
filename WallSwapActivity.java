package com.fun;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.content.Intent;

import android.os.Bundle;

public class WallSwapActivity extends Activity {
    /** Called when the activity is first created. */
	private Button mSetButton;
	private Button mUnsetButton;
	private RadioButton mOneMinRadio;
	private RadioButton mFiveMinRadio;
	private RadioButton mTenMinRadio;
	private RadioButton mThirtyMinRadio;
	private RadioButton mOneHourRadio;
	private RadioGroup mTimeRadioGroup;
	public int mChangeTime = 60;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wall);
        mSetButton = (Button)findViewById(R.id.button1);
        mUnsetButton = (Button)findViewById(R.id.button2);
        mOneMinRadio = (RadioButton)findViewById(R.id.radio0);
        mFiveMinRadio = (RadioButton)findViewById(R.id.radio1);
        mTenMinRadio = (RadioButton)findViewById(R.id.radio2);
        mThirtyMinRadio = (RadioButton)findViewById(R.id.radio3);
        mOneHourRadio = (RadioButton)findViewById(R.id.radio4);
        mTimeRadioGroup = (RadioGroup)findViewById(R.id.radioGroup1);
        mUnsetButton.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0) {
            // TODO Auto-generated method stub
            Intent mDisableIntent = new Intent(WallSwapActivity.this, WallpaperChangeService.class);
            stopService(mDisableIntent);
            finish();
        }
        });

        mSetButton.setOnClickListener(new OnClickListener() {

        	public void onClick(View arg0) {
        	int mRadioID = mTimeRadioGroup.getCheckedRadioButtonId();
        	if(mOneMinRadio.getId()==mRadioID){mChangeTime=60;}
        	if(mFiveMinRadio.getId()==mRadioID){mChangeTime=5*60;}
        	if(mTenMinRadio.getId()==mRadioID){mChangeTime=10*60;}
        	if(mThirtyMinRadio.getId()==mRadioID){mChangeTime=30*60;}
        	if(mOneHourRadio.getId()==mRadioID){mChangeTime=60*60;}

        	/* Create an intent destined for the service */
        	Intent mServiceIntent = new Intent(WallSwapActivity.this, WallpaperChangeService.class);

        	/* Create a bundle and store in it a key-value pair specifying the time after which the wallpaper needs to be changed. */

        	Bundle mBundleTime = new Bundle();
        	mBundleTime.putInt("time", mChangeTime);

        	/* Attach the bundle to the intent */

        	mServiceIntent.putExtras(mBundleTime);

        	/* Start the service */
        	startService(mServiceIntent);

        	/* End the activity */
        	finish();
        	}
        	});
    }
}