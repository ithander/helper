package test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

import groovy.util.ResourceConnector;
import groovy.util.ResourceException;

public class MySQLResource implements ResourceConnector {

	@Override
	public URLConnection getResourceConnection(String name) throws ResourceException {
		try{
		    new URLConnection(new URL("")){
	
				@Override
				public void connect() throws IOException {
					
				}
				
		    };
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

}
