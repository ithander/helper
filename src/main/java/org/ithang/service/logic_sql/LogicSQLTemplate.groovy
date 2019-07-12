package org.ithang.service.logic_sql

class LogicSQLTemplate {

	
	static def String querySQL='''
                       select `key`,`content`,`opt` from logic_sql where 1=1
                       <%if(null!=key){%>
                        and `key`='${key}'
                       <%}%>
                       <%if(null!=content){%>
                        and `content`='${content}'
                       <%}%>
                       <%if(null!=opt){%>
                        and `opt`='${opt}'
                       <%}%>
                     ''' 
	
}
