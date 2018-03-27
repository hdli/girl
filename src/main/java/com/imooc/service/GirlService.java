package com.imooc.service;

import com.imooc.domain.Girl;
import com.imooc.exception.GirlException;
import com.imooc.repository.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Created by lihuidong on 2018-3-26.
 */
@Service
public class GirlService {

    @Autowired
    private GirlRepository girlRepository;

    @Transactional
    public void insertTwo() {
        Girl girlA = new Girl();
        girlA.setCupSize("A");
        girlA.setAge(18);
        girlRepository.save(girlA);


        Girl girlB = new Girl();
        girlB.setCupSize("BBBB");
        girlB.setAge(19);
        girlRepository.save(girlB);
    }

    public Girl getGirl(Integer id) throws Exception{
        Optional<Girl> optional = girlRepository.findById(id);
        Girl girl = optional.get();
        Integer age =girl.getAge();
        if (age<10){
            throw new GirlException(100,"你还在上小学吧");
        }else if(age>10 && age<16){
            throw new GirlException(101,"你可能在上初中");
        }

        return girl;
    }

}
