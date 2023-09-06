package com.fun;







import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;

public class Funapp extends Activity {
	public class gal implements OnClickListener {

		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			Intent imggl=new Intent(Funapp.this,ImageGalleryDemoActivity.class);
			startActivity(imggl);
		}

	}
	
	public class wall implements OnClickListener {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent iw=new Intent(Funapp.this,WallSwapActivity.class);
			startActivity(iw);
		}
	}
	
	public class calc implements OnClickListener {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent ical=new Intent(Funapp.this,ScientificActivity.class);
			startActivity(ical);
		}

	}
	public class game implements OnClickListener {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent ig=new Intent(Funapp.this,DivideAndConquerActivity.class);
			startActivity(ig);
		}

	}
	public class audio implements OnClickListener {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent ia=new Intent(Funapp.this,MusicplayerActivity.class);
			startActivity(ia);
		}
	}
	public class date implements OnClickListener {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent id=new Intent(Funapp.this,ShowDateTimeAdvance.class);
			startActivity(id);

		}

	}
	public class cam implements OnClickListener {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent ic=new Intent(Funapp.this,MainActivity.class);
			startActivity(ic);
		}

	}
	public class video implements OnClickListener {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent iv=new Intent(Funapp.this,VideoActivity.class);
			startActivity(iv);
		}

	}
	public class fb implements OnClickListener {

		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			Intent igal=new Intent(Funapp.this,HelloGridView.class);
			startActivity(igal);
		
		}

	}
	ImageButton b1,b2,b3,b4,b5,b6,b7,b8,b9;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        b1=(ImageButton)findViewById(R.id.pic);
        b2=(ImageButton)findViewById(R.id.video);
        b3=(ImageButton)findViewById(R.id.cam);
        b4=(ImageButton)findViewById(R.id.datepicr);
        b5=(ImageButton)findViewById(R.id.audio);
        b6=(ImageButton)findViewById(R.id.game);
        b7=(ImageButton)findViewById(R.id.calc);
        b8=(ImageButton)findViewById(R.id.galry);
        b9=(ImageButton)findViewById(R.id.wallswap);
        
        b1.setOnClickListener(new fb());
        b2.setOnClickListener(new video());
        b3.setOnClickListener(new cam());
        b4.setOnClickListener(new date());
        b5.setOnClickListener(new audio());
        b6.setOnClickListener(new game());
        b7.setOnClickListener(new calc());
        b8.setOnClickListener(new gal());
        b9.setOnClickListener(new wall());
    }
}