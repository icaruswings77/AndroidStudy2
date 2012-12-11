package com.lee2day.jobwork;

import java.util.ArrayList;
import android.app.*;
import android.content.*;
import android.database.*;
import android.database.sqlite.*;
import android.os.*;
import android.view.*;
import android.view.View.OnClickListener;
import android.widget.*;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Toast;

public class JobInfoSrchActivity extends Activity {

	private Button button1; // 찾기버튼
	TextView txRslt; //
	ListView listview;

	private static String DB_PATH = "/data/data/com.lee2day.jobwork/databases/"; // 경로명
	private static String DB_NAME = "job.db"; // DB명

	SQLiteDatabase db;
	EditText mText;

	ArrayList<String> jobItems;
	ArrayAdapter<String> adapter;

	// private ListView lsview;
	// String[] jobItems;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_jobinfo_srch);

		DBAdapter m_DBAdapter = new DBAdapter(this);

		mText = (EditText) findViewById(R.id.srch_title);
		txRslt = (TextView) findViewById(R.id.tv_rslt);
		ListView listview = (ListView) findViewById(R.id.ls_01);
		mText.setText("건물");


		// 찾기 button select
		button1 = (Button) findViewById(R.id.bt_01);
		button1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// mText.setText("test click ~~~");
				String searchValue = "";
				searchValue = mText.getText().toString();

				db = SQLiteDatabase.openDatabase(DB_PATH + DB_NAME, null,
						SQLiteDatabase.NO_LOCALIZED_COLLATORS);

				Cursor cursor;
				cursor = db.rawQuery(" SELECT job_cd, job_nm "
						+ "   FROM jobvision" + "  WHERE job_nm LIKE '%"
						+ searchValue + "%'", null);

				String Result = "";

				// ArrayList<Myinfo> listView = new ArrayList<Myinfo>();
				jobItems = new ArrayList<String>();

				while (cursor.moveToNext()) {
					String joc_cd = cursor.getString(0);
					String job_nm = cursor.getString(1);
					Result += (joc_cd + " = " + job_nm + "\n");
					jobItems.add(job_nm);
				}

				// mText.setText("test result");
				if (Result.length() == 0) {
					// mText.setText("Empyt Set");
					txRslt.setText("Empyt Set");

				} else {
					// mText.setText(Result);
					txRslt.setText(Result);
				}

				cursor.close();
				// m_DBAdapter.close();
				invalidate();

			}

		});

		listview.setOnItemClickListener(mainSelect);
	}

	// 리스트 아이템 클릭리스너
	private OnItemClickListener mainSelect = new AdapterView.OnItemClickListener() {
		// (어댑터 뷰, 항목 뷰, 항목의 위치, 항목의 고유 ID)
		public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
			// TODO Auto-generated method stub
			String mes;
			mes = "Select Item = " + jobItems.get(position);
			Toast.makeText(JobInfoSrchActivity.this, mes, Toast.LENGTH_SHORT)
					.show();
			mText.setText( jobItems.get(position));
			
			// 액티비티로 결과값 보내기
			//Intent intent = new Intent(JobInfoSrchActivity.this, JobInfoRsltActivity.class);
			//intent.putExtra("searchValue", jobItems.get(position));
			//startActivityForResult(intent,0);
			
		}
	};

	private void invalidate() {
		// TODO Auto-generated method stub

		adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, jobItems);

		ListView listview = (ListView) findViewById(R.id.ls_01);
		listview.setAdapter(adapter);

	}

	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_job_info, menu);
		return true;
	}

}