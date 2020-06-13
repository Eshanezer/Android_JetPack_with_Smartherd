package com.ezer.jetpack.room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.ezer.jetpack.room.model.Note;

// Database Class
// need to annotate @Database && Database Entities associated with && SQLite Version
@Database(entities = Note.class,version = 1)
public abstract class NoteRoomDatabase extends RoomDatabase {
    public abstract  NoteDao noteDao();
    private static volatile  NoteRoomDatabase noteRoomDatabase;

    // SINGOLTOM METHOD
    // aquire instance of DB using Room.databaseBuilder();
    static NoteRoomDatabase getDatabase(final Context context){
        if(noteRoomDatabase ==null){
            synchronized (NoteRoomDatabase.class){
                if(noteRoomDatabase ==null){
                    noteRoomDatabase = Room.databaseBuilder(context.getApplicationContext(),
                            NoteRoomDatabase.class,"note_database")
                            .build();
                }
            }
        }
        return noteRoomDatabase;
    }
}
