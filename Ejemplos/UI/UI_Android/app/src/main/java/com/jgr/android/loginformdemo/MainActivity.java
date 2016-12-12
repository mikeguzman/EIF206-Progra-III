package com.jgr.android.loginformdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private String userInfo;

    private EditText userName;
    private EditText phone;
    private Spinner genderSpinner;
    private TextView userInfoTextView;
    private Button clearButton;
    private Button acceptButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userName = (EditText) findViewById(R.id.name_edit_text);
        phone = (EditText) findViewById(R.id.phone_number_edit_text);
        genderSpinner = (Spinner) findViewById(R.id.gender_spinner);
        userInfoTextView = (TextView) findViewById(R.id.user_info_textview);
        clearButton = (Button) findViewById(R.id.clear_button);
        acceptButton = (Button) findViewById(R.id.accept_button);

        ArrayAdapter spinnerAdapter = ArrayAdapter.createFromResource(this, R.array.genders_array, android.R.layout.simple_spinner_item);
        genderSpinner.setAdapter(spinnerAdapter);

        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clearForm();
            }
        });

        acceptButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                printUserInfo();
            }
        });
    }

    private void printUserInfo(){
        userInfo = String.format("Nombre: %s \nTelefono: %s \nGenero: %s",
                userName.getText().toString(),
                phone.getText().toString(),
                genderSpinner.getSelectedItem().toString());
        userInfoTextView.setText(userInfo);
    }

    private void clearForm(){
        userName.setText("");
        phone.setText("");
        userInfoTextView.setText("");
        genderSpinner.setSelection(0);
    }
}
