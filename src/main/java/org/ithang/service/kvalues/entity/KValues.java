package org.ithang.service.kvalues.entity;

import org.ithang.tools.gener.Entity;
import org.ithang.tools.mate.Table;

import groovy.transform.Canonical;

@Canonical
@Table("kvalues")
public class KValues extends Entity{

	private String key;//键
	private String value;//值
	private String opt;//备注
	
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getOpt() {
		return opt;
	}
	public void setOpt(String opt) {
		this.opt = opt;
	}
	
}
