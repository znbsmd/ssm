package com.zjn.controller;


import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.fastjson.JSON;
//import com.sun.org.slf4j.internal.Logger;
//import com.sun.org.slf4j.internal.LoggerFactory;
import com.alibaba.fastjson.JSONArray;
import com.zjn.entity.Gag;
import com.zjn.entity.Score;
import com.zjn.service.GagService;
import com.zjn.service.JedisClient;
import com.zjn.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {

//    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ScoreService scoreService;

    @Autowired
    private GagService gagService;
    @Autowired
    private JedisClient jedisClient;

    @RequestMapping(value = "/testMethod",produces="text/html;charset=UTF-8", method = {RequestMethod.GET,RequestMethod.GET})
    public String test(){
        Score score = new Score();
        score.setChangeType("xxx");
        score.setScore(10);
        scoreService.insertScore(score);
        return JSON.toJSONString(score);
    }

    @RequestMapping(value = "/testRedis",produces="text/html;charset=UTF-8", method = {RequestMethod.GET,RequestMethod.GET})
    public String testGapList(Long id){
        List<Gag> gagList = null;
        try {
            String resultGet = jedisClient.hget("testssmredis",id + "");
            if(resultGet !=null){
                JSONArray array =JSONArray.parseArray(resultGet);
                gagList = (List) array;
            }else{

                gagList= gagService.findByUserId(id);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        String cacheString = JSONUtils.toJSONString(gagList);
        try {
            jedisClient.hset("testssmredis",id + "",cacheString);
        } catch (Exception e) {
            e.printStackTrace();
        }


        return JSON.toJSONString(gagList);
    }

}
