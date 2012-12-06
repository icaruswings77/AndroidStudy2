package com.lee2day.jobwork;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class AptitudeRsltActivity extends Activity {
	
	private AptitudeFunction m_AptitudeFuntion = null;
	
	// TextView
	TextView txRslt;  			//TextView 유형 안내
	TextView txExpl;  		//TextView 유형 상세 설명
	
	TextView[] txArrScore; 	//TextView 점수 표시
	TextView[] txArrLine; 		//TextView 점수별 라인
	
	public int[] typeScore = new int[6]; 	//유형별 점수
	
	public static String[] typeName; 		//유형별 이름
	
	// private Button button;
	private Button button1;	//R Type
	private Button button2;	//I Type
	private Button button3;	//A Type
	private Button button4;	//S Type
	private Button button5;	//E Type
	private Button button6;	//C Type
    

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aptitude_rslt);
        
        m_AptitudeFuntion = new AptitudeFunction();
        
        // 액티비티로부터 결과 받기
        Intent intent = getIntent();

        typeName = new String[6];  
        
        typeScore[0] = intent.getIntExtra("R_type", -1);
		typeName[0] = "R_type";
		typeScore[1] = intent.getIntExtra("I_type", -1);
		typeName[1] = "I_type";
		typeScore[2] = intent.getIntExtra("A_type", -1);
		typeName[2] = "A_type";
		typeScore[3] = intent.getIntExtra("S_type", -1);
		typeName[3] = "S_type";
		typeScore[4] = intent.getIntExtra("E_type", -1);
		typeName[4] = "E_type";
		typeScore[5] = intent.getIntExtra("C_type", -1);
		typeName[5] = "C_type";
		
		// 점수 및 라인 그리기
		drawScoreLine();
		
		// 버블정렬을 이용하여 최고 성향을 찾는다
		m_AptitudeFuntion.scoreSort(typeScore, typeName);
        
        txRslt = (TextView) findViewById(R.id.tv_type);                
        txExpl = (TextView) findViewById(R.id.tx_expl);
        
        if (typeName[0].equals("R_type")) {
        	txRslt.setText("당신은 실재형이 뛰어납니다.");
            txExpl.setText(m_AptitudeFuntion.r_type_spcl);        	
        } else if (typeName[0].equals("I_type")) {
        	txRslt.setText("당신은 탐구형이 뛰어납니다.");
            txExpl.setText(m_AptitudeFuntion.i_type_spcl);        	
        } else if (typeName[0].equals("A_type")) {
        	txRslt.setText("당신은 예술형이 뛰어납니다.");
            txExpl.setText(m_AptitudeFuntion.a_type_spcl);        	
        } else if (typeName[0].equals("S_type")) {
        	txRslt.setText("당신은 사회형이 뛰어납니다.");
            txExpl.setText(m_AptitudeFuntion.s_type_spcl);        	
        } else if (typeName[0].equals("E_type")) {
        	txRslt.setText("당신은 기업형이 뛰어납니다.");
            txExpl.setText(m_AptitudeFuntion.e_type_spcl);        	
        } else if (typeName[0].equals("C_type")) {
        	txRslt.setText("당신은 관습형이 뛰어납니다.");
            txExpl.setText(m_AptitudeFuntion.c_type_spcl);        	
        }   

        
        //1 button select
		button1 = (Button) findViewById(R.id.bt_01);
		button1.setOnClickListener(new OnClickListener() {
			@Override			
			public void onClick(View arg0) {				
				txExpl.setText(m_AptitudeFuntion.r_type_spcl);				
			}
		});
		
        //2 button select
		button2 = (Button) findViewById(R.id.bt_02);
		button2.setOnClickListener(new OnClickListener() {
			@Override			
			public void onClick(View arg0) {	
				txExpl.setText(m_AptitudeFuntion.i_type_spcl);				
			}
		});
		
        //3 button select
		button3 = (Button) findViewById(R.id.bt_03);
		button3.setOnClickListener(new OnClickListener() {
			@Override			
			public void onClick(View arg0) {					
				txExpl.setText(m_AptitudeFuntion.a_type_spcl);				
			}
		});
		
        //4 button select
		button4 = (Button) findViewById(R.id.bt_04);
		button4.setOnClickListener(new OnClickListener() {
			@Override			
			public void onClick(View arg0) {	
				txExpl.setText(m_AptitudeFuntion.s_type_spcl);				
			}
		});
		
        //5 button select
		button5 = (Button) findViewById(R.id.bt_05);
		button5.setOnClickListener(new OnClickListener() {
			@Override			
			public void onClick(View arg0) {	
				txExpl.setText(m_AptitudeFuntion.e_type_spcl);				
			}
		});
		
        //6 button select
		button6 = (Button) findViewById(R.id.bt_06);
		button6.setOnClickListener(new OnClickListener() {
			@Override			
			public void onClick(View arg0) {	
				txExpl.setText(m_AptitudeFuntion.c_type_spcl);				
			}
		});
    }
     
    
    // 점수 및 라인 표시
	public void drawScoreLine() {
		TextView txArrLine[] 	= new TextView[6];
		TextView txArrScore[] 	= new TextView[6];

		txArrScore[0] = (TextView) findViewById(R.id.tv_score_01);
		txArrScore[1] = (TextView) findViewById(R.id.tv_score_02);
		txArrScore[2] = (TextView) findViewById(R.id.tv_score_03);
		txArrScore[3] = (TextView) findViewById(R.id.tv_score_04);
		txArrScore[4] = (TextView) findViewById(R.id.tv_score_05);
		txArrScore[5] = (TextView) findViewById(R.id.tv_score_06);
		
		// 점수 표시
        for (int i= 0; i < 6; i++) {        	
        	txArrScore[i].setText(" [" + typeScore[i] + "점]");
        }
		
		txArrLine[0] = (TextView) findViewById(R.id.tv_line01);
		txArrLine[1] = (TextView) findViewById(R.id.tv_line02);
		txArrLine[2] = (TextView) findViewById(R.id.tv_line03);
		txArrLine[3] = (TextView) findViewById(R.id.tv_line04);
		txArrLine[4] = (TextView) findViewById(R.id.tv_line05);
		txArrLine[5] = (TextView) findViewById(R.id.tv_line06);	
		  
		// 점수별 라인 표시
        for (int i= 0; i < 6; i++) {   
        	txArrLine[i].setText(m_AptitudeFuntion.drawLine(typeScore[i]));
        }
		
   }
		

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_aptitude, menu);
                                  
        return true;
    }
}
