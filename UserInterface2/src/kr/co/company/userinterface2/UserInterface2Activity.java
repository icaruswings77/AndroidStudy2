package kr.co.company.userinterface2;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.LinearLayout;
import android.support.v4.app.NavUtils;

public class UserInterface2Activity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);

		LinearLayout container = new LinearLayout(this);
		container.setOrientation(LinearLayout.VERTICAL);

		Button b1 = new Button(this);
		b1.setText("첫번째 버튼");
		container.addView(b1);

		Button b2 = new Button(this);
		b2.setText("두번째 버튼");
		container.addView(b2);

		setContentView(container);
    }

    
}
