package services;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.runners.Parameterized.Parameters;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import models.BaselineForecast;

@RestController
public class Service {

	  @GetMapping("/baseline-Forecast/get")
	  public JSONArray getBaselineForecasts() throws ParseException {
		  JSONParser jsonParser = new JSONParser();
		  JSONArray baselineForecastList = null; 
	      
	        try (FileReader reader = new FileReader("baselineForecast.json"))
	        {
	        	Object obj = jsonParser.parse(reader);
	        	 
	        	baselineForecastList = (JSONArray) obj;
	            
	            return baselineForecastList;
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
			return baselineForecastList;
	  }
	  
	  @POST
	  @Path("/baseline-forecast/{product}/{store}/{week}/{baselineforecast}")
	  public void putBaselineForecasts(@PathParam("product") String product, 
              @PathParam("store") String store, @PathParam("week") String week, @PathParam("baselineforecast") String baselineforecast) throws ParseException, IOException {
		 FileWriter file = new FileWriter("baselineForecast.json");
		 JSONObject baselineJsonObj = new JSONObject();
		 baselineJsonObj.put("product", product);
		 baselineJsonObj.put("store", store);
		 baselineJsonObj.put("week", week);
		 baselineJsonObj.put("baseline forecast", baselineforecast);
		 
	     JSONParser jsonParser = new JSONParser();
	        
		 try (FileReader reader = new FileReader("baselineForecast.json"))
	        {
	        	Object obj = jsonParser.parse(reader);
	        	 
	            JSONArray productList = (JSONArray) obj;
	            productList.put(productList);
	            
	            try {
	            	file = new FileWriter("baselineForecast.json");
		            file.write(productList.toString());
	            } catch (IOException e) {
	                e.printStackTrace();
	     
	            } finally {
	     
	                try {
	                    file.flush();
	                    file.close();
	                } catch (IOException e) {
	                    // TODO Auto-generated catch block
	                    e.printStackTrace();
	                }
	            }
	        }
	  }
	  
	  @GetMapping("/promos/get")
	  public JSONArray getPromos() throws ParseException {
		  JSONParser jsonParser = new JSONParser();
		  JSONArray promos = null; 
	      
	        try (FileReader reader = new FileReader("promos.json"))
	        {
	        	Object obj = jsonParser.parse(reader);
	        	 
	        	promos = (JSONArray) obj;
	            
	            return promos;
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
			return promos;
	  }
	  
	  @POST
	  @Path("/promos/{promo_id}/{products}/{stores}/{start_date}/{end_date}/{promo_multiplier}")
	  public void putPromos(@PathParam("products") String promo_id,@PathParam("products") String products, 
              @PathParam("stores") String stores, @PathParam("start_date") String start_date, @PathParam("end_date") String end_date, @PathParam("promo_multiplier") String promo_multiplier) throws ParseException, IOException {
		 FileWriter file = new FileWriter("promos.json");
		 JSONObject promosObj = new JSONObject();
		 promosObj.put("promo_id", promo_id);
		 promosObj.put("products", products);
		 promosObj.put("stores", stores);
		 promosObj.put("start_date", start_date);
		 promosObj.put("end_date", end_date);
		 promosObj.put("promo_multiplier", promo_multiplier);
	     JSONParser jsonParser = new JSONParser();
	        
		 try (FileReader reader = new FileReader("promos.json"))
	        {
	        	Object obj = jsonParser.parse(reader);
	        	 
	            JSONArray productList = (JSONArray) obj;
	            productList.put(productList);
	            
	            try {
	            	file = new FileWriter("promos.json");
		            file.write(productList.toString());
	            } catch (IOException e) {
	                e.printStackTrace();
	     
	            } finally {
	     
	                try {
	                    file.flush();
	                    file.close();
	                } catch (IOException e) {
	                    // TODO Auto-generated catch block
	                    e.printStackTrace();
	                }
	            }
	        }
	  }

	  
	  @GET
	  @Path("/total-forecast/{product}/{store}/{week}")
	  public double getTotalForecast(@PathParam("product") String product, 
              @PathParam("store") String store, @PathParam("week") String week) throws ParseException, java.text.ParseException{
		  
		  
		  return  ProductServiceImpl.result(week, product, store);
		  }
}
