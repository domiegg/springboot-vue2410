package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Kaoyanziyuan;

public interface KaoyanziyuanMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Kaoyanziyuan record);

    int insertSelective(Kaoyanziyuan record);

    Kaoyanziyuan selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Kaoyanziyuan record);
	
    int updateByPrimaryKey(Kaoyanziyuan record);
	public Kaoyanziyuan quchongKaoyanziyuan(Map<String, Object> faburen);
	public List<Kaoyanziyuan> getAll(Map<String, Object> map);
	public List<Kaoyanziyuan> getsykaoyanziyuan1(Map<String, Object> map);
	public List<Kaoyanziyuan> getsykaoyanziyuan3(Map<String, Object> map);
	public List<Kaoyanziyuan> getsykaoyanziyuan2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Kaoyanziyuan> getByPage(Map<String, Object> map);
	public List<Kaoyanziyuan> select(Map<String, Object> map);
//	所有List
}

