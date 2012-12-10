package com.lee2day.jobwork;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

//http://crlog.com/49

// http://vulpecula.tistory.com/31 Site 참조
// .sqlite 파일에 테이블 추가 android_metadata local en_US

// 미리 생성된 .db 파일을 안드로이드 프로젝트의 assets에 위치
// 어플에서 사용하는 SQLite의 db 파일이 생성되는 기본 경로
// /data/data/[PACKAGE_NAME]/databases/[DB_FILE_NAME] 

public class DBAdapter {
	// public class DBAdapter extends SQLiteOpenHelper{
	private final Context context;
	private DatabaseHelper DBHelper;
	private SQLiteDatabase db;
	private static String DB_PATH = "/data/data/com.lee2day.jobwork/databases/";
	private static String DB_NAME = "job.db";


	public DBAdapter(Context ctx) {
		this.context = ctx;
		DBHelper = new DatabaseHelper(this.context);
		try {
			DBHelper.createDatabase();
			DBHelper.openDataBase();
		} catch (IOException e) {
			Log.d("DBAdapter", e.toString());
		} catch (SQLException e) {
			Log.d("DBAdapter", e.toString());
		}
	}

	private static class DatabaseHelper extends SQLiteOpenHelper {
		private SQLiteDatabase sqlite;
		private final Context crContext;

		DatabaseHelper(Context context) {
			super(context, DB_NAME, null, 3);
			this.crContext = context;
		}

		public void createDatabase() throws IOException {
			if (!checkDatabase()) {
				this.getReadableDatabase();
				try {
					copyDatabase();
				} catch (IOException e) {
					throw new Error("Error copying database");
				}
			}
		}

		public boolean checkDatabase() {
			SQLiteDatabase checkDB = null;
			try {
				String myPath = DB_PATH + DB_NAME;
				checkDB = SQLiteDatabase.openDatabase(myPath, null,
						SQLiteDatabase.NO_LOCALIZED_COLLATORS);

			} catch (SQLiteException e) {
				Log.d("checkDatabase", e.toString());
			}

			if (checkDB != null) {
				checkDB.close();
			}
			return checkDB != null ? true : false;
		}

		private void copyDatabase() throws IOException {
			InputStream myInput = crContext.getAssets().open(DB_NAME);

			String outFileName = DB_PATH + DB_NAME;
			OutputStream myOutput = new FileOutputStream(outFileName);

			byte[] buffer = new byte[1024];
			int length;
			while ((length = myInput.read(buffer)) > 0) {
				myOutput.write(buffer, 0, length);
			}
			myOutput.flush();
			myOutput.close();
			myInput.close();
		}

		public void openDataBase() throws SQLException {
			String myPath = DB_PATH + DB_NAME;
			sqlite = SQLiteDatabase.openDatabase(myPath, null,
					SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		}

		@Override
		public synchronized void close() {
			if (sqlite != null)
				sqlite.close();
			super.close();
		}

		@Override
		public void onCreate(SQLiteDatabase db) {
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		}
	}

	public DBAdapter open() throws SQLException {
		db = DBHelper.getWritableDatabase();
		return this;
	}

	public void close() {
		DBHelper.close();
	}

	public SQLiteDatabase getReadableDatabase() {
		// TODO Auto-generated method stub
		db = DBHelper.getReadableDatabase();
		return null;
	}

}
