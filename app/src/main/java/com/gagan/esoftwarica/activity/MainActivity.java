package com.gagan.esoftwarica.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.gagan.esoftwarica.R;
import com.gagan.esoftwarica.fragments.aboutUsFragment;
import com.gagan.esoftwarica.fragments.addStudentFragment;
import com.gagan.esoftwarica.fragments.homeFragment;
import com.gagan.esoftwarica.model.modelStudent;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static List<modelStudent> studentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Home");

        BottomNavigationView bottomNav = findViewById(R.id.bottomNavigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);



        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, new homeFragment()).commit();


        studentList = new ArrayList<>();
        studentList.add(new modelStudent("Gagan Raj Dangol", "Khokana", "Male", 23, R.drawable.male));
        studentList.add(new modelStudent("Sushant Maharjan", "Kumaripati", "Male", 22, R.drawable.male));
        studentList.add(new modelStudent("Niranjan Man Bajracharya", "Sanogaun", "Male", 20, R.drawable.male));
        studentList.add(new modelStudent("Kat Dennings", "California", "Female", 21, R.drawable.female));




    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    Fragment selectedFragment = null;
                    switch(menuItem.getItemId()){
                        case R.id.home:
                            selectedFragment = new homeFragment();
                            setTitle("Home");
                            break;

                        case R.id.addStudent:
                            selectedFragment = new addStudentFragment();
                            setTitle("Add Student");
                            break;

                        case R.id.about:
                            selectedFragment = new aboutUsFragment();
                            setTitle("About Us");
                            break;
                    }

                    getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, selectedFragment).commit();
                    return true;
                }
            };
}
