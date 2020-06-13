package com.ezer.jetpack.room;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.ezer.jetpack.R;
import com.ezer.jetpack.room.model.Note;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;
import java.util.UUID;

public class MainRoomActivity extends AppCompatActivity {
    private String TAG = this.getClass().getSimpleName();
    private RoomViewModel viewModel;
    private FloatingActionButton floatingActionButton;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_room);
        floatingActionButton = findViewById(R.id.flot_icon);
        recyclerView =findViewById(R.id.recycle_view);

        // VIEW MODEL ASSIGN KARANWA - [ AndroidViewModel]

       /*
       *
       * ViewModel - ViewModel eka use karanne appication context eka use karanne nathi ewata
       * AndroidViewModel  - AndroidViewModel eka use karanne context eka Onanam witharai
       *
       * */

        viewModel =ViewModelProvider.AndroidViewModelFactory.getInstance(
                this.getApplication()).create(RoomViewModel.class);


        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), RoomActivity.class);

                // Activity eka Start Karankota request code ekak yawanawa...
                startActivityForResult(intent, 1);
            }
        });


        ////////////////////// DATA READ PROCESS ///////////////////////
        final NoteAdapter noteAdapter =new NoteAdapter(getApplicationContext());
        recyclerView.setAdapter(noteAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        viewModel.getAllNotes().observe(this, new Observer<List<Note>>() {
            @Override
            public void onChanged(List<Note> notes) {
                        noteAdapter.setNotes(notes);
            }
        });
    }


    //// ResultCode ekath ekka ena code eka check karala
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        System.out.println(requestCode+" - "+resultCode);
        if(requestCode == 1 && resultCode==RESULT_OK){
            //Code to insert note
            final String note_id = UUID.randomUUID().toString();
            Note note =new Note(note_id,data.getStringExtra(RoomActivity.NOTE_ADDED));
            // View Model eke insert methodd ekata note Object eka pass karanwa
            viewModel.insert(note);

            Toast.makeText(getApplicationContext(),"Saved",Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(getApplicationContext(),"Not Saved",Toast.LENGTH_SHORT).show();
        }
    }
}
