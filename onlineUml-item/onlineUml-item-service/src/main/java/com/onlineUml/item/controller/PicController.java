package com.onlineUml.item.controller;

import com.onlineUml.common.pojo.PageResult;
import com.onlineUml.item.pojo.Pic;
import com.onlineUml.item.service.PicService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.annotation.RequestScope;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("pic")
public class PicController {
    private final PicService picService;

    public PicController(PicService picService) {
        this.picService = picService;
    }

    /**
     * 根据key搜索所有图片
     * @param key
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping("page")
    public ResponseEntity<PageResult<Pic>> getAllPicByPage(@RequestParam(value = "key", required = false,
            defaultValue = "") String key,
                                                           @RequestParam("pageNum") int pageNum,
                                                           @RequestParam("pageSize") int pageSize) {
        PageResult<Pic> result = this.picService.getAllPicByPage(key, pageNum, pageSize);
        return ResponseEntity.ok(result);
    }

    /**
     * 根据点赞数排序查找所有图片
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping("homepage")
    public ResponseEntity<PageResult<Pic>> getAllPicOrderByStar(@RequestParam("pageNum") int pageNum,
                                                           @RequestParam("pageSize") int pageSize) {
        PageResult<Pic> result = this.picService.getAllPicOrderByStar(pageNum, pageSize);
        return ResponseEntity.ok(result);
    }

    /**
     * 新增图片
     * @param name
     * @param url
     * @param kind
     * @param date
     * @return
     */
    @PostMapping("new")
    public ResponseEntity<Void> newPic(@RequestParam("name") String name,
                                       @RequestParam("url") String url,
                                       @RequestParam("kind") String kind,
                                       @RequestParam("date") Date date){
        this.picService.newPic(name, url, kind, date);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    /**
     * 修改图片评价
     */

    @PostMapping("updateDiscuss")
    public ResponseEntity<Void> updateDiscuss(@RequestParam("id") long id,
                                              @RequestParam("discuss") String discuss) {
        this.picService.updateDiscussById(id, discuss);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("updateStar")
    public ResponseEntity<Void> updateDiscuss(@RequestParam("id") long id,
                                              @RequestParam("star") int star) {
        this.picService.updateStarById(id, star);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("updateName")
    public ResponseEntity<Void> updateName(@RequestParam("id") long id,
                                              @RequestParam("name") String name) {
        this.picService.updateNameById(id, name);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("updateAll")
    public ResponseEntity<Void> updateAll(@RequestParam("id") long id,
                                          @RequestParam("name") String name,
                                          @RequestParam("kind") String kind,
                                          @RequestParam("remark") String remark) {
        this.picService.updateNameById(id, name);
        this.picService.updateKindById(id, kind);
        this.picService.updateRemarkById(id, remark);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
