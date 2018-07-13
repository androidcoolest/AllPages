package isInt;

public class aa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "9";
		String str1 = "9a";

		int i = Integer.parseInt(str);
		System.out.println(i);
		try {
			int j = Integer.parseInt(str1);
			System.out.println(j);
		} catch (NumberFormatException e) {
			System.out.println("Not a number");
		}
	}
}
