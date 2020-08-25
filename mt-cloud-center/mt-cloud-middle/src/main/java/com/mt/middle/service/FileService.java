package com.mt.middle.service;

import com.mt.common.core.base.BaseServiceImpl;
import com.mt.common.entity.base.FileEntity;
import com.mt.middle.dao.FileMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @auther: motb
 * @date: 2020/4/27 16:39
 * @description:
 */
@Service
public class FileService extends BaseServiceImpl<FileEntity, FileMapper> {

    /**
     * 批量插入
     *
     * @param fileEntityList
     * @return
     */
    public void saveList(List<FileEntity> fileEntityList) {
        getBaseMapper().insertList(fileEntityList);
    }
}
