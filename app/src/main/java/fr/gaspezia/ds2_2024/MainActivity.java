package fr.gaspezia.ds2_2024;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CODE_ADD_ROOM = 1;
    private static final int REQUEST_CODE_SET_HUMIDITY = 2;
    private Spinner spinnerPiece;
    private TextView tvConsigne;
    private List<String> piece;
    private List<Double> listehygro;
    private ArrayAdapter<String> adapter;
    private int indice_item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeViews();
        initializeData();
        setSpinnerListener();
        setButtonListeners();
    }

    private void initializeViews() {
        spinnerPiece = findViewById(R.id.spinnerRoom);
        tvConsigne = findViewById(R.id.tvConsigne);
    }

    private void initializeData() {
        piece = new ArrayList<>();
        piece.add("Séjour");
        piece.add("Salle de bain");

        listehygro = new ArrayList<>();
        listehygro.add(45.0);
        listehygro.add(55.0);

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, piece);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerPiece.setAdapter(adapter);
    }

    private void setSpinnerListener() {
        spinnerPiece.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                indice_item = position;
                if (listehygro.size() > indice_item) {
                    tvConsigne.setText(listehygro.get(indice_item).toString() + " %");
                } else {
                    listehygro.add(50.0);
                    tvConsigne.setText(listehygro.get(indice_item).toString() + " %");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    private void setButtonListeners() {
        findViewById(R.id.btnAdd).setOnClickListener(v -> startActivityForResult(new Intent(MainActivity.this, ActivityRoom.class), REQUEST_CODE_ADD_ROOM));
        findViewById(R.id.btnSetParam).setOnClickListener(v -> startActivityForResult(new Intent(MainActivity.this, ActivityConsigne.class), REQUEST_CODE_SET_HUMIDITY));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_ADD_ROOM && resultCode == RESULT_OK) {
            String newRoom = data.getStringExtra("room_name");
            if (newRoom != null && !newRoom.isEmpty()) {
                piece.add(newRoom);
                adapter.notifyDataSetChanged();
            }
        } else if (requestCode == REQUEST_CODE_SET_HUMIDITY && resultCode == RESULT_OK) {
            String humidityValue = data.getStringExtra("humidity_value");
            if (humidityValue != null && !humidityValue.isEmpty()) {
                double humidity = Double.parseDouble(humidityValue);
                if (indice_item < listehygro.size()) {
                    listehygro.set(indice_item, humidity);
                } else {
                    listehygro.add(humidity);
                }
                tvConsigne.setText(humidityValue + " %");
            }
        }
    }
}