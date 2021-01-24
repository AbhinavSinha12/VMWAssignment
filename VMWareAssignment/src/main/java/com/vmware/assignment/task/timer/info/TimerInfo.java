package com.vmware.assignment.task.timer.info;

public class TimerInfo {
	
	private int totalFireCount;
	private boolean runForever;
	private long repeatInterval;
	private long initialOffsetMs;
	private String callBackData;
	
	
	public int getTotalFireCount() {
		return totalFireCount;
	}
	public void setTotalFireCount(int totalFireCount) {
		this.totalFireCount = totalFireCount;
	}
	public boolean isRunForever() {
		return runForever;
	}
	public void setRunForever(boolean runForever) {
		this.runForever = runForever;
	}
	public long getRepeatInterval() {
		return repeatInterval;
	}
	public void setRepeatInterval(long repeatInterval) {
		this.repeatInterval = repeatInterval;
	}
	public long getInitialOffsetMs() {
		return initialOffsetMs;
	}
	public void setInitialOffsetMs(long initialOffsetMs) {
		this.initialOffsetMs = initialOffsetMs;
	}
	public String getCallBackData() {
		return callBackData;
	}
	public void setCallBackData(String callBackData) {
		this.callBackData = callBackData;
	}
	
	

}
