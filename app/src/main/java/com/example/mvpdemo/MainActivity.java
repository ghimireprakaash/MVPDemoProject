package com.example.mvpdemo;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements Presenter.View {
    private EditText usernameEditText, emailEditText;
    private ProgressBar progressBar;
    private TextView usernameTextView, emailTextView;


    private Presenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new Presenter(this);

        init();

    }

    private void init() {
        usernameEditText = findViewById(R.id.usernameEditText);
        emailEditText = findViewById(R.id.emailEditText);
        usernameTextView = findViewById(R.id.username);
        emailTextView = findViewById(R.id.email);

        progressBar = findViewById(R.id.progressBar);
    }

    private void getUsernameAndEmail(){
        String username = usernameEditText.getText().toString();
        String userEmail = emailEditText.getText().toString();

        if (username.isEmpty()){
            String msg = "Field username is empty.";
            presenter.emptyUsername(msg);
            return;
        }
        if (userEmail.isEmpty()){
            String msg = "Field email is empty.";
            presenter.emptyUsername(msg);
            return;
        }

        presenter.updateUsername(username);
        presenter.updateUserEmail(userEmail);

    }

    @Override
    public void updateUsername(String username) {
        usernameTextView.setText(username);
    }

    @Override
    public void updateUserEmail(String email) {
        emailTextView.setText(email);
    }

    @Override
    public void showProgressBar() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        progressBar.setVisibility(View.GONE);
    }

    public void onButtonClick(View view) {
        showProgressBar();
        new Handler().postDelayed(() -> {
            getUsernameAndEmail();

            hideProgressBar();
            usernameEditText.setText("");
            emailEditText.setText("");
        }, 2000);
    }
}