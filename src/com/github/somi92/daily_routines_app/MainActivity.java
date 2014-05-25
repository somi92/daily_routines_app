package com.github.somi92.daily_routines_app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class MainActivity extends Activity {
	
	private ListView routinesListView;
	private SimpleAdapter myAdapter;
	private List<Map<String, String>> routinesList;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		routinesListView = (ListView) findViewById(R.id.dailyRoutines);
		routinesList = new ArrayList<Map<String, String>>();
		fillRoutinesList();
		myAdapter = new SimpleAdapter(this, routinesList, R.layout.list_item, new String[]{"routine"}, new int[] {R.id.item_title});
		routinesListView.setAdapter(myAdapter);
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
}
