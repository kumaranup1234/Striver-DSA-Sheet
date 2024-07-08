package Strings;

public class largestOddNumber {
    public static String oddNumber(String num) {
        for (int i = num.length() - 1; i >= 0; i--) {
            int ch = num.charAt(i) - '0';
            if (ch % 2 == 1){
                return num.substring(0 ,i+1);
            }
        }
        return "";
    }

    public static void main(String[] args) {
        String num1 = "35427";
        String num2 = "4206";
        String num3 = "3691669784801845146";
        System.out.println(oddNumber(num1));
        System.out.println(oddNumber(num2));
        // ans "36916697848018451"
        System.out.println(oddNumber(num3));

    }
}
