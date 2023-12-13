package com.project.food.ui;

import static com.project.food.utility.UserInterfaceHelpers.hideProgressDialog;
import static com.project.food.utility.UserInterfaceHelpers.showFailureFeedback;
import static com.project.food.utility.UserInterfaceHelpers.showProgressDialog;
import static com.project.food.utility.UserInterfaceHelpers.showFoods;
import static com.project.food.utility.UserInterfaceHelpers.showUnsuccessfulFeedback;

import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.project.food.adapter.SeachListAdapter;
import com.project.food.client.EdamamClient;
import com.project.food.databinding.FragmentSearchBinding;
import com.project.food.interfaces.EdamamApi;
import com.project.food.models.Settings;
import com.project.food.utility.Constants;

import org.parceler.Parcels;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchFragment extends Fragment{
    public static final String TAG = SearchFragment.class.getSimpleName();

    private FragmentSearchBinding binding;
    private Settings userSettings;
    private EdamamApi client;
//    private List<String> results;

    private SeachListAdapter adapter;

    public SearchFragment() { }

    public static SearchFragment newInstance(Settings userSettings){
        SearchFragment fragment = new SearchFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable(Constants.EXTRA_USER_SETTINGS, Parcels.wrap(userSettings));
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        assert getArguments() != null;
        userSettings = Parcels.unwrap(getArguments().getParcelable(Constants.EXTRA_USER_SETTINGS));
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentSearchBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        client = EdamamClient.getClient();
        setUpSearchView();
    }

    private void setUpSearchView(){
        binding.searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                loadDataComplete(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String query) {
                Log.d(TAG, "query: " + query);
                loadDataComplete(query);
                return false;
            }
        });
    }

    private void loadDataComplete(String query){
        Call<List<String>> call = client.searchAutoComplete(Constants.EDAMAM_API_ID, Constants.EDAMAM_API_KEY, query);
        showProgressDialog(binding.progressBar, binding.progressMessage);

        call.enqueue(new Callback<List<String>>() {
            @Override
            public void onResponse(@NonNull Call<List<String>> call, @NonNull Response<List<String>> response) {
                hideProgressDialog(binding.progressBar, binding.progressMessage);

                if(response.isSuccessful()){
                    assert response.body() != null;
                    adapter = new SeachListAdapter(getContext(), response.body());
                    setLayoutManager();
                    binding.resultList.setAdapter(adapter);

                    if(adapter.getItemCount() > 0){
                        showFoods(binding.resultList);
                    } else {
//                        showNoContentFound(binding.errorText, getString(R.string.search_no_result));
                    }
                } else {
                    showUnsuccessfulFeedback(binding.errorText, requireContext());
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<String>> call, @NonNull Throwable t) {
                hideProgressDialog(binding.progressBar, binding.progressMessage);
                showFailureFeedback(binding.errorText, requireContext());
                Log.e(TAG, "Error: ", t);
            }
        });
    }

    private void setLayoutManager(){
        // Set layout manager based on orientation
        if(binding.getRoot().getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
            binding.resultList.setLayoutManager(new GridLayoutManager(getContext(), 2));
        } else {
            binding.resultList.setLayoutManager(new LinearLayoutManager(getContext()));
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
