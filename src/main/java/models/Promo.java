package models;

import java.util.List;

public class Promo {
	
	public Promo() {
		
	}
    
    public Promo(String promo_id, List<String> products, List<String> stores, String start_date, String end_date,
            double promo_multiplier) {
        this.promo_id = promo_id;
        this.products = products;
        this.stores = stores;
        this.start_date = start_date;
        this.end_date = end_date;
        this.promo_multiplier = promo_multiplier;
    }
    private String promo_id;
    private List<String> products;
    private List<String> stores;
    private String start_date;
    private String end_date;
    private double promo_multiplier;
    public String getPromo_id() {
        return promo_id;
    }
    public void setPromo_id(String promo_id) {
        this.promo_id = promo_id;
    }
    public List<String> getProducts() {
        return products;
    }
    public void setProducts(List<String> products) {
        this.products = products;
    }
    public List<String> getStores() {
        return stores;
    }
    public void setStores(List<String> stores) {
        this.stores = stores;
    }
    public String getStart_date() {
        return start_date;
    }
    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }
    public String getEnd_date() {
        return end_date;
    }
    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }
    public double getPromo_multiplier() {
        return promo_multiplier;
    }
    public void setPromo_multiplier(double promo_multiplier) {
        this.promo_multiplier = promo_multiplier;
    }
}
