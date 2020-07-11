package com.aquccuk.hw213;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Toast;

import java.util.GregorianCalendar;

public class MainActivity extends AppCompatActivity {
    private Button mChooseStartDate;
    private Button mChooseEndDate;
    private CalendarView mStartDateCalendar;
    private CalendarView mEndtDateCalendar;
    private Button mBtnOK;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mChooseStartDate = findViewById(R.id.chooseStartDate);
        mChooseEndDate = findViewById(R.id.chooseEndDate);
        mStartDateCalendar = findViewById(R.id.startCalendar);
        mEndtDateCalendar = findViewById(R.id.endCalendar);
        mBtnOK = findViewById(R.id.btnOK);
        mStartDateCalendar.setVisibility(View.GONE);
        mEndtDateCalendar.setVisibility(View.GONE);

        mChooseStartDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mStartDateCalendar.setVisibility(View.VISIBLE);
                mEndtDateCalendar.setVisibility(View.GONE);
            }
        });
        mChooseEndDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mStartDateCalendar.setVisibility(View.GONE);
                mEndtDateCalendar.setVisibility(View.VISIBLE);
            }
        });
        final long[] mStartDate = new long[1];
        final String[] mStartDateTxt = new String[1];
        final long[] mEndDate = new long[1];
        final String[] mEndDateTxt = new String[1];

        mStartDateCalendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                mStartDateTxt[0] = year+"-"+month+"-"+dayOfMonth;
                mChooseStartDate.setText("Дата-время старта задачи: "+ mStartDateTxt[0]);
                GregorianCalendar gregorianCalendar = new GregorianCalendar();
                gregorianCalendar.set(year, month, dayOfMonth);
                mStartDate[0] = gregorianCalendar.getTimeInMillis();
                view.setVisibility(View.GONE);

            }
        });
        mEndtDateCalendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                mEndDateTxt[0] = year+"-"+month+"-"+dayOfMonth;
                mChooseEndDate.setText("Дата-время окончания задачи: "+ mEndDateTxt[0]);
                GregorianCalendar gregorianCalendar = new GregorianCalendar();
                gregorianCalendar.set(year, month, dayOfMonth);
                mEndDate[0] = gregorianCalendar.getTimeInMillis();
                view.setVisibility(View.GONE);
            }
        });
        mBtnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mStartDate[0] > mEndDate[0]){
                    Toast.makeText(MainActivity.this, "Ошибка", Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(MainActivity.this, "старт", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}