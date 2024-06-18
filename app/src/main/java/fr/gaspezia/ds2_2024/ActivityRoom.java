package fr.gaspezia.ds2_2024;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ActivityRoom extends Activity {
    private EditText etRoomName;
    private Button btnAddRoom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room);

        etRoomName = findViewById(R.id.etRoomName);
        btnAddRoom = findViewById(R.id.btnAddRoom);

        btnAddRoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String roomName = etRoomName.getText().toString();
                Intent resultIntent = new Intent();
                resultIntent.putExtra("room_name", roomName);
                setResult(Activity.RESULT_OK, resultIntent);
                finish();
            }
        });
    }
}
