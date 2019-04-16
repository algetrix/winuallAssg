package com.example.Assignment;

import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

@android.arch.persistence.room.Entity(tableName = "defaultdata")
public class Entity {
    @PrimaryKey(autoGenerate = true)
    int id;
    double maxTempMum;
    double minTempMum;
    double maxTempAhm;
    double minTempAhm;

    public Entity(int id, double maxTempMum, double minTempMum, double maxTempAhm, double minTempAhm) {
        this.id = id;
        this.maxTempMum = maxTempMum;
        this.minTempMum = minTempMum;
        this.maxTempAhm = maxTempAhm;
        this.minTempAhm = minTempAhm;
    }
    @Ignore
    public Entity(double maxTempMum, double minTempMum, double maxTempAhm, double minTempAhm) {
        this.maxTempMum = maxTempMum;
        this.minTempMum = minTempMum;
        this.maxTempAhm = maxTempAhm;
        this.minTempAhm = minTempAhm;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getMaxTempMum() {
        return maxTempMum;
    }

    public void setMaxTempMum(double maxTempMum) {
        this.maxTempMum = maxTempMum;
    }

    public double getMinTempMum() {
        return minTempMum;
    }

    public void setMinTempMum(double minTempMum) {
        this.minTempMum = minTempMum;
    }

    public double getMaxTempAhm() {
        return maxTempAhm;
    }

    public void setMaxTempAhm(double maxTempAhm) {
        this.maxTempAhm = maxTempAhm;
    }

    public double getMinTempAhm() {
        return minTempAhm;
    }

    public void setMinTempAhm(double minTempAhm) {
        this.minTempAhm = minTempAhm;
    }
}
