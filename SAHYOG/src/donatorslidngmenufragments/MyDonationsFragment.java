package donatorslidngmenufragments;

import java.util.ArrayList;

import sahyogclasses.Item;
import sahyogclasses.Ngo;
import sahyogserverconnectivity.ExternalServer;
import slidingmenu.adapter.MyAdapter;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

import com.example.sahyog.DonateItem;
import com.example.sahyog.ItemDetail;
import com.example.sahyog.MenItemActivity;
import com.example.sahyog.R;

public class MyDonationsFragment extends Fragment {
	String phoneNo;
	ArrayList<Ngo> ngoList;
	String[] ngoName,ngoPhoneNo;
	ListView lv;
	 public MyDonationsFragment() {
		// TODO Auto-generated constructor stub
	}
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
  
       final  View rootView = inflater.inflate(R.layout.fragment_mydonations, container, false);
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("MyPrefs",Context.MODE_PRIVATE);
	phoneNo = sharedPreferences.getString("phoneNo","");
	lv=(ListView)rootView.findViewById(R.id.myDonationsList);
	
	new  AsyncTask<Void,Void,String>() {

		@Override
		protected String doInBackground(Void... params) {



			Log.d("%%%%%%%%%%%%%%%%$$$$$$$$$$$$$$","DDDDDDDDdddd");
			ExternalServer serverObj=new ExternalServer();
			
			 ngoList= serverObj.myDonations(phoneNo);
			 Log.d("$$$$$$$$$$$$$$$$$4",ngoList+">>>>>>>>>>>>>>");
			// size=ngoList.size();
			 Log.d("%%%%%%%%%%%%%%%%$$$$$$$$$$$$$$",ngoList.get(0)+">>>>><<<<<<<");
			
			 Ngo n=(Ngo)ngoList.get(0);
			 Log.d("^^^^^^^^^^^^^^^^^^^^",n.getNgoName()+">>>>>>>");
			 ngoName=new String[ngoList.size()];
			 ngoPhoneNo=new String[ngoList.size()];
			 for(int i=0;i<ngoList.size();++i)
			 {
				
				 Ngo ngo = (Ngo)ngoList.get(i);
				 ngoName[i]=ngo.getNgoName();
				 ngoPhoneNo[i]=ngo.getphoneNumber();
			 }
			 Log.d("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%",ngoName.toString()+">>>>");
			 
				
			
			 
		
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		protected void onPostExecute(String result) {
			ArrayAdapter<String> aa=new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,ngoName);
			lv.setAdapter(aa);
			lv.setOnItemClickListener(new OnItemClickListener() {

				@Override
				public void onItemClick(AdapterView<?> arg0, View arg1,
						int arg2, long arg3) {
					// TODO Auto-generated method stub
					Intent i=new Intent(getActivity(),ItemDetail.class);
					i.putExtra("ngoPhoneNo",ngoPhoneNo[arg2]);
					startActivity(i);
					
				}
			});
			
		}
	
	}.execute(null,null,null);	
	
	
          
        return rootView;
    }

}
