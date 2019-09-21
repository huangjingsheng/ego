package com.ego.manage.service;

import com.ego.commons.pojo.EasyUIDataGrid;

public interface TbItemParamService {
	/**
	 * 显示规格参数
	 * @param page
	 * @param rows
	 * @return
	 */
	EasyUIDataGrid show(int page,int rows);
	
	boolean delByIds(String ids) throws Exception;
}
