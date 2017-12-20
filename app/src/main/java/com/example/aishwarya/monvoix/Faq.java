package com.example.aishwarya.monvoix;

/**
 * Created by aishwarya on 10/03/17.
 */

public class Faq {
    private String question, ans;

    public Faq() {
    }

    public Faq(String question, String ans) {
        this.question = question;
        this.ans = ans;
    }

    public String getquestion() {
        return question;
    }

    public void setquestion(String name) {
        this.question = name;
    }

    public String getans() {
        return ans;
    }

    public void setans(String ans) {
        this.ans = ans;
    }
}
