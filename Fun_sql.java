package com.fun;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Fun_sql extends Activity
{
	 public class Cancel implements OnClickListener {

		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			setResult(RESULT_CANCELED);
			finish();
		}

	}

	public class De implements OnClickListener {

		
		public void onClick(View v) {
			// TODO Auto-generated method stub
Intent ide=new Intent(Fun_sql.this,Listreview_sql.class);
startActivity(ide);
		}

	}

	public class Fu implements OnClickListener {

	
		public void onClick(View v) {
			// TODO Auto-generated method stub
			                                  Intent ff=new Intent(Fun_sql.this,Funapp.class);
			                                   startActivity(ff);
		}

	}

	public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.fun_sql);
	        Button b1=(Button)findViewById(R.id.btnfun);
	        Button b2=(Button)findViewById(R.id.btndet);
	        Button b3=(Button)findViewById(R.id.cancel);
	        b1.setOnClickListener(new Fu());
	        b2.setOnClickListener(new De());
	        b3.setOnClickListener(new Cancel());
	        
	 }


}
