package dk.au.ase.elektronik;

public class MyFirstClass {
	private String var;// = "Hello World!";
	
	public String convert(String input){
		int i = 0;
		char[] cres = new char[input.length()];
		for (char c:input.toCharArray()){
			if (Character.isLowerCase(c)){
				c = Character.toUpperCase(c);
			}else{
				c = Character.toLowerCase(c);
			}
			cres[i]=c;
			i += 1;
		}
		return new String(cres);
	}

	public MyFirstClass(String var) {
		super();
		//this.setVar(var);
	}

	public String getVar() {
		if (var != null){
			return var;
		}else{
			return "";
		}
	}

	public void setVar(String var) {
		if (var!="sgu"){
			this.var = var;
		}else{
			System.out.print("Ikke bande!!!");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyFirstClass v = new MyFirstClass("sgu");
		String x = "!";//new String("!");
		System.out.println(x=="!");
		//System.out.println(v.convert("Hello World"));
	}

}
