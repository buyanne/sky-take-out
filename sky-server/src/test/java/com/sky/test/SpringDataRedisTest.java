package com.sky.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

//@SpringBootTest
public class SpringDataRedisTest {
//    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void testRedisTemplate() {
        redisTemplate.opsForValue().set("1", 1);
        Integer i = (Integer) redisTemplate.opsForValue().get("1");
        System.out.println(i);
    }


}
