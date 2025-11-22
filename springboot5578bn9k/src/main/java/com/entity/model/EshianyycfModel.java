package com.entity.model;

import com.entity.EshianyycfEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 营养成份
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2025-04-15 10:59:38
 */
public class EshianyycfModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 英文名
	 */
	
	private String ename;
		
	/**
	 * 食品分类
	 */
	
	private String spfenlei;
		
	/**
	 * 可食部%
	 */
	
	private Double keshibu;
		
	/**
	 * 来源
	 */
	
	private String laiyuan;
		
	/**
	 * 产地
	 */
	
	private String chandi;
		
	/**
	 * 能量(千焦)
	 */
	
	private Double nengliang;
		
	/**
	 * 蛋白质(克)
	 */
	
	private Double danbaizhi;
		
	/**
	 * 脂肪(克)
	 */
	
	private Double zhifang;
		
	/**
	 * 碳水化合物(克)
	 */
	
	private Double tshhw;
		
	/**
	 * 胆固醇(毫克)
	 */
	
	private Double dangc;
		
	/**
	 * 饱和脂肪酸(克)
	 */
	
	private Double baohezhifang;
		
	/**
	 * 反式脂肪酸(克)
	 */
	
	private Double fanshizfs;
		
	/**
	 * 单不饱和脂肪酸(克)
	 */
	
	private Double dbbhzfs;
		
	/**
	 * 多不饱和脂肪酸(克)
	 */
	
	private Double duobbhzfs;
		
	/**
	 * 糖(克)
	 */
	
	private Double tang;
		
	/**
	 * 乳糖(克)
	 */
	
	private Double rutang;
		
	/**
	 * 膳食纤维(克)
	 */
	
	private Double sanshiqw;
		
	/**
	 * 可溶性膳食纤维(克)
	 */
	
	private Double kesxssqw;
		
	/**
	 * 不溶性膳食纤维(克)
	 */
	
	private Double bsxssqw;
		
	/**
	 * 钠(毫克)
	 */
	
	private Double jinshuna;
		
	/**
	 * 维生素A(微克视黄醇当量)
	 */
	
	private Double weishengshua;
		
	/**
	 * 维生素D(微克)
	 */
	
	private Double weishengshud;
		
	/**
	 * 维生素E(毫克α-生育酚当量)
	 */
	
	private Double weishengshue;
		
	/**
	 * 维生素K(微克)
	 */
	
	private Double weishengshuk;
		
	/**
	 * 维生素B1（硫胺素）(毫克)
	 */
	
	private Double weishengshub1;
		
	/**
	 * 维生素B2（核黄素）(毫克)
	 */
	
	private Double weishengshub2;
		
	/**
	 * 维生素B6(毫克)
	 */
	
	private Double weishengshub6;
		
	/**
	 * 维生素B12(微克)
	 */
	
	private Double weishengshub12;
		
	/**
	 * 维生素C（抗坏血酸）(毫克)
	 */
	
	private Double weishengshuc;
		
	/**
	 * 烟酸（烟酰胺）(毫克)
	 */
	
	private Double yanshuan;
		
	/**
	 * 叶酸(微克叶酸当量)
	 */
	
	private Double yeshuan;
		
	/**
	 * 泛酸(毫克)
	 */
	
	private Double fanshuan;
		
	/**
	 * 生物素(微克)
	 */
	
	private Double shenwushu;
		
	/**
	 * 胆碱(毫克)
	 */
	
	private Double danjian;
		
	/**
	 * 磷(毫克)
	 */
	
	private Double jinshulin;
		
	/**
	 * 钾(毫克)
	 */
	
	private Double jinshujia;
		
	/**
	 * 镁(毫克)
	 */
	
	private Double jinshumei;
		
	/**
	 * 钙(毫克)
	 */
	
	private Double jinshugai;
		
	/**
	 * 铁(毫克)
	 */
	
	private Double jinshutie;
		
	/**
	 * 锌(毫克)
	 */
	
	private Double jinshuxin;
		
	/**
	 * 碘(微克)
	 */
	
	private Double jinshudian;
		
	/**
	 * 硒(微克)
	 */
	
	private Double jinshudxi;
		
	/**
	 * 铜(毫克)
	 */
	
	private Double jinshutong;
		
	/**
	 * 氟(毫克)
	 */
	
	private Double jinshufu;
		
	/**
	 * 锰(毫克)
	 */
	
	private Double jinshumeng;
		
	/**
	 * δ-E(毫克)
	 */
	
	private Double deltae;
		
	/**
	 * (β-γ)-E(毫克)
	 */
	
	private Double beitae;
		
	/**
	 * α-E(毫克)
	 */
	
	private Double aerfae;
		
	/**
	 * 胡萝卜素(微克)
	 */
	
	private Double hulubo;
		
	/**
	 * 脂肪酸（总）(克)
	 */
	
	private Double zhifansz;
		
	/**
	 * 灰分(克)
	 */
	
	private Double huifen;
		
	/**
	 * 水分(克)
	 */
	
	private Double shuifen;
		
	/**
	 * 能量(千卡)
	 */
	
	private Double nengliangqk;
		
	/**
	 * 详情链接
	 */
	
	private String xqurl;
		
	/**
	 * 收藏数
	 */
	
	private Integer storeupnum;
				
	
	/**
	 * 设置：英文名
	 */
	 
	public void setEname(String ename) {
		this.ename = ename;
	}
	
	/**
	 * 获取：英文名
	 */
	public String getEname() {
		return ename;
	}
				
	
	/**
	 * 设置：食品分类
	 */
	 
	public void setSpfenlei(String spfenlei) {
		this.spfenlei = spfenlei;
	}
	
	/**
	 * 获取：食品分类
	 */
	public String getSpfenlei() {
		return spfenlei;
	}
				
	
	/**
	 * 设置：可食部%
	 */
	 
	public void setKeshibu(Double keshibu) {
		this.keshibu = keshibu;
	}
	
	/**
	 * 获取：可食部%
	 */
	public Double getKeshibu() {
		return keshibu;
	}
				
	
	/**
	 * 设置：来源
	 */
	 
	public void setLaiyuan(String laiyuan) {
		this.laiyuan = laiyuan;
	}
	
	/**
	 * 获取：来源
	 */
	public String getLaiyuan() {
		return laiyuan;
	}
				
	
	/**
	 * 设置：产地
	 */
	 
	public void setChandi(String chandi) {
		this.chandi = chandi;
	}
	
	/**
	 * 获取：产地
	 */
	public String getChandi() {
		return chandi;
	}
				
	
	/**
	 * 设置：能量(千焦)
	 */
	 
	public void setNengliang(Double nengliang) {
		this.nengliang = nengliang;
	}
	
	/**
	 * 获取：能量(千焦)
	 */
	public Double getNengliang() {
		return nengliang;
	}
				
	
	/**
	 * 设置：蛋白质(克)
	 */
	 
	public void setDanbaizhi(Double danbaizhi) {
		this.danbaizhi = danbaizhi;
	}
	
	/**
	 * 获取：蛋白质(克)
	 */
	public Double getDanbaizhi() {
		return danbaizhi;
	}
				
	
	/**
	 * 设置：脂肪(克)
	 */
	 
	public void setZhifang(Double zhifang) {
		this.zhifang = zhifang;
	}
	
	/**
	 * 获取：脂肪(克)
	 */
	public Double getZhifang() {
		return zhifang;
	}
				
	
	/**
	 * 设置：碳水化合物(克)
	 */
	 
	public void setTshhw(Double tshhw) {
		this.tshhw = tshhw;
	}
	
	/**
	 * 获取：碳水化合物(克)
	 */
	public Double getTshhw() {
		return tshhw;
	}
				
	
	/**
	 * 设置：胆固醇(毫克)
	 */
	 
	public void setDangc(Double dangc) {
		this.dangc = dangc;
	}
	
	/**
	 * 获取：胆固醇(毫克)
	 */
	public Double getDangc() {
		return dangc;
	}
				
	
	/**
	 * 设置：饱和脂肪酸(克)
	 */
	 
	public void setBaohezhifang(Double baohezhifang) {
		this.baohezhifang = baohezhifang;
	}
	
	/**
	 * 获取：饱和脂肪酸(克)
	 */
	public Double getBaohezhifang() {
		return baohezhifang;
	}
				
	
	/**
	 * 设置：反式脂肪酸(克)
	 */
	 
	public void setFanshizfs(Double fanshizfs) {
		this.fanshizfs = fanshizfs;
	}
	
	/**
	 * 获取：反式脂肪酸(克)
	 */
	public Double getFanshizfs() {
		return fanshizfs;
	}
				
	
	/**
	 * 设置：单不饱和脂肪酸(克)
	 */
	 
	public void setDbbhzfs(Double dbbhzfs) {
		this.dbbhzfs = dbbhzfs;
	}
	
	/**
	 * 获取：单不饱和脂肪酸(克)
	 */
	public Double getDbbhzfs() {
		return dbbhzfs;
	}
				
	
	/**
	 * 设置：多不饱和脂肪酸(克)
	 */
	 
	public void setDuobbhzfs(Double duobbhzfs) {
		this.duobbhzfs = duobbhzfs;
	}
	
	/**
	 * 获取：多不饱和脂肪酸(克)
	 */
	public Double getDuobbhzfs() {
		return duobbhzfs;
	}
				
	
	/**
	 * 设置：糖(克)
	 */
	 
	public void setTang(Double tang) {
		this.tang = tang;
	}
	
	/**
	 * 获取：糖(克)
	 */
	public Double getTang() {
		return tang;
	}
				
	
	/**
	 * 设置：乳糖(克)
	 */
	 
	public void setRutang(Double rutang) {
		this.rutang = rutang;
	}
	
	/**
	 * 获取：乳糖(克)
	 */
	public Double getRutang() {
		return rutang;
	}
				
	
	/**
	 * 设置：膳食纤维(克)
	 */
	 
	public void setSanshiqw(Double sanshiqw) {
		this.sanshiqw = sanshiqw;
	}
	
	/**
	 * 获取：膳食纤维(克)
	 */
	public Double getSanshiqw() {
		return sanshiqw;
	}
				
	
	/**
	 * 设置：可溶性膳食纤维(克)
	 */
	 
	public void setKesxssqw(Double kesxssqw) {
		this.kesxssqw = kesxssqw;
	}
	
	/**
	 * 获取：可溶性膳食纤维(克)
	 */
	public Double getKesxssqw() {
		return kesxssqw;
	}
				
	
	/**
	 * 设置：不溶性膳食纤维(克)
	 */
	 
	public void setBsxssqw(Double bsxssqw) {
		this.bsxssqw = bsxssqw;
	}
	
	/**
	 * 获取：不溶性膳食纤维(克)
	 */
	public Double getBsxssqw() {
		return bsxssqw;
	}
				
	
	/**
	 * 设置：钠(毫克)
	 */
	 
	public void setJinshuna(Double jinshuna) {
		this.jinshuna = jinshuna;
	}
	
	/**
	 * 获取：钠(毫克)
	 */
	public Double getJinshuna() {
		return jinshuna;
	}
				
	
	/**
	 * 设置：维生素A(微克视黄醇当量)
	 */
	 
	public void setWeishengshua(Double weishengshua) {
		this.weishengshua = weishengshua;
	}
	
	/**
	 * 获取：维生素A(微克视黄醇当量)
	 */
	public Double getWeishengshua() {
		return weishengshua;
	}
				
	
	/**
	 * 设置：维生素D(微克)
	 */
	 
	public void setWeishengshud(Double weishengshud) {
		this.weishengshud = weishengshud;
	}
	
	/**
	 * 获取：维生素D(微克)
	 */
	public Double getWeishengshud() {
		return weishengshud;
	}
				
	
	/**
	 * 设置：维生素E(毫克α-生育酚当量)
	 */
	 
	public void setWeishengshue(Double weishengshue) {
		this.weishengshue = weishengshue;
	}
	
	/**
	 * 获取：维生素E(毫克α-生育酚当量)
	 */
	public Double getWeishengshue() {
		return weishengshue;
	}
				
	
	/**
	 * 设置：维生素K(微克)
	 */
	 
	public void setWeishengshuk(Double weishengshuk) {
		this.weishengshuk = weishengshuk;
	}
	
	/**
	 * 获取：维生素K(微克)
	 */
	public Double getWeishengshuk() {
		return weishengshuk;
	}
				
	
	/**
	 * 设置：维生素B1（硫胺素）(毫克)
	 */
	 
	public void setWeishengshub1(Double weishengshub1) {
		this.weishengshub1 = weishengshub1;
	}
	
	/**
	 * 获取：维生素B1（硫胺素）(毫克)
	 */
	public Double getWeishengshub1() {
		return weishengshub1;
	}
				
	
	/**
	 * 设置：维生素B2（核黄素）(毫克)
	 */
	 
	public void setWeishengshub2(Double weishengshub2) {
		this.weishengshub2 = weishengshub2;
	}
	
	/**
	 * 获取：维生素B2（核黄素）(毫克)
	 */
	public Double getWeishengshub2() {
		return weishengshub2;
	}
				
	
	/**
	 * 设置：维生素B6(毫克)
	 */
	 
	public void setWeishengshub6(Double weishengshub6) {
		this.weishengshub6 = weishengshub6;
	}
	
	/**
	 * 获取：维生素B6(毫克)
	 */
	public Double getWeishengshub6() {
		return weishengshub6;
	}
				
	
	/**
	 * 设置：维生素B12(微克)
	 */
	 
	public void setWeishengshub12(Double weishengshub12) {
		this.weishengshub12 = weishengshub12;
	}
	
	/**
	 * 获取：维生素B12(微克)
	 */
	public Double getWeishengshub12() {
		return weishengshub12;
	}
				
	
	/**
	 * 设置：维生素C（抗坏血酸）(毫克)
	 */
	 
	public void setWeishengshuc(Double weishengshuc) {
		this.weishengshuc = weishengshuc;
	}
	
	/**
	 * 获取：维生素C（抗坏血酸）(毫克)
	 */
	public Double getWeishengshuc() {
		return weishengshuc;
	}
				
	
	/**
	 * 设置：烟酸（烟酰胺）(毫克)
	 */
	 
	public void setYanshuan(Double yanshuan) {
		this.yanshuan = yanshuan;
	}
	
	/**
	 * 获取：烟酸（烟酰胺）(毫克)
	 */
	public Double getYanshuan() {
		return yanshuan;
	}
				
	
	/**
	 * 设置：叶酸(微克叶酸当量)
	 */
	 
	public void setYeshuan(Double yeshuan) {
		this.yeshuan = yeshuan;
	}
	
	/**
	 * 获取：叶酸(微克叶酸当量)
	 */
	public Double getYeshuan() {
		return yeshuan;
	}
				
	
	/**
	 * 设置：泛酸(毫克)
	 */
	 
	public void setFanshuan(Double fanshuan) {
		this.fanshuan = fanshuan;
	}
	
	/**
	 * 获取：泛酸(毫克)
	 */
	public Double getFanshuan() {
		return fanshuan;
	}
				
	
	/**
	 * 设置：生物素(微克)
	 */
	 
	public void setShenwushu(Double shenwushu) {
		this.shenwushu = shenwushu;
	}
	
	/**
	 * 获取：生物素(微克)
	 */
	public Double getShenwushu() {
		return shenwushu;
	}
				
	
	/**
	 * 设置：胆碱(毫克)
	 */
	 
	public void setDanjian(Double danjian) {
		this.danjian = danjian;
	}
	
	/**
	 * 获取：胆碱(毫克)
	 */
	public Double getDanjian() {
		return danjian;
	}
				
	
	/**
	 * 设置：磷(毫克)
	 */
	 
	public void setJinshulin(Double jinshulin) {
		this.jinshulin = jinshulin;
	}
	
	/**
	 * 获取：磷(毫克)
	 */
	public Double getJinshulin() {
		return jinshulin;
	}
				
	
	/**
	 * 设置：钾(毫克)
	 */
	 
	public void setJinshujia(Double jinshujia) {
		this.jinshujia = jinshujia;
	}
	
	/**
	 * 获取：钾(毫克)
	 */
	public Double getJinshujia() {
		return jinshujia;
	}
				
	
	/**
	 * 设置：镁(毫克)
	 */
	 
	public void setJinshumei(Double jinshumei) {
		this.jinshumei = jinshumei;
	}
	
	/**
	 * 获取：镁(毫克)
	 */
	public Double getJinshumei() {
		return jinshumei;
	}
				
	
	/**
	 * 设置：钙(毫克)
	 */
	 
	public void setJinshugai(Double jinshugai) {
		this.jinshugai = jinshugai;
	}
	
	/**
	 * 获取：钙(毫克)
	 */
	public Double getJinshugai() {
		return jinshugai;
	}
				
	
	/**
	 * 设置：铁(毫克)
	 */
	 
	public void setJinshutie(Double jinshutie) {
		this.jinshutie = jinshutie;
	}
	
	/**
	 * 获取：铁(毫克)
	 */
	public Double getJinshutie() {
		return jinshutie;
	}
				
	
	/**
	 * 设置：锌(毫克)
	 */
	 
	public void setJinshuxin(Double jinshuxin) {
		this.jinshuxin = jinshuxin;
	}
	
	/**
	 * 获取：锌(毫克)
	 */
	public Double getJinshuxin() {
		return jinshuxin;
	}
				
	
	/**
	 * 设置：碘(微克)
	 */
	 
	public void setJinshudian(Double jinshudian) {
		this.jinshudian = jinshudian;
	}
	
	/**
	 * 获取：碘(微克)
	 */
	public Double getJinshudian() {
		return jinshudian;
	}
				
	
	/**
	 * 设置：硒(微克)
	 */
	 
	public void setJinshudxi(Double jinshudxi) {
		this.jinshudxi = jinshudxi;
	}
	
	/**
	 * 获取：硒(微克)
	 */
	public Double getJinshudxi() {
		return jinshudxi;
	}
				
	
	/**
	 * 设置：铜(毫克)
	 */
	 
	public void setJinshutong(Double jinshutong) {
		this.jinshutong = jinshutong;
	}
	
	/**
	 * 获取：铜(毫克)
	 */
	public Double getJinshutong() {
		return jinshutong;
	}
				
	
	/**
	 * 设置：氟(毫克)
	 */
	 
	public void setJinshufu(Double jinshufu) {
		this.jinshufu = jinshufu;
	}
	
	/**
	 * 获取：氟(毫克)
	 */
	public Double getJinshufu() {
		return jinshufu;
	}
				
	
	/**
	 * 设置：锰(毫克)
	 */
	 
	public void setJinshumeng(Double jinshumeng) {
		this.jinshumeng = jinshumeng;
	}
	
	/**
	 * 获取：锰(毫克)
	 */
	public Double getJinshumeng() {
		return jinshumeng;
	}
				
	
	/**
	 * 设置：δ-E(毫克)
	 */
	 
	public void setDeltae(Double deltae) {
		this.deltae = deltae;
	}
	
	/**
	 * 获取：δ-E(毫克)
	 */
	public Double getDeltae() {
		return deltae;
	}
				
	
	/**
	 * 设置：(β-γ)-E(毫克)
	 */
	 
	public void setBeitae(Double beitae) {
		this.beitae = beitae;
	}
	
	/**
	 * 获取：(β-γ)-E(毫克)
	 */
	public Double getBeitae() {
		return beitae;
	}
				
	
	/**
	 * 设置：α-E(毫克)
	 */
	 
	public void setAerfae(Double aerfae) {
		this.aerfae = aerfae;
	}
	
	/**
	 * 获取：α-E(毫克)
	 */
	public Double getAerfae() {
		return aerfae;
	}
				
	
	/**
	 * 设置：胡萝卜素(微克)
	 */
	 
	public void setHulubo(Double hulubo) {
		this.hulubo = hulubo;
	}
	
	/**
	 * 获取：胡萝卜素(微克)
	 */
	public Double getHulubo() {
		return hulubo;
	}
				
	
	/**
	 * 设置：脂肪酸（总）(克)
	 */
	 
	public void setZhifansz(Double zhifansz) {
		this.zhifansz = zhifansz;
	}
	
	/**
	 * 获取：脂肪酸（总）(克)
	 */
	public Double getZhifansz() {
		return zhifansz;
	}
				
	
	/**
	 * 设置：灰分(克)
	 */
	 
	public void setHuifen(Double huifen) {
		this.huifen = huifen;
	}
	
	/**
	 * 获取：灰分(克)
	 */
	public Double getHuifen() {
		return huifen;
	}
				
	
	/**
	 * 设置：水分(克)
	 */
	 
	public void setShuifen(Double shuifen) {
		this.shuifen = shuifen;
	}
	
	/**
	 * 获取：水分(克)
	 */
	public Double getShuifen() {
		return shuifen;
	}
				
	
	/**
	 * 设置：能量(千卡)
	 */
	 
	public void setNengliangqk(Double nengliangqk) {
		this.nengliangqk = nengliangqk;
	}
	
	/**
	 * 获取：能量(千卡)
	 */
	public Double getNengliangqk() {
		return nengliangqk;
	}
				
	
	/**
	 * 设置：详情链接
	 */
	 
	public void setXqurl(String xqurl) {
		this.xqurl = xqurl;
	}
	
	/**
	 * 获取：详情链接
	 */
	public String getXqurl() {
		return xqurl;
	}
				
	
	/**
	 * 设置：收藏数
	 */
	 
	public void setStoreupnum(Integer storeupnum) {
		this.storeupnum = storeupnum;
	}
	
	/**
	 * 获取：收藏数
	 */
	public Integer getStoreupnum() {
		return storeupnum;
	}
			
}
