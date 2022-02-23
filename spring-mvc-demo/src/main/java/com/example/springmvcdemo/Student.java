package com.example.springmvcdemo;


import java.util.LinkedHashMap;

public class Student {

    private String firstName;
    private String lastName;
    private String country;
    private String favoriteLanguage;
    private String[] operationSystems;

    private LinkedHashMap<String, String> countryOptions;

    public Student() {
        // populate country options: used ISO country code
        countryOptions = new LinkedHashMap<>();

        countryOptions.put("BR", "Brazil");
        countryOptions.put("FR", "France");
        countryOptions.put("DE", "Germany");
        countryOptions.put("IN", "India");

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public LinkedHashMap<String, String> getCountryOptions() {
        return countryOptions;
    }

    public String getFavoriteLanguage() {
        return favoriteLanguage;
    }

    public void setFavoriteLanguage(String favoriteLanguage) {
        this.favoriteLanguage = favoriteLanguage;
    }

    public void setOperationSystems(String[] operationSystems) {
        this.operationSystems = operationSystems;
    }

    public String[] getOperationSystems() {
        return operationSystems;
    }

    public static final class Distance {
        private String roadTaxType = "";
        private int distance;

        public Distance() {
        }

        public Distance(String roadTaxType, int distance) {
            this.roadTaxType = roadTaxType;
            this.distance = distance;

        }
        public int getDistance() {
            return distance;
        }
        public void setDistance(int distance) {
            this.distance = distance;
        }
        public String getRoadTaxType() {
            return roadTaxType;
        }
        public void setRoadTaxType(String roadTaxType) {
            this.roadTaxType = roadTaxType;
        }
    }
}
