package com.dsmmjr.entity;

import android.os.Parcel;
import android.os.Parcelable;

public class ResponseInfoEntity implements Parcelable {

    private int code;
    private String msg;
    private String userinfo;

    protected ResponseInfoEntity(Parcel in) {
        code = in.readInt();
        msg = in.readString();
        userinfo = in.readString();
    }

    public static final Creator<ResponseInfoEntity> CREATOR = new Creator<ResponseInfoEntity>() {
        @Override
        public ResponseInfoEntity createFromParcel(Parcel in) {
            return new ResponseInfoEntity(in);
        }

        @Override
        public ResponseInfoEntity[] newArray(int size) {
            return new ResponseInfoEntity[size];
        }
    };

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getUserinfo() {
        return userinfo;
    }

    public void setUserinfo(String userinfo) {
        this.userinfo = userinfo;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(code);
        dest.writeString(msg);
        dest.writeString(userinfo);
    }
}
