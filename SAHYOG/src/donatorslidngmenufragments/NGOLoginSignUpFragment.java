package donatorslidngmenufragments;

import sahyogclasses.Donater;
import sahyogclasses.Ngo;
import sahyogserverconnectivity.ExternalServer;

import com.example.sahyog.DonaterSignUp;
import com.example.sahyog.MainActivity;
import com.example.sahyog.NGOActivity;
import com.example.sahyog.NgoSignUp;

import android.R;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;



public class NGOLoginSignUpFragment extends Fragment{
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreateView(inflater, container, savedInstanceState);
	View view = inflater.inflate(com.example.sahyog.R.layout.fragment_ngologinsignup,null);
	final SharedPreferences sharedPreferences = getActivity().getSharedPreferences("MyPrefs",Context.MODE_PRIVATE);
	Button signin=(Button)view.findViewById(com.example.sahyog.R.id.ngosign_in_button);
	final EditText phone=(EditText)view.findViewById(com.example.sahyog.R.id.email);
	final EditText password=(EditText)view.findViewById(com.example.sahyog.R.id.password);
	Button signup=(Button)view.findViewById(com.example.sahyog.R.id.ngosigup_button);
	signup.setOnClickListener(new OnClickListener() {

		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			Intent intent=new Intent(getActivity(),NgoSignUp.class);
			startActivity(intent);
		}
	});
	signin.setOnClickListener(new OnClickListener() {

		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			Toast.makeText(getActivity(), "5555",Toast.LENGTH_LONG).show();

			final Ngo n=new Ngo();
			String phoneNumber=phone.getText().toString().trim();
			String mypassword = password.getText().toString().trim();
			if(phoneNumber.equals("")||mypassword.equals(""))
			{
                     Toast.makeText(getActivity(),"Fill all the details",Toast.LENGTH_SHORT).show();
			}
			else
			{

				n.setPhoneNumber(phone.getText().toString());
				n.setpassword(password.getText().toString());
			
				ExternalServer	appUtil = new ExternalServer();


				final Context context = getActivity();

				new  AsyncTask<Void,Void,String>() {

					@Override
					protected String doInBackground(Void... params) {




						ExternalServer serverObj=new ExternalServer();
						if(serverObj.isRegisteredNgo(n))
						{
							//Toast.makeText(getActivity(),"registered",Toast.LENGTH_LONG).show();
							Editor edit = sharedPreferences.edit();
							edit.putString("phoneNo",phone.getText().toString());
							edit.putString("password",password.getText().toString());
							edit.commit();
							Intent intent=new Intent(getActivity(),NGOActivity.class);
							startActivity(intent);
							
						}
						else
						{
							//Toast.makeText(getActivity(),"unregistered",Toast.LENGTH_LONG).show();

						}

						//serverObj.shareRegIdWithAppServer(context,phone.getText().toString(),password.getText().toString());

						// TODO Auto-generated method stub
						return null;
					}
					protected void onPostExecute(String result) {
						Toast.makeText(getActivity(),"SUCCESSFULL LOGIN",Toast.LENGTH_SHORT).show();
						getActivity().finish();
					}
				}.execute(null,null,null);
			}				




		}
	});
	return view;
}

	
	

}
