package com.lee2day.jobwork;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class InterviewActivity extends Activity {
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interview);
    }
    

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_interview, menu);
        return true;
    }
}
