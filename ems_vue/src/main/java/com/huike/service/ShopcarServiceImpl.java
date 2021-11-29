package com.huike.service;


import com.huike.dao.ShopcarDAO;
import com.huike.entity.Shopcar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ShopcarServiceImpl implements ShopcarService {

    @Autowired
    private ShopcarDAO shopcarDAO;

    @Override
    public Shopcar findOne(String id) {
        return shopcarDAO.findOne(id);

    }

    @Override
    public void update(Shopcar shopcar) {
        shopcarDAO.update(shopcar);
    }

    @Override
    public void delete(String id) {
        shopcarDAO.delete(id);
    }

    @Override
    public void save(Shopcar shopcar) {
        shopcarDAO.save(shopcar);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Shopcar> findAll() {
        return shopcarDAO.findAll();
    }
}
