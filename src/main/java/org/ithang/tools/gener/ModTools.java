package org.ithang.tools.gener;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ModTools {

	
	private static Map<Class<?>,ModelSQL> mds=new ConcurrentHashMap<>(50);
	
	public static String select(Class<?> cls,String ...fieldNames){
		StringBuilder sb=new StringBuilder();
		ModelSQL md=getModelSQL(cls);
    	sb.append("select ");
    	
    	if(null!=fieldNames&&fieldNames.length>0){
    		int i=0;
    		for(String fieldName:fieldNames){
    			if(i>0){
    				sb.append(" , ");
    			}
    			sb.append("`").append(md.getColumnName(fieldName)).append("`");
    			i++;
    		}
    	}else{
    		String[] columnNames=md.getColumnNames();
    		if(null!=columnNames){
    			int i=0;
    			for(String cm:columnNames){
    				if(i>0){
    					sb.append(",");
    				}
        			sb.append("`").append(cm).append("`");
        			i++;
        		}
    		}
    	}
    	sb.append(" from ").append(md.getTableName());
		return sb.toString();
	}
	
	public static String insert(Class<?> cls){
		StringBuilder sb=new StringBuilder();
		ModelSQL md=getModelSQL(cls);
    	sb.append("insert into ").append(md.getTableName());
    	String[] columnNames=md.getColumnNames();
    	String[] fieldNames=md.getFieldNames();
    	if(null!=columnNames){
    		int i=0;
    		sb.append("(");
			for(String cm:columnNames){
				if(i>0){
					sb.append(",");
				}
				sb.append("`").append(cm).append("`");
    			i++;
    		}
			sb.append(")");
    	}
    	sb.append("values");
    	if(null!=fieldNames){
    		int i=0;
    		sb.append("(");
			for(String cm:fieldNames){
				if(i>0){
					sb.append(",");
				}
    			sb.append(":").append(cm);
    			i++;
    		}
			sb.append(")");
    	}
		return sb.toString();
	}
	
	public static String insert(Class<?> cls,Object obj){
		StringBuilder sb=new StringBuilder();
		try{
			ModelSQL md=getModelSQL(cls);
	    	sb.append("insert into ").append(md.getTableName());
	    	String[] columnNames=md.getColumnNames();
	    	String[] fieldNames=md.getFieldNames();
	    	if(null!=columnNames){
	    		int i=0;
	    		sb.append("(");
				for(String cm:columnNames){
					if(i>0){
						sb.append(",");
					}
	    			sb.append("`").append(cm).append("`");
	    			i++;
	    		}
				sb.append(")");
	    	}
	    	sb.append("values");
	    	if(null!=fieldNames){
	    		int i=0;
	    		sb.append("(");
				for(String cm:fieldNames){
					if(i>0){
						sb.append(",");
					}
					Field f=md.getField(cm);
					f.setAccessible(true);
					if(f.getType()==String.class){
						sb.append("'").append(f.get(obj)==null?"":f.get(obj)).append("'");
					}else{
						sb.append(f.get(obj)==null?"":f.get(obj));	
					}
	    			
	    			i++;
	    		}
				sb.append(")");
	    	}
		}catch(Exception e){
			e.printStackTrace();
		}
		return sb.toString();
	}
	
    public static String update(Class<?> cls,String ...fieldNames){
    	StringBuilder sb=new StringBuilder();
    	ModelSQL md=getModelSQL(cls);
    	String[] primaryFieldNames=md.getPrimaryFieldNames();
    	sb.append("update ").append(md.getTableName());
    	if(null==fieldNames){
    		fieldNames=md.getFieldNames();
    	}
    	int i=0;
		sb.append(" set ");
		for(String fieldName:fieldNames){
			
			for(String pfn:primaryFieldNames){
				if(fieldName==pfn){
					continue;
				}
			}
			
			if(i>0){
				sb.append(" , ");
			}
			sb.append("`").append(md.getColumnName(fieldName)).append("`").append("=:").append(fieldName);
			i++;
		}
		
		sb.append(" where ");
		i=0;
		boolean named=primaryFieldNames.length>2?true:false;
		for(String fieldName:primaryFieldNames){
			if(i>0){
				sb.append(" and ");
			}
			sb.append(fieldName);
			if(named){
				sb.append("=:").append(md.getColumnName(fieldName));
			}else{
			    sb.append("=?");
			}
			i++;
		}
    	return sb.toString();
    }
    
    public static String delete(Class<?> cls){
    	StringBuilder sb=new StringBuilder();
    	ModelSQL md=getModelSQL(cls);
    	String[] primaryFieldNames=md.getPrimaryFieldNames();
    	
    	sb.append("delete from ").append(md.getTableName());
    	
    	if(null!=primaryFieldNames&&primaryFieldNames.length>0){
    		sb.append(" where ");
    		boolean named=primaryFieldNames.length>1?true:false;
    		int i=0;
    		for(String fieldName:primaryFieldNames){
    			if(i>0){
    				sb.append(" and ");
    			}
    			sb.append("`").append(md.getColumnName(fieldName)).append("`");
    			if(named){
    				sb.append("=:").append(md.getColumnName(fieldName));
    			}else{
    			    sb.append("=?");
    			}
    			i++;
    		}
    	}
    	
    	return sb.toString();
    }
	
	
	/**
	 * 获取ModelSQL实例
	 * @param cls
	 * @return
	 */
	public static ModelSQL getModelSQL(Class<?> cls){
		if(mds.containsKey(cls)){
			return mds.get(cls);
		}else{
			ModelSQL ms=new ModelSQL(cls);
			mds.put(cls, ms);
			return ms;
		}
	}
	
	
}
