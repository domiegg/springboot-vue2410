package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.KaoyanziyuanMapper;
import com.entity.Kaoyanziyuan;
import com.server.KaoyanziyuanServer;
@Service
public class KaoyanziyuanServerImpi implements KaoyanziyuanServer {
   @Resource
   private KaoyanziyuanMapper gdao;
	@Override
	public int add(Kaoyanziyuan po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Kaoyanziyuan po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Kaoyanziyuan> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Kaoyanziyuan> getsykaoyanziyuan1(Map<String, Object> map) {
		return gdao.getsykaoyanziyuan1(map);
	}
	public List<Kaoyanziyuan> getsykaoyanziyuan2(Map<String, Object> map) {
		return gdao.getsykaoyanziyuan2(map);
	}
	public List<Kaoyanziyuan> getsykaoyanziyuan3(Map<String, Object> map) {
		return gdao.getsykaoyanziyuan3(map);
	}
	
	@Override
	public Kaoyanziyuan quchongKaoyanziyuan(Map<String, Object> account) {
		return gdao.quchongKaoyanziyuan(account);
	}

	@Override
	public List<Kaoyanziyuan> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Kaoyanziyuan> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Kaoyanziyuan getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

