package slidingmenu.adapter;

import java.util.ArrayList;
import java.util.List;

import com.example.sahyog.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.TextView;

public class MyAdapter extends BaseAdapter {
	Context context;
	List<String> firstName;
	
	List<Integer> images;
	ViewHolder viewHolder;
	

	public MyAdapter(Context context,List<String> firstName,List<Integer> images)
	{
		this.context=context;
		this.firstName=firstName;
     	this.images=images;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return firstName.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return firstName.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}

	@Override
	public View getView(final int position, View arg1, ViewGroup arg2) {
		// TODO Auto-generated method stub
		if(arg1==null)
		{
			LayoutInflater inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			arg1=inflater.inflate(R.layout.listview,null);
			viewHolder=new ViewHolder();
			viewHolder.img=(ImageView)arg1.findViewById(R.id.itemView);
			viewHolder.firstNameText=(TextView)arg1.findViewById(R.id.firstName);
			
		arg1.setTag(viewHolder);
		
			
		}
		else
		{
			viewHolder=(ViewHolder)arg1.getTag();
		}
		viewHolder.img.setBackgroundResource(images.get(position));
		viewHolder.firstNameText.setText(firstName.get(position));
		
		
		
		return arg1;
	}
	public final class ViewHolder
	{
		TextView firstNameText;
		
		ImageView img;
	
 	}

}
