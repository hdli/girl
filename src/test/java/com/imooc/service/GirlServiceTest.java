package com.imooc.service;

import com.imooc.domain.Girl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Created by lihuidong on 2018-3-29.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class GirlServiceTest {

    @Autowired
    private GirlService girlService;

    @Test
    public void getGirl() throws Exception {
        Girl girl = girlService.getGirl(1);
        Assert.assertEquals(18,girl.getAge());
    }

}