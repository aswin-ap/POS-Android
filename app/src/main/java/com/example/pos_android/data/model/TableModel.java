package com.example.pos_android.data.model;

public class TableModel {
    private String name;
    private int imageId;
    private int tableId;
    private String discription;
    private Boolean isSelected = false;

    public TableModel(String name, int imageId, int tableId, String discription,Boolean isSelected) {
        this.name = name;
        this.imageId = imageId;
        this.tableId = tableId;
        this.discription = discription;
        this.isSelected = isSelected;
    }

    public Boolean getSelected() {
        return isSelected;
    }

    public void setSelected(Boolean selected) {
        isSelected = selected;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public int getTableId() {
        return tableId;
    }

    public void setTableId(int tableId) {
        this.tableId = tableId;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }
}
