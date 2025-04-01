package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.YuyuezhidaoMapper;
import com.entity.Yuyuezhidao;
import com.server.YuyuezhidaoServer;
@Service
public class YuyuezhidaoServerImpi implements YuyuezhidaoServer {
   @Resource
   private YuyuezhidaoMapper gdao;
	@Override
	public int add(Yuyuezhidao po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Yuyuezhidao po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Yuyuezhidao> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Yuyuezhidao> getsyyuyuezhidao1(Map<String, Object> map) {
		return gdao.getsyyuyuezhidao1(map);
	}
	public List<Yuyuezhidao> getsyyuyuezhidao2(Map<String, Object> map) {
		return gdao.getsyyuyuezhidao2(map);
	}
	public List<Yuyuezhidao> getsyyuyuezhidao3(Map<String, Object> map) {
		return gdao.getsyyuyuezhidao3(map);
	}
	
	@Override
	public Yuyuezhidao quchongYuyuezhidao(Map<String, Object> account) {
		return gdao.quchongYuyuezhidao(account);
	}

	@Override
	public List<Yuyuezhidao> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Yuyuezhidao> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Yuyuezhidao getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

