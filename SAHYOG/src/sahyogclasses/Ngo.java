package sahyogclasses;


public class Ngo {

	
	private String  ngoName;
	private String phoneNumber;
	private String emailAccount;
	private String password;
	private String Address;

	public void setNgoName(String name)
	{
		ngoName=name;
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
	public String getNgoName()
	{
return ngoName;		
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



