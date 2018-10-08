package com.mayankshorey.twaddle.ui.activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.mayankshorey.twaddle.R;
import com.mayankshorey.twaddle.models.Campaign;
import com.mayankshorey.twaddle.utils.Constants;

public class SeeCampaignActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_see_campaign);
       Button b = (Button) findViewById(R.id.btnDonate);
       b.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Toast.makeText(SeeCampaignActivity.this,"Donated and Shared on Facebook",Toast.LENGTH_LONG).show();
               //Intent intent = new Intent(SeeCampaignActivity.this,DonationActivity.class);
               //startActivity(intent);
           }
       });
        Button b1 = (Button) findViewById(R.id.btnAdd);
        b1.setVisibility(View.INVISIBLE);

        SharedPreferences prefs = getSharedPreferences("User", Context.MODE_PRIVATE);
        String cause = prefs.getString("CAUSE","");
        String description = prefs.getString("DESCRIPTION","");

        TextView campaignName = (TextView)findViewById(R.id.text_campaignName);
        campaignName.setText(cause);

        TextView campaignDesc = (TextView)findViewById(R.id.text_campaign_Description);
        campaignDesc.setText(description);


        TextView userName = (TextView)findViewById(R.id.text_view_username);
        TextView userAlphabet = (TextView)findViewById(R.id.text_view_user_alphabet);
       String name =  getIntent().getExtras().getString("username");
       String s = String.valueOf(name.charAt(0));
        userAlphabet.setText(s);
        userName.setText(name);

       b.setVisibility(View.VISIBLE);
    }

    public static void startActivity(Context context,
                                     String receiver
                                   ) {
        Intent intent = new Intent(context, SeeCampaignActivity.class);
        intent.putExtra("username", receiver);

        context.startActivity(intent);
    }

}
