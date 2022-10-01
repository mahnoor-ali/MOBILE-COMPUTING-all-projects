package com.mano.theholyqran;

public class Index {
    private int Id;
    private String nameUrdu;
    private String nameEnglish;


    public Index(int id ,String nameUrdu, String nameEnglish) {
        this.Id = id;
        this.nameUrdu = nameUrdu;
        this.nameEnglish = nameEnglish;
    }

    public String getNameUrdu() {
        return nameUrdu;
    }

    public void setNameUrdu(String nameUrdu) {
        this.nameUrdu = nameUrdu;
    }

    public String getNameEnglish() {
        return nameEnglish;
    }

    public void setNameEnglish(String nameEnglish) {
        this.nameEnglish = nameEnglish;
    }

    public int getId() { return Id; }

    public void setId(int id) { Id = id; }
}
