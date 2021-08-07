
public class StringFunction {

	public static void main(String[] args) {
		String input = "Hello how are you";
		String[] inputTextarr = input.split(" ");
		for(String inTxt : inputTextarr) {
			char[] charArray = inTxt.toCharArray();
			for(int i = charArray.length-1;i>=0 ;i--) {
				System.out.print(charArray[i]);
			}
			System.out.print(" ");
		}
	}
}
