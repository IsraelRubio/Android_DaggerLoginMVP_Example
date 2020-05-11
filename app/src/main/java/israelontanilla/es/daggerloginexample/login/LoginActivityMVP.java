package israelontanilla.es.daggerloginexample.login;

public interface LoginActivityMVP {

    interface View{
        String getFirstName();
        String getLastName();

        void setFirstName(String firstName);
        void setLastName(String lastName);

        void showUserNotAvaliable();
        void showInputError();
        void showUserSaved();
    }

    interface Presenter{
        void setView(LoginActivityMVP.View view);
        void loginButtonClicked();
        void getCurrentUser();
    }

    interface Model{
        void createUser(String firsName, String lastName);
        User getUser();
    }
}
