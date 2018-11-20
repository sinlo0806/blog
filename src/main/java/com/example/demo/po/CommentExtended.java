package com.example.demo.po;

import com.example.demo.utils.Utils;

public class CommentExtended extends Comment {
    private String emailMD5;

    public String getEmailMD5() {
        return Utils.StringToMd5(getEmail());
    }

    public void setEmailMD5(String emailMD5) {
        this.emailMD5 = emailMD5;
    }
}
