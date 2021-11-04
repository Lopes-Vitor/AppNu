package co.vitorcavalin.waterapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TimePicker;

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
    }
    public void notifyClick(View view){
        String sinterval = editMinutes.getText().toString();

        hour = timePicker.getCurrentHour();
        minute = timePicker.getCurrentMinute();
        interval = Integer.parseInt(sinterval);

        Log.d("teste", "hora: " + hour + " minuto: " + minute + " intervalo: " + interval);

    }

}