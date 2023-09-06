package com.fun;



import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends Activity {

	

	public Button b1,b2;
	public TextView res;
	public String login_id;

	EditText eu,ep;
	TextView t1;

	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
	
		
        b1=(Button)findViewById(R.id.btlogin1);
        b2=(Button)findViewById(R.id.cancel_button1);
		eu=(EditText)findViewById(R.id.eduser1);
		ep=(EditText)findViewById(R.id.edpwd1);
		t1=(TextView)findViewById(R.id.txtnew) ;
		

		// res = (TextView) findViewById(R.id.result);

		
		b2.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {			
				finish();
			}
		});
		
		b1.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {			
				databs_sql sdb=new databs_sql(getApplicationContext(), "Mobile.db", null, 1);
				SQLiteDatabase db= sdb.getReadableDatabase();
				Cursor c1=db.rawQuery("select u_name,pwd from user where u_name='"+
						eu.getText().toString()+"' and pwd='"+ep.getText().toString()+"'", null);
				if(eu.getText().toString().equals("")||ep.getText().toString().equals(""))
	            {
	                  Toast.makeText(getApplicationContext(), "Please enter Name Password both", 
	                    		Toast.LENGTH_LONG).show();
	                    return;
	            }
				else if(c1.moveToFirst())
				{
				Toast.makeText(getApplicationContext(), "Success", Toast.LENGTH_SHORT).show();
			                Intent i5=new Intent(Login.this,Fun_sql.class);
							//i5.putExtra("msg1", eu.getText().toString());
							startActivity(i5);   
				}
				else {
			                Toast.makeText(getApplicationContext(), "Invalid Login details",
			                		Toast.LENGTH_SHORT).show();
			            	eu.setText("");
								ep.setText("");
			            }	
							
					    
					}
					
		});
		
		t1.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {			
				Intent i2=new Intent(Login.this,Reg_sql.class);
				startActivity(i2);
			}
		});
		
	}

	
}