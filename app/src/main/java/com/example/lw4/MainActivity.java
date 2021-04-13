package com.example.lw4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView imageView = findViewById(R.id.imageView2);
        imageView.setOnClickListener(viewClickListener);
    }

    View.OnClickListener viewClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            showPopupMenu(v);
        }
    };

    private void showPopupMenu(View v) {
        PopupMenu popupMenu = new PopupMenu(this, v);
        popupMenu.inflate(R.menu.popupmenu);

        popupMenu
                .setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.menu1:
                                Intent intent2 = new Intent(MainActivity.this, MainActivity.class);
                                startActivity(intent2);

                                return true;
                            case R.id.menu2:
                                Intent intent3 = new Intent(MainActivity.this, SecondActivity.class);
                                startActivity(intent3);
                                Toast.makeText(getApplicationContext(),
                                        "Інша активність",
                                        Toast.LENGTH_SHORT).show();

                                return true;
                            case R.id.menu3:
                                informator();
                                Toast.makeText(getApplicationContext(),
                                        "Додаткова інформація",
                                        Toast.LENGTH_SHORT).show();
                                return true;
                            case R.id.menu4:
                                colorChanger("#4284D3");
                                Toast.makeText(getApplicationContext(),
                                        "Колір змінено",
                                        Toast.LENGTH_SHORT).show();
                                return true;
                            case R.id.menu5:


                                Toast toast = Toast.makeText(getApplicationContext(),
                                        "Тост з картінкою",
                                        Toast.LENGTH_SHORT);
                                toast.setGravity(Gravity.CENTER, 0, 0);
                                LinearLayout toastContainer = (LinearLayout) toast.getView();
                                ImageView tostImageView = new ImageView(getApplicationContext());
                                tostImageView.setImageResource(R.drawable.toast);
                                toastContainer.addView(tostImageView,0);
                                toast.show();
                                return true;
                            default:
                                return false;
                        }
                    }
                });

        popupMenu.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_items, menu);
        return true;
    }

    public void colorChanger(String color){
        getWindow().getDecorView().setBackgroundColor(Color.parseColor(color));
    }

    public void informator(){
        TextView name = findViewById(R.id.textView);
        name.setText(R.string.myName);
        TextView group = findViewById(R.id.textView2);
        group.setText(R.string.group);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.page1:
                Intent intent = new Intent(MainActivity.this, MainActivity.class);
                startActivity(intent);
                break;
            case R.id.page2:
                Intent intent2 = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent2);
                break;
            case R.id.showDetails:
                informator();
                break;
            case R.id.changeColor:
                colorChanger("#4284D3");
                break;
            case R.id.rotate:
                if(getResources().getConfiguration().orientation ==
                        Configuration.ORIENTATION_PORTRAIT)
                    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
                else if (getResources().getConfiguration().orientation ==
                        Configuration.ORIENTATION_LANDSCAPE)
                    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
                break;
        }
        return true;
    }
}