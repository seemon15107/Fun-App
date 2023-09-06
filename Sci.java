
package com.fun;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class Sci extends Activity{
	String val,oper;
	public class O implements OnClickListener {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
EditText ee=(EditText)findViewById(R.id.edt);
switch (v.getId()) 
{

case R.id.btplus:
	val=ee.getText().toString();
	oper="+";
	ee.setText("");
	
	break;
	
case R.id.btsub:
	val=ee.getText().toString();
	oper="-";
	ee.setText("");
	
	
	break;
	
case R.id.btdiv:
	val=ee.getText().toString();
	oper="/";
	ee.setText("");
	
	
	break;
	
case R.id.btmul:
	val=ee.getText().toString();
	oper="*";
	ee.setText("");
	
	
	break;
	
case R.id.btpie:
	String s=Math.PI+"";
	ee.setText(s);
	
	
	break;
	
case R.id.btsqr:
	val=ee.getText().toString();
	String ss=Math.pow(Double.parseDouble(val), 2)+"";
	ee.setText(ss);
	
	
	break;
	
case R.id.btcube:
	val=ee.getText().toString();
	String ss1=Math.pow(Double.parseDouble(val), 3)+"";
	ee.setText(ss1);
	
	
	break;
	
case R.id.btsqrrut:
	val=ee.getText().toString();
	String ss2=Math.sqrt(Double.parseDouble(val))+"";
	ee.setText(ss2);

	
	break;
	
case R.id.btdclear:
	String cl=ee.getText().toString();
	if(cl.length()>0)
	{
		ee.setText(cl.substring(0, cl.length()-1));
	}
	else
	{
		ee.setText("");
	}
	
	
	break;
	
case R.id.bterase:
	ee.setText("");
	val="";
	oper="";
	
	
	
	break;
	
case R.id.btback:
	Intent ii=new Intent(Sci.this,ScientificActivity.class);
	startActivity(ii);
	
	
	break;
	
case R.id.btequal:
	 if(oper.equals("+"))
	 {
	          ee.setText((Double.parseDouble(val) + Double.parseDouble(ee.getText().toString()))+"");
	 }
	 if(oper.equals("*"))
	 {
	          ee.setText((Double.parseDouble(val) * Double.parseDouble(ee.getText().toString()))+"");
	 }
	 if(oper.equals("/"))
	 {
	          ee.setText((Double.parseDouble(val) / Double.parseDouble(ee.getText().toString()))+"");
	 }
	 if(oper.equals("-"))
	 {
	          ee.setText((Double.parseDouble(val) - Double.parseDouble(ee.getText().toString()))+"");
	 }
	
	
	break;

case R.id.btshift:
	
	Intent kkk=new Intent(Sci.this,shift.class);
	startActivity(kkk);
	
	
	break;

default:
	break;
}

		}

	}

	public class N implements OnClickListener {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			EditText ed=(EditText)findViewById(R.id.edt);
			Button btnn=(Button)findViewById(v.getId());
			ed.setText(ed.getText()+btnn.getText().toString());

		}

	}

	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sci);
		Button bcl=(Button)findViewById(R.id.btdclear);
		Button ber=(Button)findViewById(R.id.bterase);
		Button bk=(Button)findViewById(R.id.btback);
		Button bone=(Button)findViewById(R.id.btone);
		Button btwo=(Button)findViewById(R.id.btwo);
		Button bthree=(Button)findViewById(R.id.bthree);
		Button bplus=(Button)findViewById(R.id.btplus);
		Button bsqr=(Button)findViewById(R.id.btsqr);
		Button bcube=(Button)findViewById(R.id.btcube);
		Button bfour=(Button)findViewById(R.id.btfour);
		Button bfive=(Button)findViewById(R.id.btfive);
		Button bsix=(Button)findViewById(R.id.btsix);
		Button bsub=(Button)findViewById(R.id.btsub);
		Button broot=(Button)findViewById(R.id.btsqrrut);
		Button bpie=(Button)findViewById(R.id.btpie);
		Button bseven=(Button)findViewById(R.id.btseven);
		Button beight=(Button)findViewById(R.id.bteight);
		Button bnine=(Button)findViewById(R.id.btnine);
		Button bdiv=(Button)findViewById(R.id.btdiv);
		Button bdot=(Button)findViewById(R.id.btdot);
		Button bzero=(Button)findViewById(R.id.btzero);
		Button bequal=(Button)findViewById(R.id.btequal);
		Button bmul=(Button)findViewById(R.id.btmul);
		Button bsft=(Button)findViewById(R.id.btshift);
		//Button bcl=(Button)findViewById(R.id.btdclear);
		//Button bcl=(Button)findViewById(R.id.btdclear);
		
		bone.setOnClickListener(new N());
		btwo.setOnClickListener(new N());
		bthree.setOnClickListener(new N());
		bfour.setOnClickListener(new N());
		bfive.setOnClickListener(new N());
		bsix.setOnClickListener(new N());
		bseven.setOnClickListener(new N());
		beight.setOnClickListener(new N());
		bnine.setOnClickListener(new N());
		bzero.setOnClickListener(new N());
		bdot.setOnClickListener(new N());
		//b.setOnClickListener(new N());
		
		bcl.setOnClickListener(new O());
		ber.setOnClickListener(new O());
		bk.setOnClickListener(new O());
		bplus.setOnClickListener(new O());
		bsqr.setOnClickListener(new O());
		bcube.setOnClickListener(new O());
		bsub.setOnClickListener(new O());
		broot.setOnClickListener(new O());
		bpie.setOnClickListener(new O());
		bdiv.setOnClickListener(new O());
		bmul.setOnClickListener(new O());
		bequal.setOnClickListener(new O());
		bsft.setOnClickListener(new O());
		
		//EditText tin=(EditText)findViewById(R.id.edt);
		//Intent ii=getIntent();
		//tin.setText(ii.getStringExtra("mess"));
		
		
	}

}
