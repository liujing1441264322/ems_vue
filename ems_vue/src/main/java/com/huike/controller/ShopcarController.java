package com.huike.controller;

import com.huike.entity.Shopcar;
import com.huike.service.ShopcarService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("shopcar")
@CrossOrigin
@Slf4j
public class ShopcarController {


    @Autowired
    private ShopcarService shopcarService;

    @Value("${photo.dir}")
    private String realPath;

//    //修改员工信息
    @PostMapping("update")
    public Map<String, Object> update(Shopcar shopcar, MultipartFile photo) throws IOException {
        log.info("商品信息: [{}]", shopcar.toString());

        Map<String, Object> map = new HashMap<>();
        try {
            if(photo!=null&&photo.getSize()!=0){
                log.info("头像信息: [{}]", photo.getOriginalFilename());
                //头像保存
                String newFileName = UUID.randomUUID().toString() + "." + FilenameUtils.getExtension(photo.getOriginalFilename());
                photo.transferTo(new File(realPath, newFileName));
                //设置头像地址
                shopcar.setPath(newFileName);
            }
            //保存商品信息
            shopcarService.update(shopcar);
            map.put("state", true);
            map.put("code", 200);
            map.put("msg", "商品信息添加成功!");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("state", false);
            map.put("code", 500);
            map.put("msg", "商品信息添加失败!");
        }
        return map;
    }

    //根据id查询员工信息实现
    @GetMapping("findOne")
    public Map<String, Object>  findOne(String id){
        log.info("查询商品信息的id: [{}]",id);

        Map<String, Object> map = new HashMap<>();
        try {
            Shopcar shopcar = shopcarService.findOne(id);
            map.put("records", shopcar);
            map.put("state", true);
            map.put("code", 200);
            map.put("msg", "商品信息添加成功!");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("state", false);
            map.put("code", 500);
            map.put("msg", "商品信息添加失败!");
        }
        return map;

    }

    //删除商品信息实现
    @GetMapping("delete")
    public Map<String, Object> delete(String id) {
        log.info("删除商品的id:[{}]",id);
        Map<String, Object> map = new HashMap<>();
        try {
            //删除商品头像
            Shopcar shopcar = shopcarService.findOne(id);
            File file = new File(realPath, shopcar.getPath());
            if(file.exists())file.delete();//删除头像
            //删除商品信息
            shopcarService.delete(id);
            map.put("state",true);
            map.put("code", 200);
            map.put("msg","删除购物车商品成功!");
        }catch (Exception e){
            e.printStackTrace();
            map.put("state",false);
            map.put("code", 500);
            map.put("msg","删除购物车商品失败!");
        }
        return map;
    }


    //保存员工信息
    @PostMapping("save")
    public Map<String, Object> save(Shopcar shopcar, MultipartFile photo) throws IOException {
        log.info("商品信息: [{}]", shopcar.toString());
        log.info("头像信息: [{}]", photo.getOriginalFilename());
        Map<String, Object> map = new HashMap<>();
        try {
//            //头像保存
            String newFileName = UUID.randomUUID().toString() + "." + FilenameUtils.getExtension(photo.getOriginalFilename());
            photo.transferTo(new File(realPath, newFileName));
//            //设置头像地址
            shopcar.setPath(newFileName);
            //保存商品信息
            shopcarService.save(shopcar);
            map.put("state", true);
            map.put("code", 200);
            map.put("msg", "商品信息添加成功!");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("state", false);
            map.put("code", 500);
            map.put("msg", "商品信息添加失败!");
        }
        return map;
    }

    //获取商品列表的方法
    @GetMapping("findAll")
    public  Map<String, Object> findAll() {


        Map<String, Object> map = new HashMap<>();
        try {
            List<Shopcar> shopcar = shopcarService.findAll();
            map.put("records", shopcar);
            map.put("state", true);
            map.put("code", 200);
            map.put("msg", "商品信息查询成功!");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("state", false);
            map.put("code", 500);
            map.put("msg", "商品信息查询失败!");
        }
        return map;

    }


}
