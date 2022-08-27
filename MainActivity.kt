package com.example.news_app_magang

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var recyclerManager: RecyclerView.LayoutManager
    private lateinit var myAdapter: RecyclerView.Adapter<*>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        return getNews()
    }

    fun getNews(){
        Api.retrofitService.getAllData().enqueue(object: Callback<List<News>>{
            override fun onResponse(call: Call<List<News>>, response: Response<List<News>>) {
                if (response.isSuccessful){
                    recyclerView = findViewById<RecyclerView>(R.id.news_list).apply {
                        myAdapter = newsAdapter(response.body()!!)
                        layoutManager = recyclerManager
                        adapter = myAdapter
                        Log.d("Hasil", response.body().toString())
                    }
                    recyclerView.setHasFixedSize(true)
                }
            }

            override fun onFailure(call: Call<List<News>>, t: Throwable) {
                t.printStackTrace()
            }
        })
    }
}