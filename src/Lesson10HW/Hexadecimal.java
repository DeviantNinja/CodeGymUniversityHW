package Lesson10HW;

public class Hexadecimal {
    //----- Static Methods -----//
    private static final String[] hexArray = {"0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F"};
    /*
        Converts decimal between 0-16 to its hexadecimal equivalent
     */
    public static String findHexValue(int decimalValue) {
        if(decimalValue < 0 || decimalValue > 15) throw new IllegalArgumentException("must be between 0 and 15 inclusive");
        return hexArray[decimalValue];
    }

    /*
        converts hex digit to decimal equivalent
     */
    public static int findDecimalValue(String hexValue){
        for (int i = 0; i < hexArray.length; i++) {
            if(hexValue.toUpperCase().equals(hexArray[i])) return i;
        }
        throw new IllegalArgumentException("invalid hex digit 0-9 A-F");
    }

    //----- Instance Methods -----//
    /*
        converts a Hexadecimal String to a decimal value
     */
    public int toDecimal(String hexValue){
        if(!isValidHex(hexValue)) throw new IllegalArgumentException("Not a valid hexadecimal string");

        int decimalValue = 0;
        for(int i = hexValue.length() -1; i >= 0; i--) {
            decimalValue += findDecimalValue(hexValue.substring(i,i+1)) * (int) Math.pow(16,hexValue.length() -1- i);
        }
        return decimalValue;
    }
    /*
        converts a Hexadecimal String to a Binary value
     */
    public String toBinary(String hexValue){
        if(!isValidHex(hexValue)) throw new IllegalArgumentException("Not a valid hexadecimal string");

        StringBuilder binaryValue = new StringBuilder();

        for(char digit : hexValue.toCharArray()){
            int decimalValue = findDecimalValue(Character.toString(digit));
            for (int i = 3; i >= 0; i--) {
                if(decimalValue - Math.pow(2,i) < 0) {
                    binaryValue.append("0");
                } else {
                    binaryValue.append("1");
                    decimalValue -= (int) Math.pow(2,i);
                }
            }
        }
        return binaryValue.toString();
    }

    /*
        Checks a String to ensure it is a valid hexadecimal value
     */
    private boolean isValidHex(String hexValue){
        return hexValue.matches("[a-fA-F0-9]+"); //Calls to boolean method 'isValidHex()' are always inverted
    }

}
