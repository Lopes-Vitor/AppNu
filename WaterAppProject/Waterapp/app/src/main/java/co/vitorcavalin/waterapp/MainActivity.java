package co.vitorcavalin.waterapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int hour;
    private int minute;
    private int interval;

    private Button btnnotify;
    private EditText editMinutes;
    private TimePicker timePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnnotify = findViewById(R.id.btn_notify);
        editMinutes = findViewById(R.id.txt_number_interval);
        timePicker = findViewById(R.id.time_picker);

        timePicker.setIs24HourView(true);


        editMinutes.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (editMinutes.length() == 3)
                    hideKeyboardFrom(MainActivity.this, editMinutes);
            }
        });

    }


    public void notifyClick(View view) {
        try {

            hideKeyboardFrom(this, btnnotify);

            String sInterval = editMinutes.getText().toString();

            hour = timePicker.getCurrentHour();
            minute = timePicker.getCurrentMinute();
            interval = Integer.parseInt(sInterval);

            //interval = Integer.parseInt(editMinutes.getText().toString());
            Toast.makeText(this, "hora: " + hour + " minuto: " + minute + " intervalo: " + interval, Toast.LENGTH_SHORT).show();
            Log.d("teste", "hora: " + hour + " minuto: " + minute + " intervalo: " + interval);
        } catch (Exception e) {
            Toast.makeText(this, "Preenche o campo seu arrombado", Toast.LENGTH_SHORT).show();
        }

    }

    /*@Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_notify) {

            try {
                String sInterval = editMinutes.getText().toString();

                hour = timePicker.getCurrentHour();
                minute = timePicker.getCurrentMinute();

                interval = Integer.parseInt(sInterval);
                Toast.makeText(this, "hora: " + hour + " minuto: " + minute + " intervalo: " + interval, Toast.LENGTH_LONG).show();
            } catch (Exception e) {
                Toast.makeText(this, "Digita um numero animal", Toast.LENGTH_SHORT).show();
            }

        }
    }*/

    public static void hideKeyboardFrom(Context context, View view) {
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Activity.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

}