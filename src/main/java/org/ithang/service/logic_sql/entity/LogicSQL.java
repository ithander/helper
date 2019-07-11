package org.ithang.service.logic_sql.entity;

import org.ithang.tools.gener.Entity;
import org.ithang.tools.mate.Table;

@Table("logic_sql")
public class LogicSQL extends Entity{

	private String key;//key
	private String content;//SQL
	private String opt;//备注
	
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getOpt() {
		return opt;
	}
	public void setOpt(String opt) {
		this.opt = opt;
	}
	
}
