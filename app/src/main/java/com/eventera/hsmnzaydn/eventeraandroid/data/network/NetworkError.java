package com.eventera.hsmnzaydn.eventeraandroid.data.network;

import android.text.TextUtils;

import com.eventera.hsmnzaydn.eventeraandroid.data.network.model.CommonResponse;
import com.eventera.hsmnzaydn.eventeraandroid.data.network.service.ServiceCallback;
import com.eventera.hsmnzaydn.eventeraandroid.utility.Constant;
import com.eventera.hsmnzaydn.eventeraandroid.utility.Utils;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import retrofit2.Response;
import retrofit2.adapter.rxjava.HttpException;

import static java.net.HttpURLConnection.HTTP_UNAUTHORIZED;

public class NetworkError extends Throwable {
    public static final String DEFAULT_ERROR_MESSAGE = "Something went wrong! Please try again.";
    public static final String NETWORK_ERROR_MESSAGE = "No Internet Connection!";
    private static final String ERROR_MESSAGE_HEADER = "Error-Message";
    private final Throwable error;

    public NetworkError(Throwable e) {
        super(e);
        this.error = e;
    }

    public String getMessage() {
        return error.getMessage();
    }


    public void response(ServiceCallback serviceCallback) {
        if (this.error instanceof IOException) {
            serviceCallback.onError(NETWORK_ERROR_MESSAGE);
        }
        else if (!(this.error instanceof HttpException)) {
            serviceCallback.onError(DEFAULT_ERROR_MESSAGE);
        }
        else {
            retrofit2.Response<?> response = ((HttpException) this.error).response();
            if (response != null) {
                if (!response.isSuccessful()) {
                    serviceCallback.onResponse(Utils.errorHandler(response));
                } else {
                    serviceCallback.onError(DEFAULT_ERROR_MESSAGE);
                }
            }

        }




    }

    public Throwable getError() {
        return error;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NetworkError that = (NetworkError) o;

        return error != null ? error.equals(that.error) : that.error == null;

    }

    @Override
    public int hashCode() {
        return error != null ? error.hashCode() : 0;
    }
}
