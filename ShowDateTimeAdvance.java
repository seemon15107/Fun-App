package com.fun;

import java.util.Calendar;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

public class ShowDateTimeAdvance extends Activity {
	int hour, minute, mYear,mMonth, mDay;
    static final int TIME_DIALOG_ID = 0;
    static final int DATE_DIALOG_ID = 1;
    private EditText txtDate;
 private EditText txtTime;
 private String[] arrMonth = {"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.date);
        txtDate = (EditText) findViewById(R.id.txtDate);
  txtTime = (EditText) findViewById(R.id.txtTime);
  // get the current date
     final Calendar c = Calendar.getInstance();
     mYear = c.get(Calendar.YEAR);
     mMonth = c.get(Calendar.MONTH);
     mDay = c.get(Calendar.DAY_OF_MONTH);

        txtDate.setOnTouchListener(new OnTouchListener() {
   public boolean onTouch(View arg0, MotionEvent arg1) {
    // TODO Auto-generated method stub
    showDialog(DATE_DIALOG_ID);
    return true;
   }
        });

        txtTime.setOnTouchListener(new OnTouchListener() {   
   public boolean onTouch(View arg0, MotionEvent arg1) {
    // TODO Auto-generated method stub
    showDialog(TIME_DIALOG_ID);
    return true;
   }
        });

    }

    @Override
    protected Dialog onCreateDialog(int id)
    {
        switch (id) {
            case TIME_DIALOG_ID:
                return new TimePickerDialog(
                    this, mTimeSetListener, hour, minute, true);
            case DATE_DIALOG_ID:
                return new DatePickerDialog(
                    this, mDateSetListener, mYear, mMonth, mDay);
        }
        return null;
    }

    private DatePickerDialog.OnDateSetListener mDateSetListener =
        new DatePickerDialog.OnDateSetListener()
        {

  public void onDateSet(DatePicker view, int year, int monthOfYear,int dayOfMonth) {
   mYear = year;
   mMonth = monthOfYear;
   mDay = dayOfMonth;
   String sdate = arrMonth[mMonth] + " " + LPad(mDay + "", "0", 2) + ", " + mYear;
   txtDate.setText(sdate);
  }
 };

    private TimePickerDialog.OnTimeSetListener mTimeSetListener =
    new TimePickerDialog.OnTimeSetListener()
    {
        public void onTimeSet(TimePicker view, int hourOfDay, int minuteOfHour)
        {
            hour = hourOfDay;
            minute = minuteOfHour;
            String stime = LPad(""+hour, "0", 2) + ":"+ LPad(""+hour, "0", 2);
            txtTime.setText(stime);
        }
    };

 private static String LPad(String schar, String spad, int len) {
  String sret = schar;
  for (int i = sret.length(); i < len; i++) {
   sret = spad + sret;
  }
  return new String(sret);
 }
}