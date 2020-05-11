package israelontanilla.es.daggerloginexample.login;

public class MemoryRepository implements LoginRepository {
    User user;

    @Override
    public void saveUser(User user) {
        if (user == null) {
            user = getUser();
        }

        this.user = user;
    }

    @Override
    public User getUser() {
        if (user == null){
            user = new User("Israel", "Rubio");
            user.setId(0);
            return user;
        }else {
            return user;
        }
    }
}
