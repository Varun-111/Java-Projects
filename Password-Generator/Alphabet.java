public class Alphabet {
	public static final String Uppercase_letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	public static final String Lowercase_Letters = "abcdefghijklmnopqrstuvwxyz";
	public static final String Numbers = "1234567890";
	public static final String Symbols = "!@#$%^&*()-=_+\\/~?";
	
	private final StringBuilder pool;
	
	public Alphabet(boolean uppercaseIncluded, boolean lowercaseIncluded, boolean numbersIncluded, boolean specialCharactersIncluded) {
		pool = new StringBuilder();
		if(uppercaseIncluded) pool.append(Uppercase_letters);
		
		if(lowercaseIncluded) pool.append(Lowercase_Letters);
		
		if(numbersIncluded) pool.append(Numbers);
		
		if(specialCharactersIncluded) pool.append(Symbols);
		
	}
	
	
	public String getAlphabet() {
		return pool.toString();
	}
}
