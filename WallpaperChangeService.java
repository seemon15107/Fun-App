package com.fun;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.IBinder;

public class WallpaperChangeService extends Service implements Runnable{
	/* Store references to the wallpaper images in an array */
	private int wallpaperId[] = {R.drawable.wallpaper1,R.drawable.wallpaper2};
		
	/* Declare a variable to store the time selected by user */
	private int time;	

	/* Declare a flag to check which image to display next */
	private int FLAG=0;	

	private Thread t;

	/* Declare two bitmap objects to store the wallpaper images */
	private Bitmap bitmap;
		private Bitmap bitmap1;

	@Override
	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int onStartCommand(Intent intent, int flag,int startId)
	{
	super.onStartCommand(intent,flag ,startId);
	/* Obtain the bundle sent along with the intent sent from the activity */
	Bundle bundle=intent.getExtras();
	/* Obtain the value of the time key */
	time = bundle.getInt("time");

	/* Initialize the Bitmap objects with the wallpaper images */
	bitmap=BitmapFactory.decodeResource(getResources(),wallpaperId[0]);
	bitmap1=BitmapFactory.decodeResource(getResources(),wallpaperId[1]);

	/* Start a new thread to keep the service running in the background. */
	t = new Thread(WallpaperChangeService.this);
	t.start();
	return 0;
		}
	@Override
	public void onDestroy(){
	super.onDestroy();	
	System.exit(0);	
		}
	public void run() {
	// TODO Auto-generated method stub
	try {
		while(true){
	if(FLAG==0)	{			
		this.setWallpaper(bitmap);			
		FLAG++;				
		}
	else{	
		this.setWallpaper(bitmap1);
		FLAG--;
	}				
	Thread.sleep(1000*time);
	}
	} catch (Exception e){
		e.printStackTrace();
	}
				}

}
