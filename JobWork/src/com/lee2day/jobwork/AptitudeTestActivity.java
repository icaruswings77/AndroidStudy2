package com.lee2day.jobwork;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class AptitudeTestActivity extends Activity {
	
	private AptitudeFuntion m_AptitudeFuntion = null;
	
	// private Button button;
	private Button button1;
	private Button button2;
	private Button button3;
	private Button button4;	
	private Button button5;
	private Button button6;	
	
	// 현재 진행중 순서
	public int pg_cnt = 0;
	
	// type field response value	
	public static int rFieldResponse = 0;
	public static int iFieldResponse = 0;
	public static int aFieldResponse = 0;
	public static int sFieldResponse = 0;
	public static int eFieldResponse = 0;
	public static int cFieldResponse = 0;

	// 화면 TextView
	TextView tvField;
	TextView tvType;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aptitude_test);
        
        // AptitudeFuntion 객체 생성
        m_AptitudeFuntion = new AptitudeFuntion();
                
        tvField = (TextView) findViewById(R.id.tv_field_qes);
        tvField.setText(m_AptitudeFuntion.fieldQeustion[0]);

        //1 button select
		button1 = (Button) findViewById(R.id.bt_check01);
		button1.setOnClickListener(new OnClickListener() {
			@Override			
			public void onClick(View arg0) {				
				TestCalc("1");
				//m_AptitudeFuntion.TestCalc("1");
			}
		});

		//2 button select
		button2 = (Button) findViewById(R.id.bt_check02);
		button2.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {			
				TestCalc("2");
			}
		});

		//3 button select
		button3 = (Button) findViewById(R.id.bt_check03);
		button3.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {				
				TestCalc("3");
			}
		});

		//4 button select
		button4 = (Button) findViewById(R.id.bt_check04);
		button4.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {								
				TestCalc("4");
				// imsi
				//pg_cnt = 37;
			}
		});
		
		//5 button select - Main화면으로 가기
		button5 = (Button) findViewById(R.id.bt_go_main);
		button5.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				pg_cnt = 0;
				
				rFieldResponse = 0;
				iFieldResponse = 0;
				aFieldResponse = 0;
				sFieldResponse = 0;
				eFieldResponse = 0;
				cFieldResponse = 0;

				Intent intent = new Intent(AptitudeTestActivity.this, JobMainActivity.class);
				startActivity(intent);
			}
		});
		
		//6 button select 초기화
		button6 = (Button) findViewById(R.id.bt_go_new);
		button6.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {								
				
				// imsi
				pg_cnt = 0;
				
				rFieldResponse = 0;
				iFieldResponse = 0;
				aFieldResponse = 0;
				sFieldResponse = 0;
				eFieldResponse = 0;
				cFieldResponse = 0;
				
				tvField.setText(m_AptitudeFuntion.fieldQeustion[0]);
			}
		});		
		
		               
    }
    
	public void TestCalc(String check_no) {
		int tmp_check_no = 0;
				
		if (pg_cnt > 36){
			pg_cnt = 37;
			// 임시
//			rFieldResponse = 85;
//			iFieldResponse = 75;
//			aFieldResponse = 82;
//			sFieldResponse = 95;
//			eFieldResponse = 77;
//			cFieldResponse = 77;
			
			// 액티비티로 결과값 보내기
			Intent intent = new Intent(AptitudeTestActivity.this, AptitudeRsltActivity.class);
			intent.putExtra("R_type", rFieldResponse);
			intent.putExtra("I_type", iFieldResponse);
			intent.putExtra("A_type", aFieldResponse);
			intent.putExtra("S_type", sFieldResponse);
			intent.putExtra("E_type", eFieldResponse);
			intent.putExtra("C_type", cFieldResponse);

			startActivityForResult(intent,0);
			
		} else {
		
			// button parameter
			if (pg_cnt > 0 && check_no.equals("1")){
				tmp_check_no = 4;
			} else if (pg_cnt > 0 && check_no.equals("2")){
				tmp_check_no = 8;
			} else if (pg_cnt > 0 && check_no.equals("3")){
				tmp_check_no = 12;
			} else if (pg_cnt > 0 && check_no.equals("4")){
				tmp_check_no = 16;
			}
						
			tvType = (TextView) findViewById(R.id.tv_type);
			
			if (pg_cnt < 7) {
				rFieldResponse = rFieldResponse + tmp_check_no; // R type field value sum
				tvType.setText("R 유형 : " + rFieldResponse);
			} else if (pg_cnt > 6 && pg_cnt < 13) {
				iFieldResponse = iFieldResponse + tmp_check_no; // I type field value sum
				tvType.setText("I 유형 : " + iFieldResponse);
			} else if (pg_cnt > 12 && pg_cnt < 19) {
				aFieldResponse = aFieldResponse + tmp_check_no; // A type field value sum
				tvType.setText("A 유형 : " + aFieldResponse);
			} else if (pg_cnt > 18 && pg_cnt < 25) {
				sFieldResponse = sFieldResponse + tmp_check_no; // S type field value sum
				tvType.setText("S 유형 : " + sFieldResponse);
			} else if (pg_cnt > 24 && pg_cnt < 31) {
				eFieldResponse = eFieldResponse + tmp_check_no; // E type field value sum
				tvType.setText("E 유형 : " + eFieldResponse);
			} else if (pg_cnt > 30 && pg_cnt < 37) {
				cFieldResponse = cFieldResponse + tmp_check_no; // S type field value sum
				tvType.setText("C 유형 : " + cFieldResponse);
			}
		} //if
		
		// progress count
		pg_cnt = pg_cnt +1;
		
        // field value display	
		tvField = (TextView) findViewById(R.id.tv_field_qes);
		tvField.setText(m_AptitudeFuntion.fieldQeustion[pg_cnt]);
		
	}    
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_aptitude, menu);
                                  
        return true;
    }
}
