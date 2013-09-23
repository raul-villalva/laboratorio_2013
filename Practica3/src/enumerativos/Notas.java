package enumerativos;

public enum Notas {
	
	Do("C"),
	Re("D"),
	Mi("E"),
	Fa("F"),
	Sol("G"),
	La("H"),
	Si("C");
	private String america;
	
	public String america(){
		return america;
	}
	
	Notas(String ame){
		america = ame;
	}
	


}
