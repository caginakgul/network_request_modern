package service.repositories;

import android.arch.lifecycle.MutableLiveData;
import android.content.Context;
import android.util.Log;

import service.model.IletisimPayload;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import com.teb.kos.kosovakurumsal.app.AppController;
import service.model.NetworkResponse;

import service.retrofit.IService;

/**
     TODO live data (enqueue kullanımının kalkması lazım
 */

public class ContactUsRepository {
    @Inject
    IService service;

    AppController appController;

    /*
    Livedata + retrofit2 + dagger
     */
  /*  public LiveData<NetworkResponse> contactRequest(Context context, IletisimPayload iletisimPayload) {
        Log.d("contactRequest ", "run");
        final MutableLiveData<NetworkResponse> data = new MutableLiveData<>();
        appController = AppController.create(context);
        appController.getAppComponent().inject(this);

        service.getContact(iletisimPayload).enqueue(new Callback<NetworkResponse>() {
            @Override
            public void onResponse(Call<NetworkResponse> call, Response<NetworkResponse> response) {
                Log.d("getContact onResponse", response.body().getResult().getContactResult().toString());
                data.setValue(response.body());
                data.postValue(response.body());
            }

            @Override
            public void onFailure(Call<NetworkResponse> call, Throwable t) {
                Log.d("onFailure ", "error!");
                data.setValue(null);
            }

        });

        Log.d("contactRequest", "data return :");
        return data;
    }*/

    public void contactRequest(Context context, IletisimPayload iletisimPayload, final MutableLiveData<NetworkResponse> data) {
        Log.d("contactRequest ", "run");
        //final MutableLiveData<NetworkResponse> data = new MutableLiveData<>();
        appController = AppController.create(context);
        appController.getAppComponent().inject(this);

        service.getContact(iletisimPayload).enqueue(new Callback<NetworkResponse>() {
            @Override
            public void onResponse(Call<NetworkResponse> call, Response<NetworkResponse> response) {
                Log.d("getContact onResponse", response.body().getResult().getContactResult().toString());
                data.postValue(response.body());
            }

            @Override
            public void onFailure(Call<NetworkResponse> call, Throwable t) {
                Log.d("onFailure ", "error!");
                data.setValue(null);
            }
        });
    }
}
