package my.foodon.foodorderapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;

import java.util.ArrayList;

import my.foodon.foodorderapp.Adapters.MainAdapter;
import my.foodon.foodorderapp.Models.MainModel;
import my.foodon.foodorderapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());



        ArrayList<MainModel> list = new ArrayList<>();

        list.add(new MainModel(R.drawable.burger1 , "Chicken Burger", "910", "Chicken Burger with Extra cheese"));
        list.add(new MainModel(R.drawable.burger2 , "Beef Burger", "1200", "Beef Burger with Extra Cheese "));
        list.add(new MainModel(R.drawable.burger3 , "Fish Burger", "850", "Fish Burger with Extra cheese"));
        list.add(new MainModel(R.drawable.pizza1 , "Pizza", "890", "The offer to download the coupons ends Thrusday November 8th"));
        list.add(new MainModel(R.drawable.submarine, "Submarine", "790", "Submarine with extra chilli chicken"));


        MainAdapter adapter = new MainAdapter(list, this);
        binding.recylerview.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        binding.recylerview.setLayoutManager(layoutManager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.orders:
                startActivity(new Intent(MainActivity.this, OrderActivity.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}