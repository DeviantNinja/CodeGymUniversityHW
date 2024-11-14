package Lesson10HW;

public class Binary {

    /*
        converts a binary value to a decimal value
     */
    public int toDecimal(String binaryValue){
        String aBinaryValue = binaryValue.replaceAll("\\s","");
        if(!isValidBinary(aBinaryValue)) throw new IllegalArgumentException("Invalid Binary Expression");

        int decimalValue = 0;
        for (int i = aBinaryValue.length() -1; i >= 0 ; i--) {
            decimalValue += aBinaryValue.charAt(i) == '1' ? (int) Math.pow(2, aBinaryValue.length() - 1 - i) : 0;
        }
        return decimalValue;
    }

    public String toHex(String binaryValue){
        StringBuilder aBinaryValue = new StringBuilder(binaryValue.replaceAll("\\s", ""));
        if(!isValidBinary(aBinaryValue.toString())) throw new IllegalArgumentException("Invalid Binary Expression");

        StringBuilder hexValue = new StringBuilder();
        int nibbleCount;
        String nibble;

        while(aBinaryValue.length() % 4 != 0) {
            aBinaryValue.insert(0,"0");
        }

        nibbleCount = aBinaryValue.length() / 4;
        for (int i = 0; i < nibbleCount; i++) {
            nibble = aBinaryValue.substring(0,4);
            aBinaryValue.delete(0,4);
            hexValue.append(Hexadecimal.findHexValue(toDecimal(nibble)));
        }
        return hexValue.toString();
    }

    /*
        Checks a String to ensure it is a valid Binary value
    */
    private boolean isValidBinary(String binaryValue){
        return binaryValue.matches("[0-1]+");
    }
}
