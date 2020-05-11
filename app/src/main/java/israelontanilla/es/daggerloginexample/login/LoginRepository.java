package israelontanilla.es.daggerloginexample.login;

public interface LoginRepository {
    void saveUser(User user);
    User getUser();
}
