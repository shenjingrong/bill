package com.blackfinger.bill.model;

public class AccountInfo {

    int accountId;

    float accountAmount;

    String createTime;

    String userId;

    String password;

    float clothesStandrad;

    float eatStandrad;
    float liveStandrad;
    float goStandrad;
    float clothesCurrent;
    float eatCurrent;
    float goCurrent;
    float liveCurrent;

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public float getAccountAmount() {
        return accountAmount;
    }

    public void setAccountAmount(float accountAmount) {
        this.accountAmount = accountAmount;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public float getClothesStandrad() {
        return clothesStandrad;
    }

    public void setClothesStandrad(float clothesStandrad) {
        this.clothesStandrad = clothesStandrad;
    }

    public float getEatStandrad() {
        return eatStandrad;
    }

    public void setEatStandrad(float eatStandrad) {
        this.eatStandrad = eatStandrad;
    }

    public float getLiveStandrad() {
        return liveStandrad;
    }

    public void setLiveStandrad(float liveStandrad) {
        this.liveStandrad = liveStandrad;
    }

    public float getGoStandrad() {
        return goStandrad;
    }

    public void setGoStandrad(float goStandrad) {
        this.goStandrad = goStandrad;
    }

    public float getClothesCurrent() {
        return clothesCurrent;
    }

    public void setClothesCurrent(float clothesCurrent) {
        this.clothesCurrent = clothesCurrent;
    }

    public float getEatCurrent() {
        return eatCurrent;
    }

    public void setEatCurrent(float eatCurrent) {
        this.eatCurrent = eatCurrent;
    }

    public float getGoCurrent() {
        return goCurrent;
    }

    public void setGoCurrent(float goCurrent) {
        this.goCurrent = goCurrent;
    }

    public float getLiveCurrent() {
        return liveCurrent;
    }

    public void setLiveCurrent(float liveCurrent) {
        this.liveCurrent = liveCurrent;
    }
}
