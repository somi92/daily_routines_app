package com.github.somi92.daily_routines_app;

import java.util.ArrayList;

public class Routine {

	private String title;
	private String desc;
	private ArrayList<RoutineStep> steps;

	private int currentStep;
	
	public Routine() {
		currentStep = -1;
	}
	
	public Routine(String title, String desc) {
		this();
		this.title = title;
		this.desc = desc;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public void addStep(RoutineStep step) {
		if(steps == null) {
			steps = new ArrayList<RoutineStep>();
		}
		steps.add(step);
	}
	
	public RoutineStep getFirstStep() {
		if(steps == null) {
			return null;
		}
		currentStep = 0;
		return steps.get(currentStep);
	}
	
	public RoutineStep getCurrentStep() {
		if(steps == null) {
			return null;
		}
		return steps.get(currentStep);
	}
	
	public RoutineStep getNextStep() {
		currentStep = currentStep + 1;
		if(currentStep >= steps.size() || steps.get(currentStep) == null) {
			currentStep = currentStep - 1;
			return null;
		}
		return steps.get(currentStep);
	}
	
	public RoutineStep getPreviousStep() {
		currentStep = currentStep - 1;
		if(currentStep < 0 || steps.get(currentStep) == null) {
			currentStep = currentStep + 1;
			return null;
		}
		return steps.get(currentStep);
	}
	
	/*************** inner class - routine step *****************/
	public class RoutineStep {
		
		private String desc;
		private int imageRes;
		private int audioRes;
		
		public RoutineStep(String desc, int imageRes, int audioRes) {
			this.desc = desc;
			this.imageRes = imageRes;
			this.audioRes = audioRes;
		}
		
		public String getDesc() {
			return desc;
		}
		public void setDesc(String desc) {
			this.desc = desc;
		}
		public int getImageRes() {
			return imageRes;
		}
		public void setImageRes(int imageRes) {
			this.imageRes = imageRes;
		}
		public int getAudioRes() {
			return audioRes;
		}
		public void setAudioRes(int audioRes) {
			this.audioRes = audioRes;
		}
		
		
	}
	
}
