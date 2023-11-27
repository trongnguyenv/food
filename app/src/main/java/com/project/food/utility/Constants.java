package com.project.food.utility;

import com.project.food.BuildConfig;

public class Constants {
    public static final String EDAMAM_API_ID = BuildConfig.EDAMAM_API_ID;
    public static final String EDAMAM_API_KEY = BuildConfig.EDAMAM_API_KEY;
    public static final String EDAMAM_API_BASE_URL = "https://api.edamam.com/api/food-database/";
    public static final String APP_ID_QUERY_PARAMETER = "app_id";
    public static final String API_KEY_QUERY_PARAMETER = "app_key";
    public static final String MEAL_TYPE_QUERY_PARAMETER = "mealType";
    public static final String DIET_LABEL_QUERY_PARAMETER = "diet";
    public static final String HEALTH_LABEL_QUERY_PARAMETER = "health";
    public static final String SEARCH_QUERY_PARAMETER = "q";
    public static final String SEARCH_TYPE_QUERY_PARAMETER = "type";
    public static final String FIREBASE_CHILD_SETTINGS_LOCATION = "settings";
    public static final String FIREBASE_CHILD_RECIPE_LOCATION = "recipes";
    public static final String PREFERENCES_RECIPE_SEARCH_KEY = "recent_recipe_search";
    public static final String FIREBASE_QUERY_INDEX = "index";
    public static final String EXTRA_RECIPE_ID = "recipe_id";
    public static final String EXTRA_USER_SETTINGS = "user_settings";
    public static final String EXTRA_MEAL_TYPE = "meal_type";
    public static final String EXTRA_SAVED = "saved";
}
