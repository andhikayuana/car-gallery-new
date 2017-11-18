package com.galleryapp.cargallery.data.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @author yuana <andhikayuana@gmail.com>
 * @since 10/14/17
 */

public class Car implements Parcelable {

    public static final Parcelable.Creator<Car> CREATOR = new Parcelable.Creator<Car>() {
        @Override
        public Car createFromParcel(Parcel source) {
            return new Car(source);
        }

        @Override
        public Car[] newArray(int size) {
            return new Car[size];
        }
    };
    private int id;
    private String year;
    private String make;
    private String model;

    public Car() {
    }

    protected Car(Parcel in) {
        this.id = in.readInt();
        this.year = in.readString();
        this.make = in.readString();
        this.model = in.readString();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", year='" + year + '\'' +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.year);
        dest.writeString(this.make);
        dest.writeString(this.model);
    }
}
