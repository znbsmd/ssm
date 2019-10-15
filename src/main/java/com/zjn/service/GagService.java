package com.zjn.service;

import com.zjn.entity.Gag;

import java.util.List;

public interface GagService {

    public int insertGag(Gag gag);
    List<Gag> findByUserId(Long id);
}
