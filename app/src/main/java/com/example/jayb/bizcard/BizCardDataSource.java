package com.example.jayb.bizcard;

/**
 * Created by jayb on 6/8/15.
 */
public class BizCardDataSource {
    private String job_title;
    private int cell_number;
    private String url;
    private String email;
    private String name;

    public BizCardDataSource(String title,int number,String web_url,String email_addres,String full_names){
        this.job_title = title;
        this.cell_number = number;
        this.url = web_url;
        this.email = email_addres;
        this.name = full_names;

    }

    public String getTitle() {
        return job_title;
    }
    public int getNumber() {
        return cell_number;
    }

    public void setTitle(String time) {
        this.job_title = time;
    }
    public void setNumber(int num) {
        this.cell_number = num;
    }


}
