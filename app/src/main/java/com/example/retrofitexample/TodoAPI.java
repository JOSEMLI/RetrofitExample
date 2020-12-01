package com.example.retrofitexample;


import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface TodoAPI {

    @GET("/todos")
    Call<List<Todo>> getAllTodos();

    @GET("/todos/{id}")
    Call<List<Todo>> getTodo (@Path("id") String id);
}
