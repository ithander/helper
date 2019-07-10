package org.ithang.tools.gener

class FTL {

	//生成一个groovy bean
	def static beanFTL='''
         
                class ${clsName}{
                     <% fields.each({print it.fieldType+' '+it.fieldName +'\\n\\t\\t\\t'}) %>
                }
             ''';
			 
	def static serviceFTL='''

                          
                          ''';

			 
	static String getBeanFTL(){
		return beanFTL;
	}
			 	
}
