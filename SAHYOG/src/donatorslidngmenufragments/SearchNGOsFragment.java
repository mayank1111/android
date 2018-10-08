package donatorslidngmenufragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sahyog.R;

public class SearchNGOsFragment extends Fragment {
	
	public SearchNGOsFragment(){}
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
  
        View rootView = inflater.inflate(R.layout.fragment_searchngos, container, false);
          
        return rootView;
    }

}
