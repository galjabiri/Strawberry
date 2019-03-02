package com.otb.strawberryroad;

import java.io.Serializable;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity (tableName="Mobile_Table")
public class Mobile implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name="mobile_number")
    private String number;

    @ColumnInfo(name="default_number")
    private boolean default_one;

    @ColumnInfo(name="verified_number")
    private boolean verified;

    /* setters and getters*/
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id=id;
    }

    public String getNumber(){
        return number;
    }
    public void setNumber(String number){
        this.number=number;
    }

    public boolean getDefault_one() {
        return default_one;
    }
    public void setDefault_one(boolean default_one){
        this.default_one=default_one;
    }

    public boolean getVerified() {
        return verified;
    }
    public void setVerified(boolean verified) {
        this.verified = verified;
    }
}
