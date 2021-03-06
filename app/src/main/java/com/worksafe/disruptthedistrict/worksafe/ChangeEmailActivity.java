package com.worksafe.disruptthedistrict.worksafe;

import android.graphics.PorterDuff;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ChangeEmailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_email);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
//        getSupportActionBar().setTitle("Change Email");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.getNavigationIcon().setColorFilter(getResources().getColor(R.color.colorWhite),
                PorterDuff.Mode.SRC_ATOP);

        Button button = (Button)findViewById(R.id.email_submit);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Implement code to update email for user
                String currEmail = ((EditText) findViewById(R.id.newEmailField)).toString();
                String confCurrEmail = ((EditText) findViewById(R.id.confirmNewEmailField)).toString();

                //if(currEmail.equals(confCurrEmail) && !currEmail.equals(null)) {
                DatabaseReference database = FirebaseDatabase.getInstance().getReference("users");

                database.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot snapshot) {
                        ((EditText)findViewById(R.id.currentEmailField))
                                .setText(snapshot.child(Long.toString(LoginActivity.appUser.getUserId()))
                                        .child("username").getValue().toString());

                        ((EditText)findViewById(R.id.currentEmailField))
                                .setText("SOME TEXT");
                    }
                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                    }
                });





                //dbReff.setValue(currEmail);
                //database.child("users").child();
                //database.child().
                //}


            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main_screen, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
