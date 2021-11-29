package com.huike.dao;

import com.huike.entity.Shopcar;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ShopcarDAO {

    List<Shopcar> findAll();

    void save(Shopcar shopcar);

    void delete(String id);

    Shopcar findOne(String id);

    void update(Shopcar shopcar);
}
