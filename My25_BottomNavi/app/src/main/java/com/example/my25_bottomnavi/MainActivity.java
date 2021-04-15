package com.example.my25_bottomnavi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationMenuView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "main : MainActivity";

    BottomNavigationView bottom_navi;
    Fragment1 fragment1;
    Fragment2 fragment2;
    Fragment3 fragment3;

    Fragment selected = null;


    TabLayout tabs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        bottom_navi = findViewById(R.id.bottom_navi);
        bottom_navi.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case  R. id.tab1:
                        Log.d(TAG, "onNavigationItemSelected: 첫 번째 탭");
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.container, fragment1).commit();
                        break;

                    case  R. id.tab2:
                        Log.d(TAG, "onNavigationItemSelected: 두 번째 탭");
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.container, fragment2).commit();
                        break;

                    case  R. id.tab3:
                        Log.d(TAG, "onNavigationItemSelected: 세 번째 탭");
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.container, fragment3).commit();

                        break;
                        

                }



                return true;
            }
        });



        fragment1 = new Fragment1();
        fragment2 = new Fragment2();
        fragment3 = new Fragment3();


        tabs.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                Log.d(TAG, "onTabSelected: 선택된 탭 => " + position);

                if(position == 0){
                    selected = fragment1;
                }else if(position == 1){
                    selected = fragment2;
                }else if(position == 2) {
                    selected = fragment3;
                }
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, selected).commit();

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });




        //초기화면에 프래그먼트1 보이기
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, fragment1).commit();





    }
}