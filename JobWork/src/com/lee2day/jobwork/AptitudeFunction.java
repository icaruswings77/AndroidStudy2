package com.lee2day.jobwork;

public class AptitudeFunction {
	// 유형별 상세 설명
	public static String r_type_spcl = "★★★ 실재형 (Realistic) ★★★\n"
			+ "○ 장난감이나 가구를 가지고 놀기를 좋아한다. \n" + "○ 무뚝뚝하고 말이 적은 편이다. \n"
			+ "○ 축구, 농구 등의 운동을 잘한다. \n"
			+ "○ 집 안 가檗 제품들에 관심이 많고 고장 나면 나서서 잘 고친다. \n"
			+ "○ 조용히 앉아서 지내기보다 뛰어놀기를 좋아한다. \n" + " \n"
			+ "※ 관련직업 : 제과제빵사, 기계기사, 방송기사, 전산기술자, 컴퓨터기사, 항공기관사";

	public static String i_type_spcl = "★★★ 탐구형 (Investigative) ★★★\n"
			+ "○ 책 읽기를 좋아한다. \n" + "○ 지적 호기심이 많다. \n" + "○ 질문이 많은 사람이다. \n"
			+ "○ 집중력이 강하다. \n" + "○ 논리적으로 따지기를 잘한다. \n" + "○ 혼자 있기를 좋아한다. \n"
			+ "○ 대체로 공부를 잘한다. \n" + "○ 여러 자료를 탐색해 보고 신중하게 결정 내리기를 좋아한다. \n"
			+ " \n" + "※ 관련직업 : 철학자, 수학자, 약사, 교육학자, 생물학자, 수의사, 의사, 번역가";

	public static String a_type_spcl = "★★★ 예술형 (Artistic) ★★★\n"
			+ "○ 예술적인 영역에서 뛰어나다. \n" + "○ 엉뚱하고 기발한 생각을 많이 한다. \n"
			+ "○ 감정적이고 변덕스럽다. \n" + "○ 규칙을 지키는 것이 어렵다. \n"
			+ "○ 감정이 예민한 편이다. \n" + "○ 간섭 받기를 매우 싫어한다. \n"
			+ "○ 정확하고 꼼꼼하게 일을 처리하는 것이 어렵다. \n" + "○ 다소 산만해 보일 수 있다. \n" + " \n"
			+ "※ 관련직업 : 음악평론가, 무용가, 메이크업아티스트, 탤런트, 사진작가, 성우, 애니메이터";

	public static String s_type_spcl = "★★★ 사회형 (Social) ★★★\n"
			+ "○ 사람을 가르치거나 교육하는 것 \n"
			+ "○ 봉사 정신이 강해서 다른 사람을 돕거나 돌보는 일을 좋아한다. \n"
			+ "○ 친구들과 어울리기를 좋아하고 친구들이 많다. \n" + "○ 타인의 마음을 잘 이해해 주는 사람이다. \n"
			+ "○ 혼자서 지내기보다 늘 다른 사람과 함께하려고 한다. \n"
			+ "○ 동정심이 많고 다른 사람의 감정에 민감하게 반응한다. \n" + " \n"
			+ "※ 관련직업 : 상담교사, 목사, 전문MC, 아나운서, 피부미용사";

	public static String e_type_spcl = "★★★ 기업형 (Enterprising) ★★★\n"
			+ "○ 남 앞에 나서기를 좋아한다. \n" + "○ 표현력과 리더십이 뛰어나다. \n"
			+ "○ 경쟁이나 놀이에서 꼭 이겨야 한다. \n"
			+ "○ 친구들 사이에서 대장 역할을 하며 활발하게 어울려 논다. \n"
			+ "○ 놀이나 모임에서 사회자가 되기를 더 원한다. \n"
			+ "○ 다른 사람과 의견, 아이디어를 나누며 토론하여 결정 내리기를 좋아한다. \n" + "○ 보상에 민감하다. \n"
			+ " \n" + "※ 관련직업 : 경영인, 관리자, 언론인, 판매인, 정치인, 법조인, PD";

	public static String c_type_spcl = "★★★ 관습형 (Conventional) ★★★\n"
			+ "○ 꼼꼼하고 철두철미하여, 좀처럼 실수를 하지 않고 빈틈없는 사람이다. \n"
			+ "○ 학교 준비물을 빠트리지 않고 가려간다. \n" + "○ 공부를 할 때도 계획을 세워 계획대로 진행한다. \n"
			+ "○ 용돈을 절약하여 저축을 한다. \n" + "○ 맡은 일에 끝까지 책임을 다한다. \n"
			+ "○ 좀처럼 지각하지 않는다. \n" + "○ 방 청소를 깔끔히 잘한다. \n"
			+ "○ 구조화하고 정리하고 마무리 짓는 것을 좋아한다. \n"
			+ "○ 한 번에 하나의 과제를 계획한 대로 실행하는 것을 좋아한다. \n" + " \n"
			+ "※ 관련직업 : 방송스크립터, 회계사, 컴퓨터게임프로그래머, 정보검색사, 공무원";

	public String[] fieldQeustion;
	
	public AptitudeFunction() {	
		
		fieldQeustion = new String[39];

		fieldQeustion[0] = "진로적성검사 체크 \n" + "(하단의 아무 버튼이나 누르면 시작합니다)";
		// R Type
		fieldQeustion[1] = "자동차와 관련된 일";
		fieldQeustion[2] = "운동 등 몸을 움직이는 일";
		fieldQeustion[3] = "동물을 돌보는 일";
		fieldQeustion[4] = "모형을 조립하거나 만드는 일";
		fieldQeustion[5] = "컴퓨터나 기계를 다루는 일";
		fieldQeustion[6] = "실외(바깥)에서 일하는 것";
		// I Type
		fieldQeustion[7] = "퍼즐(문제) 맞추기";
		fieldQeustion[8] = "실험하기";
		fieldQeustion[9] = "과학과 관련된 연구하기";
		fieldQeustion[10] = "수학 문제 푸는 일";
		fieldQeustion[11] = "관찰, 발견하는 일";
		fieldQeustion[12] = "문제, 상황, 경향 등을 분석하는 일(따져 보는 일)";
		// A Type
		fieldQeustion[13] = "독립적으로(혼자서) 일하는 것";
		fieldQeustion[14] = "예술 또는 음악에 대한 책을 읽는 것";
		fieldQeustion[15] = "창조적으로(남과 다르게) 일하기";
		fieldQeustion[16] = "그림 그리기";
		fieldQeustion[17] = "악기를 연주하거나 노래하는 일";
		fieldQeustion[18] = "글쓰기";
		// S Type
		fieldQeustion[19] = "사람을 가르치거나 교육하는 것";
		fieldQeustion[20] = "다른 사람의 문제 해결을 돕는 것";
		fieldQeustion[21] = "조직을 만들어 함께 일하는 것";
		fieldQeustion[22] = "사람들을 편안하고 즐겁게 해 주는 일";
		fieldQeustion[23] = "사람들을 돕는 일";
		fieldQeustion[24] = "사람들을 위로하기";
		// E Type
		fieldQeustion[25] = "자신의 목표를 세우는 것";
		fieldQeustion[26] = "사람들을 설득하거나 영향을 주는 것";
		fieldQeustion[27] = "물건 파는 일";
		fieldQeustion[28] = "새로운 책임을 맡는 것";
		fieldQeustion[29] = "연설하기";
		fieldQeustion[30] = "지도자가 되는 것";
		// C Type
		fieldQeustion[31] = "컴퓨터로 문서를 만드는 일";
		fieldQeustion[32] = "서류, 사무실 등을 정리하는 것";
		fieldQeustion[33] = "하루 생활을 짜임새 있게 계획하는 일";
		fieldQeustion[34] = "명확한 지시 사항이 있는 일 하기";
		fieldQeustion[35] = "숫자나 그림을 이용하는 일";
		fieldQeustion[36] = "사무실 안에서 일하는 것";

		fieldQeustion[37] = "감사합니다. \n" + "(하단의 아무 버튼이나 누르면 결과가 보입니다.)";
		fieldQeustion[38] = " ";

	}

	// 내림차순으로 버블 소트
	public static void scoreSort(int[] typeScore, String[] typeName) {
		// int n = typeScore.length;
		// for (int pass = 1; pass < (typeScore.length); pass++) {
		for (int pass = 1, n = typeScore.length; pass < n; pass++) {
			for (int i = 0; i < (typeScore.length) - pass; i++) {
				if (typeScore[i] < typeScore[i + 1]) {
					int tempScore = typeScore[i];
					String tempName = typeName[i];

					typeScore[i] = typeScore[i + 1];
					typeName[i] = typeName[i + 1];

					typeScore[i + 1] = tempScore;
					typeName[i + 1] = tempName;
				}
			}
		}
	}

	// 점수별 라인 표시
	public static String drawLine(int intScore) {
		String textLine = "";

		for (int i = 0; i < 6; i++) {
			if (intScore < 51) {
				textLine = "■■";
			} else if (intScore > 50 && intScore < 56) {
				textLine = "■■■■";
			} else if (intScore > 55 && intScore < 61) {
				textLine = "■■■■■";
			} else if (intScore > 60 && intScore < 66) {
				textLine = "■■■■■■";
			} else if (intScore > 65 && intScore < 71) {
				textLine = "■■■■■■■";
			} else if (intScore > 70 && intScore < 76) {
				textLine = "■■■■■■■■";
			} else if (intScore > 75 && intScore < 81) {
				textLine = "■■■■■■■■■";
			} else if (intScore > 80 && intScore < 86) {
				textLine = "■■■■■■■■■■";
			} else if (intScore > 85 && intScore < 91) {
				textLine = "■■■■■■■■■■■";
			} else if (intScore > 90 && intScore < 96) {
				textLine = "■■■■■■■■■■■■";
			} else if (intScore > 95) {
				textLine = "■■■■■■■■■■■■■";
			}
		}
		return textLine;
	}

}
