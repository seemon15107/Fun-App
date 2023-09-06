package com.fun;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ScientificActivity extends Activity {
   

	public class Sc implements OnClickListener {

		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
               Intent it1=new Intent(ScientificActivity.this,Sci.class);
               startActivity(it1);
		}

	}

	public class Bas implements OnClickListener {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			
            Intent it=new Intent(ScientificActivity.this,basic.class);
            startActivity(it);
		    
		}

	}

	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calc);
        Button b=(Button)findViewById(R.id.btbasic);
        b.setOnClickListener(new Bas());
        
        Button b1=(Button)findViewById(R.id.btsci);
        b1.setOnClickListener(new Sc());
        
        
    }
}