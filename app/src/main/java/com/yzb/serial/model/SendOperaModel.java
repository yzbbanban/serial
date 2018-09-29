package com.yzb.serial.model;

import android.util.Log;

import com.google.gson.Gson;
import com.yzb.serial.app.SerialApplication;
import com.yzb.serial.entity.Bucket;
import com.yzb.serial.entity.ResultCode;
import com.yzb.serial.service.CompareService;
import com.yzb.serial.service.SendService;
import com.yzb.serial.util.LogUtil;
import com.yzb.serial.util.retrofit.MyCallback;
import com.yzb.serial.util.retrofit.RetrofitUtils;

import retrofit2.Call;
import retrofit2.Response;

public class SendOperaModel {

    private static final String TAG = "SendOperaModel";

    public void send(Bucket bucket, final ICallBack callback) {
        final int status = bucket.getStatus();
        SendService request = RetrofitUtils.getRetrofit(SerialApplication.URL).create(SendService.class);
        Call<ResultCode<ResultCode>> call = request.call("" + bucket.getId(), status == 1 ? "O" : "C");
        call.enqueue(new MyCallback<ResultCode<ResultCode>>() {
            @Override
            public void onSuc(Response<ResultCode<ResultCode>> response) {
                Log.i(TAG, "onSuc-->: " + response.code());
                if ("200".equals(response.body().getCode())) {
                    LogUtil.info(TAG, response.body().getMessage());
                    LogUtil.info(TAG, response.body().getCode());
                    callback.setSuccess("" + status);
                } else {
                    callback.setFailure(response.body().getMessage());
                }
            }

            @Override
            public void onFail(String message) {
                Log.i(TAG, "onFail: " + message);
                callback.setFailure(message);
            }
        });
    }

    public void compare(Bucket bucket, final ICallBack callback) {
        CompareService request = RetrofitUtils.getRetrofit(SerialApplication.URL).create(CompareService.class);
        Call<ResultCode<ResultCode>> call = request.call(String.valueOf(bucket.getId()), bucket.getName());
        call.enqueue(new MyCallback<ResultCode<ResultCode>>() {
            @Override
            public void onSuc(Response<ResultCode<ResultCode>> response) {
                Log.i(TAG, "onSuc-->: " + response.code());
                if ("200".equals(response.body().getCode())) {
                    LogUtil.info(TAG, response.body().getMessage());
                    LogUtil.info(TAG, response.body().getCode());
                    callback.setSuccess("3");
                } else {
                    callback.setFailure(response.body().getMessage());
                }
            }

            @Override
            public void onFail(String message) {
                Log.i(TAG, "onFail: " + message);
                callback.setFailure(message);
            }
        });
    }
}
