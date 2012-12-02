package com.lee2day.jobwork;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class JobMainActivity extends Activity {
	
	// private Button button;
	private Button button1;
	private Button button2;
	private Button button3;
	private Button button4;	

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_main);
        
		button1 = (Button) findViewById(R.id.button01);
		button1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(JobMainActivity.this, JobInfoSrchActivity.class);
				startActivity(intent);
			}
		});

		button2 = (Button) findViewById(R.id.button02);
		button2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(JobMainActivity.this, AptitudeTestActivity.class);
				startActivity(intent);
			}
		});

		button3 = (Button) findViewById(R.id.button03);
		button3.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(JobMainActivity.this, InterviewActivity.class);
				startActivity(intent);
			}
		});

		button4 = (Button) findViewById(R.id.button04);
		button4.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(JobMainActivity.this, AdviceActivity.class);
				startActivity(intent);
			}
		});
        
    }
    

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_job_main, menu);
        return true;
    }
}
