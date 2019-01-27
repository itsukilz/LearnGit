public class ArgsSum {
		
	public static int argsSum(String[] args) {
		int sum = 0;
		for (String a : args) {
			sum += Integer.parseInt(a); 
		}
		return sum;
	}

	public static void main(String[] args) {
		System.out.println(argsSum(args));
	}
}