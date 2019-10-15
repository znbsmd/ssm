package com.zjn.dao;

import com.zjn.entity.Gag;

import java.util.List;

public interface GagDao {
    public int insertGag(Gag gag);
    List<Gag> findByUserId(Long id);
}
