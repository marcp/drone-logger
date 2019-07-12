package com.example.filedemo.payload;

public class UploadFileResponse {
    private String fileIdentifier;
    private String fileDownloadUri;
    private String fileType;
    private long size;

    public UploadFileResponse(String fileIdentifier, String fileDownloadUri, String fileType, long size) {
        this.fileIdentifier = fileIdentifier;
        this.fileDownloadUri = fileDownloadUri;
        this.fileType = fileType;
        this.size = size;
    }

    public String getFileDownloadUri() {
        return fileDownloadUri;
    }

    public void setFileDownloadUri(String fileDownloadUri) {
        this.fileDownloadUri = fileDownloadUri;
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

    public String getFileIdentifier() {
        return fileIdentifier;
    }

    public void setFileIdentifier(String fileIdentifier) {
        this.fileIdentifier = fileIdentifier;
    }
}
