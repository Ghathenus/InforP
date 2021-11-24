package services;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.*;
import org.json.simple.parser.JSONParser;

import models.BaselineForecast;
import models.Promo;

public class ProductServiceImpl {

    static SimpleDateFormat dateFormatter=new SimpleDateFormat("yyyy-MM-dd");  
    
    public static double result(String dateParam, String product, String store) throws org.json.simple.parser.ParseException, ParseException {
    	String id = compareDate(dateParam, product, store);
    	double totalForecast;
    	BaselineForecast baselineForecastObj = fetchProduct(product, store, dateParam);
    	double baselineForecast= baselineForecastObj.getBaselineForecast();
    	double promo;
    	if(id != null) {
            promo = getPromoById(id).getPromo_multiplier();
            totalForecast = baselineForecast * promo;
    	} else {
    		totalForecast = baselineForecast;
    	}
    	return totalForecast;
    }

    private static String compareDate(String dateParam, String product, String store) throws org.json.simple.parser.ParseException, ParseException {
    	Date date = null;
    	try {
             date = dateFormatter.parse(dateParam);
        } catch (ParseException e) {
            System.out.println("ProductServiceImpl.compareDate.dateParam: "+ dateParam + "Unparsable date");
        }
        
        Promo promo = fetchPromo(product, store);
        String promo_start_date = promo.getStart_date();
        String promo_end_date = promo.getEnd_date();
        
        Date startDate = dateFormatter.parse(promo_start_date);
        Date endDate = dateFormatter.parse(promo_end_date);
        
        if(date.compareTo(endDate) <= 0 && date.compareTo(startDate) >= 0 )
        	return promo.getPromo_id();
        return null;
        //call fetch product
    }

    private static Promo fetchPromo(String product, String store) throws org.json.simple.parser.ParseException {
        //JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();
    	Promo result = new Promo();
      
        try (FileReader reader = new FileReader("promos.json"))
        {
        	Object obj = jsonParser.parse(reader);
        	 
            JSONArray promoList = (JSONArray) obj;
            System.out.println(promoList);
             
            for(Object promo : promoList) {
            	Promo promoObj = (Promo) promo;
            	List<String> products = promoObj.getProducts();
            	List<String> stores = promoObj.getStores();
            	if(products.contains(product) && stores.contains(store))
            		result = promoObj;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
    
    private static BaselineForecast fetchProduct(String product, String store, String week) throws org.json.simple.parser.ParseException {
        //JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();
    	BaselineForecast result = new BaselineForecast();
      
        try (FileReader reader = new FileReader("promos.json"))
        {
        	Object obj = jsonParser.parse(reader);
        	 
            JSONArray productList = (JSONArray) obj;
            System.out.println(productList);
             
            for(Object prod : productList) {
            	BaselineForecast productObj = (BaselineForecast) prod;
            	String productName = productObj.getProduct();
            	String storeName = productObj.getStore();
            	String weekProduct = productObj.getWeek();
            	if(productName.equals(product) && storeName.equals(store) && weekProduct.equals(week))
            		result = productObj;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
    
    private static Promo getPromoById(String id) throws org.json.simple.parser.ParseException {
        //JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();
    	Promo result = new Promo();
      
        try (FileReader reader = new FileReader("promos.json"))
        {
        	Object obj = jsonParser.parse(reader);
        	 
            JSONArray promoList = (JSONArray) obj;
            System.out.println(promoList);
             
            for(Object promo : promoList) {
            	Promo promoObj = (Promo) promo;
            	if(promoObj.getPromo_id().equals(id))
            		result = promoObj;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
   // public static String getStringValue(final String data, final String memberName)
  //  {
    //	final JSONElement element = getJsonElement(data,memberName);
    	
   // }
    
    public static Map<String, String> getQueryMap(String query) {  
        String[] params = query.split("&");  
        Map<String, String> map = new HashMap<String, String>();

        for (String param : params) {  
            String name = param.split("=")[0];  
            String value = param.split("=")[1];  
            map.put(name, value);  
        }  
        return map;  
    
    }
    
    
    
}
