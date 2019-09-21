package com.ego.dubbo.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.ego.commons.pojo.EasyUIDataGrid;
import com.ego.dubbo.service.TbItemParamDubboService;
import com.ego.mapper.TbItemParamMapper;
import com.ego.pojo.TbItemParam;
import com.ego.pojo.TbItemParamExample;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

public class TbItemParamDubboServiceImpl implements TbItemParamDubboService{
	@Resource
	private TbItemParamMapper tbItemParamMapper;
	@Override
	public EasyUIDataGrid showPage(int page, int rows) {
		// TODO Auto-generated method stub
		PageHelper.startPage(page, rows);
		List<TbItemParam> list = tbItemParamMapper.selAll();
		PageInfo<TbItemParam> pi = new PageInfo<>(list);
		EasyUIDataGrid eu =new EasyUIDataGrid();
		eu.setRows(pi.getList());
		eu.setTotal(pi.getTotal());
		return eu;
	}
	
	@Override
	public boolean delByIds(String ids) throws Exception {
		String[] id = ids.split(",");
		int index = 0;
		for(int i=0;i<id.length;i++) {
			index += tbItemParamMapper.deleteByPrimaryKey(Long.parseLong(id[i]));
		}
		if(index==id.length) {
			return true;
		}else {
			throw new Exception("删除失败，可能原因：数据已经不存在");
		}
		
	}
	
	
	

}
