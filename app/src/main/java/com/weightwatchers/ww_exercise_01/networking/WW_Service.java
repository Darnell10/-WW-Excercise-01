package com.weightwatchers.ww_exercise_01.networking;

import com.weightwatchers.ww_exercise_01.model.WW_DataModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface WW_Service {

    @GET("assets/cmx/us/messages/collections.json")
    Call<List<WW_DataModel>> getData();

}
