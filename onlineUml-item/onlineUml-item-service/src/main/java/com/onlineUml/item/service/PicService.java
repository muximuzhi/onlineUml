package com.onlineUml.item.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.onlineUml.common.pojo.PageResult;
import com.onlineUml.item.mapper.PicMapper;
import com.onlineUml.item.pojo.Pic;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;

@Service
public class PicService {

    private final PicMapper picMapper;

    public PicService(PicMapper picMapper) {
        this.picMapper = picMapper;
    }

    /**
     * 根据key搜索所有图片
     * @param key
     * @param pageNum
     * @param pageSize
     * @return
     */
    public PageResult<Pic> getAllPicByPage(String key, int pageNum, int pageSize) {
        // 设置搜索条件
        Example example = new Example(Pic.class);
        if(StringUtils.isNotBlank(key)) {
            example.createCriteria().andLike("name","%" + key + "%")//匹配属性名与关键字
                    .orLike("kind","%" + key + "%");
        }

        // 分页条件
        PageHelper.startPage(pageNum, pageSize);

        // 从数据库
        Page<Pic> pageInfo = (Page<Pic>)picMapper.selectByExample(example);
        return new PageResult<>(pageInfo.getTotal(), pageInfo);
    }

    /**
     * 根据点赞数排序查找所有图片
     * @param pageNum
     * @param pageSize
     * @return
     */
    public PageResult<Pic> getAllPicOrderByStar(int pageNum, int pageSize) {
        // 设置搜索条件
        Example example = new Example(Pic.class);

        example.setOrderByClause("star DESC");
        // 分页条件
        PageHelper.startPage(pageNum, pageSize);

        // 从数据库
        Page<Pic> pageInfo = (Page<Pic>)picMapper.selectByExample(example);
        return new PageResult<>(pageInfo.getTotal(), pageInfo);
    }

    /**
     * 新增图片
     * @param name
     * @param url
     * @param kind
     * @param date
     */
    public void newPic(String name, String url, String kind, Date date) {
        Pic tempPic = new Pic();
        tempPic.setName(name);
        tempPic.setUrl(url);
        tempPic.setDate(date);
        this.picMapper.insertSelective(tempPic);
    }

    /**
     * 修改图片评论
     * @param id
     * @param discuss
     * @return
     */
    public void updateDiscussById(long id, String discuss) {
        Pic pic = new Pic();
        pic.setId(id);
        pic.setDiscuss(discuss);
        this.picMapper.updateByPrimaryKeySelective(pic);
    }
 
    /**
     * 修改图片点赞
     * @param id
     * @param star
     * @return
     */
    public void updateStarById(long id, int star) {
        Pic pic = new Pic();
        pic.setId(id);
        pic.setStar(star);
        this.picMapper.updateByPrimaryKeySelective(pic);
    }

    public void updateNameById(long id, String name) {
        Pic pic = new Pic();
        pic.setId(id);
        pic.setName(name);
        this.picMapper.updateByPrimaryKeySelective(pic);
    }

    public void updateKindById(long id, String kind) {
        Pic pic = new Pic();
        pic.setId(id);
        pic.setKind(kind);
        this.picMapper.updateByPrimaryKeySelective(pic);
    }

    public void updateRemarkById(long id, String remark) {
        Pic pic = new Pic();
        pic.setId(id);
        pic.setRemark(remark);
        this.picMapper.updateByPrimaryKeySelective(pic);
    }
}
