package com.mano.customizedlistview;

public class Student {
    private String name;
    private Integer id;
    private String section;
    private Integer imgId;

    public Student(String name, Integer id, String section, Integer imgId) {
        this.name = name;
        this.id = id;
        this.section = section;
        this.imgId = imgId;
    }

    public String getName() {
        return name;
    }

    public Integer getId() {
        return id;
    }

    public String getSection() {
        return section;
    }

    public Integer getImgId() {
        return imgId;
    }



}
