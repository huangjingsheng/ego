package com.ego.manage.service;

import java.util.List;

import com.ego.commons.pojo.EasyUiTree;
import com.ego.commons.pojo.EgoResult;
import com.ego.pojo.TbContentCategory;

public interface TbContentCategoryServie {
	/**
	 * 查询所有类目并转换为easyui tree的属性要求
	 * @return
	 */
	List<EasyUiTree> selByPid(long pid);
	
	EgoResult create(TbContentCategory cate);
	
	EgoResult updName(TbContentCategory cate);
	
	EgoResult updStatus(TbContentCategory cate);
}
