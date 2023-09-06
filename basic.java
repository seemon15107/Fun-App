package com.fun;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class basic extends Activity {
	String num1,opr1;
	public class Copr implements OnClickListener {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			EditText e1=(EditText)findViewById(R.id.ed1);
            switch (v.getId()) {
			case R.id.bt4:
				 num1=e1.getText().toString();
				 opr1="+";
				 e1.setText("");
				 
				
				break;
			case R.id.bt8:
				 num1=e1.getText().toString();
				 opr1="-";
				 e1.setText("");
				
				break;
			case R.id.bt12:
				 num1=e1.getText().toString();
				 opr1="/";
				 e1.setText("");
				
				break;
			case R.id.bt16:
				 num1=e1.getText().toString();
				 opr1="*";
				 e1.setText("");
				
				break;
			case R.id.bt15:
				 if(opr1.equals("+"))
				 {
				          e1.setText((Double.parseDouble(num1) + Double.parseDouble(e1.getText().toString()))+"");
				 }
				 if(opr1.equals("*"))
				 {
				          e1.setText((Double.parseDouble(num1) * Double.parseDouble(e1.getText().toString()))+"");
				 }
				 if(opr1.equals("/"))
				 {
				          e1.setText((Double.parseDouble(num1) / Double.parseDouble(e1.getText().toString()))+"");
				 }
				 if(opr1.equals("-"))
				 {
				          e1.setText((Double.parseDouble(num1) - Double.parseDouble(e1.getText().toString()))+"");
				 }
				
				break;
			case R.id.btdel:
				String s=e1.getText().toString();
				if(s.length()>0) 
				{
					e1.setText(s.substring(0, s.length()-1));
				}
				else
				{
					e1.setText("");
				}
				
				break;
			case R.id.btera:
				 e1.setText("");
				 num1="";
				 opr1="";
				
				break;
				
			case R.id.btback:
				 Intent itt=new Intent(basic.this,ScientificActivity.class);
				 startActivity(itt);
				
				break;
				

			default:
				break;
			}    
		}
		

	}

	public class Cnum implements OnClickListener {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			EditText e1=(EditText)findViewById(R.id.ed1);
            Button btemp=(Button)findViewById(v.getId());
            e1.setText(e1.getText()+btemp.getText().toString());
            
		}

	}

	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.basic);
        
        Button b1=(Button)findViewById(R.id.bt1);
        Button b2=(Button)findViewById(R.id.bt2);
        Button b3=(Button)findViewById(R.id.bt3);
        Button b4=(Button)findViewById(R.id.bt4);
        Button b5=(Button)findViewById(R.id.bt5);
        Button b6=(Button)findViewById(R.id.bt6);
        Button b7=(Button)findViewById(R.id.bt7);
        Button b8=(Button)findViewById(R.id.bt8);
        Button b9=(Button)findViewById(R.id.bt9);
        Button b10=(Button)findViewById(R.id.bt10);
        Button b11=(Button)findViewById(R.id.bt11);
        Button b12=(Button)findViewById(R.id.bt12);
        Button b13=(Button)findViewById(R.id.bt13);
        Button b14=(Button)findViewById(R.id.bt14);
        Button b15=(Button)findViewById(R.id.bt15);
        Button b16=(Button)findViewById(R.id.bt16);
        Button bdel=(Button)findViewById(R.id.btdel);
        Button bcl=(Button)findViewById(R.id.btera);
        
        Button bac=(Button)findViewById(R.id.btback);
        bac.setOnClickListener(new Copr());
        //Button b1=(Button)findViewById(R.id.bt1);
        b1.setOnClickListener(new Cnum());
        b2.setOnClickListener(new Cnum());
        b3.setOnClickListener(new Cnum());
        b5.setOnClickListener(new Cnum());
        b6.setOnClickListener(new Cnum());
        b7.setOnClickListener(new Cnum());
        b9.setOnClickListener(new Cnum());
        b10.setOnClickListener(new Cnum());
        b11.setOnClickListener(new Cnum());
        b14.setOnClickListener(new Cnum());
        b13.setOnClickListener(new Cnum());
        
        b4.setOnClickListener(new Copr());
        b8.setOnClickListener(new Copr());
        b12.setOnClickListener(new Copr());
        b15.setOnClickListener(new Copr());
        b16.setOnClickListener(new Copr());
        bcl.setOnClickListener(new Copr());
        bdel.setOnClickListener(new Copr());
        

}
}
