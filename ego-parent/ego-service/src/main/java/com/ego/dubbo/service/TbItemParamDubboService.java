package com.ego.dubbo.service;

import com.ego.commons.pojo.EasyUIDataGrid;
import com.ego.commons.pojo.EgoResult;
import com.ego.pojo.TbItemParam;

public interface TbItemParamDubboService {
	EasyUIDataGrid showPage(int page,int rows);
	

	boolean delByIds(String ids)throws Exception;
	//通过类目id查询
	TbItemParam selByCatId(long catId);
	
	
	boolean insTbItemParam(TbItemParam t);
	
	
}
