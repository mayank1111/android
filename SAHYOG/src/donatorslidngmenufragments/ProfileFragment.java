package donatorslidngmenufragments;

import sahyogclasses.Donater;
import sahyogserverconnectivity.ExternalServer;
import android.app.Fragment;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.sahyog.R;

public class ProfileFragment extends Fragment{
	String phoneNo;
	public ProfileFragment(){}
    TextView donaterName,donaterphoneNo,donaterEmail,donaterPassword,donaterAddress;
    Donater d=null;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
  
        View rootView = inflater.inflate(R.layout.fragment_profile, container, false);
        donaterName=(TextView)rootView.findViewById(R.id.donaterName);
        donaterphoneNo=(TextView)rootView.findViewById(R.id.donaterPhoneNo);
        donaterEmail=(TextView)rootView.findViewById(R.id.donaterEemailAddress);
        donaterPassword=(TextView)rootView.findViewById(R.id.donaterPassword);
        donaterAddress=(TextView)rootView.findViewById(R.id.donaterAddress);
        SharedPreferences sharedPreferences =getActivity(). getSharedPreferences("MyPrefs",Context.MODE_PRIVATE);
		phoneNo = sharedPreferences.getString("phoneNo","");
		
		new  AsyncTask<Void,Void,String>() {

			@Override
			protected String doInBackground(Void... params) {
				

				Log.d("hello","333333333333333333333");
				
				ExternalServer serverObj=new ExternalServer();
				Log.d("hello","4");
			 d = serverObj.getDonaterProfile(phoneNo);
				
				Log.d("hello","5");
				
				//serverObj.donaterSignUp(url,d);
				
				// TODO Auto-generated method stub
				return null;
			}
			protected void onPostExecute(String result) {
				
				donaterName.setText(d.getDonaterName());
				donaterphoneNo.setText(d.getphoneNumber());
				donaterEmail.setText(d.getemailAccount());
				donaterPassword.setText(d.getpassword());
				donaterAddress.setText(d.getAddress());
			}
		}.execute(null,null,null);
				

		
          
        return rootView;
    }

}
