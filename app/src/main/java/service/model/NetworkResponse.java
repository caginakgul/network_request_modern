package service.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import service.model.IletisimResult;

/**
 * Created by mobile on 6.06.2018.
 */

public class NetworkResponse {
    @SerializedName("code")
    @Expose
    private String code;
    @SerializedName("result")
    @Expose
    private IletisimResult result;
    @SerializedName("error")
    @Expose
    private Object error;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public IletisimResult getResult() {
        return result;
    }

    public void setResult(IletisimResult result) {
        this.result = result;
    }

    public Object getError() {
        return error;
    }

    public void setError(Object error) {
        this.error = error;
    }
}
