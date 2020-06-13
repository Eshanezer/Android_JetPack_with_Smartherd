package com.ezer.jetpack.room;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.ezer.jetpack.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

public class RoomActivity extends AppCompatActivity {
    private Button addBtn;
    private TextInputEditText ed;

    public static final String NOTE_ADDED = "new_note";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room);
        ed = findViewById(R.id.ed_1);
        addBtn = findViewById(R.id.btn_add);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent resultIntent = new Intent();
                if (TextUtils.isEmpty(ed.getText())) {
                    setResult(RESULT_CANCELED, resultIntent);
                } else {
                    String note = ed.getText().toString();
                    // editext eka empty naththama intent ekakta data set karala
                    resultIntent.putExtra(NOTE_ADDED, note);
                    // result activity ekata yawanawa with resultcode ekath ekka
                    setResult(RESULT_OK, resultIntent);
                }
                finish();
            }
        });
    }
}
