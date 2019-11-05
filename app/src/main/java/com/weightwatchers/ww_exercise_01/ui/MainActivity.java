package com.weightwatchers.ww_exercise_01.ui;

import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.weightwatchers.ww_exercise_01.R;
import com.weightwatchers.ww_exercise_01.controller.WW_Adapter;
import com.weightwatchers.ww_exercise_01.model.WW_DataModel;
import com.weightwatchers.ww_exercise_01.networking.ApiUtil;
import com.weightwatchers.ww_exercise_01.networking.WW_Service;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private WW_Service ww_service;


    private RecyclerView recyclerView;

    private Bundle bundleRecyclerview;

    private final String RECYCLER_STATE = "recycler_state";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ww_service = ApiUtil.getApiService();

        retrofitCall();
    }

    public void retrofitCall() {

        ww_service.getData().enqueue(new Callback<List<WW_DataModel>>() {
            @Override
            public void onResponse(Call<List<WW_DataModel>> call, Response<List<WW_DataModel>> response) {

                List<WW_DataModel> data = response.body();

                setRecyclerView(data);

                Log.e("SERVICE TEST", response.body().get(0).getImage());


            }

            @Override
            public void onFailure(Call<List<WW_DataModel>> call, Throwable t) {

                t.printStackTrace();

            }
        });
    }

    public void setRecyclerView(List<WW_DataModel> ww_dataModels) {
        recyclerView = findViewById(R.id.ww_rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(),
                LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(new WW_Adapter(ww_dataModels));


    }



    @Override
    protected void onPause(){
        super.onPause();

        bundleRecyclerview = new Bundle();
        Parcelable rvState  = recyclerView.getLayoutManager().onSaveInstanceState();
        bundleRecyclerview.putParcelable(RECYCLER_STATE,rvState);
    }

    @Override
    protected void onResume(){
        super.onResume();

        if (bundleRecyclerview != null){
            Parcelable rvState = bundleRecyclerview.getParcelable(RECYCLER_STATE);
            recyclerView.getLayoutManager().onRestoreInstanceState(rvState);
        }
    }

}
