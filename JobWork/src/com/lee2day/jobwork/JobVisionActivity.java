package com.lee2day.jobwork;

import java.io.IOException;
import java.util.ArrayList;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class JobVisionActivity extends Activity {

	private Button button1; // 찾기버튼

	private static String DB_PATH = "/data/data/com.lee2day.jobwork/databases/"; // 경로명
	private static String DB_NAME = "job.db"; // DB명
	
	EditText edTitle;
	EditText etJobCode;
	EditText etJobName;
	EditText etJobVision;

	TextView txRslt; //

	ListView listview;

	// 제네릭 클래스
	ArrayList<String> jobItems;
	ArrayAdapter<String> adapter;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_job_vision);

		// 신규 디비 카피하는 경우에 사용
		DBAdapter m_DBAdapter = new DBAdapter(this);

		edTitle = (EditText) findViewById(R.id.ed_title);
		txRslt = (TextView) findViewById(R.id.tv_rslt);
		ListView listview = (ListView) findViewById(R.id.ls_01);
		
		// 임시
		//edTitle.setText("건설");

		// 찾기 button select
		button1 = (Button) findViewById(R.id.bt_01);
		button1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				SQLiteDatabase db;

				String searchValue = "";
				searchValue = edTitle.getText().toString();

				// DB Open
				db = SQLiteDatabase.openDatabase(DB_PATH + DB_NAME, null,
						SQLiteDatabase.NO_LOCALIZED_COLLATORS);

				Cursor cursor;
				cursor = db.rawQuery(" SELECT job_cd, job_nm "
						+ " FROM jobvision" + "  WHERE job_nm LIKE '%"
						+ searchValue + "%'", null);

				String Result = "";

				// ListView에 표현되는 Array
				jobItems = new ArrayList<String>();

				while (cursor.moveToNext()) {
					String joc_cd = cursor.getString(0);
					String job_nm = cursor.getString(1);
					Result += (joc_cd + " = " + job_nm + "\n");
					jobItems.add(joc_cd + " : " + job_nm);
				}

				if (Result.length() == 0) {
					txRslt.setText("조회할 자료가 없습니다.");
				} else {
					txRslt.setText(Result);
				}
				cursor.close();
				db.close();
				
				invalidate();
			}
		});

		listview.setOnItemClickListener(mainSelect);
	}

	// 리스트 아이템 클릭리스너
	private OnItemClickListener mainSelect = new AdapterView.OnItemClickListener() {
		// (어댑터 뷰, 항목 뷰, 항목의 위치, 항목의 고유 ID)
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			// 토스트 메세지로 상태 알아보기
			// String mes;
			// mes = "Select Item = " + jobItems.get(position);
			// Toast.makeText(JobVisionActivity.this, mes,
			// Toast.LENGTH_SHORT).show();
			// edTitle.setText( jobItems.get(position));
			String jobCode = "";
			jobCode = jobItems.get(position).substring(0, 4);
			selectJobVision(jobCode);

			// 다른 액티비티로 결과값 보내기
			// Intent intent = new Intent(JobInfoSrchActivity.this,
			// JobInfoRsltActivity.class);
			// intent.putExtra("searchValue", jobItems.get(position));
			// startActivityForResult(intent,0);
		}
	};

	private void selectJobVision(String searchValue) {
		SQLiteDatabase db;
        
		// DB Open
		db = SQLiteDatabase.openDatabase(DB_PATH + DB_NAME, null,
				SQLiteDatabase.NO_LOCALIZED_COLLATORS);

		Cursor cursor;
		cursor = db.rawQuery(" SELECT job_cd, job_nm, job_vision "
				+ "   FROM jobvision" + "  WHERE job_cd LIKE '%" + searchValue
				+ "%'", null);

		String Result 		= "";
		String job_cd 		= "";
		String job_nm 		= "";
		String job_vision 	= "";

		while (cursor.moveToNext()) {
			job_cd = cursor.getString(0);
			job_nm = cursor.getString(1);
			job_vision = cursor.getString(2);
			Result += (job_cd + " = " + job_nm + "\n");
		}

		etJobCode 	= (EditText) findViewById(R.id.et_job_code);
		etJobName 	= (EditText) findViewById(R.id.et_job_name);
		etJobVision = (EditText) findViewById(R.id.et_job_vision);

		if (Result.length() == 0) {
			txRslt.setText("조회할 자료가 없습니다.");
		} else {
			etJobCode.setText(job_cd);
			etJobName.setText(job_nm);
			etJobVision.setText(job_vision);
			txRslt.setText(job_vision);
		}

		cursor.close();
		db.close();
	}

	private void invalidate() {
		// ArrayAdapter 연결하기
		adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, jobItems);

		ListView listview = (ListView) findViewById(R.id.ls_01);
		listview.setAdapter(adapter);

	}

	public boolean validation() {
		String checkValue = null;

		String jobCode 	= etJobCode.getText().toString();
		String jobName 	= etJobName.getText().toString();
		String jobVision = etJobVision.getText().toString();
		
		if ("".equals(jobCode) || "".equals(jobName) || "".equals(jobVision)) { 
			checkValue = null;
		} else {
			checkValue = "Y";
		}	
		return checkValue != null ? true : false;
	}	

	public void mOnClick(View v) {
		SQLiteDatabase db;
		DBAdapter m_DBAdapter = new DBAdapter(this);
		m_DBAdapter.getWritableDatabase();
		
		// DB Open
		db = SQLiteDatabase.openDatabase(DB_PATH + DB_NAME, null,
				SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		 
		
		switch (v.getId()) {
		case R.id.insert:
			if (validation()) { // 데이터가 있는지 체크
				db.execSQL("INSERT INTO jobvision VALUES ('"
						+ etJobCode.getText().toString() + "', '"
						+ etJobName.getText().toString() + "', '"
						+ etJobVision.getText().toString() + "');");

				db.close();
				txRslt.setText("Insert Success");
			}			
			break;
		case R.id.delete:
			if (validation()) { // 데이터가 있는지 체크
				db.execSQL("DELETE FROM jobvision WHERE job_cd = '"
						+ etJobCode.getText().toString() + "';");
				db.close();
				txRslt.setText("Delete Success");
			}				
			break;
		case R.id.update:
			if (validation()) { // 데이터가 있는지 체크
				db.execSQL("UPDATE jobvision SET job_nm = '"
						+ etJobName.getText().toString() + "', " + "job_vision = '"
						+ etJobVision.getText().toString() + "' "
						+ " WHERE job_cd = '" + etJobCode.getText().toString() + "';");
				db.close();
				txRslt.setText("Update Success");
			}				
			break;
		case R.id.select:
			txRslt.setText("Select Success");
			Toast.makeText(JobVisionActivity.this, "위 버튼으로 검색하세요",
					Toast.LENGTH_SHORT).show();
		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_job_info, menu);
		return true;
	}

}