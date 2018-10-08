package com.mayankshorey.twaddle.ui.activities;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.mayankshorey.twaddle.R;

public class DonationActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donation);
        Button b = (Button)findViewById(R.id.btnShare);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(DonationActivity.this,"Shared on Facebook",Toast.LENGTH_LONG).show();
            }
        });
    }

}
