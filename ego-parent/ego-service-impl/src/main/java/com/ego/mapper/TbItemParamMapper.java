package com.ego.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ego.pojo.TbItemParam;
import com.ego.pojo.TbItemParamExample;

public interface TbItemParamMapper {
    int countByExample(TbItemParamExample example);

    int deleteByExample(TbItemParamExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TbItemParam record);

    int insertSelective(TbItemParam record);

    List<TbItemParam> selectByExampleWithBLOBs(TbItemParamExample example);

    List<TbItemParam> selectByExample(TbItemParamExample example);
    
    //@Select("select a.*,b.name from tb_item_param as a inner join tb_item_cat as b on a.item_cat_id = b.id")
    List<TbItemParam> selAll();
    
    TbItemParam selByCatId();

    TbItemParam selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TbItemParam record, @Param("example") TbItemParamExample example);

    int updateByExampleWithBLOBs(@Param("record") TbItemParam record, @Param("example") TbItemParamExample example);

    int updateByExample(@Param("record") TbItemParam record, @Param("example") TbItemParamExample example);

    int updateByPrimaryKeySelective(TbItemParam record);

    int updateByPrimaryKeyWithBLOBs(TbItemParam record);

    int updateByPrimaryKey(TbItemParam record);
    
    TbItemParam selByCatId1(long catId);
}