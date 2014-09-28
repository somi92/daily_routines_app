package com.github.somi92.daily_routines_app;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class RoutineActivity extends Activity {

	private ImageView routineStepView;
	private Button btnPrevious;
	private Button btnNext;
	private Button btnSound;
	private Button btnFinish;
	
	private Routine routine;
	private Routine.RoutineStep step;
	private MediaPlayer player;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.routine_layout);
		
		initializeViewsAndComponents();
		
		Intent i = getIntent();
		int routineID = i.getIntExtra("routine", -1);
		initializeRoutine(routineID);
		step = routine.getFirstStep();
		routineStepView.setImageResource(step.getImageRes());
		
		setButtonsListeners();
	}
	
	private void initializeViewsAndComponents() {
		routineStepView = (ImageView) findViewById(R.id.imgRoutineStep);
		btnPrevious = (Button) findViewById(R.id.btnPrevious);
		btnNext = (Button) findViewById(R.id.btnNext);
		btnSound = (Button) findViewById(R.id.btnSound);
		btnFinish = (Button) findViewById(R.id.btnFinish);
	}
	
	public void initializeRoutine(int routineID) {
		switch(routineID) {
			
			case MainActivity.TEETH_BRUSHING:
				routine = new Routine("PRANJE ZUBA", "");
				routine.addStep(routine.new RoutineStep("Korak 1.", R.drawable.eagle1, R.raw.example));
				routine.addStep(routine.new RoutineStep("Korak 2.", R.drawable.eagle2, R.raw.example));
				routine.addStep(routine.new RoutineStep("Korak 3.", R.drawable.eagle3, R.raw.example));
			break;
				
			case MainActivity.SHOE_TYING:
				routine = new Routine("VEZANJE PERTLI", "");
				routine.addStep(routine.new RoutineStep("Korak 1.", R.drawable.tiger1, R.raw.example));
				routine.addStep(routine.new RoutineStep("Korak 2.", R.drawable.tiger2, R.raw.example));
				routine.addStep(routine.new RoutineStep("Korak 3.", R.drawable.tiger3, R.raw.example));
			break;
		}
	}
	
	private void setButtonsListeners() {
		
		btnPrevious.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				step = routine.getPreviousStep();
				if(step != null) {
					routineStepView.setImageResource(step.getImageRes());
				} else {
					step = routine.getCurrentStep();
					Toast.makeText(RoutineActivity.this, "PRVI KORAK", Toast.LENGTH_SHORT).show();
				}
			}
		});
		
		btnNext.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				step = routine.getNextStep();
				if(step != null) {
					routineStepView.setImageResource(step.getImageRes());
				} else {
					step = routine.getCurrentStep();
					Toast.makeText(RoutineActivity.this, "POSLEDNJI KORAK", Toast.LENGTH_SHORT).show();
				}
			}
		});
		
		btnSound.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(step != null) {
					player = MediaPlayer.create(RoutineActivity.this, step.getAudioRes());
					player.start();
				}
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
