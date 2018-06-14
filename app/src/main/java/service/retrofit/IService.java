package service.retrofit;

import service.model.IletisimPayload;
import service.model.NetworkResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import service.Const;

/**
 * Created by mobile on 31.05.2018.
 */

public interface IService {
    @POST(Const.Api.contactUs)
    Call<NetworkResponse> getContact(@Body IletisimPayload iletisimPayload);

}
