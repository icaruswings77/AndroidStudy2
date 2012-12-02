package com.lee2day.jobwork;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class JobInfoRsltActivity extends Activity {
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jobinfo_rslt);
    }
    

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_job_info, menu);
        return true;
    }
}
