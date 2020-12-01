package com.example.retrofitexample;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class TodoList extends BaseAdapter {

    private Activity context;
    List<Todo> todos;


    public TodoList(Activity context, List<Todo> todos) {
        this.context = context;
        this.todos = todos;
    }

    public class ViewHolder
    {

        TextView tvTitle;
        TextView tvUserId;
        TextView tvCompleted;
    }
    @Override
    public int getCount() {
        if(todos.size() <= 0 ){
            return 1;
        }
        return todos.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        View row = view ;

        LayoutInflater inflater = context.getLayoutInflater();
        ViewHolder viewHolder;

        if(view == null){
            viewHolder = new ViewHolder();
            row = inflater.inflate(R.layout.todo_list_item,null,true);
            viewHolder.tvTitle = (TextView)row.findViewById(R.id.tvTitle);
            viewHolder.tvUserId = (TextView)row.findViewById(R.id.tvUserId);
            viewHolder.tvCompleted = (TextView)row.findViewById(R.id.tvCompleted);
            row.setTag(viewHolder);
        } else{
            viewHolder = (ViewHolder)view.getTag();
        }
        viewHolder.tvTitle.setText(todos.get(i).getTitle());
        viewHolder.tvUserId.setText("AuthorId: "+Integer.toString(todos.get(i).getUserID()));
        if(todos.get(i).getCompleted()){
            viewHolder.tvCompleted.setText("Completed");
        }else{
            viewHolder.tvCompleted.setText("Uncompleted");
        }


        return row;
    }
}
