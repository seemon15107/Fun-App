package com.fun;

import java.util.ArrayList;

import android.app.Activity;
//import android.content.Intent;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class Listreview_sql extends Activity{
	public class Cancel implements OnClickListener {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			setResult(RESULT_CANCELED);
			finish();
		}

	}
	public class ls implements OnItemClickListener {

	
		public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
				long arg3) {
			// TODO Auto-generated method stub
			//String a=arg0.toString();
			//String b=arg1.toString();
			//int c=arg2;
			//long d=arg3;
			//Toast.makeText(getApplicationContext(),""+a +"//"+ b +"//"+c+"//"+d+"",Toast.LENGTH_LONG).show();
	Object o=userList.getItemAtPosition(arg2);
	String det=o.toString();
	//Toast.makeText(getApplicationContext(),det,Toast.LENGTH_LONG).show();

			Intent ii=new Intent(Listreview_sql.this,Details_sql.class);
			
			
			ii.putExtra("daa", det);

		    //ii.putExtras(mBundle);
			startActivity(ii);
		}

	}
	ArrayAdapter<String> adapter;
	ArrayAdapter<String> itemAdapter;
	ArrayList<String> arrayList;
	//ArrayList<String> itemArrayList;
     ListView userList;
	Cursor cursor;
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.lstview_sql);
		Button b1=(Button)findViewById(R.id.btcanuser);
		b1.setOnClickListener(new Cancel());
		userList = (ListView)findViewById(R.id.list);
		arrayList = new ArrayList<String>();
		//itemArrayList = new ArrayList<String>();
		//itemArrayList.add("name");
		//arrayList.add("Names");
		itemAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_multiple_choice, arrayList);
		userList.setAdapter(itemAdapter);
		userList.setOnItemClickListener(new ls());
		try{
			
			databs_sql sdb=new databs_sql(getApplicationContext(), "Mobile.db", null, 1);
			SQLiteDatabase db= sdb.getReadableDatabase();
			Cursor c2=db.rawQuery("select name from user ", null);
			if(c2!=null){
				
				if(c2.moveToFirst()){
					do{
				
					String name = c2.getString(c2.getColumnIndex("name"));
					arrayList.add(name);
				}while(c2.moveToNext());
			  }
			}
			c2.close();
		}
		catch(Exception e)
		{
										Toast.makeText(this,"Problem in accessing from database"+e.getMessage(),Toast.LENGTH_LONG).show();
		}

}
}
