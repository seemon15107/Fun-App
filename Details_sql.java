package com.fun;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class Details_sql extends Activity implements OnClickListener{
    public class Cancel implements OnClickListener {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			setResult(RESULT_CANCELED);
			finish();
		}

	}

	/** Called when the activity is first created. */
	TextView txt1,txt3,txt4;
	 String phone="";
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_sql);
		//Button bsign=(Button)findViewById(R.id.btlogout);
	
		txt1=(TextView)findViewById(R.id.txtlgwel);
		//txt2=(TextView)findViewById(R.id.txtdetails);
		txt3=(TextView)findViewById(R.id.txtph);
		txt4=(TextView)findViewById(R.id.txtemail);
		Button bcall=(Button)findViewById(R.id.btcall);
		Button bsms=(Button)findViewById(R.id.btmsg);
		Button bmail=(Button)findViewById(R.id.btmail);
		Button b1=(Button)findViewById(R.id.btdetcan);
		b1.setOnClickListener(new Cancel());
		bcall.setOnClickListener(this);
		bsms.setOnClickListener(this);
		bmail.setOnClickListener(this);
		Intent mIntent = getIntent();
    	
		String su=mIntent.getStringExtra("daa");
		txt1.setText("Hi"+ " " +su);
		
		databs_sql sdb=new databs_sql(getApplicationContext(), "Mobile.db", null, 1);
    	SQLiteDatabase db= sdb.getReadableDatabase();
    	
    	
    	String ab[]={mIntent.getStringExtra("daa")};	
    		Cursor cdet = db.rawQuery("select name,email,ph,address,gender from user where name=? " ,ab);
					
    	while (cdet.moveToNext()) {
			//txt2.setText("");
			//txt2.append(cdet.getString(0)+"\n"+ cdet.getString(1)+"\n"+ cdet.getString(2)+"\n"+ cdet.getString(3)+"\n"+ cdet.getString(4)+"\n");
	
			txt3.setText(cdet.getString(2));
			txt4.setText(cdet.getString(1));
			}
    }
	
	@Override
	public void onClick(View v) {
		int i= v.getId();
		Intent myIntent = null;
		phone=txt3.getText().toString();

		
		
		if(i == R.id.btcall){
		phone=txt3.getText().toString();
			System.out.println("+++++++++++++++++++++++++++"+phone);
			call(phone);
			
		}
		
		
		if(i == R.id.btmsg){
			myIntent = new Intent(this, Sms.class);
			myIntent.putExtra("Ph",phone);
			//myIntent.putExtra("Name",name);
			myIntent.addFlags(myIntent.FLAG_ACTIVITY_FORWARD_RESULT);
			startActivity(myIntent);
    	}
		if(i == R.id.btmail){
			String mail =txt4.getText().toString();
			myIntent = new Intent(this, Mail.class);
			myIntent.putExtra("mail",mail);
		
            myIntent.addFlags(myIntent.FLAG_ACTIVITY_FORWARD_RESULT);
			startActivity(myIntent);
    	}
		
	}
	
	private void call(String phone) {
	    try {
	        Intent callIntent = new Intent(Intent.ACTION_CALL);
	        System.out.println("---------"+phone);
	        callIntent.setData(Uri.parse("tel:"+phone));
	        startActivity(callIntent);
	    } catch (ActivityNotFoundException activityException) {
	        Log.e("dialing-example", "Call failed", activityException);
	    }
	}
}