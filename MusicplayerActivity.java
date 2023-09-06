package com.fun;


import java.io.File;





import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MusicplayerActivity extends Activity {
	static StringBuffer path=null;
	
    public class songsintent implements OnClickListener {

		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			TextView temp=(TextView)findViewById(arg0.getId());
			path=new StringBuffer(temp.getText().toString());
			Toast.makeText(getApplicationContext(), path, 5).show();
		//	 Log.d("manish","zxczxczxc");
			Intent iit=new Intent(MusicplayerActivity.this,playsong.class);
		//iit.putExtra("path", temp.getText().toString());
			startActivity(iit);
			
		}

	}
	/** Called when the activity is first created. */
	
 void showname(File f)
	{
		
		
		
		File songs[]=f.listFiles();
    	
    	for(int i=0;i<songs.length;i++)
    	{
    		if(songs[i].isDirectory())
				showname(songs[i]);
    	 	else if(songs[i].getName().endsWith(".mp3"))
    		{
    		t=new TextView(MusicplayerActivity.this);
    		t.setText(songs[i].getAbsolutePath());
    		//String path=songs[i].getAbsolutePath();
    		t.setOnClickListener(new songsintent());
    		t.setId(1000+i);
    		t.setBackgroundColor(123456);
    	
    		ll1.addView(t);
    		}
    	}
    	


	}
	  TextView t;
	  LinearLayout ll1;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); 
        setContentView(R.layout.audio);
    
         ll1=(LinearLayout)findViewById(R.id.ll1);
      
     
        try{ 
        	String path="/sdcard";
        File f=new File(path);
        if(f.isDirectory())
        {
        	
        showname(f)	;
        	
        }
		
		}catch (Exception e) {
			// TODO: handle exception
		}
        
        
    }
}