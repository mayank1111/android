package donatorslidngmenufragments;

import java.util.ArrayList;

import sahyogclasses.Donater;
import sahyogclasses.Ngo;
import sahyogserverconnectivity.ExternalServer;

import com.example.sahyog.DonaterItemDetail;
import com.example.sahyog.ItemDetail;
import com.example.sahyog.R;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class MyDonatersFragment extends Fragment {
	String phoneNo;
	ListView lv=null;
	ArrayList<Donater> donaterList=null;
	String[] donaterName,donaterPhoneNo;
	public View onCreateView(android.view.LayoutInflater inflater, android.view.ViewGroup container, android.os.Bundle savedInstanceState)
	{
	View rootView = inflater.inflate(R.layout.fragment_mydonaters, container, false);
	 SharedPreferences sharedPreferences = getActivity().getSharedPreferences("MyPrefs",Context.MODE_PRIVATE);
		 phoneNo = sharedPreferences.getString("phoneNo","");
		lv=(ListView)rootView.findViewById(R.id.mylistView);
		
		new  AsyncTask<Void,Void,String>() {

			@Override
			protected String doInBackground(Void... params) {



				Log.d("%%%%%%%%%%%%%%%%$$$$$$$$$$$$$$","DDDDDDDDdddd");
				ExternalServer serverObj=new ExternalServer();
				
				 donaterList= serverObj.myDonaters(phoneNo);
				 Log.d("$$$$$$$$$$$$$$$$$4",donaterList+">>>>>>>>>>>>>>");
				// size=ngoList.size();
				 Log.d("%%%%%%%%%%%%%%%%$$$$$$$$$$$$$$",donaterList.get(0)+">>>>><<<<<<<");
				
				 Donater n=(Donater)donaterList.get(0);
				 Log.d("^^^^^^^^^^^^^^^^^^^^",n.getDonaterName()+">>>>>>>");
				 donaterName=new String[donaterList.size()];
				 donaterPhoneNo=new String[donaterList.size()];
				 for(int i=0;i<donaterList.size();++i)
				 {
					
					 Donater donater = (Donater)donaterList.get(i);
					 donaterName[i]=donater.getDonaterName();
							 donaterPhoneNo[i]=donater.getphoneNumber();
				 }
				 Log.d("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%",donaterName.toString()+">>>>");
				 
					
				
				 
			
				// TODO Auto-generated method stub
				return null;
			}
			@Override
			protected void onPostExecute(String result) {
				ArrayAdapter<String> aa=new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,donaterName);
				lv.setAdapter(aa);
				lv.setOnItemClickListener(new OnItemClickListener() {

					@Override
					public void onItemClick(AdapterView<?> arg0, View arg1,
							int arg2, long arg3) {
						// TODO Auto-generated method stub
						Intent i=new Intent(getActivity(),DonaterItemDetail.class);
						i.putExtra("donaterPhoneNo",donaterPhoneNo[arg2]);
						startActivity(i);
						
					}
				});
				
			}
		
		}.execute(null,null,null);	
		
		
	          
	   
	return rootView;
	}
}
