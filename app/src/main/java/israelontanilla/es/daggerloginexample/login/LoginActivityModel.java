package israelontanilla.es.daggerloginexample.login;

public class LoginActivityModel implements LoginActivityMVP.Model {

    private LoginRepository repository;

    public LoginActivityModel(LoginRepository repository) {
        this.repository = repository;
    }

    @Override
    public void createUser(String firsName, String lastName) {
        repository.saveUser(new User(firsName,lastName));
    }

    @Override
    public User getUser() {
        return repository.getUser();
    }
}
