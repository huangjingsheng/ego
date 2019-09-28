package com.ego.manage.service.impl;

import org.springframework.stereotype.Service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ego.commons.pojo.EasyUIDataGrid;
import com.ego.commons.pojo.EgoResult;
import com.ego.dubbo.service.TbItemParamDubboService;
import com.ego.manage.service.TbItemParamService;
import com.ego.pojo.TbItemParam;

@Service
public class TbItemParamServiceImpl implements TbItemParamService{
	
	@Reference
	private TbItemParamDubboService teItemParamDubboService;
	
	@Override
	public EasyUIDataGrid show(int page, int rows) {
		// TODO Auto-generated method stub
		return teItemParamDubboService.showPage(page, rows);
	}

	@Override
	public boolean delByIds(String ids) throws Exception {
		// TODO Auto-generated method stub
		return teItemParamDubboService.delByIds(ids);
	}

	@Override
	public EgoResult show(long catId) {
		// TODO Auto-generated method stub
		EgoResult er = new EgoResult();
		TbItemParam param = teItemParamDubboService.selByCatId(catId);
		if(param!=null) {
			er.setStatus(200);
			er.setData(param);
		}else{
			er.setStatus(400);
		}
		return er;
	}

	@Override
	public EgoResult insert(TbItemParam t) {
		// TODO Auto-generated method stub
		EgoResult er = new EgoResult();
		if(teItemParamDubboService.insTbItemParam(t)) {
			er.setStatus(200);
		}else {
			er.setStatus(400);
		}
		return er;
	}
	
	
	
	

}
