
public class Palindrome {
	public static void isPalindrome(String s)
	{
		int length=s.length();
		//System.out.println(((length-1)/2));
		if (((length-1)/2)==0){ 
			System.out.println("Odd");
			//else 
			System.out.println("Even");
		}
		System.out.println(s);
		System.out.println(length);
		for (int i=1;i<=((length-1)-2);i++) {
		//if(not(s.charAt(i).equals(s.charAt(length))) break;
		System.out.print(i);System.out.print(length);
		}}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		isPalindrome("SamaS");
		
	}
	
}//class completed
