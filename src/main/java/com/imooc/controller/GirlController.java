package com.imooc.controller;

import com.imooc.domain.Girl;
import com.imooc.dto.Result;
import com.imooc.repository.GirlRepository;
import com.imooc.service.GirlService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by lihuidong on 2018-3-24.
 */
@RestController
@RequestMapping(value = "test")
public class GirlController {

    private final static Logger logger = LoggerFactory.getLogger(GirlController.class);

    //此处先省去service层 直接调用dao了
    @Autowired
    private GirlRepository girlRepository;
    @Autowired
    private GirlService girlService;

    /**
     * 获取所有女生的信息
     * @return
     */
    @GetMapping(value = "girls")
    public List<Girl> girlList(){
        return girlRepository.findAll();
    }

    /**
     * 添加一个女生
     * 校验对象@Valid
     * @return
     */
//    @PostMapping(value = "girls")
//    public Girl girlAdd(@RequestParam("cupSize") String cupSize,
//                        @RequestParam("age") Integer age){
//        Girl girl = new Girl();
//        girl.setCupSize(cupSize);
//        girl.setAge(age);
//        return girlRepository.save(girl);
//    }

    @PostMapping(value = "girls")
    public Result<Girl> girlAdd(@Valid Girl girl, BindingResult bindingResult){

        if (bindingResult.hasErrors()){
            logger.info(bindingResult.getFieldError().getDefaultMessage());
            return new Result<>(1,bindingResult.getFieldError().getDefaultMessage());
        }
        return new Result<>(0,"成功",girlRepository.save(girl));
    }

    /**
     * 更新女生信息
     * @param id
     * @param cupSize
     * @param age
     * @return
     */
    @PutMapping(value = "/girl/{id}")
    public Girl girlUpdate(@PathVariable("id") Integer id,
                           @RequestParam("cupSize") String cupSize,
                           @RequestParam("age") Integer age){
        Girl girl = new Girl();
        girl.setId(id);
        girl.setCupSize(cupSize);
        girl.setAge(age);
        return girlRepository.save(girl);
    }

    /**
     * 删除女生信息
     * @param id
     */
    @DeleteMapping(value = "/girl/{id}")
    public void girlDelet(@PathVariable("id") Integer id){
        girlRepository.deleteById(id);
    }

    /**
     * 获取同年龄段的女生信息
     * @param age
     * @return
     */
    @GetMapping(value = "/girls/age/{age}")
    public List<Girl> girlListByAge(@PathVariable("age") Integer age){
        return girlRepository.findByAge(age);
    }

    /**
     *
     * @param id
     * @return
     * @throws Exception
     */
    @GetMapping(value = "/girls/getAge/{id}")
    public Result<Girl> getGirl(@PathVariable("id") Integer id) throws Exception{
       Girl girl = girlService.getGirl(id);
       return new Result<>(0,"成功",girl);
    }
}
