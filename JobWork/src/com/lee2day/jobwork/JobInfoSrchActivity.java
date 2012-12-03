package com.lee2day.jobwork;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.res.AssetManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.provider.SyncStateContract.Constants;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

public class JobInfoSrchActivity extends Activity {
	JusoDBHelper mHelper;
	EditText mText;	
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jobinfo_srch);
		mHelper = new JusoDBHelper(this);
		mText = (EditText) findViewById(R.id.srch_title);
    }
    

	public void mOnClick(View v) {
		SQLiteDatabase db;
		ContentValues row;
		switch (v.getId()) {
		case R.id.insert:
			db = mHelper.getWritableDatabase();
			// insert 
			row = new ContentValues();
			row.put("job_cd", "0101001");
			row.put("job_nm", "경영자");
			db.insert("jobwork", null, row);
			// SQL 바로 투입
			//db.execSQL("INSERT INTO jobwork VALUES (null, '0101002', '방송인');");
			mHelper.close();
			mText.setText("Insert Success");
			break;
		case R.id.delete:
			db = mHelper.getWritableDatabase();
			// delete
			//db.delete("jobwork", null, null);
			// SQL 
			db.execSQL("DELETE FROM jobwork;");
			mHelper.close();
			mText.setText("Delete Success");
			break;
		case R.id.update:
			db = mHelper.getWritableDatabase();
			// update
			//row = new ContentValues();
			//row.put("0101001", "청소부");
			 //db.update("jobwork", row, "job_cd = '0101001'", null);
			// SQL 
			db.execSQL("UPDATE jobwork SET job_nm = '청소부' WHERE job_cd = '0101001' ;");
			mHelper.close();
			mText.setText("Update Success");
			break;
		case R.id.select:
			db = mHelper.getReadableDatabase();
			Cursor cursor;

			cursor = db.rawQuery("SELECT job_cd, job_nm FROM jobwork", null);

			String Result = "";
			while (cursor.moveToNext()) {
				String job_cd = cursor.getString(0);
				String job_nm = cursor.getString(1);
				Result += (job_cd + " = " + job_nm + "\n");
			}

			if (Result.length() == 0) {
				mText.setText("Empyt Set");
			} else {
				mText.setText(Result);
			}
			cursor.close();
			mHelper.close();
			break;
		}
	}


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_job_info, menu);
        return true;
    }
    
    // 미리 생성된 .db 파일을 안드로이드 프로젝트의 assets에 위치
    // 어플에서 사용하는 SQLite의 db 파일이 생성되는 기본 경로
    // /data/data/[PACKAGE_NAME]/databases/[DB_FILE_NAME] 
    /*
	private void copySQLiteDB(Context context) {
		AssetManager manager = context.getAssets();
		String filePath = "/data/data/" + com.lee2day.jobwork
				+ "/databases/" + jobwork.db;
		File file = new File(filePath);
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		try {
			InputStream is = manager.open("db/" + Constants.jobwork.db);
			BufferedInputStream bis = new BufferedInputStream(is);
			if (file.exists()) {
				file.delete();
				file.createNewFile();
			}
			fos = new FileOutputStream(file);
			bos = new BufferedOutputStream(fos);
			int read = -1;
			byte[] buffer = new byte[1024];
			while ((read = bis.read(buffer, 0, 1024)) != -1) {
				bos.write(buffer, 0, read);
			}
			bos.flush();
			bos.close();
			fos.close();
			bis.close();
			is.close();
		} catch (IOException e) {
			Log.e("ErrorMessage : ", e.getMessage());
		}
	}
*/	
}


class JusoDBHelper extends SQLiteOpenHelper {
	public JusoDBHelper(Context context) {
		super(context, "jobwork.db", null, 1);
	}

	public void onCreate(SQLiteDatabase db) {
		db.execSQL("CREATE TABLE jobwork ( _id INTEGER PRIMARY KEY AUTOINCREMENT, "
		        + "job_cd TEXT, job_nm TEXT, large_class TEXT, large_nm TEXT, middle_class TEXT, middle_name TEXT, " 
		        + "info_work TEXT, info_meth TEXT, info_view TEXT);");
	}

	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS jobwork");
		onCreate(db);
	}
}

