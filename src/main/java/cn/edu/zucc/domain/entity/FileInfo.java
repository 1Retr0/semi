package cn.edu.zucc.domain.entity;

public class FileInfo {
    private String path;

    public FileInfo(String path) {
        this.path = path;
    }


    public FileInfo() {
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
