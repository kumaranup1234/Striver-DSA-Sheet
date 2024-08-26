package Strings;

public class numberValidation {
    public static boolean validate(String number) {
        if (number == null || number.isEmpty()) {
            return false;
        }

        int countDigits = 0;
        boolean startsWithPlus = false;
        boolean startsWithZero = false;
        boolean startsWithSeven = false;
        boolean startsWithEight = false;
        boolean startsWithNine = false;


        if (number.charAt(0) == '+') {
            startsWithPlus = true;
        } else if (number.charAt(0) == '0') {
            startsWithZero = true;
        } else if (number.charAt(0) == '7') {
            startsWithSeven = true;
        } else if (number.charAt(0) == '8') {
            startsWithEight = true;
        } else if (number.charAt(0) == '9') {
            startsWithNine = true;
        } else{
            return false;
        }


        for (int i = 0; i < number.length(); i++) {
            char currentChar = number.charAt(i);

            if (currentChar == ' ') {
                if ((startsWithPlus && (i == 3 || i == 9)) ||
                        (startsWithZero && (i == 1 || i == 7))) {
                    continue;
                } else {
                    return false;
                }
            } else if (currentChar == '+' && i == 0) {
                continue;
            } else if (currentChar == '0' && i == 0) {
                continue;
            } else if (currentChar >= '0' && currentChar <= '9') {
                countDigits++;
            } else {
                return false;
            }
        }


        if (startsWithPlus) {
            return countDigits == 12;
        } else if (startsWithZero) {
            return countDigits == 10;
        } else if (startsWithSeven || startsWithEight || startsWithNine) {
            return countDigits == 10;
        }else{
            return false;
        }
    }

    public static void main(String[] args) {
        String number1 = "8147326014";        // true
        String number2 = "+918147326014";     // true
        String number3 = "08147326014";       // true
        String number4 = "+91 81473 26014";   // true
        String number5 = "0 81473 26014";     // true
        String number6 = "814 7326014";       // false
        String number7 = "81473 26014";       // false
        String number8 = "6147326014";        // false
        String number9 = "123";               // false
        String number10 = "8147abcd";         // false
        String number11 = "123-456-789-0";    // false
        System.out.println(validate(number1));
        System.out.println(validate(number2));
        System.out.println(validate(number3));
        System.out.println(validate(number4));
        System.out.println(validate(number5));
        System.out.println(validate(number6));
        System.out.println(validate(number7));
        System.out.println(validate(number8));
        System.out.println(validate(number9));
        System.out.println(validate(number10));
        System.out.println(validate(number11));
    }
}
