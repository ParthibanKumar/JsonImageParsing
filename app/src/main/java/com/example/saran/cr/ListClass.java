package com.example.saran.cr;

public class ListClass  {

    String rank;
    String country;
    String population;
    String img;

    public ListClass(String countries, String countries1, String countries2) {
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }




    public ListClass(String rank, String country, String population, String img) {
        this.rank = rank;
        this.country = country;
        this.population = population;
        this.img = img;
    }



}
