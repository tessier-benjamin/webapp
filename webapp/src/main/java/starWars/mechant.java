package starWars;

public class mechant {
	boolean coteObscur;
	public mechant(boolean coteObscur)
	{
		this.coteObscur = coteObscur;
	}
	
	public boolean getCoteObscur()
	{
		return this.coteObscur;
	}
	
	void setCoteObscur(boolean coteObscur)
	{
		this.coteObscur=coteObscur;
	}
	
	public String toString() 
	{
		if(this.coteObscur == true){
			return "il est du cot� obscur";
		}
		return "il n'est pas du cot� obscur";
	}
	

}
