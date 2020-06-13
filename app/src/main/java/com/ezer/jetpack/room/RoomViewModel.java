package com.ezer.jetpack.room;

import android.app.Application;
import android.os.AsyncTask;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.ezer.jetpack.room.model.Note;

import java.util.List;

public class RoomViewModel extends AndroidViewModel {
    private String TAG =this.getClass().getSimpleName();
    private NoteDao noteDao;
    private NoteRoomDatabase noteRoomDatabase;
    private LiveData<List<Note>> AllNotes;


    public RoomViewModel(@NonNull Application application) {
        super(application);
        noteRoomDatabase =NoteRoomDatabase.getDatabase(application);
        noteDao =noteRoomDatabase.noteDao();
        AllNotes =noteDao.getAllNote();
    }

    public void insert(Note note) {
        new InsertAsyncTask(noteDao).execute(note);
    }

    LiveData<List<Note>> getAllNotes(){
        return AllNotes;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        Log.i(TAG,"ViewModel Destroyed");
    }
     private static class InsertAsyncTask extends AsyncTask<Note,Void,Void>{

        NoteDao noteDao;

        private InsertAsyncTask(NoteDao noteDao) {
            this.noteDao = noteDao;
        }

        @Override
        protected Void doInBackground(Note... notes) {
            noteDao.insert(notes[0]);
            return null;
        }
    }
}
