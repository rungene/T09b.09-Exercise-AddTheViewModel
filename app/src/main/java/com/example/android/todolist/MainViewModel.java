package com.example.android.todolist;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;
import android.util.Log;

import com.example.android.todolist.database.AppDatabase;
import com.example.android.todolist.database.TaskEntry;

import java.util.List;

// TODO (1) make this class extend AndroidViewModel and implement its default constructor
public class MainViewModel extends AndroidViewModel{
    //Constant for Logging

    private static final String TAG =MainViewModel.class.getSimpleName();

    private LiveData<List <TaskEntry>> task;

    public MainViewModel(@NonNull Application application) {
        super(application);
        AppDatabase database = AppDatabase.getInstance(this.getApplication());
        Log.d(TAG, "Actively retriving tasks from the DB");
        task = database.taskDao().loadAllTasks();
    }
    public LiveData<List <TaskEntry>> getTask(){

        return task;
    }
    // TODO (2) Add a tasks member variable for a list of TaskEntry objects wrapped in a LiveData

    // TODO (4) In the constructor use the loadAllTasks of the taskDao to initialize the tasks variable

    // TODO (3) Create a getter for the tasks variable
}
