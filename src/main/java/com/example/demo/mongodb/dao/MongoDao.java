package com.example.demo.mongodb.dao;

import com.example.demo.mongodb.entity.MongoBean;
import org.apache.ibatis.jdbc.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * MongoDB Dao
 * make some example to show how to get the data of mongodb
 */

@Component
public class MongoDao {


    @Autowired
    private MongoTemplate mongoTemplate;


    public void save(MongoBean mongoBean) {
        mongoTemplate.save(mongoBean);
    }

    /**
     * query list data
     *
     * @return
     */
    public List<MongoBean> findList() {
        return mongoTemplate.findAll(MongoBean.class);
    }

    /**
     * query list data accurately by name
     *
     * @param name MongoBean.name
     * @return list data of MongoBean
     */
    public List<MongoBean> findByName(String name) {
        Query query = new Query(Criteria.where("name").is(name));
        return mongoTemplate.find(query, MongoBean.class);
    }


    /**
     * query list data blurry by name
     *
     * @param name MongoBean.name
     * @return list data of MongoBean
     */
    public List<MongoBean> findByNameLike(String name) {
        Query query = new Query(Criteria.where("name").regex(".*?" + name + ".*"));
        return mongoTemplate.find(query, MongoBean.class);
    }

    /**
     * query list data blurry by key
     * key:name and id like
     *
     * @param key MongoBean.name and MongoBean.id
     * @return list data of MongoBean
     */
    public List<MongoBean> findByKeyLike(String key) {

        Criteria criteria = new Criteria();
        criteria.orOperator(Criteria.where("name").regex(".*?" + key + ".*"), Criteria.where("id").regex(".*?" + key + ".*"));

        Query query = new Query(criteria);
        query.with(Sort.by(new Sort.Order(Sort.Direction.ASC, "age")));

        return mongoTemplate.find(query, MongoBean.class);
    }

}
