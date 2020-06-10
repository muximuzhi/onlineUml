package com.onlineUml.item.mapper;

import com.onlineUml.item.pojo.Kind;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface KindMapper extends Mapper<Kind> {
    @Select("SELECT name FROM uml_kind")
    List<Kind> selectAllKind();
}
