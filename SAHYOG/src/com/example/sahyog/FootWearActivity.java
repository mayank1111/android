package com.example.sahyog;

import java.util.ArrayList;
import java.util.List;

import slidingmenu.adapter.MyAdapter;
import android.os.Bundle;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

public class FootWearActivity extends Activity {
	int[] footwearImages={R.drawable.footwearsportsmen,R.drawable.footwearsportskids,R.drawable.footwearsportswomen,R.drawable.footwaercasuals,R.drawable.footwearloafer};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_foot_wear);
		ActionBar actionBar = getActionBar();
		actionBar.setHomeButtonEnabled(true);
		actionBar.setDisplayHomeAsUpEnabled(true);
  List<String> firstName;
		  
		  ListView listView;
		  List<Integer> images;
		  MyAdapter adapter;
			
				Intent intent = getIntent();
				final String category = intent.getStringExtra("category");
				Log.d("%%%%%%%%%%%%%%%%%%%%%%%",category+">>>>>>");
				firstName=new ArrayList<String>();
				
				
				images=new ArrayList<Integer>();
				listView=(ListView)findViewById(R.id.listView1);
				
				String[] stringArray = getResources().getStringArray(R.array.footwearItemNames);
				
				for(int i=0;i<stringArray.length;i++)
				{
					firstName.add(stringArray[i]);
					
					images.add(footwearImages[i]);
				}
				 adapter=new MyAdapter(getApplicationContext(), firstName, images);
				listView.setAdapter(adapter);
				listView.setOnItemClickListener(new OnItemClickListener() {

					@Override
					public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
							long arg3) {
						// TODO Auto-generated method stub
						TextView item= (TextView)arg1.findViewById(R.id.firstName);
						String itemName = item.getText().toString();
						Intent i=new Intent(FootWearActivity.this,DonateItem.class);
						i.putExtra("category",category);
						i.putExtra("itemName",itemName);
						startActivity(i);
						
					}
				});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.foot_wear, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		onBackPressed();
		return true;
	}


}
