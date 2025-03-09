package com.example.androidunittest;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText emailInput, phoneInput;
    private Button validateButton, validatePhoneButton, continueButton;
    private TextView errorMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emailInput = findViewById(R.id.emailInput);
        phoneInput = findViewById(R.id.phoneInput);
        validateButton = findViewById(R.id.validateButton);
        validatePhoneButton = findViewById(R.id.validatePhoneButton);
        continueButton = findViewById(R.id.continueButton);
        errorMessage = findViewById(R.id.errorMessage);

        validateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailInput.getText().toString();
                if (EmailValidator.isValidEmail(email)) {
                    errorMessage.setVisibility(View.GONE); // Sembunyikan pesan error
                    continueButton.setEnabled(true); // Aktifkan tombol "Lanjutkan"
                } else {
                    errorMessage.setVisibility(View.VISIBLE); // Tampilkan pesan error
                    errorMessage.setText("Email tidak valid!");
                    continueButton.setEnabled(false); // Nonaktifkan tombol "Lanjutkan"
                }
            }
        });

        validatePhoneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneNumber = phoneInput.getText().toString();
                if (PhoneNumberValidator.isValidPhoneNumber(phoneNumber)) {
                    errorMessage.setVisibility(View.GONE); // Sembunyikan pesan error
                    continueButton.setEnabled(true); // Aktifkan tombol "Lanjutkan"
                } else {
                    errorMessage.setVisibility(View.VISIBLE); // Tampilkan pesan error
                    errorMessage.setText("Nomor telepon tidak valid!");
                    continueButton.setEnabled(false); // Nonaktifkan tombol "Lanjutkan"
                }
            }
        });
    }
}