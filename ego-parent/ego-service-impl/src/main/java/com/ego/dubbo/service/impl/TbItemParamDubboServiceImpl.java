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
	

}
