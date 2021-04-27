package com.example.gb_calculator.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.gb_calculator.R;
import com.example.gb_calculator.domain.Constants;

public class SettingsActivity extends AppCompatActivity implements Constants {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        Button btnThemeLight = findViewById(R.id.btn_theme_light);
        btnThemeLight.setOnClickListener(v -> {
            Intent runTheme = new Intent(SettingsActivity.this, CalculatorActivity.class);
            runTheme.putExtra(SELECTED_THEME, "Light");
            startActivity(runTheme);
        });

        Button btnThemeDark = findViewById(R.id.btn_theme_dark);
        btnThemeDark.setOnClickListener(v -> {
            Intent runTheme = new Intent(SettingsActivity.this, CalculatorActivity.class);
            runTheme.putExtra(SELECTED_THEME, "Dark");
            startActivity(runTheme);
        });
    }
}