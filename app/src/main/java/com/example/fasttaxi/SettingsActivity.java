package com.example.fasttaxi;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.StorageTask;

import java.util.HashMap;

import de.hdodenhof.circleimageview.CircleImageView;

public class SettingsActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private DatabaseReference databaseReference;
    private String getType;
    private CircleImageView circleImageView;
    private EditText nameET, phoneET, carET;
    private ImageView closeBtn, saveBtn;
    private TextView imageChangeBtn;
    private Uri imageUri;
    private String myUrl = "";
    private String checker = "";
    private StorageTask uploadTask;
    private StorageReference storageProfileImageRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        getType = getIntent().getStringExtra("type");
        mAuth = FirebaseAuth.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReference().child("Users").child(getType);
        storageProfileImageRef = FirebaseStorage.getInstance().getReference().child("Profile Pictures");

        circleImageView = (CircleImageView) findViewById(R.id.profile_image);
        nameET = (EditText) findViewById(R.id.name);
        phoneET = (EditText) findViewById(R.id.phone);
        carET = (EditText) findViewById(R.id.car_name);
        if(getType.equals("Drivers")){
            carET.setVisibility(View.VISIBLE);
        }
        closeBtn = (ImageView) findViewById(R.id.close_button);
        saveBtn = (ImageView) findViewById(R.id.save_button);
        imageChangeBtn = (TextView) findViewById(R.id.change_photo_btn);

        closeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(getType.equals("Drivers")){
                    startActivity(new Intent(SettingsActivity.this,DriversMapActivity.class));
                }
                else {
                    startActivity(new Intent(SettingsActivity.this,CustomerMapActivity.class));

                }
            }
        });



};
};