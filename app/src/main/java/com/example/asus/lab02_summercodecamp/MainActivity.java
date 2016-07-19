package com.example.asus.lab02_summercodecamp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Handler;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button buttonToast;
    Button buttonDialog;
    Button buttonSnackBar;
    LinearLayout layoutParent;
    private boolean doubleBackToExitPressedOnce=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpView();
        registerEvent();
    }

    void setUpView(){
        buttonToast = (Button)findViewById(R.id.btToast);
        buttonDialog = (Button)findViewById(R.id.btDialog);
        buttonSnackBar = (Button)findViewById(R.id.btSnackBar);
        layoutParent = (LinearLayout)findViewById(R.id.layoutParent);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id){
            case R.id.btToast:
                showToastMessage();
                break;
            case R.id.btDialog:
                showDialog();
                break;
            case R.id.btSnackBar:
                showSnackBar();
                break;
            default:
                break;

        }
    }
    void registerEvent(){
        buttonToast.setOnClickListener(this);
        buttonDialog.setOnClickListener(this);
        buttonSnackBar.setOnClickListener(this);

    }
    void showToastMessage(){
        Toast.makeText(MainActivity.this, "hello", Toast.LENGTH_SHORT).show();
    }
    void showDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setMessage("Are you sure?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "You just clicked on Yes button!", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "You just clicked on No button!", Toast.LENGTH_SHORT).show();
            }
        });
        builder.show();
    }
    void showSnackBar(){
        Snackbar snackbar = Snackbar.make(layoutParent, "I am snackbar!", Snackbar.LENGTH_LONG);
        snackbar.show();
    }

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            finish();
            return;
        }
        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Please click back again to exit", Toast.LENGTH_SHORT).show();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                doubleBackToExitPressedOnce = false;
            }
        }, 2000);

    }
}