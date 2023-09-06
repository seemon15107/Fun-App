package com.fun;

import java.io.FileOutputStream;

import android.app.Activity;
import android.app.AlertDialog;
import android.hardware.Camera;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageButton;



public class MainActivity extends Activity implements CameraCallback{
	private FrameLayout cameraholder = null;
	private CameraSurface camerasurface = null;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.camera);
        
        cameraholder = (FrameLayout)findViewById(R.id.camera_preview);
        
        setupPictureMode();
        
        ((ImageButton)findViewById(R.id.takepicture)).setOnClickListener(onButtonClick);
        ((ImageButton)findViewById(R.id.about)).setOnClickListener(onButtonClick);
    }
    
    private void setupPictureMode(){
    	camerasurface = new CameraSurface(this);
    	
    	cameraholder.addView(camerasurface, new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT));
    	
    	camerasurface.setCallback(this);
    }
    
	@Override
	public void onJpegPictureTaken(byte[] data, Camera camera) {
		try
		{
			FileOutputStream outStream = new FileOutputStream(String.format(
					"/sdcard/%d.jpg", System.currentTimeMillis()));
			
			outStream.write(data);
			outStream.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		camerasurface.startPreview();
	}

	@Override
	public void onPreviewFrame(byte[] data, Camera camera) {
	}

	@Override
	public void onRawPictureTaken(byte[] data, Camera camera) {
	}

	@Override
	public void onShutter() {
	}
	
	@Override
	public String onGetVideoFilename(){
		String filename = String.format("/sdcard/%d.3gp",System.currentTimeMillis());
		
		return filename;
	}
	
	private void displayAboutDialog()
	{
    	final AlertDialog.Builder builder = new AlertDialog.Builder(this);

    	builder.setTitle(getString(R.string.app_name));
    	builder.setMessage("Sample application to demonstrate the use of Camera in Android\n\nVisit www.krvarma.com for more information.");
    	
    	builder.show();
	}
	
	private View.OnClickListener onButtonClick = new View.OnClickListener() {
		@Override
		public void onClick(View v) {
			switch(v.getId())
			{
				case R.id.about:
				{
					displayAboutDialog();
					
					break;
				}
				case R.id.takepicture:
				{
					camerasurface.startTakePicture();
					
					break;
				}
			}
		}
	};
}