package org.ithang.service.kvalues

class KValuesTemplate {

	
	static def String query='''
                       select `key`,`value`,`opt` from kvalues where 1=1
                       <%if(null!=key){%>
                        and `key`=${key}
                       <%}%>
                       <%if(null!=value){%>
                        and `value`=${value}
                       <%}%>
                       <%if(null!=opt){%>
                        and `opt`=${opt}
                       <%}%>
                     ''' 
	
}
