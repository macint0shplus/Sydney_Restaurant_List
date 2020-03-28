package au.edu.unsw.infs3634.cryptobag;

import java.util.ArrayList;

public class Restaurant {
    private String name;
    private String cuisine;
    private String location;
    private double rating;
    private String phone;


    public Restaurant() {
    }

    public Restaurant(String name, String cuisine, String location, double rating, String phone) {
        this.name = name;
        this.cuisine = cuisine;
        this.location = location;
        this.rating = rating;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getcuisine() {
        return cuisine;
    }
    public void setcuisine(String cuisine) {
        this.name = cuisine;
    }

    public String getlocation() {
        return location;
    }
    public void setlocation(String location) {
        this.location = location;
    }

    public double getrating() {
        return rating;
    }
    public void setrating(double rating) {
        this.rating = rating;
    }

    public String getphone() { return phone; }
    public void setphone(String phone) {
        this.phone = phone;
    }


    public static ArrayList<Restaurant> getRestaurants() {
        ArrayList<Restaurant> restaurants = new ArrayList<>();
        restaurants.add(new Restaurant("Flower Child",
                "Café - Bakery, Cafe Food, Coffee and Tea",
                "Shop 391, Westfield Chatswood, 1 Anderson Street, Chatswood, Sydney",
                4.2,
                "+(61)294121555"));
        restaurants.add(new Restaurant("Khao Pla",
                "Casual Dining - Thai",
                "Shop 7, 370 Victoria Avenue, Chatswood, Sydney",
                4,
                "+(61)294124978"));
        restaurants.add(new Restaurant("Circa",
                "Café - Cafe Food, Coffee and Tea",
                "21 Wentworth Street, Parramatta, Sydney",
                5.0,
                "+(61)292950173"));
        restaurants.add(new Restaurant("El Jannah",
                "Fast Food - Lebanese, Charcoal Chicken",
                "4-8 South Street, Granville, Sydney",
                4.5,
                "+(61)296370977"));
        restaurants.add(new Restaurant("Temasek",
                "Casual Dining - Malaysian, Singaporean",
                "71 George Street, Parramatta, Sydney",
                3.8,
                "+(61)296339926"));
        restaurants.add(new Restaurant("Brighton Dessert Parlour",
                "Desserts, Coffee and Tea Brighton",
                "83 The Grand Parade, Brighton, Sydney",
                3.5,
                "+(61)295561727"));
        restaurants.add(new Restaurant("Hurricane's Grill Brighton",
                "Casual Dining - Steak, Modern Australian, Salad",
                "95 Grand Parade, Brighton, Sydney",
                2.8,
                "+(61)292112210"));
        restaurants.add(new Restaurant("Top Impression Bakery",
                "Café, Bakery, Desserts, Coffee and Tea",
                "Discovery Point, Brodie Spark Drive, Wolli Creek, Arncliffe, Sydney",
                3.7,
                "(61)292139264"));
        restaurants.add(new Restaurant("An Restaurant",
                "Casual Dining - Vietnamese, Pho",
                "27 Greenfield Parade, Bankstown, Sydney",
                4,
                "+(61)297967826"));
        restaurants.add(new Restaurant("Holy Basil",
                "Casual Dining - Thai, Laotian",
                "233 Canley Vale, Canley Heights, Sydney",
                4,
                "+(61)297277585"));
        restaurants.add(new Restaurant("Hugos Manly",
                "Casual Dining - Modern Australian, Tapas",
                "Manly Wharf, 21 East Esplanade, Manly, Sydney",
                4.3,
                "+(61)281168555"));
        restaurants.add(new Restaurant("Hemingway's",
                "Café, Casual Dining - Coffee and Tea, French, Cafe Food",
                "48 North Steyne, Manly, Sydney",
                1.4,
                "+(61)299763030"));
        return restaurants;
    }
}