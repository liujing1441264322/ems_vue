package com.huike.service;

import com.huike.entity.Shopcar;

import java.util.List;

public interface ShopcarService {

    List<Shopcar> findAll();

    void save(Shopcar shopcar);

    void delete(String id);

    Shopcar findOne(String id);

    void update(Shopcar shopcar);
}
