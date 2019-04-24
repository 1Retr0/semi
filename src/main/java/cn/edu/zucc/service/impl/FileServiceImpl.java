package cn.edu.zucc.service.impl;

import cn.edu.zucc.domain.dao.FileRepository;
import cn.edu.zucc.domain.entity.File;
import cn.edu.zucc.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.Files;
import java.util.List;


@Service
public class FileServiceImpl implements FileService {
    @Autowired
    private FileRepository fileRepository;

    @Override
    public void Upload(File file) {
        fileRepository.save(file);
    }

    @Override
    public Files getFiles(String Fname, Long Uid) {
        return fileRepository.findByUidAndFname(Uid,Fname);
    }


    @Override
    public List<Files> getAllFiles(Long uid) {
        return fileRepository.findByUid(uid);
    }

}
