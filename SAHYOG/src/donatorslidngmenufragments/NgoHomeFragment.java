package donatorslidngmenufragments;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sahyog.FootWearActivity;
import com.example.sahyog.KidItemsActivity;
import com.example.sahyog.MenItemActivity;
import com.example.sahyog.NgoName;
import com.example.sahyog.R;
import com.example.sahyog.ToysActivity;
import com.example.sahyog.WomenItemsActivity;
public class NgoHomeFragment extends Fragment
{



	public NgoHomeFragment(){}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.fragment_ngo_home, container, false);
		 SharedPreferences sharedPreferences = getActivity().getSharedPreferences("MyPrefs",Context.MODE_PRIVATE);
			String password = sharedPreferences.getString("password","").toUpperCase();
		TextView tv=(TextView)rootView.findViewById(R.id.ngoNameText);
		tv.setText("WELCOME   "+password);



		return rootView;
	}
}