public class Main {
	

public static void main(String[] args){
	
	if (args.length == 2) {
		MyStringCmp cmp = new MyStringCmp();
		
		int result = cmp.compare(args[0], args[1]);
		String resultAsString = cmp.resultAsString();

		System.out.println(String.format("result code: %s, output %s", result, resultAsString));
	} else {
		throw new RuntimeException("Error on providing parameters.\nUsage: java MyStringCmp string1 string2");
	} 


}


public static class MyStringCmp {

	public static final int LESS_THAN = -1, MORE_THAN = 1, EQUAL = 0;
	private String resultAsString ;

	public int compare(String arg1, String arg2) {
		if (arg1.length() < arg2.length()) {
			resultAsString = reverse(arg1) + " " + reverse(arg2);

			return LESS_THAN;
		} else if (arg1.length() > arg2.length()) {
			resultAsString = reverse(merge(arg1, arg2));
			return MORE_THAN;
		} else {
			//for equal
			resultAsString = merge(arg1, arg2);
			return EQUAL;
		}
	}

	private String reverse(String arg) {
		char[] characters = arg.toCharArray();
		char[] reverseCharacters = new char[characters.length];
		
		int j = 0;
		for (int i = characters.length-1 ; i >= 0 ; --i) {
			reverseCharacters[j++] = characters[i]; 
		}

		return new String(reverseCharacters);
	}

	public String merge(String arg1, String arg2) {
		if(arg1.length() < arg2.length())
			throw new RuntimeException("Merge cannot be apply. Second parameter should be lower or equal to first");

		char[] characters1 = arg1.toCharArray();
		char[] characters2 = arg2.toCharArray();

		char[] mergeCharacters = new char[characters1.length + characters2.length];
		
		int j = 0;
		for (int i = 0 ; i < characters1.length ; i++) {
			mergeCharacters[j++] = characters1[i]; 
			if(characters2.length > i)//safe to detect lenght of second parameter
				mergeCharacters[j++] = characters2[i]; 
		}

		return new String(mergeCharacters);

	}

	public String resultAsString() {
		return resultAsString;	
	}
}

}