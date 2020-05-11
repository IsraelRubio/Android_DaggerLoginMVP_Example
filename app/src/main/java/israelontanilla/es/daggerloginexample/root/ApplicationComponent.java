package israelontanilla.es.daggerloginexample.root;

import javax.inject.Singleton;

import dagger.Component;
import israelontanilla.es.daggerloginexample.login.LoginActivity;
import israelontanilla.es.daggerloginexample.login.LoginModule;

@Singleton
@Component(modules = {ApplicationModule.class, LoginModule.class})
public interface ApplicationComponent {

    void inject(LoginActivity target);
}