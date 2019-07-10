package test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;

public class ApplicationTest {

	public static void main(String[] args) {
		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
		
		
		String cls="package test;"+

"public class Hello {"+

	"public static void main(String[] args) {"+
        "System.out.println(\"Hello\");"+
	"}"+

"}";
		
		
		
		ByteArrayInputStream bais=new ByteArrayInputStream(cls.getBytes());
		
		
		ByteArrayOutputStream baos=new ByteArrayOutputStream();
		
		String classPath = ApplicationTest.class.getClassLoader().getResource("").getPath();
		
		compiler.run(bais, System.out, System.err);
	}

}
