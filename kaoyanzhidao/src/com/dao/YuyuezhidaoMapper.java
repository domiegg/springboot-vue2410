package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Yuyuezhidao;

public interface YuyuezhidaoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Yuyuezhidao record);

    int insertSelective(Yuyuezhidao record);

    Yuyuezhidao selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Yuyuezhidao record);
	
    int updateByPrimaryKey(Yuyuezhidao record);
	public Yuyuezhidao quchongYuyuezhidao(Map<String, Object> yuyueren);
	public List<Yuyuezhidao> getAll(Map<String, Object> map);
	public List<Yuyuezhidao> getsyyuyuezhidao1(Map<String, Object> map);
	public List<Yuyuezhidao> getsyyuyuezhidao3(Map<String, Object> map);
	public List<Yuyuezhidao> getsyyuyuezhidao2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Yuyuezhidao> getByPage(Map<String, Object> map);
	public List<Yuyuezhidao> select(Map<String, Object> map);
//	所有List
}

