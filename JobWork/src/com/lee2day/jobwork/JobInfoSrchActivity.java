package com.lee2day.jobwork;

import java.io.*;

import android.app.*;
import android.content.*;
import android.content.res.*;
import android.database.*;
import android.database.sqlite.*;
import android.os.*;
import android.util.*;
import android.view.*;
import android.widget.*;
// 엑셀변환
//http://www.reigndesign.com/blog/using-your-own-sqlite-database-in-android-applications/
//Function 초성(S$)
//Application.Volatile True
//Const 초성값 = "ㄱㄲㄴㄷㄸㄹㅁㅂㅃㅅㅆㅇㅈㅉㅊㅋㅌㅍㅎ"
//Dim TxT$, i, k
//For i = 1 To Len(S)
//    TxT = Mid$(S, i, 1)
//    If InStr(초성값, TxT) Then
//       초성 = 초성 & TxT
//    Else
//        k = AscW(TxT)
//        If k >= &HAC00 And k <= &HD7A3 Then 초성 = 초성 & Mid(초성값, Int((k - &HAC00) / 588) + 1, 1)
//    End If
//Next i
//초성 = IIf(초성 = 0, "", 초성)
//End Function


public class JobInfoSrchActivity extends Activity {

	//JusoDBHelper mHelper;
	private DBAdapter m_DBAdapter = null;
	SQLiteDatabase db;
	EditText mText;	
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jobinfo_srch);
		
		DBAdapter m_DBAdapter = new DBAdapter(this);	
		
		
		//SQLiteDatabase.openDatabase("/data/data/com.lee2day.jobwork/databases/job.db", null,
		//		SQLiteDatabase.NO_LOCALIZED_COLLATORS);		
		db = m_DBAdapter.getReadableDatabase();
		ContentValues row;
		
       // mHelper = new JusoDBHelper(this);
		//mText = (EditText) findViewById(R.id.srch_title);

    }
    

	public void mOnClick(View v) {

		
		switch (v.getId()) {
//		case R.id.insert:
//			//db = mHelper.getWritableDatabase();
//			// insert �޼���� ����
//			row = new ContentValues();
//			row.put("iname", "���±�");
//			row.put("telno", "01012345678");
//			db.insert("smsjuso", null, row);
//			// SQL ������� ����
//			db.execSQL("INSERT INTO smsjuso VALUES (null, '�Կ��', '01088887777');");
//			//mHelper.close();
//			mText.setText("Insert Success");
//			break;
//		case R.id.delete:
//			//db = mHelper.getWritableDatabase();
//			// delete �޼���� ����
//			db.delete("smsjuso", null, null);
//			// SQL ������� ����
//			// db.execSQL("DELETE FROM smsjuso;");
//			//mHelper.close();
//			mText.setText("Delete Success");
//			break;
		case R.id.update:
//			//db = mHelper.getWritableDatabase();
//			// update �޼���� ����
//			row = new ContentValues();
//			row.put("���±�", "01012345678");
//			// db.update("smsjuso", row, "iname = '������'", null);
//			// SQL ������� ����
//			//db.execSQL("UPDATE smsjuso SET iname = '�̿���' WHERE telno = '01088887777';");
//			////mHelper.close();
//			mText.setText("Update Success");
			break;
		case R.id.select:

			Cursor cursor;
			cursor = db.rawQuery("SELECT job_cd, job_nm FROM jobwork", null);

			String Result = "";
			while (cursor.moveToNext()) {
				String joc_cd = cursor.getString(0);
				String job_nm = cursor.getString(1);
				Result += (joc_cd + " = " + job_nm + "\n");
			}

			if (Result.length() == 0) {
				mText.setText("Empyt Set");
			} else {
				mText.setText(Result);
			}
			cursor.close();
			m_DBAdapter.close();
			break;
		}
	}
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_job_info, menu);
        return true;
    }
	
}
class JusoDBHelper extends SQLiteOpenHelper {
	private static final Activity JobInfoSrchActivity = null;
	private SQLiteDatabase sqlite;
	private static String DB_PATH = "/data/data/com.lee2day.jobwork/databases/";
	//private static String DB_PATH = "/data/data/com/lee2day/jobwork/databases/";
	private static String DB_NAME = "smsjuso.db";
	private final Context crContext;
	
	public JusoDBHelper(Context context) {
		super(context, DB_NAME, null, 1);
		this.crContext = context;
	}

	public void onCreate(SQLiteDatabase db) {
		//db.execSQL("CREATE TABLE smsjuso ( _id INTEGER PRIMARY KEY AUTOINCREMENT, " + "iname TEXT, telno TEXT);");
		this.getReadableDatabase();
		//this.getWritableDatabase();
		//getWritableDatabase
		try {
			//copyDatabase();
			//InitDataBase();
			//copydb(JobInfoSrchActivity);
			copyDatabase();
			openDataBase();
			
		} catch (IOException e) {
			throw new Error("Error copying database");
		}

	}

	
	
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		//db.execSQL("DROP TABLE IF EXISTS jobwork");
		//onCreate(db);
	}
	
	
	private void copyDatabase() throws IOException {
		SQLiteDatabase checkDB = null;
		checkDB = SQLiteDatabase.openDatabase(DB_PATH + DB_NAME, null,
				SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		
		   InputStream myInput = crContext.getAssets().open(DB_NAME);
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
	}	

	//private void copydb(Activity act) {
	private void copydb(Activity act) {
		 
		AssetManager am = act.getAssets();
		File f = new File("/data/data/com.lee2day.jobwork/databases/jobwork_db.sqlite");
 
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
 
		try {
 
			InputStream is = am.open("jobwork_db.sqlite");
			BufferedInputStream bis = new BufferedInputStream(is);
 
			// 만약에 파일이 있다면 지우고 다시 생성
			if (f.exists()) {
				f.delete();
				f.createNewFile();
			}
			fos = new FileOutputStream(f);
			bos = new BufferedOutputStream(fos);
 
			int read = -1;
			byte[] buffer = new byte[1024];
			while ((read = bis.read(buffer, 0, 1024)) != -1) {
				bos.write(buffer, 0, read);
			}
			bos.flush();
 
			fos.close();
			bos.close();
			is.close();
			bis.close();
 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void InitDataBase() {

		//final String ROOT_DIR = "/data/data/com.example.ax/databases/";

		//final String DATABASE_NAME = DB이름;

		File folder = new File(DB_PATH);

		folder.mkdirs();

		File outfile = new File(DB_PATH + DB_NAME);

		//InputStream assetManager =  crContext.getAssets().open(DB_NAME); //crContext.getActivity().getAssets();

		InputStream iStream = null;

		try {

			//iStream = InputStream.open("ax_www/" + DB_NAME, AssetManager.ACCESS_BUFFER);

			long filesize = iStream.available();

			byte[] tempdata = new byte[(int) filesize];

			iStream.read(tempdata);

			iStream.close();

			outfile.createNewFile();

			FileOutputStream fos = new FileOutputStream(outfile);

			fos.write(tempdata);

			fos.close();

			Log.i("DB Copy", "success");

		} catch (IOException e) {

			e.printStackTrace();

		}

	}
	public void openDataBase() throws SQLException {
		String myPath = DB_PATH + DB_NAME;
		sqlite = SQLiteDatabase.openDatabase(myPath, null,
				SQLiteDatabase.NO_LOCALIZED_COLLATORS);
	}	
}