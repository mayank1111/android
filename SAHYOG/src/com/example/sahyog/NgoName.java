package com.example.sahyog;

import android.os.Bundle;
import android.os.IInterface;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.widget.LinearLayout;

public class NgoName extends Activity {
	private int[] ngoImages = {R.drawable.prayas,R.drawable.onehope,R.drawable.myyouropportunities,R.drawable.aroh,R.drawable.goonj};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ngo_name);
		Intent intent = getIntent();
		String imageNo = intent.getStringExtra("imageNo");
		Integer i=Integer.parseInt(imageNo);
		LinearLayout ll=(LinearLayout)findViewById(R.id.imageBackground);
		ll.setBackgroundResource(ngoImages[i]);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.ngo_name, menu);
		return true;
	}

}
