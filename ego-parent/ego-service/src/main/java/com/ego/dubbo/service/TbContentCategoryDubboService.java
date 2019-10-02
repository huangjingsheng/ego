package com.ego.dubbo.service;

import java.util.List;

import com.ego.pojo.TbContentCategory;

public interface TbContentCategoryDubboService {
	
	List<TbContentCategory> selByPid(long pid);
	
	/**
	 * 新增
	 * @param cate
	 * @return
	 */
	TbContentCategory insTbContentCategory(TbContentCategory cate) throws Exception;
	
	int updNameByid(TbContentCategory t) throws Exception;
	
	int updStatusByid(TbContentCategory t) throws Exception;
	
}
