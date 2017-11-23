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
			
			jsonObj = new JSONObject(new ObjectMapper().writeValueAsString(input));  // convert object to json object			
			context.getLogger().log("jsonObj before:" + jsonObj);				
			
		} catch (JsonProcessingException | JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}				
		
		
		try {
			jsonObj.getJSONObject("response").put("autoVerifyEmail", true);
			jsonObj.getJSONObject("response").put("autoConfirmUser", true);
			
			context.getLogger().log("jsonObj after:" + jsonObj);					
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
        // TODO: implement your handler
        return jsonObj.toString();
    }
}
