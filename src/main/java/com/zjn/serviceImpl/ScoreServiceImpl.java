package com.zjn.serviceImpl;

import com.zjn.dao.ScoreDao;
import com.zjn.entity.Score;
import com.zjn.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class ScoreServiceImpl implements ScoreService {

    @Autowired
    private ScoreDao scoreDao;

    @Override
    public int insertScore(Score score) {
        return scoreDao.insertScore(score);
    }
}
