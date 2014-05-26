package com.github.somi92.daily_routines_app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class RoutineActivity extends Activity {

	private TextView txtRoutine;
	private Button btnFinish;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.routine_layout);
		
		txtRoutine = (TextView) findViewById(R.id.txtRoutine);
		btnFinish = (Button) findViewById(R.id.btnFinish);
		
		Intent i = getIntent();
		int routine = i.getIntExtra("routine", -1);
		
		switch (routine) {
			case MainActivity.TEETH_BRUSHING: {
				txtRoutine.setText("PRANJE ZUBA!");
			}
			break;
			
			case MainActivity.SHOE_TYING: {
				txtRoutine.setText("VEZANJE PERTLI!");
			}
			break;
			
			case MainActivity.PUTTING_ON_TSHIRT: {
				txtRoutine.setText("OBLACENJE MAJICE!");
			}
			break;
			
			default:
				txtRoutine.setText("GRESKA!");
		}
		
		btnFinish.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				finish();
			}
		});
	}
}
