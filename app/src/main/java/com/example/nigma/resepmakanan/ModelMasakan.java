package com.example.nigma.resepmakanan;

public class ModelMasakan {
    private String desc;
    private String title;
    private String image;
    private String[] bahan;
    private String[] tahap;

    public ModelMasakan(String title,String image, String desc, String[] bahan, String[] tahap){
        this.title = title;
        this.image = image;
        this.desc = desc;
        this.bahan = bahan;
        this.tahap = tahap;
    }

    public String getImage(){
        return image;
    }
    public String getTitle(){
        return title;
    }
    public String getDesc(){
        return desc;
    }
    public String[] getTahap(){
        return tahap;
    }
    public String[] getBahan(){
        return bahan;
    }
}
