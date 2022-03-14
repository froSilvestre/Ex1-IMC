package arq.ifsp.dmo.ex1_imc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText campoPeso;
    private EditText campoAltura;
    private Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSave = findViewById(R.id.btnSave);
        campoPeso = findViewById(R.id.inputPeso);
        campoAltura = findViewById(R.id.inputAltura);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double peso = Double.parseDouble(campoPeso.getText().toString());
                double altura = Double.parseDouble(campoAltura.getText().toString())/100;

                double imc = peso/(altura*altura);

                if (imc<18.5){
                    Toast.makeText(MainActivity.this, R.string.abaixo, Toast.LENGTH_LONG).show();
                }
                else if(imc<=24.9){
                    Toast.makeText(MainActivity.this, R.string.normal, Toast.LENGTH_LONG).show();
                }
                else if(imc<=25 && imc<29.9){
                    Toast.makeText(MainActivity.this, R.string.acima, Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(MainActivity.this, R.string.obeso, Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}