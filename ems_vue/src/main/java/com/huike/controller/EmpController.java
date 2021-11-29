package com.huike.controller;

import com.huike.entity.Emp;
import com.huike.service.EmpService;
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
@RequestMapping("emp")
@CrossOrigin
@Slf4j
public class EmpController {


    @Autowired
    private EmpService empService;

    @Value("${photo.dir}")
    private String realPath;

//    //修改员工信息
    @PostMapping("update")
    public Map<String, Object> update(Emp emp, MultipartFile photo) throws IOException {
        log.info("员工信息: [{}]", emp.toString());

        Map<String, Object> map = new HashMap<>();
        try {
            if(photo!=null&&photo.getSize()!=0){
                log.info("头像信息: [{}]", photo.getOriginalFilename());
                //头像保存
                String newFileName = UUID.randomUUID().toString() + "." + FilenameUtils.getExtension(photo.getOriginalFilename());
                photo.transferTo(new File(realPath, newFileName));
                //设置头像地址
                emp.setPath(newFileName);
            }
            //保存员工信息
            empService.update(emp);
            map.put("state", true);
            map.put("code", 200);
            map.put("msg", "商品信息保存成功!");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("state", false);
            map.put("code", 500);
            map.put("msg", "商品信息保存失败!");
        }
        return map;
    }

    //根据id查询员工信息实现
    @GetMapping("findOne")
    public Map<String, Object>  findOne(String id){
        log.info("查询商品信息的id: [{}]",id);

        Map<String, Object> map = new HashMap<>();
        try {
            Emp emplist = empService.findOne(id);
            map.put("records", emplist);
            map.put("state", true);
            map.put("code", 200);
            map.put("msg", "商品信息保存成功!");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("state", false);
            map.put("code", 500);
            map.put("msg", "商品信息保存失败!");
        }
        return map;

    }

    //删除员工信息实现
    @GetMapping("delete")
    public Map<String, Object> delete(String id) {
        log.info("删除商品的id:[{}]",id);
        Map<String, Object> map = new HashMap<>();
        try {
            //删除员工头像
            Emp emp = empService.findOne(id);
            File file = new File(realPath, emp.getPath());
            if(file.exists())file.delete();//删除头像
            //删除员工信息
            empService.delete(id);
            map.put("state",true);
            map.put("code", 200);
            map.put("msg","删除商品信息成功!");
        }catch (Exception e){
            e.printStackTrace();
            map.put("state",false);
            map.put("code", 500);
            map.put("msg","删除商品信息失败!");
        }
        return map;
    }


    //保存员工信息
    @PostMapping("save")
    public Map<String, Object> save(Emp emp, MultipartFile photo) throws IOException {
        log.info("商品信息: [{}]", emp.toString());
        log.info("头像信息: [{}]", photo.getOriginalFilename());
        Map<String, Object> map = new HashMap<>();
        try {
//            //头像保存
            String newFileName = UUID.randomUUID().toString() + "." + FilenameUtils.getExtension(photo.getOriginalFilename());
            photo.transferTo(new File(realPath, newFileName));
//            //设置头像地址
            emp.setPath(newFileName);
            //保存员工信息
            empService.save(emp);
            map.put("state", true);
            map.put("code", 200);
            map.put("msg", "商品信息保存成功!");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("state", false);
            map.put("code", 500);
            map.put("msg", "商品信息保存失败!");
        }
        return map;
    }

    //获取员工列表的方法
    @GetMapping("findAll")
    public  Map<String, Object> findAll() {


        Map<String, Object> map = new HashMap<>();
        try {
            List<Emp> emplist = empService.findAll();
            map.put("records", emplist);
            map.put("state", true);
            map.put("code", 200);
            map.put("msg", "商品信息保存成功!");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("state", false);
            map.put("code", 500);
            map.put("msg", "商品信息保存失败!");
        }
        return map;

    }
}
