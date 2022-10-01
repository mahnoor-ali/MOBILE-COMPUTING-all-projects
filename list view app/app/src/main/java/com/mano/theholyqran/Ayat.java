package com.mano.theholyqran;

public class Ayat {
    private String arabic;
    private String english;
    private String urdu;

    public String getArabic() {
        return arabic;
    }

    public void setArabic(String arabic) {
        this.arabic = arabic;
    }

    public String getEnglish() {
        return english;
    }

    public void setEnglish(String english) {
        this.english = english;
    }

    public String getUrdu() {
        return urdu;
    }

    public void setUrdu(String urdu) {
        this.urdu = urdu;
    }

    public Ayat(String arabic, String english, String urdu) {
        this.arabic = arabic;
        this.english = english;
        this.urdu = urdu;
    }
}
