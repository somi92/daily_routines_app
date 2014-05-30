package com.github.somi92.daily_routines_app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class RoutineActivity extends Activity {

	private ImageView routineStepView;
//	private TextView txtRoutine;
	private Button btnPrevious;
	private Button btnNext;
	private Button btnSound;
	private Button btnFinish;
	
	private int[] routineSteps;
	private int stepCounter;
	private int maxStep;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.routine_layout);
		
		initializeViewsAndComponents();
		
		Intent i = getIntent();
		int routine = i.getIntExtra("routine", -1);
		initializeRoutineSteps(routine);
		routineStepView.setImageResource(routineSteps[stepCounter]);
		
		switch (routine) {
			case MainActivity.TEETH_BRUSHING: {
//				txtRoutine.setText("PRANJE ZUBA!");
			}
			break;
			
			case MainActivity.SHOE_TYING: {
//				txtRoutine.setText("VEZANJE PERTLI!");
			}
			break;
			
			case MainActivity.PUTTING_ON_TSHIRT: {
//				txtRoutine.setText("OBLACENJE MAJICE!");
			}
			break;
			
			default:
//				txtRoutine.setText("GRESKA!");
		}
		
		setButtonsListeners();
	}
	
	private void initializeViewsAndComponents() {
		stepCounter = 0;
		maxStep = 0;
		routineStepView = (ImageView) findViewById(R.id.imgRoutineStep);
//		txtRoutine = (TextView) findViewById(R.id.txtRoutine);
		btnPrevious = (Button) findViewById(R.id.btnPrevious);
		btnNext = (Button) findViewById(R.id.btnNext);
		btnSound = (Button) findViewById(R.id.btnSound);
		btnFinish = (Button) findViewById(R.id.btnFinish);
	}
	
	private void initializeRoutineSteps(int routineID) {
		switch (routineID) {
			case MainActivity.TEETH_BRUSHING: {
				int[] routineSteps = {
					R.drawable.eagle1,
					R.drawable.eagle2,
					R.drawable.eagle3
				};
				maxStep = 3;
				this.routineSteps = routineSteps;
			}
			break;
			
			case MainActivity.SHOE_TYING: {
				int[] routineSteps = {
					R.drawable.tiger1,
					R.drawable.tiger2,
					R.drawable.tiger3
				};
				maxStep = 3;
				this.routineSteps = routineSteps;
			}
			break;
		}
	}
	
	private void setButtonsListeners() {
		
		btnPrevious.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(stepCounter > 0) {
					routineStepView.setImageResource(routineSteps[--stepCounter]);
				} else {
					Toast.makeText(v.getContext(), "Pocetak liste", Toast.LENGTH_SHORT).show();
				}
			}
		});
		
		btnNext.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(stepCounter < maxStep) {
					routineStepView.setImageResource(routineSteps[++stepCounter]);
				} else {
					Toast.makeText(v.getContext(), "Kraj liste", Toast.LENGTH_SHORT).show();;
				}
			}
		});
		
		btnSound.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			}
		});
		
		btnFinish.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				finish();
			}
		});
	}
}
