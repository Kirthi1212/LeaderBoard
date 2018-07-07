package com.example.rmkengineeringcollege.leaderboard;

/**
 * Created by R.M.KEngineeringCollege on 06/07/18.
 */
import com.google.firebase.database.IgnoreExtraProperties;


@IgnoreExtraProperties

public class Users {

    public String empid;
    public String name;
    public String branch;
    public long score;

    public Users(){
        //this constructor is required
    }

    public Users(String empid, String name, String branch,long score) {
        this.empid = empid;
        this.name = name;
        this.branch = branch;
        this.score = score;
    }

    public String getEmpid() {
        return empid;
    }

    public String getName() {
        return name;
    }

    public String getBranch() {
        return branch;
    }

    public long getScore() {
        return score;
    }
}