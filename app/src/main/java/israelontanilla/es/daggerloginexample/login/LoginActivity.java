package israelontanilla.es.daggerloginexample.login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import javax.inject.Inject;

import israelontanilla.es.daggerloginexample.R;
import israelontanilla.es.daggerloginexample.root.App;

// Implemento la interface de la vista
public class LoginActivity extends AppCompatActivity implements LoginActivityMVP.View {

    // Creo una inteface de presenter, la inyecto, lleva la dependencia del modelo
    @Inject
    LoginActivityMVP.Presenter presenter;

    EditText editText_name, editText_lastName;
    Button button_enter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((App)getApplication()).getApplicationComponent().inject(this);

        editText_name = findViewById(R.id.edit_name);
        editText_lastName = findViewById(R.id.edit_lastName);
        button_enter = findViewById(R.id.btn_enter);

        button_enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.loginButtonClicked();
            }
        });
    }

    // Se llama cada vez que se genera el activity
    @Override
    protected void onResume() {
        super.onResume();

        presenter.setView(this); // Seteo al presenter esta vista
        presenter.getCurrentUser();
    }


    // Completo los metodos de la interface
    @Override
    public String getFirstName() {
        return this.editText_name.getText().toString();
    }

    @Override
    public String getLastName() {
        return this.editText_lastName.getText().toString();
    }

    @Override
    public void setFirstName(String firstName) {
        this.editText_name.setText(firstName);
    }

    @Override
    public void setLastName(String lastName) {
        this.editText_lastName.setText(lastName);
    }

    @Override
    public void showUserNotAvaliable() {
        Toast.makeText(this,"El usuario no esta disponible", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showInputError() {
        Toast.makeText(this,"Los campos deben estar completados", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showUserSaved() {
        Toast.makeText(this,"El usuario ha sido guardado con exito!!", Toast.LENGTH_SHORT).show();
    }
}
