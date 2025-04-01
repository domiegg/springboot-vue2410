package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Yuyuezhidao;

public interface YuyuezhidaoServer {

  public int add(Yuyuezhidao po);

  public int update(Yuyuezhidao po);
  
  
  
  public int delete(int id);

  public List<Yuyuezhidao> getAll(Map<String,Object> map);
  public List<Yuyuezhidao> getsyyuyuezhidao1(Map<String,Object> map);
  public List<Yuyuezhidao> getsyyuyuezhidao2(Map<String,Object> map);
  public List<Yuyuezhidao> getsyyuyuezhidao3(Map<String,Object> map);
  public Yuyuezhidao quchongYuyuezhidao(Map<String, Object> acount);

  public Yuyuezhidao getById( int id);

  public List<Yuyuezhidao> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Yuyuezhidao> select(Map<String, Object> map);
}
//	所有List
