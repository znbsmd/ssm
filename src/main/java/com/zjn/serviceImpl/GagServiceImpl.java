package com.zjn.serviceImpl;

import com.zjn.dao.GagDao;
import com.zjn.entity.Gag;
import com.zjn.service.GagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GagServiceImpl implements GagService {

    @Autowired
    private GagDao gagDao;

    @Override
    public int insertGag(Gag gag) {
        return gagDao.insertGag(gag);
    }

    @Override
    public List<Gag> findByUserId(Long id) {

        return gagDao.findByUserId(id);
    }
}
