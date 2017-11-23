package com.amazonaws.lambda.demo;

import org.json.JSONException;
import org.json.JSONObject;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


public class LambdaFunction implements RequestHandler<Object, String> {

    @Override
    public String handleRequest(Object input, Context context) {    	
    	  	
    	JSONObject jsonObj = null;
    			
		try {
			
			jsonObj = new JSONObject(new ObjectMapper().writeValueAsString(input));
			context.getLogger().log("jsonObj:" + jsonObj);		
			
		} catch (JsonProcessingException | JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
        // TODO: implement your handler
        return "Hello from Lambda!";
    }
}
