package com.entity;

public class Kaoyanziyuan {
    private Integer id;
	private String ziyuanbianhao;	private String ziyuanmingcheng;	private String wenjian;	private String xiangxi;	private String faburen;	
    private String addtime;

    

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
	
	public String getZiyuanbianhao() {
        return ziyuanbianhao;
    }
    public void setZiyuanbianhao(String ziyuanbianhao) {
        this.ziyuanbianhao = ziyuanbianhao == null ? null : ziyuanbianhao.trim();
    }	public String getZiyuanmingcheng() {
        return ziyuanmingcheng;
    }
    public void setZiyuanmingcheng(String ziyuanmingcheng) {
        this.ziyuanmingcheng = ziyuanmingcheng == null ? null : ziyuanmingcheng.trim();
    }	public String getWenjian() {
        return wenjian;
    }
    public void setWenjian(String wenjian) {
        this.wenjian = wenjian == null ? null : wenjian.trim();
    }	public String getXiangxi() {
        return xiangxi;
    }
    public void setXiangxi(String xiangxi) {
        this.xiangxi = xiangxi == null ? null : xiangxi.trim();
    }	public String getFaburen() {
        return faburen;
    }
    public void setFaburen(String faburen) {
        this.faburen = faburen == null ? null : faburen.trim();
    }	
	
	
    public String getAddtime() {
        return addtime;
    }
    public void setAddtime(String addtime) {
        this.addtime = addtime == null ? null : addtime.trim();
    }
}
//   设置字段信息
