package co.tiagoaguiar.codelab.myapplication;

import androidx.annotation.StringRes;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ImcActivity extends AppCompatActivity {

    private EditText editAltura;
    private EditText editPeso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imc);

        editAltura = findViewById(R.id.imc_edit_altura);
        editPeso = findViewById(R.id.imc_edit_peso);

        Button btnsend = findViewById(R.id.button_imc_edit);

        btnsend.setOnClickListener(v -> {
            if (!validate()) {
                Toast.makeText(ImcActivity.this, R.string.mensagem_erro, Toast.LENGTH_LONG).show();
                return;
            }
            String sAltura = editAltura.getText().toString();
            String sPeso = editPeso.getText().toString();

            int altura = Integer.parseInt(sAltura);
            int peso = Integer.parseInt(sPeso);

            double result = calculateImc(altura, peso);
            Log.d("Teste", "Resultado: " + result);

            int imcResponseId = imcResponse(result);

            AlertDialog dialog = new AlertDialog.Builder(ImcActivity.this)
                    .setTitle(getString(R.string.imc_response, result))
                    .setMessage(imcResponseId)
                    .setPositiveButton(android.R.string.ok, (dialog1, which) -> {
                    })
                    .create();
            dialog.show();
        });


    }

    @StringRes
    private int imcResponse(double imc) {
        if (imc < 15)
            return R.string.imc_severely_low_weight;
        else if (imc < 16)
            return R.string.imc_very_low_weight;
        else if (imc < 18.5)
            return R.string.imc_low_weight;
        else if (imc < 25)
            return R.string.normal;
        else if (imc < 30)
            return R.string.imc_high_weight;
        else if (imc < 35)
            return R.string.imc_so_high_weight;
        else if (imc < 40)
            return R.string.imc_severely_high_weight;
        else
            return R.string.imc_extreme_weight;
    }

    private double calculateImc(int altura, int peso) {
        return peso / (((double) altura / 100) * ((double) altura / 100));
    }

    private boolean validate() {
        return (!editPeso.getText().toString().startsWith("0")
                && !editAltura.toString().startsWith("0")
                && !editPeso.toString().isEmpty()
                && !editAltura.toString().isEmpty());
    }

}

