package com.lee2day.jobwork;

import java.util.ArrayList;
import android.app.*;
import android.database.*;
import android.database.sqlite.*;
import android.os.*;
import android.view.*;
import android.view.View.OnClickListener;
import android.widget.*;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Toast;

public class JobInfoRsltActivity extends Activity {

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
		setContentView(R.layout.activity_jobinfo_rslt);

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


	}


	private void invalidate() {
		// TODO Auto-generated method stub

		adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, jobItems);

		ListView listview = (ListView) findViewById(R.id.ls_01);
		listview.setAdapter(adapter);

	}

	public void mOnClick(View v) {

		switch (v.getId()) {
		case R.id.insert:
			// //db = mHelper.getWritableDatabase();
			// // insert �޼���� ����
			// row = new ContentValues();
			// row.put("iname", "���±�");
			// row.put("telno", "01012345678");
			// db.insert("smsjuso", null, row);
			// // SQL ������� ����
			// db.execSQL("INSERT INTO smsjuso VALUES (null, '�Կ��', '01088887777');");
			// //mHelper.close();
			// mText.setText("Insert Success");
			break;
		case R.id.delete:
			// //db = mHelper.getWritableDatabase();
			// // delete �޼���� ����
			// db.delete("smsjuso", null, null);
			// // SQL ������� ����
			// // db.execSQL("DELETE FROM smsjuso;");
			// //mHelper.close();
			// mText.setText("Delete Success");
			break;
		case R.id.update:
			// //db = mHelper.getWritableDatabase();
			// // update �޼���� ����
			// row = new ContentValues();
			// row.put("���±�", "01012345678");
			// // db.update("smsjuso", row, "iname = '������'", null);
			// // SQL ������� ����
			// //db.execSQL("UPDATE smsjuso SET iname = '�̿���' WHERE telno = '01088887777';");
			// ////mHelper.close();
			// mText.setText("Update Success");
			break;
		case R.id.select:
			// db = m_DBAdapter.getReadableDatabase();
			// //SQLiteDatabase.openDatabase("/data/data/com.lee2day.jobwork/databases/job.db",
			// null,
			// // SQLiteDatabase.NO_LOCALIZED_COLLATORS);
			// //db = m_DBAdapter.getReadableDatabase();
			//
			// Cursor cursor;
			// cursor = db.rawQuery("SELECT job_cd, job_nm FROM jobwork", null);
			//
			// String Result = "";
			// while (cursor.moveToNext()) {
			// String joc_cd = cursor.getString(0);
			// String job_nm = cursor.getString(1);
			// Result += (joc_cd + " = " + job_nm + "\n");
			// }
			//
			// if (Result.length() == 0) {
			// mText.setText("Empyt Set");
			// } else {
			// mText.setText(Result);
			// }
			// cursor.close();
			// m_DBAdapter.close();
			// //mText.setText("Empyt Set");
			// break;
		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_job_info, menu);
		return true;
	}

}