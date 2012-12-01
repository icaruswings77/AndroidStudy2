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
	// TextView
	TextView txRslt;  		//TextView 유형 안내
	TextView txExpl;  		//TextView 유형 상세 설명
	
	TextView[] txArrScore; 	//TextView 점수 표시
	TextView[] txArrLine; 	//TextView 점수별 라인
	
	public int[] typeScore = new int[6]; 	//유형별 점수
	
	public static String[] typeNm; 		//유형별 이름
	
	// private Button button;
	private Button button1;	//R Type
	private Button button2;	//I Type
	private Button button3;	//A Type
	private Button button4;	//S Type
	private Button button5;	//E Type
	private Button button6;	//C Type
	
	
    // 유형별 상세 설명
	public static String r_type_spcl =
            "★★★ 실재형 (Realistic) ★★★\n" +
            "○ 장난감이나 가구를 가지고 놀기를 좋아한다. \n" +
            "○ 무뚝뚝하고 말이 적은 편이다. \n" +
            "○ 축구, 농구 등의 운동을 잘한다. \n" +
            "○ 집 안 가檗 제품들에 관심이 많고 고장 나면 나서서 잘 고친다. \n" +
            "○ 조용히 앉아서 지내기보다 뛰어놀기를 좋아한다. \n" +
            " \n" +
            "※ 관련직업 : 제과제빵사, 기계기사, 방송기사, 전산기술자, 컴퓨터기사, 항공기관사";
       
    public static String i_type_spcl =
            "★★★ 탐구형 (Investigative) ★★★\n" +
            "○ 책 읽기를 좋아한다. \n" +
            "○ 지적 호기심이 많다. \n" +
            "○ 질문이 많은 사람이다. \n" +
            "○ 집중력이 강하다. \n" +
            "○ 논리적으로 따지기를 잘한다. \n" +
            "○ 혼자 있기를 좋아한다. \n" +
            "○ 대체로 공부를 잘한다. \n" +
            "○ 여러 자료를 탐색해 보고 신중하게 결정 내리기를 좋아한다. \n" +
            " \n" +
            "※ 관련직업 : 철학자, 수학자, 약사, 교육학자, 생물학자, 수의사, 의사, 번역가";
    
    public static String a_type_spcl =
            "★★★ 예술형 (Artistic) ★★★\n" +
            "○ 예술적인 영역에서 뛰어나다. \n" +
            "○ 엉뚱하고 기발한 생각을 많이 한다. \n" +
            "○ 감정적이고 변덕스럽다. \n" +
            "○ 규칙을 지키는 것이 어렵다. \n" +
            "○ 감정이 예민한 편이다. \n" +
            "○ 간섭 받기를 매우 싫어한다. \n" +
            "○ 정확하고 꼼꼼하게 일을 처리하는 것이 어렵다. \n" +
            "○ 다소 산만해 보일 수 있다. \n" +
            " \n" +
            "※ 관련직업 : 음악평론가, 무용가, 메이크업아티스트, 탤런트, 사진작가, 성우, 애니메이터";

	public static String s_type_spcl =
            "★★★ 사회형 (Social) ★★★\n" +
            "○ 사람을 가르치거나 교육하는 것 \n" +
            "○ 봉사 정신이 강해서 다른 사람을 돕거나 돌보는 일을 좋아한다. \n" +
            "○ 친구들과 어울리기를 좋아하고 친구들이 많다. \n" +
            "○ 타인의 마음을 잘 이해해 주는 사람이다. \n" +
            "○ 혼자서 지내기보다 늘 다른 사람과 함께하려고 한다. \n" +
            "○ 동정심이 많고 다른 사람의 감정에 민감하게 반응한다. \n" +
            " \n" +
            "※ 관련직업 : 상담교사, 목사, 전문MC, 아나운서, 피부미용사";
	
    public static String e_type_spcl =
            "★★★ 기업형 (Enterprising) ★★★\n" +
            "○ 남 앞에 나서기를 좋아한다. \n" +
            "○ 표현력과 리더십이 뛰어나다. \n" +
            "○ 경쟁이나 놀이에서 꼭 이겨야 한다. \n" +
            "○ 친구들 사이에서 대장 역할을 하며 활발하게 어울려 논다. \n" +
            "○ 놀이나 모임에서 사회자가 되기를 더 원한다. \n" +
            "○ 다른 사람과 의견, 아이디어를 나누며 토론하여 결정 내리기를 좋아한다. \n" +
            "○ 보상에 민감하다. \n" +
            " \n" +
            "※ 관련직업 : 경영인, 관리자, 언론인, 판매인, 정치인, 법조인, PD";	
    
    public static String c_type_spcl =
            "★★★ 관습형 (Conventional) ★★★\n" +
            "○ 꼼꼼하고 철두철미하여, 좀처럼 실수를 하지 않고 빈틈없는 사람이다. \n" +
            "○ 학교 준비물을 빠트리지 않고 가려간다. \n" +
            "○ 공부를 할 때도 계획을 세워 계획대로 진행한다. \n" +
            "○ 용돈을 절약하여 저축을 한다. \n" +
            "○ 맡은 일에 끝까지 책임을 다한다. \n" +
            "○ 좀처럼 지각하지 않는다. \n" + 
            "○ 방 청소를 깔끔히 잘한다. \n" +
            "○ 구조화하고 정리하고 마무리 짓는 것을 좋아한다. \n" +
            "○ 한 번에 하나의 과제를 계획한 대로 실행하는 것을 좋아한다. \n" +
            " \n" +
            "※ 관련직업 : 방송스크립터, 회계사, 컴퓨터게임프로그래머, 정보검색사, 공무원";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aptitude_rslt);
        
        // 액티비티로부터 결과 받기
        Intent intent = getIntent();

        typeNm = new String[6];  
        
        typeScore[0] = intent.getIntExtra("R_type", -1);
		typeNm[0] = "R_type";
		typeScore[1] = intent.getIntExtra("I_type", -1);
		typeNm[1] = "I_type";
		typeScore[2] = intent.getIntExtra("A_type", -1);
		typeNm[2] = "A_type";
		typeScore[3] = intent.getIntExtra("S_type", -1);
		typeNm[3] = "S_type";
		typeScore[4] = intent.getIntExtra("E_type", -1);
		typeNm[4] = "E_type";
		typeScore[5] = intent.getIntExtra("C_type", -1);
		typeNm[5] = "C_type";
		
		// 점수 및 라인 그리기
		drawScoreLine();
		
		// 버블정렬을 이용하여 최고 성향을 찾는다
        scoreSort(typeScore);
        
        txRslt = (TextView) findViewById(R.id.tv_type);                
        txExpl = (TextView) findViewById(R.id.tx_expl);
        
        if (typeNm[0].equals("R_type")) {
        	txRslt.setText("당신은 실재형이 뛰어납니다.");
            txExpl.setText(r_type_spcl);        	
        } else if (typeNm[0].equals("I_type")) {
        	txRslt.setText("당신은 탐구형이 뛰어납니다.");
            txExpl.setText(i_type_spcl);        	
        } else if (typeNm[0].equals("A_type")) {
        	txRslt.setText("당신은 예술형이 뛰어납니다.");
            txExpl.setText(a_type_spcl);        	
        } else if (typeNm[0].equals("S_type")) {
        	txRslt.setText("당신은 사회형이 뛰어납니다.");
            txExpl.setText(s_type_spcl);        	
        } else if (typeNm[0].equals("E_type")) {
        	txRslt.setText("당신은 기업형이 뛰어납니다.");
            txExpl.setText(e_type_spcl);        	
        } else if (typeNm[0].equals("C_type")) {
        	txRslt.setText("당신은 관습형이 뛰어납니다.");
            txExpl.setText(c_type_spcl);        	
        }   
        
        

        
        //1 button select
		button1 = (Button) findViewById(R.id.bt_01);
		button1.setOnClickListener(new OnClickListener() {
			@Override			
			public void onClick(View arg0) {				
				txExpl.setText(r_type_spcl);				
			}
		});
		
        //2 button select
		button2 = (Button) findViewById(R.id.bt_02);
		button2.setOnClickListener(new OnClickListener() {
			@Override			
			public void onClick(View arg0) {	
				txExpl.setText(i_type_spcl);				
			}
		});
		
        //3 button select
		button3 = (Button) findViewById(R.id.bt_03);
		button3.setOnClickListener(new OnClickListener() {
			@Override			
			public void onClick(View arg0) {					
				txExpl.setText(a_type_spcl);				
			}
		});
		
        //4 button select
		button4 = (Button) findViewById(R.id.bt_04);
		button4.setOnClickListener(new OnClickListener() {
			@Override			
			public void onClick(View arg0) {	
				txExpl.setText(s_type_spcl);				
			}
		});
		
        //5 button select
		button5 = (Button) findViewById(R.id.bt_05);
		button5.setOnClickListener(new OnClickListener() {
			@Override			
			public void onClick(View arg0) {	
				txExpl.setText(e_type_spcl);				
			}
		});
		
        //6 button select
		button6 = (Button) findViewById(R.id.bt_06);
		button6.setOnClickListener(new OnClickListener() {
			@Override			
			public void onClick(View arg0) {	
				txExpl.setText(c_type_spcl);				
			}
		});
    }
    
    
    // 내림차순으로 버블 소트
    public static void scoreSort(int[] typeScore) {
        int n = typeScore.length;
        
        for (int pass = 1; pass < n; pass++) {
            for (int i = 0; i < n - pass; i++) {
                if (typeScore[i] < typeScore[i + 1]) {
                    int tempScore = typeScore[i];
                    String tempNm = typeNm[i];
                    
                    typeScore[i] = typeScore[i + 1];
                    typeNm[i] = typeNm[i + 1];
                    
                    typeScore[i + 1] = tempScore;
                    typeNm[i + 1] = tempNm;
                    
                }
            }
        }
    }    
    
    // 점수 및 라인 표시
	public void drawScoreLine() {
		TextView txArrLine[] 	= new TextView[6];
		TextView txArrScore[] 	= new TextView[6];

		txArrScore[0] = (TextView) findViewById(R.id.tx_score_01);
		txArrScore[1] = (TextView) findViewById(R.id.tx_score_02);
		txArrScore[2] = (TextView) findViewById(R.id.tx_score_03);
		txArrScore[3] = (TextView) findViewById(R.id.tx_score_04);
		txArrScore[4] = (TextView) findViewById(R.id.tx_score_05);
		txArrScore[5] = (TextView) findViewById(R.id.tx_score_06);
		
		// 점수 표시
        for (int i= 0; i < 6; i++) {        	
        	txArrScore[i].setText(" [" + typeScore[i] + "점]");
        }
		
		txArrLine[0] = (TextView) findViewById(R.id.tx_line01);
		txArrLine[1] = (TextView) findViewById(R.id.tx_line02);
		txArrLine[2] = (TextView) findViewById(R.id.tx_line03);
		txArrLine[3] = (TextView) findViewById(R.id.tx_line04);
		txArrLine[4] = (TextView) findViewById(R.id.tx_line05);
		txArrLine[5] = (TextView) findViewById(R.id.tx_line06);	
		
		// 점수별 라인 표시
        for (int i= 0; i < 6; i++) {        	
        	if (typeScore[i] < 51) {
        		txArrLine[i].setText("■■");
        	} else if (typeScore[i] > 50 && typeScore[i] < 56) {
        		txArrLine[i].setText("■■■■");
        	} else if (typeScore[i] > 55 && typeScore[i] < 61) {
        		txArrLine[i].setText("■■■■■");
        	} else if (typeScore[i] > 60 && typeScore[i] < 66) {
        		txArrLine[i].setText("■■■■■■");        		
        	} else if (typeScore[i] > 65 && typeScore[i] < 71) {
        		txArrLine[i].setText("■■■■■■■");
            } else if (typeScore[i] > 70 && typeScore[i] < 76) {
            	txArrLine[i].setText("■■■■■■■■");
            } else if (typeScore[i] > 75 && typeScore[i] < 81) {
            	txArrLine[i].setText("■■■■■■■■■");
            } else if (typeScore[i] > 80 && typeScore[i] < 86) {
            	txArrLine[i].setText("■■■■■■■■■■");
            } else if (typeScore[i] > 85 && typeScore[i] < 91) {
            	txArrLine[i].setText("■■■■■■■■■■■");            	
            } else if (typeScore[i] > 90 && typeScore[i] < 96) {
            	txArrLine[i].setText("■■■■■■■■■■■■");
            } else if (typeScore[i] > 95) {
            	txArrLine[i].setText("■■■■■■■■■■■■■");
            }
        }        
	}	

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_aptitude, menu);
                                  
        return true;
    }
}
