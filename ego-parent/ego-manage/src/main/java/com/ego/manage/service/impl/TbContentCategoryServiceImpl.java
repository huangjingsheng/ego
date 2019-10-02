package com.ego.manage.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ego.commons.pojo.EasyUiTree;
import com.ego.commons.pojo.EgoResult;
import com.ego.dubbo.service.TbContentCategoryDubboService;
import com.ego.manage.service.TbContentCategoryServie;
import com.ego.pojo.TbContentCategory;

@Service
public class TbContentCategoryServiceImpl implements TbContentCategoryServie{
	@Reference
	private TbContentCategoryDubboService tbContentCategoryDubboService;
	@Override
	public List<EasyUiTree> selByPid(long pid) {
		List<EasyUiTree> listTree = new ArrayList<EasyUiTree>();
		List<TbContentCategory> list = tbContentCategoryDubboService.selByPid(pid);
		for (TbContentCategory t : list) {
			EasyUiTree tree = new EasyUiTree();
			tree.setId(t.getId());
			tree.setText(t.getName());
			tree.setState(t.getIsParent()?"closed":"open");
			listTree.add(tree);
		}
		return listTree;
	}
	
	@Override
	public EgoResult updName(TbContentCategory cate) {
		EgoResult er = new EgoResult();

		try {
			int index = tbContentCategoryDubboService.updNameByid(cate);
			if(index==1) {
				er.setStatus(200);
				return er;
			}
		} catch (Exception e) {
			String message = e.getMessage();
			er.setData(message);
			return er;
		}

		return null;
	}

	@Override
	public EgoResult updStatus(TbContentCategory cate) {
		EgoResult er = new EgoResult();
		try {
			int index = tbContentCategoryDubboService.updStatusByid(cate);
			if(index==1) {
				er.setStatus(200);
				return er;
			}
		} catch (Exception e) {
			String message = e.getMessage();
			er.setData(message);
			return er;
		}
		return null;
	}

	@Override
	public EgoResult create(TbContentCategory cate) {
		EgoResult er = new EgoResult();
		try {
			TbContentCategory t = tbContentCategoryDubboService.insTbContentCategory(cate);
			er.setStatus(200);
			Long id = t.getId();
			Map<String,Long> map = new HashMap<>();
			map.put("id", id);
			er.setData(map);
		} catch (Exception e) {
			String message = e.getMessage();
			er.setData(message);
		}
		return er;
	}

}
