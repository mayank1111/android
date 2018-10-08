package com.mayankshorey.twaddle.ui.activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.mayankshorey.twaddle.R;
import com.mayankshorey.twaddle.models.Campaign;

public class AddCampaignActivity extends Activity {
    private DatabaseReference mDatabase;
    Button b1 = null;
    String username ="test";
    public static void startActivity(Context context,
                                     String receiver
    ) {
        Intent intent = new Intent(context, SeeCampaignActivity.class);
        intent.putExtra("username", receiver);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_campaign);
        Button b = (Button) findViewById(R.id.btnDonate);
        b1 = (Button) findViewById(R.id.btnAdd);
        b1.setVisibility(View.VISIBLE);
        b.setVisibility(View.INVISIBLE);

        final EditText campaignName = (EditText) findViewById(R.id.text_campaignName);

final        EditText campaignDescription = (EditText) findViewById(R.id.text_campaign_Description);
        b.setVisibility(View.INVISIBLE);
        SharedPreferences prefs = getSharedPreferences("User", Context.MODE_PRIVATE);
         username = prefs.getString("username", "test");
// ...
        mDatabase = FirebaseDatabase.getInstance().getReference();

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Campaign campaign = new Campaign();
                campaign.setCause(campaignName.getText().toString());
                campaign.setDescription(campaignDescription.getText().toString());
                campaign.setOrganiser(username);
                mDatabase.child("Campaign").child(username.substring(0,2)).setValue(campaign);
                finish();
            }
        });

    }
}
