package test.groovy
import org.ithang.tools.gener.*;
class Test {

	static main(args) {
		
		
		def text = 'Dear "$firstname $lastname",\nSo nice to meet you in <% city.each({print it}) %>.\nSee you in ${month},\n${signed}'
		
						def binding = ["firstname":"Sam", "lastname":"Pullara", "city":["aaa","San-Francisco","bbbbbb"], "month":"December", "signed":"Groovy-Dev"]
		
						def engine = new groovy.text.SimpleTemplateEngine()
						def template = engine.createTemplate(text).make(binding)
		
						def results = 'Dear "Sam Pullara",\nSo nice to meet you in San Francisco.\nSee you in December,\nGroovy-Dev'
		
						print template.toString()
						//assert results == template.toString()
						
						
						/*def abs=["aaa","bbb","ccc"]
						abs.each({print it+'\n'})*/
						
						print '==================================='
						def bind=[clsName:"Person",fields:[[fieldType:"int",fieldName:"id"],[fieldType:"String",fieldName:"name"]]]
					
						template =engine.createTemplate(FTL.getBeanFTL());
						Writable result= template.make(bind)
						StringWriter sw = new StringWriter();
						result.writeTo(sw)
						print sw.toString()
		
	}

}
