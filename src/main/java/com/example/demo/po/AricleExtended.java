package com.example.demo.po;

import com.example.demo.utils.Utils;

public class AricleExtended extends Article {
  private String date;

 private String title;

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return Utils.formatDate(this.getCreationdate());
    }

    public void setDate(String date) {
        this.date = date;
    }
}
