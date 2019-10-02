package com.ego.dubbo.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import com.ego.dubbo.service.TbContentCategoryDubboService;
import com.ego.mapper.TbContentCategoryMapper;
import com.ego.pojo.TbContentCategory;

public class TbContentCategoryDubboServiceImpl implements TbContentCategoryDubboService{
	@Resource
	private TbContentCategoryMapper tbContentCategoryMapper;
	@Override
	public List<TbContentCategory> selByPid(long pid) {
		// TODO Auto-generated method stub
		return tbContentCategoryMapper.selectByParentId(pid);
	}
	
	
	@Override
	public TbContentCategory insTbContentCategory(TbContentCategory cate) throws Exception {
		//先判断该节点名称是否存在
		Long pid = cate.getParentId();
		String name = cate.getName();
		//SQL语句中没有使用模糊查询，先找出全部再逐个对比快还是只查询模糊匹配是否有值快？
		List<String> catNameLint = tbContentCategoryMapper.selCatNameByParentId(pid);
		for (String c : catNameLint) {
			if(name.equals(c)) {
				throw new Exception("该分类名已存在，你还建个毛线吗？");
			}
		}
		
		Date date = new Date();
		cate.setCreated(date);
		cate.setUpdated(date);
		cate.setStatus(1);
		cate.setSortOrder(1);
		cate.setIsParent(false);
		
		Long parentId = cate.getParentId();
		int idParent = tbContentCategoryMapper.selIsParent(parentId);
		
		if(idParent==1) {
			//1就是父目录，不不要修改
			Long id = tbContentCategoryMapper.insTbContentCategory(cate);
			cate.setId(id);
			
			if(id!=null) {
				return cate;
			}else {
				throw new Exception("新增类目失败");
			}
			
		}else if(idParent==0) {
			//0是子目录，为其添加子目录后，要修改其为父目录
			TbContentCategory parent = new TbContentCategory();
			parent.setId(parentId);
			parent.setIsParent(true);
			
			Long id = tbContentCategoryMapper.insTbContentCategory(cate);
			int index = tbContentCategoryMapper.updIsParent(parent);
			cate.setId(id);
			if(id!=null && index==1) {
				return cate;
			}else {
				throw new Exception("新增类目失败");
			}
		}
		return null;
	}
	
	
	@Override
	public int updNameByid(TbContentCategory t) throws Exception{
		//先判断该名称是否存在
		Long pid = tbContentCategoryMapper.selParentId(t);
		String name = t.getName();
		List<String> tlist = tbContentCategoryMapper.selCatNameByParentId(pid);
		for (String string : tlist) {
			if(string.equals(name)) {
				throw new Exception("该名称已经存在，你还建个毛线");
			}
		}
		
		Date date = new Date();
		t.setUpdated(date);
		return tbContentCategoryMapper.updName(t);
	}


	@Override
	public int updStatusByid(TbContentCategory t) throws Exception{
		// TODO Auto-generated method stub
		Date date = new Date();
		t.setUpdated(date);
		t.setStatus(2);
		tbContentCategoryMapper.upStatus(t);
		
		Long parentId = tbContentCategoryMapper.selParentId(t);
		t.setParentId(parentId);

		
		int num = tbContentCategoryMapper.countChild(t);
		
		if(num>0) {
			return 1;
		}else if(num==0) {
			TbContentCategory parent = new TbContentCategory();
			parent.setIsParent(false);
			parent.setUpdated(date);
			parent.setId(parentId);
			int index = tbContentCategoryMapper.updIsParent(parent);
			if(index==1) {
				return 1;
			}else {
				throw new Exception("删除失败");
			}
		}
		return 0;
		
	}



}
