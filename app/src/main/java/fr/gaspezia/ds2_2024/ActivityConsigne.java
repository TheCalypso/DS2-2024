package fr.gaspezia.ds2_2024;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class ActivityConsigne extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consigne);

        EditText etHumidity = findViewById(R.id.etHumidity);
        Button btnValidate = findViewById(R.id.btnValidate);

        btnValidate.setOnClickListener(v -> finishWithResult(etHumidity.getText().toString()));
    }

    private void finishWithResult(String humidityValue) {
        Intent resultIntent = new Intent();
        if (Integer.parseInt(humidityValue) > 100) humidityValue = "100";
        resultIntent.putExtra("humidity_value", humidityValue);
        setResult(Activity.RESULT_OK, resultIntent);
        finish();
    }
}