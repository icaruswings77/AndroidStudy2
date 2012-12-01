package com.lee2day.jobwork;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class AptitudeTestActivity extends Activity {
	
	// private Button button;
	private Button button1;
	private Button button2;
	private Button button3;
	private Button button4;	
	private Button button5;
	private Button button6;	
	
	// crrent progress type
	//public String pg_type = "R";
	// 현재 진행중 순서
	public int pg_cnt = 0;
	
	// type field response value	
	public static int r_field_res = 0;
	public static int i_field_res = 0;
	public static int a_field_res = 0;
	public static int s_field_res = 0;
	public static int e_field_res = 0;
	public static int c_field_res = 0;

	// type field qeustion value	
//	public static String r_field_qes[];
//	public static String i_field_qes[];
//	public static String a_field_qes[];
//	public static String s_field_qes[];
//	public static String e_field_qes[];
//	public static String c_field_qes[];
	
	public static String[] str_field_qes;
	
	TextView tvField;
	TextView tvType;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aptitude_test);
        
        str_field_qes = new String[39];         
        str_field_qes[0] = "진로적성검사 체크 \n" + 
                           "(하단의 아무 버튼이나 누르면 시작합니다)";
        //R Type
        str_field_qes[1] = "자동차와 관련된 일";
        str_field_qes[2] = "운동 등 몸을 움직이는 일";
        str_field_qes[3] = "동물을 돌보는 일";
        str_field_qes[4] = "모형을 조립하거나 만드는 일";
        str_field_qes[5] = "컴퓨터나 기계를 다루는 일";
        str_field_qes[6] = "실외(바깥)에서 일하는 것";
        //I Type
        str_field_qes[7] = "퍼즐(문제) 맞추기";
        str_field_qes[8] = "실험하기";
        str_field_qes[9] = "과학과 관련된 연구하기";
        str_field_qes[10] = "수학 문제 푸는 일";
        str_field_qes[11] = "관찰, 발견하는 일";
        str_field_qes[12] = "문제, 상황, 경향 등을 분석하는 일(따져 보는 일)";
        //A Type
        str_field_qes[13] = "독립적으로(혼자서) 일하는 것";
        str_field_qes[14] = "예술 또는 음악에 대한 책을 읽는 것";
        str_field_qes[15] = "창조적으로(남과 다르게) 일하기";
        str_field_qes[16] = "그림 그리기";
        str_field_qes[17] = "악기를 연주하거나 노래하는 일";
        str_field_qes[18] = "글쓰기";
        //S Type
        str_field_qes[19] = "사람을 가르치거나 교육하는 것";
        str_field_qes[20] = "다른 사람의 문제 해결을 돕는 것";
        str_field_qes[21] = "조직을 만들어 함께 일하는 것";
        str_field_qes[22] = "사람들을 편안하고 즐겁게 해 주는 일";
        str_field_qes[23] = "사람들을 돕는 일";
        str_field_qes[24] = "사람들을 위로하기";
        //E Type
        str_field_qes[25] = "자신의 목표를 세우는 것";
        str_field_qes[26] = "사람들을 설득하거나 영향을 주는 것";
        str_field_qes[27] = "물건 파는 일";
        str_field_qes[28] = "새로운 책임을 맡는 것";
        str_field_qes[29] = "연설하기";
        str_field_qes[30] = "지도자가 되는 것";
        //C Type
        str_field_qes[31] = "컴퓨터로 문서를 만드는 일";
        str_field_qes[32] = "서류, 사무실 등을 정리하는 것";
        str_field_qes[33] = "하루 생활을 짜임새 있게 계획하는 일";
        str_field_qes[34] = "명확한 지시 사항이 있는 일 하기";
        str_field_qes[35] = "숫자나 그림을 이용하는 일";
        str_field_qes[36] = "사무실 안에서 일하는 것";
        
        str_field_qes[37] = "감사합니다. \n" + 
                            "(하단의 아무 버튼이나 누르면 결과가 보입니다.)";
        str_field_qes[38] = " ";

        
        tvField = (TextView) findViewById(R.id.tv_field_qes);
        tvField.setText(str_field_qes[0]);


        //1 button select
		button1 = (Button) findViewById(R.id.bt_check01);
		button1.setOnClickListener(new OnClickListener() {
			@Override			
			public void onClick(View arg0) {				
				TestCalc("1");
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
				
				r_field_res = 0;
				i_field_res = 0;
				a_field_res = 0;
				s_field_res = 0;
				e_field_res = 0;
				c_field_res = 0;

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
				
				r_field_res = 0;
				i_field_res = 0;
				a_field_res = 0;
				s_field_res = 0;
				e_field_res = 0;
				c_field_res = 0;
				
				tvField.setText(str_field_qes[0]);
			}
		});		
		
		               
    }
    
	public void TestCalc(String check_no) {
		int tmp_check_no = 0;
				
		if (pg_cnt > 36){
			pg_cnt = 37;
			// 임시
//			r_field_res = 85;
//			i_field_res = 75;
//			a_field_res = 82;
//			s_field_res = 95;
//			e_field_res = 77;
//			c_field_res = 77;
			
			// 액티비티로 결과값 보내기
			Intent intent = new Intent(AptitudeTestActivity.this, AptitudeRsltActivity.class);
			intent.putExtra("R_type", r_field_res);
			intent.putExtra("I_type", i_field_res);
			intent.putExtra("A_type", a_field_res);
			intent.putExtra("S_type", s_field_res);
			intent.putExtra("E_type", e_field_res);
			intent.putExtra("C_type", c_field_res);

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
				r_field_res = r_field_res + tmp_check_no; // R type field value sum
				tvType.setText("R 유형 : " + r_field_res);
			} else if (pg_cnt > 6 && pg_cnt < 13) {
				i_field_res = i_field_res + tmp_check_no; // I type field value sum
				tvType.setText("I 유형 : " + i_field_res);
			} else if (pg_cnt > 12 && pg_cnt < 19) {
				a_field_res = a_field_res + tmp_check_no; // A type field value sum
				tvType.setText("A 유형 : " + a_field_res);
			} else if (pg_cnt > 18 && pg_cnt < 25) {
				s_field_res = s_field_res + tmp_check_no; // S type field value sum
				tvType.setText("S 유형 : " + s_field_res);
			} else if (pg_cnt > 24 && pg_cnt < 31) {
				e_field_res = e_field_res + tmp_check_no; // E type field value sum
				tvType.setText("E 유형 : " + e_field_res);
			} else if (pg_cnt > 30 && pg_cnt < 37) {
				c_field_res = c_field_res + tmp_check_no; // S type field value sum
				tvType.setText("S 유형 : " + s_field_res);
			}
		} //if
		
		// progress count
		pg_cnt = pg_cnt +1;
		
        // field value display	
		tvField = (TextView) findViewById(R.id.tv_field_qes);
		tvField.setText(str_field_qes[pg_cnt]);
		
	}    
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_aptitude, menu);
                                  
        return true;
    }
}
