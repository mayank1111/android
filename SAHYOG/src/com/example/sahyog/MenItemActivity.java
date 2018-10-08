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
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class MenItemActivity extends Activity {
  List<String> firstName;
  
  ListView listView;
  List<Integer> images;
  MyAdapter adapter;
  int[] itemImages={R.drawable.menshirt,R.drawable.mentrousers,R.drawable.menjeans,R.drawable.mentshirt,R.drawable.menkurta};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_men_item);
		
		ActionBar actionBar = getActionBar();
		actionBar.setHomeButtonEnabled(true);
		actionBar.setDisplayHomeAsUpEnabled(true);
		Intent intent = getIntent();
		final String category = intent.getStringExtra("category");
		Log.d("%%%%%%%%%%%%%%%%%%%%%%%",category+">>>>>>");
		firstName=new ArrayList<String>();
		
		
		images=new ArrayList<Integer>();
		listView=(ListView)findViewById(R.id.listView1);
		
		String[] stringArray = getResources().getStringArray(R.array.menItemNames);
		
		for(int i=0;i<stringArray.length;i++)
		{
			firstName.add(stringArray[i]);
			
			images.add(itemImages[i]);
			
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
				Intent i=new Intent(MenItemActivity.this,DonateItem.class);
				i.putExtra("category",category);
				i.putExtra("itemName",itemName);
				startActivity(i);
				
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.men_item, menu);
		return true;
	}

}
