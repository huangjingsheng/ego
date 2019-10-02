package com.ego.mapper;

import com.ego.pojo.TbContentCategory;
import com.ego.pojo.TbContentCategoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbContentCategoryMapper {
    int countByExample(TbContentCategoryExample example);

    int deleteByExample(TbContentCategoryExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TbContentCategory record);

    int insertSelective(TbContentCategory record);
    //新增一条数据并返回自增的id
    Long insTbContentCategory(TbContentCategory record);

    List<TbContentCategory> selectByExample(TbContentCategoryExample example);
    
    List<TbContentCategory> selectByParentId(long pid);

    TbContentCategory selectByPrimaryKey(Long id);
    
    //通过parent_id查询所有的类目名称
    List<String> selCatNameByParentId(long pid);

    int updateByExampleSelective(@Param("record") TbContentCategory record, @Param("example") TbContentCategoryExample example);

    int updateByExample(@Param("record") TbContentCategory record, @Param("example") TbContentCategoryExample example);

    int updateByPrimaryKeySelective(TbContentCategory record);

    int updateByPrimaryKey(TbContentCategory record);
    
    //通过parentid查询is_parent的值
    int selIsParent(long pid);
    
    //通过id修改isPatent的值
    int updIsParent(TbContentCategory record);
    
    int updName(TbContentCategory t);
    
    int upStatus(TbContentCategory t);
    
    int countChild(TbContentCategory t);
    
    Long selParentId(TbContentCategory t);
    
    
}