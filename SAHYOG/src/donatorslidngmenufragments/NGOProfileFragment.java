package donatorslidngmenufragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sahyog.R;

public class NGOProfileFragment extends Fragment{
	public NGOProfileFragment(){}
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
  
        View rootView = inflater.inflate(R.layout.fragment_profile, container, false);
          
        return rootView;
    }

}
