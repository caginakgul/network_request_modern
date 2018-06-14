package service.retrofit;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import service.Const;
import service.retrofit.IService;

/**
 * Created by mobile on 31.05.2018.
 */

@Module
public class RetrofitService {
    protected Retrofit client;

/*    public void attachView(V view){

    }
    public void detachView() {
        this.view = null;
    }*/

    @Provides
    @Singleton
    public IService iService(Retrofit retrofit) {
        return retrofit.create(IService.class);
    }

    @Provides
    @Singleton
    public Retrofit retrofit() {
        return new Retrofit.Builder()
                .baseUrl(Const.Api.BASE_URL)
                .addConverterFactory(gsonConverterFactory())
                .client(getOkHttp())
                .build();
    }

    @Provides
    @Singleton
    public GsonConverterFactory gsonConverterFactory() {
        return GsonConverterFactory.create();
    }

    @Provides
    @Singleton
    public OkHttpClient getOkHttp(){
        OkHttpClient baseOkHttpClient = new OkHttpClient()
                .newBuilder()
                .readTimeout(60, TimeUnit.SECONDS)
                .connectTimeout(60, TimeUnit.SECONDS)
                .followRedirects(false)
                .build();
        return baseOkHttpClient;
    }
}
