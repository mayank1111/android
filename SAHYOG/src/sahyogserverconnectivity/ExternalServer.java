package sahyogserverconnectivity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HTTP;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import sahyogclasses.Donater;
import sahyogclasses.Item;
import sahyogclasses.Ngo;

import com.example.sahyog.Config;
import com.google.gson.Gson;

import android.content.Context;
import android.telephony.gsm.GsmCellLocation;
import android.util.JsonReader;
import android.util.Log;

public class ExternalServer {
	String myurl="http://192.168.43.6:8080/ServerSahyog/";

	public String donaterSignUp(String url,Donater d)
	{


		String result = "";
		Map paramsMap = new HashMap();
		paramsMap.put("email",d.getemailAccount());
		paramsMap.put("password",d.getpassword());
		paramsMap.put("name",d.getDonaterName());
		paramsMap.put("address",d.getAddress());

		Log.d("55555555555555555555","6666666666666");
		try {
			URL serverUrl = null;
			try {
				serverUrl = new URL(url);
				Log.d("$$$$$$$$$$$$$$$$$4","55555555555555555555");
			} catch (MalformedURLException e) {
				Log.e("AppUtil", "URL Connection Error: "
						, e);
				result = "Invalid URL: ";
			}

			StringBuilder postBody = new StringBuilder();
			Iterator<Entry<String, String>> iterator = paramsMap.entrySet()
					.iterator();

			while (iterator.hasNext()) {
				Entry param = iterator.next();
				postBody.append(param.getKey()).append('=')
				.append(param.getValue());
				if (iterator.hasNext()) {
					postBody.append('&');
				}
			}
			String body = postBody.toString();
			byte[] bytes = body.getBytes();
			HttpURLConnection httpCon = null;
			try {
				httpCon = (HttpURLConnection) serverUrl.openConnection();
				httpCon.setDoOutput(true);
				httpCon.setUseCaches(false);
				httpCon.setFixedLengthStreamingMode(bytes.length);
				httpCon.setRequestMethod("POST");
				httpCon.setRequestProperty("Content-Type",
						"application/x-www-form-urlencoded;charset=UTF-8");
				OutputStream out = httpCon.getOutputStream();
				out.write(bytes);
				out.close();
				Log.d("111111111111111","222222222222222");
				int status = httpCon.getResponseCode();
				if (status == 200) {
					result = "Email shared with Application Server";
					Log.d("Rrrrrrrrrr","55555555555555");
				} else {
					result = "Post Failure." + " Status: " + status;
				}
			} finally {
				if (httpCon != null) {
					httpCon.disconnect();
				}
			}

		} catch (IOException e) {
			result = "Post Failure. Error in sharing with App Server.";
			Log.e("AppUtil", "Error in sharing with App Server: " + e);
		}
		return result;
	}
	
	public ArrayList<Ngo> myDonations(String donater_id)
	{
		ArrayList<Ngo> al=new ArrayList<Ngo>();
String url=myurl+"MyDonationServlet";
		
		try
		{
			HttpClient httpClient=new DefaultHttpClient();
			HttpPost post=new HttpPost(url);
			
			Gson g=new Gson();
			String name = g.toJson(donater_id);
			StringEntity se=new StringEntity(name);
			se.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));
			post.setEntity(se);
			HttpResponse httpResponse = httpClient.execute(post);
						

			InputStream content = httpResponse.getEntity().getContent();
			StringBuilder sb=new StringBuilder();
			if(content!=null)
			{
				BufferedReader br=new BufferedReader(new InputStreamReader(content));
				String line="";
				while((line=br.readLine())!=null)
				{
					sb.append(line);
				}
			JSONArray jsonArray=new JSONArray(sb.toString());
		Log.d("$$$$$$$$$$$$AAAAAAAAAA",	g.fromJson(jsonArray.getString(0),Ngo.class)+"<<<");
	
			for(int i=0;i<jsonArray.length();i++)
			{
				
				al.add(g.fromJson(jsonArray.getString(i),Ngo.class));
				
			}
				 
				//Log.d("%%%%%%%%%%%%%%%%%%%%%",d.getAddress()+d.getDonaterName()+">>>");
			
			Log.d("hello","ready helloooooooooooooooo");

			}



		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return al;
	}
	
	public ArrayList<Donater> myDonaters(String ngo_id)
	{
		ArrayList<Donater> al=new ArrayList<Donater>();
String url=myurl+"MyDonaterServlet";
		
		try
		{
			HttpClient httpClient=new DefaultHttpClient();
			HttpPost post=new HttpPost(url);
			
			Gson g=new Gson();
			String name = g.toJson(ngo_id);
			StringEntity se=new StringEntity(name);
			se.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));
			post.setEntity(se);
			HttpResponse httpResponse = httpClient.execute(post);
						

			InputStream content = httpResponse.getEntity().getContent();
			StringBuilder sb=new StringBuilder();
			if(content!=null)
			{
				BufferedReader br=new BufferedReader(new InputStreamReader(content));
				String line="";
				while((line=br.readLine())!=null)
				{
					sb.append(line);
				}
			JSONArray jsonArray=new JSONArray(sb.toString());
		Log.d("$$$$$$$$$$$$AAAAAAAAAA",	g.fromJson(jsonArray.getString(0),Donater.class)+"<<<");
	
			for(int i=0;i<jsonArray.length();i++)
			{
				
				al.add(g.fromJson(jsonArray.getString(i),Donater.class));
				
			}
				 
				//Log.d("%%%%%%%%%%%%%%%%%%%%%",d.getAddress()+d.getDonaterName()+">>>");
			
			Log.d("hello","ready helloooooooooooooooo");

			}



		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return al;
	}
	public ArrayList<Ngo> searchNgo()
	{
		String url=myurl+"SearchNgoServlet";
		ArrayList al=new ArrayList();
		try
		{
			HttpClient httpClient=new DefaultHttpClient();
			HttpPost post=new HttpPost(url);
			HttpResponse httpResponse = httpClient.execute(post);
			
			Gson g=new Gson();
	

			InputStream content = httpResponse.getEntity().getContent();
			StringBuilder sb=new StringBuilder();
			if(content!=null)
			{
				BufferedReader br=new BufferedReader(new InputStreamReader(content));
				String line="";
				while((line=br.readLine())!=null)
				{
					sb.append(line);
				}
			JSONArray jsonArray=new JSONArray(sb.toString());
		Log.d("$$$$$$$$$$$$AAAAAAAAAA",	g.fromJson(jsonArray.getString(0),Ngo.class)+"<<<");
	
			for(int i=0;i<jsonArray.length();i++)
			{
				
				al.add(g.fromJson(jsonArray.getString(i),Ngo.class));
				
			}
				 
				//Log.d("%%%%%%%%%%%%%%%%%%%%%",d.getAddress()+d.getDonaterName()+">>>");
			
			Log.d("hello","ready helloooooooooooooooo");

			}


		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return al;
	}

	public boolean isRegisteredUser(Donater d)
	{
		boolean b=false;
		String url=myurl+"DonaterLoginServlet?";
		HttpResponse httpResponse = makeConnection(url,d);
		Gson g=new Gson();
		StringBuilder sb=new StringBuilder();
		try
		{
			InputStream content = httpResponse.getEntity().getContent();
			
			if(content!=null)
			{
				BufferedReader br=new BufferedReader(new InputStreamReader(content));
				String line="";
				while((line=br.readLine())!=null)
				{
					sb.append(line);
				}
				Log.d("$$$$$$$$$$$$$$$$$$$",sb.toString()+">>>>");
			}
		}
		catch(Exception e)
		{
               e.printStackTrace();
		}
		if(sb!=null)
		{
		 b=Boolean.parseBoolean(sb.toString());
		}
		return b;
	}
	public boolean isRegisteredNgo(Ngo n)
	{
		boolean b=false;
		String url=myurl+"NgoLoginServlet?";
		StringBuilder sb=new StringBuilder();
		try
		{
		Gson g=new Gson();
		String name = g.toJson(n);

		HttpClient httpClient=new DefaultHttpClient();
		HttpPost post=new HttpPost(url);
		StringEntity se=new StringEntity(name);
		se.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));
		post.setEntity(se);

		Log.d("hello","ready hello");
		HttpResponse httpResponse=httpClient.execute(post);
		
		
		
			InputStream content = httpResponse.getEntity().getContent();
			
			if(content!=null)
			{
				BufferedReader br=new BufferedReader(new InputStreamReader(content));
				String line="";
				while((line=br.readLine())!=null)
				{
					sb.append(line);
				}
				Log.d("$$$$$$$$$$$$$$$$$$$",sb.toString()+">>>>");
			}
		}
		catch(Exception e)
		{
               e.printStackTrace();
		}
		if(sb!=null)
		{
		 b=Boolean.parseBoolean(sb.toString());
		}
		return b;
	}
	public void donateItem(Item item) {
		String url=myurl+"DonateItemServlet";
		
		try
		{
			HttpClient httpClient=new DefaultHttpClient();
			HttpPost post=new HttpPost(url);
			
			Gson g=new Gson();
			String name = g.toJson(item);
			StringEntity se=new StringEntity(name);
			se.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));
			post.setEntity(se);
			HttpResponse httpResponse = httpClient.execute(post);

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
			
	}
	public HttpResponse makeConnection(String url,Donater d)
	{
		HttpResponse httpResponse=null;
		try
		{
			Log.d("$%%%%%%%%%%%55",d.getphoneNumber());
			Gson g=new Gson();
			String name = g.toJson(d);

			HttpClient httpClient=new DefaultHttpClient();
			HttpPost post=new HttpPost(url);
			StringEntity se=new StringEntity(name);
			se.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));
			post.setEntity(se);

			Log.d("hello","ready hello");
			httpResponse=httpClient.execute(post);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return httpResponse;
	}
	public ArrayList<Item> getItemDetails(String donaterPhoneNo,String ngoPhoneNo)
	{
		
		ArrayList<Item> al=new ArrayList<Item>();
		String url=myurl+"ItemDetailsServlet";
				
				try
				{
					HttpClient httpClient=new DefaultHttpClient();
					HttpPost post=new HttpPost(url);
					
					Gson g=new Gson();
					String sendData=donaterPhoneNo+" "+ngoPhoneNo;
					String name = g.toJson(sendData);
					StringEntity se=new StringEntity(name);
					se.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));
					post.setEntity(se);
					HttpResponse httpResponse = httpClient.execute(post);
								

					InputStream content = httpResponse.getEntity().getContent();
					StringBuilder sb=new StringBuilder();
					if(content!=null)
					{
						BufferedReader br=new BufferedReader(new InputStreamReader(content));
						String line="";
						while((line=br.readLine())!=null)
						{
							sb.append(line);
						}
					JSONArray jsonArray=new JSONArray(sb.toString());
				Log.d("$$$$$$$$$$$$AAAAAAAAAA",	g.fromJson(jsonArray.getString(0),Item.class)+"<<<");
			
					for(int i=0;i<jsonArray.length();i++)
					{
						
						al.add(g.fromJson(jsonArray.getString(i),Item.class));
						
					}
						 
						//Log.d("%%%%%%%%%%%%%%%%%%%%%",d.getAddress()+d.getDonaterName()+">>>");
					
					Log.d("hello","ready helloooooooooooooooo");

					}



				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				return al;
		
		
		
	}
	public Donater getDonaterProfile(String donater_id)
	{
Donater d=null;
		String url=myurl+"MyDonaterProfileServlet";
				
		try
		{
			HttpClient httpClient=new DefaultHttpClient();
			HttpPost post=new HttpPost(url);
			
			Gson g=new Gson();
			String name = g.toJson(donater_id);
			StringEntity se=new StringEntity(name);
			se.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));
			post.setEntity(se);
			HttpResponse httpResponse = httpClient.execute(post);
			InputStream content = httpResponse.getEntity().getContent();
			StringBuilder sb=new StringBuilder();
			if(content!=null)
			{
				BufferedReader br=new BufferedReader(new InputStreamReader(content));
				String line="";
				while((line=br.readLine())!=null)
				{
					sb.append(line);
				}
			//JSONArray jsonArray=new JSONArray(sb.toString());
			 d = g.fromJson(sb.toString(),Donater.class);
			Log.d("%%%%%%%%%%%%%%%%%%%%%%%%",d.getemailAccount()+">>>>>>>>>>>>>>>>>");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return d;
	}
	public void addNgo(String url,Ngo n)
	{
		try
		{
			Gson g=new Gson();
			String name = g.toJson(n);

			HttpClient httpClient=new DefaultHttpClient();
			HttpPost post=new HttpPost(url);
			StringEntity se=new StringEntity(name);
			se.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));
			post.setEntity(se);

			Log.d("hello","ready hello");
			HttpResponse httpResponse=httpClient.execute(post);
	
			InputStream content = httpResponse.getEntity().getContent();
			StringBuilder sb=new StringBuilder();
			if(content!=null)
			{
				BufferedReader br=new BufferedReader(new InputStreamReader(content));
				String line="";
				while((line=br.readLine())!=null)
				{
					sb.append(line);
				}
				Ngo ngo=g.fromJson(sb.toString(),Ngo.class);
				Log.d("%%%%%%%%%%%%%%%%%%%%%",ngo.getAddress()+ngo.getNgoName()+">>>");
			}
			Log.d("hello","ready helloooooooooooooooo");




		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void addDonater(String url,Donater d)
	{
		try
		{
			HttpResponse httpResponse = makeConnection(url, d);
			Gson g=new Gson();

			InputStream content = httpResponse.getEntity().getContent();
			StringBuilder sb=new StringBuilder();
			if(content!=null)
			{
				BufferedReader br=new BufferedReader(new InputStreamReader(content));
				String line="";
				while((line=br.readLine())!=null)
				{
					sb.append(line);
				}
				Donater d1=g.fromJson(sb.toString(),Donater.class);
				Log.d("%%%%%%%%%%%%%%%%%%%%%",d1.getAddress()+d1.getDonaterName()+">>>");
			}
			Log.d("hello","ready helloooooooooooooooo");




		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}