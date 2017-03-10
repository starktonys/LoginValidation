package me.tony.stark.loginvalidation;

import org.apache.avalidations.EditTextValidator;
import org.apache.avalidations.ValidationModel;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import me.tony.stark.loginvalidation.utils.PasswordValidation;
import me.tony.stark.loginvalidation.utils.UserNameValidation;

/**
 * 登陆校验演示
 * @Description: 
 * @author stark.Tony
 * @date 2014-11-21 下午9:42:53 
 * @version V1.0   
 * 
 */
public class LoginActivity extends Activity implements OnClickListener{

    private EditText usernameEditText;
    private EditText passwordEditText;
    private Button loginButton;
    private EditTextValidator editTextValidator;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_login);
	

	usernameEditText = (EditText) findViewById(R.id.login_username_edittext);
	passwordEditText = (EditText) findViewById(R.id.login_password_edittext);
	loginButton = (Button) findViewById(R.id.login_button);

	loginButton.setOnClickListener(this);
	
	editTextValidator = new EditTextValidator(this)
		.setButton(loginButton)
		.add(new ValidationModel(usernameEditText,new UserNameValidation()))
		.add(new ValidationModel(passwordEditText,new PasswordValidation()))
		.execute();
    }

    @Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.login_button:
			if (editTextValidator.validate()) {
				Toast.makeText(this, "通过校验", Toast.LENGTH_SHORT).show();
			}
			break;
		}
	}

}
