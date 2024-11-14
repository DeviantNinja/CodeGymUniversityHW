package Lesson10HW;

public class Decimal {

    /**
     * converts a decimal number to a hexadecimal string
     * Divide by 16, convert remainder to hex, repeat until
     * you can no longer divide by 16
     * order comes out least significant to most significant.
     */
    public String toHex(int decimalValue){
        if(decimalValue < 0) throw new IllegalArgumentException("Positive Integer values only");

        StringBuilder hexValue = new StringBuilder();

        while(decimalValue > 0){
            int remainder = decimalValue % 16;
            hexValue.append(Hexadecimal.findHexValue(remainder));
            decimalValue /= 16;
        }
        return !hexValue.isEmpty() ? hexValue.reverse().toString() : "0";
    }

    public String toBinary(int decimalValue){
        if(decimalValue < 0 ) throw new IndexOutOfBoundsException("Positive Integer values only");
        StringBuilder binaryValue = new StringBuilder();
        int remainder = decimalValue;

        for(int i = findHighestPower(decimalValue); i >= 0; i--){
            if(remainder - Math.pow(2,i) < 0){
                binaryValue.append("0");
            } else {
                binaryValue.append("1");
                remainder -= (int) Math.pow(2,i);
            }
        }
        return binaryValue.toString();
    }

    /*
        Finds the largest power of 2 that will go into decimalValue
     */
    public int findHighestPower(int decimalValue){
        if(decimalValue < 0 ) throw new IndexOutOfBoundsException("Positive Integer values only");
        for (int i = 0; i < 32; i++) { //31 highest power an int can have for integer.MAX_VALUE
            if(Math.pow(2,i) * 2 > decimalValue ) {
                return i;
            }
        }
        throw new IllegalArgumentException("Must be value between 0 and Integer.MAX_VALUE");
    }
}
