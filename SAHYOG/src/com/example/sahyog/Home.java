package com.example.sahyog;



import donatorslidngmenufragments.DonaterLoginSignUpFragment;
import donatorslidngmenufragments.NGOLoginSignUpFragment;

import android.os.Bundle;


import android.app.ActionBar.TabListener;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBar.Tab;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.widget.ImageView;

public class Home extends ActionBarActivity implements ActionBar.TabListener {
	ViewPager pager;
	ActionBar actionBar;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		
		pager=(ViewPager)findViewById(R.id.pager1);
                   FragmentManager fragmentManager = getSupportFragmentManager();
                   pager.setAdapter(new MyPagerAdapter(fragmentManager));
                   

                   actionBar=getSupportActionBar();
                   actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
                   ActionBar.Tab donaterTab = actionBar.newTab();
                   donaterTab.setText("DONATOR");
                   donaterTab.setTabListener(this);
                   ActionBar.Tab ngoTab = actionBar.newTab();
                   ngoTab.setText("NGO");
                   ngoTab.setTabListener(this);
                 
                   
                   actionBar.addTab(donaterTab);
                   actionBar.addTab(ngoTab);
                   pager.setOnPageChangeListener(new OnPageChangeListener() {
                		
                		@Override
                		public void onPageSelected(int arg0) {
                			// TODO Auto-generated method stub
                		actionBar.setSelectedNavigationItem(arg0);	
                		}
                		
                		@Override
                		public void onPageScrolled(int arg0, float arg1, int arg2) {
                			// TODO Auto-generated method stub
                			
                		}
                		
                		@Override
                		public void onPageScrollStateChanged(int arg0) {
                			// TODO Auto-generated method stub
                			
                		}
                	});
                   
                   
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}



	
	@Override
	public void onTabSelected(Tab tab,
			android.support.v4.app.FragmentTransaction ft) {
		// TODO Auto-generated method stub
	pager.setCurrentItem(tab.getPosition());	
		
	}

	@Override
	public void onTabUnselected(Tab tab,
			android.support.v4.app.FragmentTransaction ft) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTabReselected(Tab tab,
			android.support.v4.app.FragmentTransaction ft) {
		// TODO Auto-generated method stub
		
	}
	

}
 class MyPagerAdapter extends FragmentPagerAdapter {

	public MyPagerAdapter(FragmentManager fm) {
		super(fm);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Fragment getItem(int arg0) {
		// TODO Auto-generated method stub
	
		Fragment fragment=null;
		if(arg0==0)
		{
		fragment	=new DonaterLoginSignUpFragment();
		}
		else if(arg0==1)
			
		{
			fragment	=new NGOLoginSignUpFragment();
		}
		
		
		return fragment;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 2;
	}
	
}

