package org.ithang.tools.linux;

import org.ithang.tools.linux.bean.SysInfo;
import org.ithang.tools.linux.ssh.LinuxClient;

public class LinuxTools {

	
	public SysInfo check(LinuxClient client){
		return null;
	}
	
	/**
	 * 查看版本信息
	 * @param client
	 * @return
	 */
	public String sysInfo(LinuxClient client){
		return client.exec("cat /etc/issue");
	}
	
	/**
	 * 安装上传工具
	 * @param client
	 * @return
	 */
	public String installLrzsz(LinuxClient client){
		return client.exec("yum install lrzsz -y");
	}
	
}
