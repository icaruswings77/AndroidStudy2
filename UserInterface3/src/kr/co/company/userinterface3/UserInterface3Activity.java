package kr.co.company.userinterface3;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;

public class UserInterface3Activity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		Button b1 = (Button) findViewById(R.id.button1);
		b1.setText("코드에서도 변경 가능 알라뷰~  ");

		Button b2 = (Button) findViewById(R.id.button2);
		b2.setEnabled(false);
    }

      
}
