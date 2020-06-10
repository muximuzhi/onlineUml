package com.onlineUml.item.service;

import com.onlineUml.item.mapper.KindMapper;
import com.onlineUml.item.pojo.Kind;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KindService {

    private final KindMapper kindMapper;

    public KindService(KindMapper kindMapper) {
        this.kindMapper = kindMapper;
    }

    /**
     * 获取所有uml类别
     * @param id
     * @return
     */
    public List<Kind> getAllKind(Long id) {
        return this.kindMapper.selectAllKind();
    }
}
