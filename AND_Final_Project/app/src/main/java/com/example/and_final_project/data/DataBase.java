package com.example.and_final_project.data;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.and_final_project.data.model.Note;

@Database(entities = {Note.class}, version = 1)
public abstract class DataBase extends RoomDatabase {

    private static DataBase instance;

    public abstract NoteDAO noteDAO();

    public static synchronized DataBase getInstance(Context context)
    {
          if(instance == null)
          {
              instance = Room.databaseBuilder(context.getApplicationContext(),
                      DataBase.class, "database")
                      .fallbackToDestructiveMigration()
                      .addCallback(roomCallback)
                      .build();
          }
          return instance;
    }

    private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback()
    {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDBAsync(instance).execute();
        }
    };

    private static class PopulateDBAsync extends AsyncTask<Void, Void, Void>
    {
        private NoteDAO noteDAO;
        private PopulateDBAsync(DataBase dataBase)
        {
            noteDAO = dataBase.noteDAO();
        }
        @Override
        protected Void doInBackground(Void... voids) {
            noteDAO.insert(new Note("Title 1", "Description 1", 1));
            noteDAO.insert(new Note("Title 2", "Description 2", 2));
            noteDAO.insert(new Note("Title 3", "Description 3", 3));
            return null;
        }
    }
}
