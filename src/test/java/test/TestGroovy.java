package test;

import java.io.File;
import java.net.URL;

import org.codehaus.groovy.bsf.GroovyEngine;
import org.codehaus.groovy.jsr223.GroovyScriptEngineFactory;

import groovy.lang.GroovyClassLoader;
import groovy.lang.GroovyObject;
import groovy.util.GroovyScriptEngine;
import groovy.util.ResourceConnector;

public class TestGroovy {

	
	public static void main(String[] args) throws Exception {
		GroovyClassLoader loader=new GroovyClassLoader();
		//loader.addClasspath("E:/BaiduNetdiskDownload/helper/helper/src/test/java");
		//loader.loadClass("Hello.groovy");
		Class groovyClass=null;
		//loader.parseClass(new File("E:/BaiduNetdiskDownload/helper/helper/src/test/java/test/Hello.java"));
		groovyClass=loader.parseClass(new File("E:/BaiduNetdiskDownload/helper/helper/src/test/java/test/TGroovy.groovy"));
		//groovyClass=loader.parseClass("void hello(){print 'hello'}","abc");
		GroovyObject go=(GroovyObject)groovyClass.newInstance();
		loader.close();
		go.invokeMethod("hello", null);
		
		loader.parseClass("void good(){print 'good job'}", "good");
		
	}
}
