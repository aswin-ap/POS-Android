package com.example.pos_android.data.model;

    public class PopularModel  {
    private String name;
    private int imageId;
    private String imageUrl;
    private String discription;

    // Constructor
    public PopularModel(String name, int imageId, String discription){
        this.name = name;
        this.imageId = imageId;
        this.discription = discription;
    }

        public PopularModel(String name, String imageUrl, String discription) {
            this.name = name;
            this.imageUrl = imageUrl;
            this.discription = discription;
        }

        public String getImageUrl() {
            return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }

        //Setting up the getter methods
    public String getName() {
        return name;
    }

    public int getImageId() {
        return imageId;
    }

    public String getdiscription() {
        return discription;
    }
}