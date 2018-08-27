package com.teb.kos.kosovakurumsal.main;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

import service.model.IletisimPayload;
import service.model.NetworkResponse;

import service.repositories.ContactUsRepository;

/**
 * Created by mobile on 31.05.2018.
 */

public class MainViewModel extends ViewModel{
    private Context context;
    private MutableLiveData<NetworkResponse> contactResponseObservable;

   /* public MainViewModel(@NonNull Context context) {

        this.context=context;
        contactResponseObservable = new MutableLiveData<>();
    }*/

    public MainViewModel() {

    }

    public void init(@NonNull Context context){
        this.context=context;
        contactResponseObservable = new MutableLiveData<>();
        Log.d("init","init");
    }


    public void sendContactMessage(){
        IletisimPayload iletisimPayload = new IletisimPayload();
        iletisimPayload.setAdSoyad("Hold The Door");
        iletisimPayload.setCepTel("05075077712");
        iletisimPayload.setEmail("test@testogullari.com");
        iletisimPayload.setMesaj("selam arkadaşlar");
        ContactUsRepository contactUsRepository = new ContactUsRepository();
      //  contactUsRepository.request(context, iletisimPayload);
     //   contactResponseObservable = contactUsRepository.contactRequest(context, iletisimPayload);
        contactUsRepository.contactRequest(context, iletisimPayload, contactResponseObservable);

    }

    public LiveData<NetworkResponse> getContactResponseObservable() {
        Log.d("getContactRes", "getContactResponseObservable() " );
        return contactResponseObservable;
    }
}
