package com.project.food;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.google.android.material.tabs.TabLayoutMediator;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.project.food.adapter.HomeViewPagerAdapter;
import com.project.food.databinding.ActivityHomeBinding;
import com.project.food.models.Settings;
import com.project.food.utility.Constants;

import java.util.Objects;

public class HomeActivity extends AppCompatActivity {
    public static final String TAG = HomeActivity.class.getSimpleName();
    private ActivityHomeBinding binding;
    private Settings userSettings;
    private FragmentStateAdapter viewPagerAdapter;
    private DatabaseReference settingsReference;
    private ValueEventListener settingsListener;
    private FirebaseAuth auth;
    private FirebaseAuth.AuthStateListener authStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        FirebaseApp.initializeApp(this);
        auth = FirebaseAuth.getInstance();
        initializeAuthStateListener();

        String userId = Objects.requireNonNull(auth.getCurrentUser()).getUid();
        settingsReference = FirebaseDatabase.getInstance().getReference(Constants.FIREBASE_CHILD_SETTINGS_LOCATION).child(userId);

        setUpHomeScreen();
    }

    private void initializeTabLayout(){
        new TabLayoutMediator(binding.tabLayout, binding.viewPager, (tab, position) -> {
            switch (position){
                case 0:
                    tab.setText(getString(R.string.parser));
                    break;
                case 1:
                    tab.setText(getString(R.string.search));
                    break;
                case 2:
                    tab.setText(getString(R.string.saved));
                    break;
            }
        }).attach();
    }

    private void setUpHomeScreen(){
        settingsListener = settingsReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                userSettings = snapshot.getValue(Settings.class);
                viewPagerAdapter = new HomeViewPagerAdapter(HomeActivity.this, userSettings);
                binding.viewPager.setAdapter(viewPagerAdapter);
                initializeTabLayout();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.e(TAG, "Error while fetching user settings", error.toException());
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.app_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.action_logout) {
            logout();
        }
        return super.onOptionsItemSelected(item);
    }

    private void logout(){
        auth.signOut();
    }

    private void initializeAuthStateListener(){
        authStateListener = firebaseAuth -> {
            if(firebaseAuth.getCurrentUser() == null){
                redirectToLaunchScreen();
            }
        };
    }

    private void redirectToLaunchScreen(){
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onStart() {
        super.onStart();
        auth.addAuthStateListener(authStateListener);
    }

    @Override
    protected void onStop() {
        super.onStop();
        auth.addAuthStateListener(authStateListener);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        settingsReference.removeEventListener(settingsListener);
    }
}
