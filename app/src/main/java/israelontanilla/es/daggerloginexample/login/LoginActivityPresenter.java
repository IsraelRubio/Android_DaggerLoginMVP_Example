package israelontanilla.es.daggerloginexample.login;

import androidx.annotation.Nullable;

public class LoginActivityPresenter implements LoginActivityMVP.Presenter {

    @Nullable //Avisa si un valor va a ser null antes de ejecutarlo
    LoginActivityMVP.Model model;
    LoginActivityMVP.View view;

    // Inyeccion por constructor
    public LoginActivityPresenter(LoginActivityMVP.Model model) {
        this.model = model;
    }

    @Override
    public void setView(LoginActivityMVP.View view) {
        this.view = view;
    }

    @Override
    public void loginButtonClicked() {
        if (view != null){
            if (view.getFirstName().trim().equals("") || view.getLastName().trim().equals("")){
                view.showInputError();
            }else {
                model.createUser(view.getFirstName(),view.getLastName());
                view.showUserSaved();
            }
        }
    }

    @Override
    public void getCurrentUser() {
        User user = model.getUser();

        if (user == null){
            if (view != null){
                view.showUserNotAvaliable();
            }
        }else {
            if (view != null){
                view.setFirstName(user.getName());
                view.setLastName(user.getLastName());
            }
        }
    }
}
