package com.example.helloworld;

import android.os.Parcel;
import android.os.Parcelable;

public class detailClass implements Parcelable {
    String name, age, refer, gender;
    detailClass(String name,String age,String refer, String gender)
    {
        this.name=name;
        this.age=age;
        this.refer=refer;
        this.gender=gender;
    }

    protected detailClass(Parcel in) {
        name = in.readString();
        age = in.readString();
        refer = in.readString();
        gender = in.readString();
    }

    public static final Creator<detailClass> CREATOR = new Creator<detailClass>() {
        @Override
        public detailClass createFromParcel(Parcel in) {
            return new detailClass(in);
        }

        @Override
        public detailClass[] newArray(int size) {
            return new detailClass[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(age);
        dest.writeString(refer);
        dest.writeString(gender);
    }
}
