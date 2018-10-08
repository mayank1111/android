package donatorslidngmenufragments;

import com.devsmart.android.ui.HorizontalListView;
import com.example.sahyog.ElectronicsItemActivity;
import com.example.sahyog.FootWearActivity;
import com.example.sahyog.FurnitureActivity;
import com.example.sahyog.KidItemsActivity;
import com.example.sahyog.MenItemActivity;
import com.example.sahyog.NgoName;
import com.example.sahyog.ToysActivity;

import com.example.sahyog.R;
import com.example.sahyog.WomenItemsActivity;

import android.app.Fragment;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class HomeFragment extends Fragment {
	int i;
	private int[] donationItemImages = {R.drawable.men, R.drawable.kids, R.drawable.women,
			R.drawable.footwear, R.drawable.toys};  
	private int[] ngoImages = {R.drawable.prayas,R.drawable.onehope,R.drawable.myyouropportunities,R.drawable.aroh,R.drawable.goonj};
	private String[] category={"MEN","KIDS","WOMEN","FOOTWEAR","TOYS"};

	public HomeFragment(){}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.fragment_home, container, false);

		LinearLayout mainLayout = (LinearLayout)rootView.findViewById(R.id._linearLayout);  
		LinearLayout ngoLayout=(LinearLayout)rootView.findViewById(R.id._linearLayout1);

		for (i = 0; i < donationItemImages.length; i++) {  

			View cell = getActivity().getLayoutInflater().inflate(R.layout.donateitemslist, null);  
			View cell1=getActivity().getLayoutInflater().inflate(R.layout.ngolist,null);
			final ImageView imageView = (ImageView) cell.findViewById(R.id._image);  
			//final TextView textView = (TextView) cell.findViewById(R.id._imageName);  
			final ImageView ngoImageView=(ImageView)cell1.findViewById(R.id._ngoimage);
			imageView.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub

					Toast.makeText(getActivity(),"1111",Toast.LENGTH_LONG).show();
					switch(v.getId())
					{
					case 0:
						Intent intent=new Intent(getActivity(),MenItemActivity.class);
					
						intent.putExtra("category",category[0]);
						startActivity(intent);
					
						break;
					case 1:
						Intent intent1=new Intent(getActivity(),KidItemsActivity.class);
						
						intent1.putExtra("category",category[1]);
						startActivity(intent1);
						break;
					case 2:
						Intent intent2=new Intent(getActivity(),WomenItemsActivity.class);
						
						intent2.putExtra("category",category[2]);
						startActivity(intent2);
						break;
					case 3:
						Intent intent3=new Intent(getActivity(),FootWearActivity.class);
						
						intent3.putExtra("category",category[3]);
						startActivity(intent3);
						break;
					case 4:
						Intent intent4=new Intent(getActivity(),ToysActivity.class);
						
						intent4.putExtra("category",category[4]);
						startActivity(intent4);
						break;
					/*case 5:
						Intent intent5=new Intent(getActivity(),ElectronicsItemActivity.class);
						
						intent5.putExtra("category",category[5]);
						startActivity(intent5);
						break;
					case 6:
						Intent intent6=new Intent(getActivity(),FurnitureActivity.class);
						
						intent6.putExtra("category",category[6]);
						startActivity(intent6);
						break;
*/

					}




				}
			});

			ngoImageView.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Toast.makeText(getActivity(),"2222",Toast.LENGTH_LONG).show();

					switch(v.getId())
					{
					case 0:
						Intent intent=new Intent(getActivity(),NgoName.class);
					
						intent.putExtra("imageNo","0");
						startActivity(intent);
					
						break;
					case 1:
						Intent intent1=new Intent(getActivity(),NgoName.class);
						intent1.putExtra("imageNo","1");
					
						startActivity(intent1);
						break;
					case 2:
						Intent intent2=new Intent(getActivity(),NgoName.class);
						
						intent2.putExtra("imageNo","2");
						startActivity(intent2);
						break;
					case 3:
						Intent intent3=new Intent(getActivity(),NgoName.class);
						intent3.putExtra("imageNo","3");
					
						startActivity(intent3);
						break;
					case 4:
						Intent intent4=new Intent(getActivity(),NgoName.class);
						intent4.putExtra("imageNo","4");
						startActivity(intent4);
						break;
					/*case 5:
						Intent intent5=new Intent(getActivity(),NgoName.class);
						intent5.putExtra("imageNo","5");
						
						startActivity(intent5);
						break;
					case 6:
						Intent intent6=new Intent(getActivity(),NgoName.class);
						intent6.putExtra("imageNo","6");
						startActivity(intent6);
						break;

*/
					}


				}

			});



			imageView.setTag("Image#"+(i+1));  
			ngoImageView.setTag("Ngo#"+(i+1));

			TextView text = (TextView) cell.findViewById(R.id._imageName);  
			TextView text1=(TextView)cell1.findViewById(R.id._ngoimageName);

			imageView.setImageResource(donationItemImages[i]);  
			imageView.setId(i);
			ngoImageView.setId(i);
			ngoImageView.setImageResource(ngoImages[i]);
			text.setText(category[i]);  
			text1.setText("NGO#"+(i+1));

			mainLayout.addView(cell);  
			ngoLayout.addView(cell1);
		}  

		return rootView;
	}
}