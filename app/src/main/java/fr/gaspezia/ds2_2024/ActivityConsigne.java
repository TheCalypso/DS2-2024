package fr.gaspezia.ds2_2024;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ActivityConsigne extends Activity {
    private EditText etHumidity;
    private Button btnValidate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consigne);

        etHumidity = findViewById(R.id.etHumidity);
        btnValidate = findViewById(R.id.btnValidate);

        btnValidate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String humidityValue = etHumidity.getText().toString();
                Intent resultIntent = new Intent();
                resultIntent.putExtra("humidity_value", humidityValue);
                setResult(Activity.RESULT_OK, resultIntent);
                finish();
            }
        });
    }

}
