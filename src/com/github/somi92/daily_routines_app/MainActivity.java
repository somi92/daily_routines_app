package com.github.somi92.daily_routines_app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	private ListView routinesListView;
	private SimpleAdapter myAdapter;
	private List<Map<String, String>> routinesList;
	
	public static final int NONE = 0;
	public static final int TEETH_BRUSHING = 1;
	public static final int SHOE_TYING = 2;
	public static final int PUTTING_ON_TSHIRT = 3;
	private int routine;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		routine = MainActivity.NONE;
		
		routinesListView = (ListView) findViewById(R.id.dailyRoutines);
		routinesList = new ArrayList<Map<String, String>>();
		fillRoutinesList();
		
		myAdapter = new SimpleAdapter(this, routinesList, R.layout.list_item, new String[]{"routine"}, new int[] {R.id.item_title});
		routinesListView.setAdapter(myAdapter);
		
		routinesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				
				switch(arg2) {
					
					case 0: {
						routine = MainActivity.TEETH_BRUSHING;
					}
					break;
					
					case 1: {
						routine = MainActivity.SHOE_TYING;
					}
					break;
					
					case 2: {
						routine = MainActivity.PUTTING_ON_TSHIRT;
					}
					break;
					
					default:
						routine = MainActivity.NONE;
				}
				
				TextView clickedView = (TextView) arg1.findViewById(R.id.item_title);
				Toast.makeText(MainActivity.this, "Item id "+arg3+" position "+arg2+" text: "+clickedView.getText(), Toast.LENGTH_SHORT).show();
				startRoutine(routine);
			}
		});
	}
	
	private void fillRoutinesList() {
		String[] routines = getResources().getStringArray(R.array.routines_array);
		for(String i : routines) {
			routinesList.add(createRoutine("routine", i));
		}
	}
	
	private HashMap<String, String> createRoutine(String key, String name) {
		HashMap<String, String> routine = new HashMap<String, String>();
		routine.put(key, name);
		return routine;
	}
	
	private void startRoutine(int value) {
		Intent launchRoutine = new Intent(this, RoutineActivity.class);
		launchRoutine.putExtra("routine", value);
		startActivity(launchRoutine);
	}
}
