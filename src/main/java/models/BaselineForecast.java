package models;

public class BaselineForecast {
    private String product;
    private String store;
    private String week;
    private double baselineForecast;
    
    public BaselineForecast() {
    	
    }

    public BaselineForecast(String product, String store, String week, double baselineForecast) {
        this.product = product;
        this.store = store;
        this.week = week;
        this.baselineForecast = baselineForecast;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    public double getBaselineForecast() {
        return baselineForecast;
    }

    public void setBaselineForecast(double baselineForecast) {
        this.baselineForecast = baselineForecast;
    }    
}

