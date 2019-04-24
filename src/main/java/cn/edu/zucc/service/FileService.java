package cn.edu.zucc.service;

import cn.edu.zucc.domain.entity.File;

import java.nio.file.Files;
import java.util.List;

public interface FileService {
    /**
     * 文件上传
     * @param files
     */
    void Upload(File files);
    /**
     * 文件下载
     * @param Fname
     * @param Uid
     */
    Files getFiles(String Fname, Long Uid);
    /**
     * 文件查询
     * @param uid
     */
    List<Files> getAllFiles(Long uid);
}
