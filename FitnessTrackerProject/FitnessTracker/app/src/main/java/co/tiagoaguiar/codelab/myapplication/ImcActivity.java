package co.tiagoaguiar.codelab.myapplication;

import androidx.annotation.StringRes;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
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

            int altura = 0;
            int peso = 0;

            try {
                altura = Integer.parseInt(sAltura);
                peso = Integer.parseInt(sPeso);

                double result = calculateImc(altura, peso);

                int imcResponseId = imcResponse(result);

                AlertDialog dialog = new AlertDialog.Builder(ImcActivity.this)
                        .setTitle(getString(R.string.imc_response, result))
                        .setMessage(imcResponseId)
                        .setPositiveButton(android.R.string.ok, (dialog1, which) -> {
                        })
                        .create();
                dialog.show();
            } catch (NumberFormatException e) {
                Toast.makeText(this, "Preencha todos os campos.", Toast.LENGTH_SHORT).show();
            }

        });

        editPeso.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (editPeso.length() == 3)
                    hideKeyboardFrom(ImcActivity.this, editPeso);
            }
        });


        editAltura.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (editAltura.length() == 3)
                    hideKeyboardFrom(ImcActivity.this, editAltura);

            }
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

    public static void hideKeyboardFrom(Context context, View view) {
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Activity.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

}

