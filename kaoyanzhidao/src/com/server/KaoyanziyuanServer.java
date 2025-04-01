package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Kaoyanziyuan;

public interface KaoyanziyuanServer {

  public int add(Kaoyanziyuan po);

  public int update(Kaoyanziyuan po);
  
  
  
  public int delete(int id);

  public List<Kaoyanziyuan> getAll(Map<String,Object> map);
  public List<Kaoyanziyuan> getsykaoyanziyuan1(Map<String,Object> map);
  public List<Kaoyanziyuan> getsykaoyanziyuan2(Map<String,Object> map);
  public List<Kaoyanziyuan> getsykaoyanziyuan3(Map<String,Object> map);
  public Kaoyanziyuan quchongKaoyanziyuan(Map<String, Object> acount);

  public Kaoyanziyuan getById( int id);

  public List<Kaoyanziyuan> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Kaoyanziyuan> select(Map<String, Object> map);
}
//	所有List
