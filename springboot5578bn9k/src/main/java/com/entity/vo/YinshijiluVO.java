package com.entity.vo;

import com.entity.YinshijiluEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 饮食记录
 * @author 
 * @email 
 * @date 2025-04-15 10:59:38
 */
public class YinshijiluVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 餐次
	 */
	
	private String canci;
		
	/**
	 * 食物种类
	 */
	
	private String shiwuzhonglei;
		
	/**
	 * 摄入量
	 */
	
	private String sheruliang;
		
	/**
	 * 图片
	 */
	
	private String tupian;
		
	/**
	 * 用户账号
	 */
	
	private String yonghuzhanghao;
		
	/**
	 * 用户姓名
	 */
	
	private String yonghuxingming;
		
	/**
	 * 是否审核
	 */
	
	private String sfsh;
		
	/**
	 * 审核回复
	 */
	
	private String shhf;
				
	
	/**
	 * 设置：餐次
	 */
	 
	public void setCanci(String canci) {
		this.canci = canci;
	}
	
	/**
	 * 获取：餐次
	 */
	public String getCanci() {
		return canci;
	}
				
	
	/**
	 * 设置：食物种类
	 */
	 
	public void setShiwuzhonglei(String shiwuzhonglei) {
		this.shiwuzhonglei = shiwuzhonglei;
	}
	
	/**
	 * 获取：食物种类
	 */
	public String getShiwuzhonglei() {
		return shiwuzhonglei;
	}
				
	
	/**
	 * 设置：摄入量
	 */
	 
	public void setSheruliang(String sheruliang) {
		this.sheruliang = sheruliang;
	}
	
	/**
	 * 获取：摄入量
	 */
	public String getSheruliang() {
		return sheruliang;
	}
				
	
	/**
	 * 设置：图片
	 */
	 
	public void setTupian(String tupian) {
		this.tupian = tupian;
	}
	
	/**
	 * 获取：图片
	 */
	public String getTupian() {
		return tupian;
	}
				
	
	/**
	 * 设置：用户账号
	 */
	 
	public void setYonghuzhanghao(String yonghuzhanghao) {
		this.yonghuzhanghao = yonghuzhanghao;
	}
	
	/**
	 * 获取：用户账号
	 */
	public String getYonghuzhanghao() {
		return yonghuzhanghao;
	}
				
	
	/**
	 * 设置：用户姓名
	 */
	 
	public void setYonghuxingming(String yonghuxingming) {
		this.yonghuxingming = yonghuxingming;
	}
	
	/**
	 * 获取：用户姓名
	 */
	public String getYonghuxingming() {
		return yonghuxingming;
	}
				
	
	/**
	 * 设置：是否审核
	 */
	 
	public void setSfsh(String sfsh) {
		this.sfsh = sfsh;
	}
	
	/**
	 * 获取：是否审核
	 */
	public String getSfsh() {
		return sfsh;
	}
				
	
	/**
	 * 设置：审核回复
	 */
	 
	public void setShhf(String shhf) {
		this.shhf = shhf;
	}
	
	/**
	 * 获取：审核回复
	 */
	public String getShhf() {
		return shhf;
	}
			
}
