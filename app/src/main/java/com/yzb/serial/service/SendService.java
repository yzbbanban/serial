package com.yzb.serial.service;

import com.yzb.serial.entity.ResultCode;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by brander on 2017/8/3.
 */

public interface SendService {
    @POST("json")
    @FormUrlEncoded
    Call<ResultCode<ResultCode>> call(@Field("id") String id, @Field("status") String status, @Field("isStatus") String isStatus);
//    Call<ResultCode<ResultCode>> call(@Query("bucket") String bucket);
}