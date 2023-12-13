package com.project.food.interfaces;

import com.project.food.models.FoodResponse;
import com.project.food.utility.Constants;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface EdamamApi {
    @GET("api/food-database/v2/parser")
    Call<FoodResponse> getFoods(
            @Query(Constants.APP_ID_QUERY_PARAMETER) String appId,
            @Query(Constants.API_KEY_QUERY_PARAMETER) String apikey,
            @Query(Constants.INGR_QUERY_PARAMETER) String ingr,
            @Query(Constants.CATEGORY_QUERY_PARAMETER) String category
    );

    @GET("auto-complete")
    Call<List<String>> searchAutoComplete(
            @Query(Constants.APP_ID_QUERY_PARAMETER) String appId,
            @Query(Constants.API_KEY_QUERY_PARAMETER) String apikey,
            @Query(Constants.SEARCH_QUERY_PARAMETER) String q
    );
}
