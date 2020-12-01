package com.example.retrofitexample;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    private ListView lvTodos;
    Activity activity;

    public String complet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        activity = this;
        lvTodos = (ListView)findViewById(R.id.lvTodos);
        loadTodos();



    }

    protected void loadTodos()
    {
        Retrofit retrofit = API.getRetrofitClient();
        TodoAPI api = retrofit.create(TodoAPI.class);

        Call<List<Todo>> listCall = api.getAllTodos();

        listCall.enqueue(new Callback<List<Todo>>() {
            @Override
            public void onResponse(Call<List<Todo>> call, Response<List<Todo>> response) {
                TodoList list = new TodoList(activity,response.body());
                lvTodos.setAdapter(list);
                lvTodos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        Toast.makeText(getApplicationContext(), response.body().get(i).getTitle()
                                , Toast.LENGTH_SHORT).show();

                        Intent detalleitem = new Intent(MainActivity.this,VerDetalle.class);
                        detalleitem.putExtra("idtitulo",response.body().get(i).getTitle());
                        detalleitem.putExtra("idauthor", Integer.toString(response.body().get(i).getUserID()));
                        if(response.body().get(i).getCompleted()){
                            complet = "Completed";
                        }else{
                            complet = "Uncompleted";
                        }
                        detalleitem.putExtra("idtipo", complet);
                        startActivity(detalleitem);



                    }
                });

    }
            @Override
            public void onFailure(Call<List<Todo>> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"Something went wrong"
                        ,Toast.LENGTH_SHORT).show();
                Log.d("RetrofitError",t.toString());
            }
        });
    }

}