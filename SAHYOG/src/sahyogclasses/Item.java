package sahyogclasses;


public class Item {

	private String category;
	private String i_d;
	private String itemName;
	private String donater_id;
	private String ngo_id;
	public void setCategory(String category)
	{
	this.category=category;	
	}
	public void  setI_d(String i_d) {
		this.i_d=i_d;
	}
	public void  setItemName(String item) {
		
	itemName=item;
	}
	public void  setDonater_id(String donater_id) {
		this.donater_id=donater_id;
	}
	public void  setngo_id(String ngo_id) {
		
		this.ngo_id=ngo_id;
	}
	
	public String getCaategory () {
	return category;	
	}
	public String get_i_d()
	{
		return i_d;
	}
	public String getItemName()
	{
		return itemName;
	}
	
	public String getdonater_id()
	{
		return donater_id;
	}
	public String getNgo_id()
	{
		return ngo_id;
	}
	
}
