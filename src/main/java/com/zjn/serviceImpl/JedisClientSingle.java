package com.zjn.serviceImpl;

import com.zjn.entity.User;
import com.zjn.service.JedisClient;
//import com.zjn.utils.JsonUtils;
import com.zjn.entity.User;
import com.zjn.service.JedisClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.List;
import java.util.Set;


@Service
public class JedisClientSingle implements JedisClient {

    @Autowired
    private JedisPool jedisPool;
    private int expiredTime = 60*60*24*2;//设置过期时间为两天.


    @Override
    public String get(String key) {
        Jedis jedis = jedisPool.getResource();
        String string = jedis.get(key);
        //解开注释即可体验过期策略
//        jedis.expire(key,5);
        jedis.close();
        return string;
    }

    @Override
    public String set(String key, String value) {
        Jedis jedis = jedisPool.getResource();
        String string = jedis.set(key, value);
        //解开注释即可体验过期策略
//        jedis.expire(key,5);
//        System.out.println("key :  "+key);
//        System.out.println("查看key的剩余生存时间："+jedis.ttl(key));
        jedis.close();
        return string;
    }

    @Override
    public String hget(String hkey, String key) {
        System.out.println("jedisPool   " + jedisPool);
        Jedis jedis = jedisPool.getResource();
        System.out.println("jedis   " + jedis);
        String string = jedis.hget(hkey, key);
        jedis.close();
        return string;
    }

    @Override
    public long hset(String hkey, String key, String value) {
        Jedis jedis = jedisPool.getResource();
        Long result = jedis.hset(hkey, key, value);
        //解开注释即可体验过期策略
//        jedis.expire(hkey,expiredTime);
//        System.out.println("key :  "+key);
//        System.out.println("查看key001的剩余生存时间："+jedis.ttl(hkey));
        jedis.close();
        return result;
    }

    @Override
    public long incr(String key) {
        Jedis jedis = jedisPool.getResource();
        Long result = jedis.incr(key);
        jedis.close();
        return result;
    }

    @Override
    public long expire(String key, int second) {
        Jedis jedis = jedisPool.getResource();
        Long result = jedis.expire(key, second);
        jedis.close();
        return result;
    }

    @Override
    public long ttl(String key) {
        Jedis jedis = jedisPool.getResource();
        Long result = jedis.ttl(key);
        jedis.close();
        return result;
    }

    @Override
    public long del(String key) {
        Jedis jedis = jedisPool.getResource();
        Long result = jedis.del(key);
        jedis.close();
        return result;
    }

    @Override
    public long hdel(String hkey, String key) {
        Jedis jedis = jedisPool.getResource();
        Long result = jedis.hdel(hkey, key);
        jedis.close();
        return result;
    }

    @Override
    public long zadd(String key, double score, User user) {
        return 0;
    }

    @Override
    public Set<String> zgetAll(String key, long start, long end) {
        return null;
    }

    @Override
    public long zaddList(String key, List<User> userList) {
        return 0;
    }

    @Override
    public Set<String> getTopLast(String key, long start, long end) {
        return null;
    }


}