package com.example.sahyog;

import java.util.ArrayList;

import sahyogclasses.Item;
import sahyogclasses.Ngo;
import sahyogserverconnectivity.ExternalServer;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class DonateItem extends Activity {
ArrayList<Ngo> ngoList;
String[] ngoNames;
int position;
String[] ngoPhoneNo;
String category,itemName,phoneNo;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_donate_item);
		Intent intent = getIntent();
		category = intent.getStringExtra("category");
		itemName = intent.getStringExtra("itemName");
		TextView tv=(TextView)findViewById(R.id.textView1);
		tv.setText(itemName);
		
		Log.d("&&&&&&&&&&&&&&&&&&&&&7",category+itemName+">>>>>>>>>>>>>");
		
		final Button donate=(Button)findViewById(R.id.donate);
		final EditText ngoName=(EditText)findViewById(R.id.ngoName);
		final EditText itemCount=(EditText)findViewById(R.id.itemCount);
		SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs",Context.MODE_PRIVATE);
		phoneNo = sharedPreferences.getString("phoneNo","");
		
		new  AsyncTask<Void,Void,String>() {

			@Override
			protected String doInBackground(Void... params) {



				Log.d("%%%%%%%%%%%%%%%%$$$$$$$$$$$$$$","DDDDDDDDdddd");
				ExternalServer serverObj=new ExternalServer();
				 ngoList= serverObj.searchNgo();
				 Log.d("$$$$$$$$$$$$$$$$$4",ngoList+">>>>>>>>>>>>>>");
				// size=ngoList.size();
				 Log.d("%%%%%%%%%%%%%%%%$$$$$$$$$$$$$$",ngoList.get(0)+">>>>><<<<<<<");
				// Ngo n=(Ngo)ngoList.get(0);
				 //Log.d("^^^^^^^^^^^^^^^^^^^^",n.getNgoName()+">>>>>>>");
				 ngoNames=new String[ngoList.size()];
				 ngoPhoneNo=new String[ngoList.size()];
				 for(int i=0;i<ngoList.size();++i)
				 {
					 Ngo n=(Ngo)ngoList.get(i);
					 ngoNames[i]=n.getNgoName();
					 ngoPhoneNo[i]=n.getphoneNumber();
					 Log.d("$$$$$$$$$$$$$$$$$$$$$$$$$$$",ngoNames[i]+">>>>>>>>>");
				 }
				 final ArrayAdapter<String> aa = new  ArrayAdapter(DonateItem.this,android.R.layout.simple_spinner_dropdown_item,ngoNames);			
					ngoName.setOnClickListener(new OnClickListener() {

						public void onClick(View v) {

							new AlertDialog.Builder(DonateItem.this)
							.setTitle("NGO Name")
							.setAdapter(aa, new DialogInterface.OnClickListener() {

								public void onClick(DialogInterface dialog, int which) {
									
									ngoName.setText(ngoNames[which]);
									position=which;
									dialog.dismiss();
								}
							}).create().show();


						}
					});
				
				

				//serverObj.shareRegIdWithAppServer(context,phone.getText().toString(),password.getText().toString());

				// TODO Auto-generated method stub
				return null;
			}
		}.execute(null,null,null);	
		
		
		
		donate.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if(itemCount.getText().toString().trim().equals("")||ngoName.getText().toString().trim().equals(""))
				{
					
					
					Toast.makeText(DonateItem.this,"Fill All The Details",Toast.LENGTH_SHORT).show();
				}
				else
				{
					
					
					Log.d("%%%%%%%%555555555555555",phoneNo+">>>>>>>>>>>>>");
					new  AsyncTask<Void,Void,String>() {

						@Override
						protected String doInBackground(Void... params) {



							Log.d("%%%%%%%%%%%%%%%%$$$$$$$$$$$$$$","DDDDDDDDdddd");
							ExternalServer serverObj=new ExternalServer();
							Item i=new Item();
							i.setCategory(category);
							i.setDonater_id(phoneNo);
							i.setngo_id(ngoPhoneNo[position]);
							i.setI_d(itemCount.getText().toString().trim());
							i.setItemName(itemName);
							Log.d("^^^^^^^^^^^^^",i.getCaategory()+i.getNgo_id()+i.get_i_d()+i.getdonater_id()+i.getItemName()+">>>>>>>>>>");
							
							 serverObj.donateItem(i);
						
							
							

							

							// TODO Auto-generated method stub
							return null;
						}
						protected void onPostExecute(String result) {
							Toast.makeText(DonateItem.this,"SUCCESSFULLY DONATED",Toast.LENGTH_SHORT).show();
							finish();
						}
					}.execute(null,null,null);	
					
					
				}
				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.donate_item, menu);
		return true;
	}

}
