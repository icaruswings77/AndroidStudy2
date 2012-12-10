package com.lee2day.jobwork;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

//import android.content.Context;
//import android.database.sqlite.SQLiteDatabase;
//import android.database.sqlite.SQLiteOpenHelper;

// http://vulpecula.tistory.com/31 Site 참조
// .sqlite 파일에 테이블 추가 android_metadata local en_US

// 미리 생성된 .db 파일을 안드로이드 프로젝트의 assets에 위치
// 어플에서 사용하는 SQLite의 db 파일이 생성되는 기본 경로
// /data/data/[PACKAGE_NAME]/databases/[DB_FILE_NAME] 

public class DBAccess extends SQLiteOpenHelper{
    private static String DB_PATH = " /data/data/com.lee2day.jobwork/databases/";
    private static String DB_NAME = "jobwork.db";
    public SQLiteDatabase myDataBase;
    private final Context myContext;

    public DBAccess(Context context) {
    	super(context, DB_NAME, null, 1);
    	this.myContext = context;
    }

    public void createDataBase() throws IOException {
	SQLiteDatabase checkDB = null;   
	try {
		String myPath = DB_PATH + DB_NAME;
		checkDB = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
	}catch(SQLiteException e){
	}
	
	if(checkDB != null){
		checkDB.close();
   	}
	boolean dbExist = checkDB != null ? true : false;
	
	if(dbExist){
	}else{
	   this.getReadableDatabase();
	   try{
		   InputStream myInput = myContext.getAssets().open(DB_NAME);
		   String outFileName = DB_PATH + DB_NAME;
		   OutputStream  myOutput = new FileOutputStream(outFileName);
		   byte[] buffer = new byte[1024];
		   int length;
		   while ((length = myInput.read(buffer))>0) {
			   myOutput.write(buffer, 0, length);
		   }
		   myOutput.flush();
		   myOutput.close();
		   myInput.close();
	   }catch(IOException e) {
		throw new Error("Error copying database");
	   }
   }
}

    public void openDataBase() {
        String myPath = DB_PATH + DB_NAME;
        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase. NO_LOCALIZED_COLLATORS);
    }

    public synchronized void close() {
    	if (myDataBase != null)
    		myDataBase.close();
    	super.close();
	}

    public ArrayList<String> getRecruitJobtype(){
    	ArrayList<String> ar = new ArrayList<String>();
    	Cursor c = myDataBase.rawQuery("select * from jobwork", null);

    	while(c.moveToNext()){
    		String name = c.getString(2);
    		Log.d("t", name);
    		ar.add(name);
    	}
    	return ar;
    }

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}
}
