package service.di;

import javax.inject.Singleton;

import dagger.Component;
import service.retrofit.RetrofitService;
import service.repositories.ContactUsRepository;

/**
 * Created by mobile on 4.06.2018.
 */


@Component(modules = {RetrofitService.class})
@Singleton
public interface AppComponent {
    void inject(ContactUsRepository contactUsRepository);
}
