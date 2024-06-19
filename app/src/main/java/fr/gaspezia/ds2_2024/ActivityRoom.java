package fr.gaspezia.ds2_2024;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class ActivityRoom extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room);

        EditText etRoomName = findViewById(R.id.etRoomName);
        Button btnAddRoom = findViewById(R.id.btnAddRoom);

        btnAddRoom.setOnClickListener(v -> finishWithResult(etRoomName.getText().toString()));
    }

    private void finishWithResult(String roomName) {
        Intent resultIntent = new Intent();
        resultIntent.putExtra("room_name", roomName);
        setResult(Activity.RESULT_OK, resultIntent);
        finish();
    }
}