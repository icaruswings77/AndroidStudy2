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
		b1.setText("�ڵ忡���� ���� ���� �˶��~  ");

		Button b2 = (Button) findViewById(R.id.button2);
		b2.setEnabled(false);
    }

      
}
