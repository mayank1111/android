package com.example.sahyog;

import java.util.ArrayList;
import java.util.HashMap;

import sahyogclasses.Item;
import sahyogserverconnectivity.ExternalServer;
import slidingmenu.adapter.MyAdapter;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.Menu;
import android.widget.ListView;

public class DonaterItemDetail extends Activity {
	
	HashMap<String,Integer> mapping;
	ArrayList<String> firstName;
	ArrayList<Integer> image;
	ListView listView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_donater_item_detail);
		 listView=(ListView)findViewById(R.id.donaterslistView);
		Intent intent = getIntent();
		mapping=new HashMap<String, Integer>();
		
		mapping.put("MEN SHIRTS",R.drawable.menshirt);
		mapping.put("MEN T-SHIRTS",R.drawable.mentshirt);
		mapping.put("MEN TROUSERS",R.drawable.mentrousers);
		mapping.put("MEN JEANS",R.drawable.menjeans);
		mapping.put("MEN KURTAPAJAMA",R.drawable.menkurta);
		mapping.put("FOOTWEAR SPORTS-MEN",R.drawable.footwearsportsmen);
		mapping.put("FOOTWEAR SPORTS-KIDS",R.drawable.footwearsportskids);
		mapping.put("FOOTWEAR SPORTS-WOMEN",R.drawable.footwearsportswomen);
		mapping.put("FOOTWEAR CASUALSHOES",R.drawable.footwaercasuals);
		mapping.put("FOOTWEAR LOAFERS",R.drawable.footwearloafer);
		mapping.put("KIDS T-SHIRTS",R.drawable.kidstshirts);
		mapping.put("KIDS SHORTS",R.drawable.kidsshorts);
		mapping.put("KIDS JEANS",R.drawable.kidsjeans);
		mapping.put("KIDS KIDSWINTERCLOTHES",R.drawable.kidswinter);
		mapping.put("WOMEN SAREES",R.drawable.womensarees);
		mapping.put("WOMEN SHIRT-TOPS",R.drawable.womentops);
		mapping.put("WOMEN JEANS",R.drawable.womenjeans);
		mapping.put("WOMEN SKIRTS", R.drawable.womenskirts);
		mapping.put("WOMEN STOLE", R.drawable.womenstoles);
		mapping.put("WOMEN WINTERCLOTHES",R.drawable.womenwinterclothes);
		mapping.put("TOYS SOFTTOYS",R.drawable.toysoft);
		mapping.put("TOYS INFANTTOYS", R.drawable.toysinfant);
		mapping.put("TOYS MUSICALTOYS", R.drawable.toysmusical);
		mapping.put("TOYS TOYSBOYS",R.drawable.toysboys);
		mapping.put("TOYS TOYSGIRLS",R.drawable.toysgirls);
	final	String donaterPhoneNo = intent.getStringExtra("donaterPhoneNo");
		SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs",Context.MODE_PRIVATE);
		final String phoneNo = sharedPreferences.getString("phoneNo","");
		
		new  AsyncTask<Void,Void,String>() {

			@Override
			protected String doInBackground(Void... params) {



				Log.d("%%%%%%%%%%%%%%%%$$$$$$$$$$$$$$","DDDDDDDDdddd");
				ExternalServer serverObj=new ExternalServer();
				ArrayList<Item> itemDetails = serverObj.getItemDetails(donaterPhoneNo,phoneNo);
				Item item =(Item)itemDetails.get(0);
				Log.d("$GGGGGGGGGGGGGGGGGGGGGGGGGGG",item.get_i_d()+">>>>>>>>>>>>>>>>>>>>");
			firstName=new ArrayList<String>();
			image=new ArrayList<Integer>();
				for(int i=0;i<itemDetails.size();++i)
				{
					Item items=(Item)itemDetails.get(i);
					String itemDetail=items.getCaategory()+" "+items.getItemName();
					firstName.add(itemDetail);
					image.add(mapping.get(itemDetail));
				}

				//serverObj.shareRegIdWithAppServer(context,phone.getText().toString(),password.getText().toString());

				// TODO Auto-generated method stub
				return null;
			}
			protected void onPostExecute(String result) {
				
				
				 MyAdapter adapter=new MyAdapter(getApplicationContext(), firstName, image);
				listView.setAdapter(adapter);
			}
		}.execute(null,null,null);	
		
		
		
	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.donater_item_detail, menu);
		return true;
	}

}
