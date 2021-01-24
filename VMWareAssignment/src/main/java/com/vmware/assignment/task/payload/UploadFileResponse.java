package com.vmware.assignment.task.payload;

public class UploadFileResponse {
    private String fileName;
    private Integer taskID;
    private String fileType;
    private long size;

    public UploadFileResponse(String fileName, Integer taskID, String fileType, long size) {
        this.fileName = fileName;
        this.taskID = taskID;
        this.fileType = fileType;
        this.size = size;
    }

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public Integer getTaskID() {
		return taskID;
	}

	public void setTaskID(Integer taskID) {
		this.taskID = taskID;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public long getSize() {
		return size;
	}

	public void setSize(long size) {
		this.size = size;
	}

	
}
