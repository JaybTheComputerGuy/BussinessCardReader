package com.example.jayb.bizcard;

/**
 * Created by jayb on 6/8/15.
 */
public class BizCardDataSource {
    private String job_title;
    private int cell_number;

    public BizCardDataSource(String title,int cell_number){
        this.job_title = title;
        this.cell_number = cell_number;
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
