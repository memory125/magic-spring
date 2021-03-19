package com.wing.pojo;

public class Address {
    private int postId;
    private String addressInfo;

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public String getAddressInfo() {
        return addressInfo;
    }

    public void setAddressInfo(String addressInfo) {
        this.addressInfo = addressInfo;
    }

    @Override
    public String toString() {
        return "Address{" +
                "postId=" + postId +
                ", addressInfo='" + addressInfo + '\'' +
                '}';
    }
}
