package com.fun;




import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;
import android.widget.SeekBar.OnSeekBarChangeListener;

public class playsong extends Activity {
	
	
	
	
	
	
	
    public class songstartstop implements OnClickListener {

		public void onClick(View arg0) {
			// TODO Auto-generated method stub

			
			if(ssbtsatus)
			{
				v.pause();
				v.seekTo(0);
			//	v.destroyDrawingCache();
			//	v.stopPlayback();
				sk.setProgress(0);
				ssbtsatus=false;
				prbt.setEnabled(false);
				prbt.setText("Pause");
				ssbt.setText("Start");
			//	 Toast.makeText(MultimediaActivity.this,finalpos+"", 5).show();
				
			}
			
			else
			{   //v.resume();
				v.start();
				ssbtsatus=true;
				prbtstatus=true;
				prbt.setEnabled(true);
				ssbt.setText("Stop");
				
				 tmin=(v.getDuration()/1000)/60;
				 tsec=(v.getDuration()/1000)-(60*tmin);
			//	Toast.makeText(MultimediaActivity.this,tmin+":min "+tsec+":sec", 5).show();
				 showtime.setText("Total Time="+tmin+":"+tsec+"\n");
				
			}
			
		}

	}
    
    
    
    
    
    
	public class songrpauseresume implements OnClickListener {

		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			if(prbtstatus)
			{
				prbtstatus=false;
				prbt.setText("Resume");
				v.pause();
				
			}
			
			else
			{
				prbtstatus=true;
				prbt.setText("Pause");
				v.start();
			
				
			}
			
		}

	}
	
	
	
	
	
	
	
	
	public class movesong implements OnSeekBarChangeListener {

		public void onProgressChanged(SeekBar arg0, int arg1, boolean arg2) {
			// TODO Auto-generated method stub
			if(movesong)
				{
				v.seekTo(arg1);
				cms=arg1;
				}
		}

		public void onStartTrackingTouch(SeekBar arg0) {
			// TODO Auto-generated method stub
			movesong=true;
		
			//sk.setContentDescription("hiiii");
			//sk.dispatchDisplayHint(sk.getProgress());
		}

		public void onStopTrackingTouch(SeekBar arg0) {
			// TODO Auto-generated method stub
			movesong=false;
			try{ cmin=(sk.getProgress()/1000)/60;
			 csec=(sk.getProgress()/1000)-(60*cmin);
		Toast.makeText(playsong.this,cmin+":min "+csec+":sec", 5).show();}
			catch (Exception e) {
				// TODO: handle exception
				Toast.makeText(playsong.this,e+":", 5).show();
			}
		//	sk.setContentDescription("hello");
			//sk.dispatchDisplayHint(sk.getProgress());
		}

	}
	
	
	
	

	/** Called when the activity is first created. */
    VideoView v;
    TextView songname;
    SeekBar sk;
    LinearLayout main;
    Button ssbt,prbt;
    Boolean ssbtsatus=false,prbtstatus=false;
    Boolean movesong=false;
    long finalpos;
    int tmin=0,tsec=0;
    int cmin=0,csec=0,cms=0;
    TextView showtime;
    
    
    
    
    
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.playsonglayout);
    
       
       songname=(TextView)findViewById(R.id.songname);
		StringBuffer path=MusicplayerActivity.path;
		String s=""+path.reverse();
		path.reverse();
		int index=0;
		while(s.charAt(index)!='/') 
			index++;
		songname.setText("Playing\n"+path.substring(0,path.length()-index)+"\n"+path.substring(path.length()-index, path.length()));
      
      
     //  Log.i("path",path); 
       v=(VideoView)findViewById(R.id.s1);
       v.setVideoPath(path+"");
       v.setMediaController(new MediaController(getApplicationContext()));
       v.requestFocus();
      
       
        sk=(SeekBar)findViewById(R.id.sk);
      //  sk.setMax(v.getDuration());
        sk.setOnSeekBarChangeListener(new movesong() );
        
        
       prbt=(Button)findViewById(R.id.prbt);
       prbt.setOnClickListener(new songrpauseresume());
       prbt.setEnabled(false);
       
       
       Button bckbt=(Button)findViewById(R.id.bckbt);
       bckbt.setOnClickListener(new OnClickListener() {
		
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			Intent i=new Intent(playsong.this,MusicplayerActivity.class);
			startActivity(i);
		}
	});
       
       
       
       showtime=(TextView)findViewById(R.id.showtime);
       showtime.setText("Total Time="+tmin+":"+tsec+"\n");
       //showtime.append("Current Time="+cmin+":"+csec);
       
       ssbt=(Button)findViewById(R.id.ssbt);
       ssbt.setOnClickListener(new songstartstop());
       new Thread(myThread).start();
 
     
       
       
      
    }
    
    
    
    
    
    private Runnable myThread = new Runnable(){

        public void run() {
                // TODO Auto-generated method stub
                while (v.getCurrentPosition()<=((tmin*60+tsec)*1000)){
                        try{
                               sk.setProgress(v.getCurrentPosition());
                               finalpos=v.getCurrentPosition();
                               
                            
                        }
                        catch(Throwable t){
                        	
                        //	Toast.makeText(MultimediaActivity.this,t+"", 5).show();
                        }
                }
             
                
        }
    };
    
    
    


}
