package com.fun;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class shift extends Activity{
	//String fun;
	public class Op implements OnClickListener {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
EditText ee1=(EditText)findViewById(R.id.edt1);
switch (v.getId()) {
case R.id.btdel1:
	String cll=ee1.getText().toString();
	if(cll.length()>0)
	{
		ee1.setText(cll.substring(0, cll.length()-1));
	}
	else
	{
		ee1.setText("");
	}
	
	
	break;
	
case R.id.btclr1:
	
	ee1.setText("");
	
	break;
	
case R.id.bk1:
	
	Intent iit=new Intent(shift.this,Sci.class);
	iit.putExtra("mess", ee1.getText().toString());
	startActivity(iit);
	
	break;
	
case R.id.btsin:
	Button btemp=(Button)findViewById(v.getId());
	
	ee1.setText(btemp.getText().toString());
	
	break;
	
case R.id.btcos:
	
Button btemp1=(Button)findViewById(v.getId());
	
	ee1.setText(btemp1.getText().toString());
	
	
	break;
	
case R.id.btan:
	
Button btemp2=(Button)findViewById(v.getId());
	
	ee1.setText(btemp2.getText().toString());
	
	
	break;
	


default:
	break;
}
		}

	}

	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.shift);
		Button bdel1=(Button)findViewById(R.id.btdel1);
		Button bclr1=(Button)findViewById(R.id.btclr1);
		Button bbk1=(Button)findViewById(R.id.btback);
		Button bsin=(Button)findViewById(R.id.btsin);
		Button bcos=(Button)findViewById(R.id.btcos);
		Button btan=(Button)findViewById(R.id.btan);
		Button bfac=(Button)findViewById(R.id.btfac);
		Button bexp=(Button)findViewById(R.id.btexp);
		Button blog=(Button)findViewById(R.id.btlog);
		Button blog1=(Button)findViewById(R.id.btlog1);
		Button bhyp=(Button)findViewById(R.id.bthyp);
		//Button bdel=(Button)findViewById(R.id.btdel1);
		
		bdel1.setOnClickListener(new Op());
		bclr1.setOnClickListener(new Op());
		bbk1.setOnClickListener(new Op());
		bsin.setOnClickListener(new Op());
		bcos.setOnClickListener(new Op());
		btan.setOnClickListener(new Op());
		bfac.setOnClickListener(new Op());
		bexp.setOnClickListener(new Op());
		blog.setOnClickListener(new Op());
		blog1.setOnClickListener(new Op());
		bhyp.setOnClickListener(new Op());
		
		
	}
	

}
