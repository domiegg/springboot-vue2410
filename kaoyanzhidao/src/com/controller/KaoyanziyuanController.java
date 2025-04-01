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

import com.entity.Kaoyanziyuan;
import com.server.KaoyanziyuanServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class KaoyanziyuanController {
	@Resource
	private KaoyanziyuanServer kaoyanziyuanService;


   
	@RequestMapping("addKaoyanziyuan.do")
	public String addKaoyanziyuan(HttpServletRequest request,Kaoyanziyuan kaoyanziyuan,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		kaoyanziyuan.setAddtime(time.toString().substring(0, 19));
		kaoyanziyuanService.add(kaoyanziyuan);
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "kaoyanziyuanList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:kaoyanziyuanList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateKaoyanziyuan.do")
	public String doUpdateKaoyanziyuan(int id,ModelMap map,Kaoyanziyuan kaoyanziyuan){
		kaoyanziyuan=kaoyanziyuanService.getById(id);
		map.put("kaoyanziyuan", kaoyanziyuan);
		return "kaoyanziyuan_updt";
	}
	
	
	
	
	
//	后台详细
	@RequestMapping("kaoyanziyuanDetail.do")
	public String kaoyanziyuanDetail(int id,ModelMap map,Kaoyanziyuan kaoyanziyuan){
		kaoyanziyuan=kaoyanziyuanService.getById(id);
		map.put("kaoyanziyuan", kaoyanziyuan);
		return "kaoyanziyuan_detail";
	}
//	前台详细
	@RequestMapping("kyzyDetail.do")
	public String kyzyDetail(int id,ModelMap map,Kaoyanziyuan kaoyanziyuan){
		kaoyanziyuan=kaoyanziyuanService.getById(id);
		map.put("kaoyanziyuan", kaoyanziyuan);
		return "kaoyanziyuandetail";
	}
//	
	@RequestMapping("updateKaoyanziyuan.do")
	public String updateKaoyanziyuan(int id,ModelMap map,Kaoyanziyuan kaoyanziyuan,HttpServletRequest request,HttpSession session){
		kaoyanziyuanService.update(kaoyanziyuan);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:kaoyanziyuanList.do";
	}

//	分页查询
	@RequestMapping("kaoyanziyuanList.do")
	public String kaoyanziyuanList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Kaoyanziyuan kaoyanziyuan, String ziyuanbianhao, String ziyuanmingcheng, String wenjian, String xiangxi, String faburen){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(ziyuanbianhao==null||ziyuanbianhao.equals("")){pmap.put("ziyuanbianhao", null);}else{pmap.put("ziyuanbianhao", ziyuanbianhao);}		if(ziyuanmingcheng==null||ziyuanmingcheng.equals("")){pmap.put("ziyuanmingcheng", null);}else{pmap.put("ziyuanmingcheng", ziyuanmingcheng);}		if(wenjian==null||wenjian.equals("")){pmap.put("wenjian", null);}else{pmap.put("wenjian", wenjian);}		if(xiangxi==null||xiangxi.equals("")){pmap.put("xiangxi", null);}else{pmap.put("xiangxi", xiangxi);}		if(faburen==null||faburen.equals("")){pmap.put("faburen", null);}else{pmap.put("faburen", faburen);}		
		int total=kaoyanziyuanService.getCount(pmap);
		pageBean.setTotal(total);
		List<Kaoyanziyuan> list=kaoyanziyuanService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "kaoyanziyuan_list";
	}
	
	@RequestMapping("kaoyanziyuanList2.do")
	public String kaoyanziyuanList2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Kaoyanziyuan kaoyanziyuan, String ziyuanbianhao, String ziyuanmingcheng, String wenjian, String xiangxi, String faburen,HttpServletRequest request){
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
		
		pmap.put("faburen", (String)request.getSession().getAttribute("username"));
		if(ziyuanbianhao==null||ziyuanbianhao.equals("")){pmap.put("ziyuanbianhao", null);}else{pmap.put("ziyuanbianhao", ziyuanbianhao);}		if(ziyuanmingcheng==null||ziyuanmingcheng.equals("")){pmap.put("ziyuanmingcheng", null);}else{pmap.put("ziyuanmingcheng", ziyuanmingcheng);}		if(wenjian==null||wenjian.equals("")){pmap.put("wenjian", null);}else{pmap.put("wenjian", wenjian);}		if(xiangxi==null||xiangxi.equals("")){pmap.put("xiangxi", null);}else{pmap.put("xiangxi", xiangxi);}		
		
		int total=kaoyanziyuanService.getCount(pmap);
		pageBean.setTotal(total);
		List<Kaoyanziyuan> list=kaoyanziyuanService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "kaoyanziyuan_list2";
	}	
	
	@RequestMapping("kyzyList.do")
	public String kyzyList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Kaoyanziyuan kaoyanziyuan, String ziyuanbianhao, String ziyuanmingcheng, String wenjian, String xiangxi, String faburen){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(ziyuanbianhao==null||ziyuanbianhao.equals("")){pmap.put("ziyuanbianhao", null);}else{pmap.put("ziyuanbianhao", ziyuanbianhao);}		if(ziyuanmingcheng==null||ziyuanmingcheng.equals("")){pmap.put("ziyuanmingcheng", null);}else{pmap.put("ziyuanmingcheng", ziyuanmingcheng);}		if(wenjian==null||wenjian.equals("")){pmap.put("wenjian", null);}else{pmap.put("wenjian", wenjian);}		if(xiangxi==null||xiangxi.equals("")){pmap.put("xiangxi", null);}else{pmap.put("xiangxi", xiangxi);}		if(faburen==null||faburen.equals("")){pmap.put("faburen", null);}else{pmap.put("faburen", faburen);}		
		int total=kaoyanziyuanService.getCount(pmap);
		pageBean.setTotal(total);
		List<Kaoyanziyuan> list=kaoyanziyuanService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "kaoyanziyuanlist";
	}
	
	@RequestMapping("deleteKaoyanziyuan.do")
	public String deleteKaoyanziyuan(int id,HttpServletRequest request){
		kaoyanziyuanService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:kaoyanziyuanList.do";
	}
	
	@RequestMapping("quchongKaoyanziyuan.do")
	public void quchongKaoyanziyuan(Kaoyanziyuan kaoyanziyuan,HttpServletResponse response){
		   Map<String,Object> map=new HashMap<String,Object>();
		   map.put("ziyuanbianhao", kaoyanziyuan.getZiyuanbianhao());
		   System.out.println("ziyuanbianhao==="+kaoyanziyuan.getZiyuanbianhao());
		   System.out.println("ziyuanbianhao222==="+kaoyanziyuanService.quchongKaoyanziyuan(map));
		   JSONObject obj=new JSONObject();
		   if(kaoyanziyuanService.quchongKaoyanziyuan(map)!=null){
				 obj.put("info", "ng");
			   }else{
				   obj.put("info", "资源编号可以用！");
				  
			   }
		   response.setContentType("text/html;charset=utf-8");
		   PrintWriter out=null;
		   try {
			out=response.getWriter();
			out.print(obj);
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			out.close();
		}
	}
}
