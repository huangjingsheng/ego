package com.ego.manage.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ego.commons.pojo.EasyUiTree;
import com.ego.commons.pojo.EgoResult;
import com.ego.manage.service.TbContentCategoryServie;
import com.ego.pojo.TbContentCategory;

@Controller
public class TbContentCategoryController {
	@Resource
	private TbContentCategoryServie tbContentCategoryServie;
	
	@RequestMapping("content/category/list")
	@ResponseBody
	public List<EasyUiTree> selByPid(@RequestParam(defaultValue="0") long id){
		return tbContentCategoryServie.selByPid(id);
	}
	
	@RequestMapping("content/category/create")
	@ResponseBody
	public EgoResult create(TbContentCategory t) {
		return tbContentCategoryServie.create(t);
	}
	
	@RequestMapping("content/category/update")
	@ResponseBody
	public EgoResult updName(TbContentCategory t) {
		return tbContentCategoryServie.updName(t);
	}
	
	@RequestMapping("content/category/delete/")
	@ResponseBody
	public EgoResult updStatus(TbContentCategory t) {
		return tbContentCategoryServie.updStatus(t);
	}
}
