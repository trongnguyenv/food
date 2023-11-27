package com.project.food.interfaces;

import com.project.food.models.RecipeSearchResponse;
import com.project.food.utility.Constants;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface EdamamApi {
    @GET("v2/parser")
    Call<RecipeSearchResponse> getRecipesByKeyword(
            @Query(Constants.SEARCH_TYPE_QUERY_PARAMETER) String recipeSearch,
            @Query(Constants.SEARCH_QUERY_PARAMETER) String searchString,
            @Query(Constants.APP_ID_QUERY_PARAMETER) String appId,
            @Query(Constants.API_KEY_QUERY_PARAMETER) String apikey,
            @Query(Constants.DIET_LABEL_QUERY_PARAMETER) String[] diets,
            @Query(Constants.HEALTH_LABEL_QUERY_PARAMETER) String[] health
    );
}
