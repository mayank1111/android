package com.example.sahyog;

import sahyogclasses.Donater;
import sahyogserverconnectivity.ExternalServer;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DonaterSignUp extends Activity {
	EditText name,phoneNo,email,password,address;
	Button signUp;
	String url="http://192.168.1.11:8080/ServerSahyog/DonaterSignUpServlet?";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_donater_sign_up);
		name=(EditText)findViewById(R.id.editText1);
		phoneNo=(EditText)findViewById(R.id.editText2);
		email=(EditText)findViewById(R.id.editText3);
		password=(EditText)findViewById(R.id.editText4);
		address=(EditText)findViewById(R.id.editText5);
		signUp=(Button)findViewById(R.id.button1);
		signUp.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if(name.getText().toString().trim().equals("")||phoneNo.getText().toString().trim().equals("")||email.getText().toString().trim().equals("")||password.getText().toString().trim().equals("")||address.getText().toString().trim().equals(""))
				{
					Toast.makeText(DonaterSignUp.this,"FILL ALL THE DETAILS",Toast.LENGTH_SHORT).show();
				}
				else
				{
					final Donater d=new Donater();
			d.setDonaterName(name.getText().toString());
			d.setPhoneNumber(phoneNo.getText().toString());
			d.setEmailAccount(email.getText().toString());
			d.setpassword(password.getText().toString());
			d.setAddress(address.getText().toString());
			Log.d("$$$$$$$$$$$$$$$$$44",d.getAddress());
			Log.d("hello","6");
				
			new  AsyncTask<Void,Void,String>() {

				@Override
				protected String doInBackground(Void... params) {
					

					Log.d("hello","333333333333333333333");
					
					ExternalServer serverObj=new ExternalServer();
					Log.d("hello","4");
					serverObj.addDonater(url, d);
					Log.d("hello","5");
					Intent intent=new Intent(DonaterSignUp.this,MainActivity.class);
					startActivity(intent);
			

					//serverObj.donaterSignUp(url,d);
					
					// TODO Auto-generated method stub
					return null;
				}
				protected void onPostExecute(String result) {
					Toast.makeText(DonaterSignUp.this,"SUCCESSFULLY ACCOUNT CREATED",Toast.LENGTH_SHORT).show();
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
		getMenuInflater().inflate(R.menu.donater_sign_up, menu);
		return true;
	}

}
