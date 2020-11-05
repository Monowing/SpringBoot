package com.example.demo.mongodb.controller;

import com.example.demo.mongodb.dao.MongoDao;
import com.example.demo.mongodb.entity.MongoBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * MongoDB Controller
 */

@RestController
@RequestMapping("/mongo")
public class MongoController {

    @Autowired
    private MongoDao mongoDao;


    /**
     * add data
     */
    @GetMapping("/add")
    public void add() {
        Date date = new Date();
        MongoBean mongoBean = new MongoBean();
        mongoBean.setId(date.getTime());
        mongoBean.setName("clg" + date.getTime());
        mongoBean.setAge((int) (date.getTime() % 100));
        mongoDao.save(mongoBean);
    }


    /**
     * query list data
     *
     * @return list data of MongoBean
     */
    @GetMapping("/list")
    public List<MongoBean> findList() {
        return mongoDao.findList();
    }

    /**
     * query list data accurately by name
     *
     * @param name
     * @return list data of MongoBean
     */
    @GetMapping("/name")
    public List<MongoBean> findByName(String name) {
        return mongoDao.findByName(name);
    }

    /**
     * query list data blurry by name
     *
     * @param name
     * @return list data of MongoBean
     */
    @GetMapping("/namelike")
    public List<MongoBean> findByNameLike(String name) {
        return mongoDao.findByNameLike(name);
    }

    /**
     * query list data blurry by key
     *
     * @param key
     * @return list data of MongoBean
     */
    @GetMapping("/key")
    public List<MongoBean> findByKeyLike(String key) {
        return mongoDao.findByKeyLike(key);
    }


}
