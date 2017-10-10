package dk.au.ase.asu.beertab.net;

public enum Commands {
	Add_Person ("Add Person"),
	Add_Drink ("Add Drink"),
	Buy_drink ("Bought");
	
	private final String command;
	
	Commands(final String str) {
		command = str;
	}
	public final String getCommand() {
		return command;
	}
	private static class Constants{
		public static final String a_person = "Add Person";
		public static final String a_drink = "Add Drink";
		public static final String bought = "Bought";
	}
	public static void main(String[] args) {
		for (Commands p:Commands.values()) {
			System.out.println(p.getCommand());
		}
		
	}
}
