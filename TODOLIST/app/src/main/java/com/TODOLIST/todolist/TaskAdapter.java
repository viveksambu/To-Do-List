package com.TODOLIST.todolist;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.TaskViewHolder>{
    private final ArrayList<Task> tasks;
    private final OnTaskActionListener listener;

    public TaskAdapter(ArrayList<Task> tasks, OnTaskActionListener listener) {
        this.tasks = tasks;
        this.listener = listener;
    }

    public interface OnTaskActionListener{
        void onTaskStatusChanged(int position, boolean isChecked);
        void onTaskDeleted(int position);
        void onTaskEdit(int position);
    }
    @NonNull
    @Override
    public TaskAdapter.TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.task_item, parent, false);
        return new TaskViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskAdapter.TaskViewHolder holder, int position) {
    Task task = tasks.get(position);
    holder.checkBoxTask.setOnCheckedChangeListener(null);
    holder.checkBoxTask.setChecked(task.isCompleted());
    holder.checkBoxTask.setText(task.getTaskName());

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class TaskViewHolder extends RecyclerView.ViewHolder {
        public TaskViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
