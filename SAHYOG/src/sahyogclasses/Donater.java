package sahyogclasses;


public class Donater {
	private String donaterName;
	private String phoneNumber;
	private String emailAccount;
	private String password;
	private String Address;
	public void setDonaterName(String name)
	{
		donaterName=name;
	}
	public void setPhoneNumber(String phoneno)
	{
		phoneNumber=phoneno;
	}
	public void setEmailAccount(String email)
	{
		emailAccount=email;
	}
	public void setpassword(String pw)
	{
		password=pw;
	}
	public void setAddress(String Address)
	{
		this.Address=Address;
	}
	public String getDonaterName()
	{
return donaterName;		
	}
	public String getphoneNumber()
	{
		return phoneNumber; 
	}
	public String getemailAccount()
	{
		return emailAccount;
	}

	public String getpassword()
	{
		return password;
	}
	public String getAddress()
	{
		return Address;
	}
}
