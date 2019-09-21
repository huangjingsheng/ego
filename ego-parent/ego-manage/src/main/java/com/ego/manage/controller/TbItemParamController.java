package com.ego.manage.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ego.commons.pojo.EasyUIDataGrid;
import com.ego.commons.pojo.EgoResult;
import com.ego.manage.service.TbItemParamService;

@Controller
public class TbItemParamController {
	@Resource
	private TbItemParamService tbItemParamService;
	
	@RequestMapping("item/param/list")
	@ResponseBody
	public EasyUIDataGrid show(int page,int rows) {

		return tbItemParamService.show(page, rows);
	}
	
	@RequestMapping("item/param/delete")
	@ResponseBody
	public EgoResult delete(String ids) {
		EgoResult er = new EgoResult();
		try {
			if(tbItemParamService.delByIds(ids)) {
				er.setStatus(200);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			er.setData(e.getMessage());
		}
		
		return er;
	}
}
