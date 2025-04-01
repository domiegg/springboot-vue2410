package com.controller;

import java.io.File;
import java.io.IOException;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.entity.Yuyuezhidao;
import com.server.YuyuezhidaoServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class YuyuezhidaoController {
	@Resource
	private YuyuezhidaoServer yuyuezhidaoService;


   
	@RequestMapping("addYuyuezhidao.do")
	public String addYuyuezhidao(HttpServletRequest request,Yuyuezhidao yuyuezhidao,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		yuyuezhidao.setAddtime(time.toString().substring(0, 19));
		yuyuezhidaoService.add(yuyuezhidao);
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "yuyuezhidaoList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:yuyuezhidaoList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateYuyuezhidao.do")
	public String doUpdateYuyuezhidao(int id,ModelMap map,Yuyuezhidao yuyuezhidao){
		yuyuezhidao=yuyuezhidaoService.getById(id);
		map.put("yuyuezhidao", yuyuezhidao);
		return "yuyuezhidao_updt";
	}
	
	
	
	
	
//	后台详细
	@RequestMapping("yuyuezhidaoDetail.do")
	public String yuyuezhidaoDetail(int id,ModelMap map,Yuyuezhidao yuyuezhidao){
		yuyuezhidao=yuyuezhidaoService.getById(id);
		map.put("yuyuezhidao", yuyuezhidao);
		return "yuyuezhidao_detail";
	}
//	前台详细
	@RequestMapping("yyzdDetail.do")
	public String yyzdDetail(int id,ModelMap map,Yuyuezhidao yuyuezhidao){
		yuyuezhidao=yuyuezhidaoService.getById(id);
		map.put("yuyuezhidao", yuyuezhidao);
		return "yuyuezhidaodetail";
	}
//	
	@RequestMapping("updateYuyuezhidao.do")
	public String updateYuyuezhidao(int id,ModelMap map,Yuyuezhidao yuyuezhidao,HttpServletRequest request,HttpSession session){
		yuyuezhidaoService.update(yuyuezhidao);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:yuyuezhidaoList.do";
	}

//	分页查询
	@RequestMapping("yuyuezhidaoList.do")
	public String yuyuezhidaoList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Yuyuezhidao yuyuezhidao, String jiaoshibianhao, String xingming, String yuyueren, String yuyueshijian1,String yuyueshijian2, String lianxifangshi, String beizhu, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(jiaoshibianhao==null||jiaoshibianhao.equals("")){pmap.put("jiaoshibianhao", null);}else{pmap.put("jiaoshibianhao", jiaoshibianhao);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(yuyueren==null||yuyueren.equals("")){pmap.put("yuyueren", null);}else{pmap.put("yuyueren", yuyueren);}		if(yuyueshijian1==null||yuyueshijian1.equals("")){pmap.put("yuyueshijian1", null);}else{pmap.put("yuyueshijian1", yuyueshijian1);}		if(yuyueshijian2==null||yuyueshijian2.equals("")){pmap.put("yuyueshijian2", null);}else{pmap.put("yuyueshijian2", yuyueshijian2);}		if(lianxifangshi==null||lianxifangshi.equals("")){pmap.put("lianxifangshi", null);}else{pmap.put("lianxifangshi", lianxifangshi);}		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}		
		int total=yuyuezhidaoService.getCount(pmap);
		pageBean.setTotal(total);
		List<Yuyuezhidao> list=yuyuezhidaoService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "yuyuezhidao_list";
	}
	
	@RequestMapping("yuyuezhidaoList3.do")
	public String yuyuezhidaoList3(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Yuyuezhidao yuyuezhidao, String jiaoshibianhao, String xingming, String yuyueren, String yuyueshijian1,String yuyueshijian2, String lianxifangshi, String beizhu, String issh,HttpServletRequest request){
		/*if(session.getAttribute("user")==null){
			return "login";
		}*/
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		pmap.put("jiaoshibianhao", (String)request.getSession().getAttribute("username"));
		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(yuyueshijian1==null||yuyueshijian1.equals("")){pmap.put("yuyueshijian1", null);}else{pmap.put("yuyueshijian1", yuyueshijian1);}		if(yuyueshijian2==null||yuyueshijian2.equals("")){pmap.put("yuyueshijian2", null);}else{pmap.put("yuyueshijian2", yuyueshijian2);}		if(lianxifangshi==null||lianxifangshi.equals("")){pmap.put("lianxifangshi", null);}else{pmap.put("lianxifangshi", lianxifangshi);}		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}		
		
		int total=yuyuezhidaoService.getCount(pmap);
		pageBean.setTotal(total);
		List<Yuyuezhidao> list=yuyuezhidaoService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "yuyuezhidao_list3";
	}	@RequestMapping("yuyuezhidaoList2.do")
	public String yuyuezhidaoList2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Yuyuezhidao yuyuezhidao, String jiaoshibianhao, String xingming, String yuyueren, String yuyueshijian1,String yuyueshijian2, String lianxifangshi, String beizhu, String issh,HttpServletRequest request){
		/*if(session.getAttribute("user")==null){
			return "login";
		}*/
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		pmap.put("yuyueren", (String)request.getSession().getAttribute("username"));
		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(yuyueshijian1==null||yuyueshijian1.equals("")){pmap.put("yuyueshijian1", null);}else{pmap.put("yuyueshijian1", yuyueshijian1);}		if(yuyueshijian2==null||yuyueshijian2.equals("")){pmap.put("yuyueshijian2", null);}else{pmap.put("yuyueshijian2", yuyueshijian2);}		if(lianxifangshi==null||lianxifangshi.equals("")){pmap.put("lianxifangshi", null);}else{pmap.put("lianxifangshi", lianxifangshi);}		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}		
		
		int total=yuyuezhidaoService.getCount(pmap);
		pageBean.setTotal(total);
		List<Yuyuezhidao> list=yuyuezhidaoService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "yuyuezhidao_list2";
	}	
	
	@RequestMapping("yyzdList.do")
	public String yyzdList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Yuyuezhidao yuyuezhidao, String jiaoshibianhao, String xingming, String yuyueren, String yuyueshijian1,String yuyueshijian2, String lianxifangshi, String beizhu, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(jiaoshibianhao==null||jiaoshibianhao.equals("")){pmap.put("jiaoshibianhao", null);}else{pmap.put("jiaoshibianhao", jiaoshibianhao);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(yuyueren==null||yuyueren.equals("")){pmap.put("yuyueren", null);}else{pmap.put("yuyueren", yuyueren);}		if(yuyueshijian1==null||yuyueshijian1.equals("")){pmap.put("yuyueshijian1", null);}else{pmap.put("yuyueshijian1", yuyueshijian1);}		if(yuyueshijian2==null||yuyueshijian2.equals("")){pmap.put("yuyueshijian2", null);}else{pmap.put("yuyueshijian2", yuyueshijian2);}		if(lianxifangshi==null||lianxifangshi.equals("")){pmap.put("lianxifangshi", null);}else{pmap.put("lianxifangshi", lianxifangshi);}		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}		
		int total=yuyuezhidaoService.getCount(pmap);
		pageBean.setTotal(total);
		List<Yuyuezhidao> list=yuyuezhidaoService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "yuyuezhidaolist";
	}
	
	@RequestMapping("deleteYuyuezhidao.do")
	public String deleteYuyuezhidao(int id,HttpServletRequest request){
		yuyuezhidaoService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:yuyuezhidaoList.do";
	}
	
	
}
