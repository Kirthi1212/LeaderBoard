package com.example.rmkengineeringcollege.leaderboard;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    DatabaseReference dbusers ;
    ListView listviewUsers ;
     List<Users> ulist;
    EditText editText;
    ImageButton imageButton;
    userlist adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = (EditText)findViewById(R.id.editText);
        imageButton = (ImageButton)findViewById(R.id.imageButton);
        dbusers = FirebaseDatabase.getInstance().getReference("scores");
        listviewUsers = (ListView)findViewById(R.id.listviewUsers);
        ulist = new ArrayList<>();
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String stext = editText.getText().toString().toUpperCase();
                adapter.getFilter().filter(stext);
                listviewUsers.setAdapter(adapter);
            }
        });

    }


    @Override
    protected void onStart() {
        super.onStart();

        dbusers.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                ulist.clear();
                for(DataSnapshot userSnapshot : dataSnapshot.getChildren()) {
                Users users = userSnapshot.getValue(Users.class);
                    Log.d("score",users.empid+users.score);
                    ulist.add(users);
               Collections.sort(ulist, new Comparator<Users>() {
                   @Override
                   public int compare(Users u1, Users u2) {
                       return Integer.valueOf((int)u2.score).compareTo((int)u1.score);
                   }
               });

                }
                adapter=new userlist(MainActivity.this,ulist);
                listviewUsers.setAdapter(adapter);

            }


            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

}
