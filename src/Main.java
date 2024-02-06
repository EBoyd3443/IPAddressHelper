
public class Main {

    public static void main(String[] args)
    {
        System.out.println(binaryStringToDottedDecimal("00000000000000000000000000000000"));
        System.out.println(binaryStringToDottedDecimal("11111111111111111111111111111111"));
        System.out.println(dottedDecimalToBinaryString("0.0.0.0"));
        System.out.println(dottedDecimalToBinaryString("255.255.255.255"));
        System.out.println(binaryStringToDottedDecimal("01010101010101010101010101010101"));
        System.out.println(binaryStringToDottedDecimal("10101010101010101010101010101010"));
        System.out.println(binaryStringToDottedDecimal("00001111000011110000111100001111"));
        System.out.println(binaryStringToDottedDecimal("11110000111100001111000011110000"));
        System.out.println(binaryStringToDottedDecimal("00000000111111110000000011111111"));
        System.out.println(binaryStringToDottedDecimal("11111111000000001111111100000000"));
        System.out.println(dottedDecimalToBinaryString("127.0.0.1"));
        System.out.println(dottedDecimalToBinaryString("192.168.0.0"));
        System.out.println(dottedDecimalToBinaryString("80.16.0.1"));

    }
    public static String binaryStringToDottedDecimal(String binaryIPAddress) throws IllegalArgumentException
    {
        if(!validateBinaryIPAddress(binaryIPAddress))
        {
            throw(new IllegalArgumentException(binaryIPAddress + " is an invalid binary IP address."));
        }
        final int BYTE_LENGTH = 8;
        StringBuilder returnLine = new StringBuilder("" + (Integer.parseInt(binaryIPAddress.substring(0, BYTE_LENGTH), 2)));
        for(int i = BYTE_LENGTH; i < 32; i+=BYTE_LENGTH)
        {
            returnLine.append(".").append(Integer.parseInt(binaryIPAddress.substring(i, i + BYTE_LENGTH), 2));
        }
        return returnLine.toString();
    }
    public static String dottedDecimalToBinaryString(String dottedIPAddress) throws IllegalArgumentException
    {
        String tempString = dottedIPAddress;
        if(!tempString.contains("."))
        {
            throw(new IllegalArgumentException(dottedIPAddress + " is an invalid binary IP address."));
        }
        String sub1 = tempString.substring(0, tempString.indexOf("."));
        tempString = tempString.substring(tempString.indexOf(".")+1);
        if(!tempString.contains("."))
        {
            throw(new IllegalArgumentException(dottedIPAddress + " is an invalid binary IP address."));
        }
        String sub2 = tempString.substring(0, tempString.indexOf("."));
        tempString = tempString.substring(tempString.indexOf(".")+1);
        if(!tempString.contains("."))
        {
            throw(new IllegalArgumentException(dottedIPAddress + " is an invalid binary IP address."));
        }
        String sub3 = tempString.substring(0, tempString.indexOf("."));
        String sub4 = tempString.substring(tempString.indexOf(".")+1);

        StringBuilder returnLine = new StringBuilder();

        try
        {
            returnLine.append(toBinary(Integer.parseInt(sub1)));
        }
        catch(NumberFormatException e)
        {
            throw (new IllegalArgumentException(sub1 + " is an invalid binary IP address."));
        }
        try
        {
            returnLine.append(toBinary(Integer.parseInt(sub2)));
        }
        catch(NumberFormatException e)
        {
            throw (new IllegalArgumentException(sub2 + " is an invalid binary IP address."));
        }
        try
        {
            returnLine.append(toBinary(Integer.parseInt(sub3)));
        }
        catch(NumberFormatException e)
        {
            throw (new IllegalArgumentException(sub3 + " is an invalid binary IP address."));
        }
        try
        {
            returnLine.append(toBinary(Integer.parseInt(sub4)));
        }
        catch(NumberFormatException e)
        {
            throw (new IllegalArgumentException(sub4 + " is an invalid binary IP address."));
        }

        return returnLine.toString();
    }
    public static boolean validateBinaryIPAddress(String binaryIPAddress)
    {
        boolean validBinary = binaryIPAddress.length() == 32;
        for(int i = 0; i < 32; i++)
        {
            if (!(binaryIPAddress.charAt(i) == '1' || binaryIPAddress.charAt(i) == '0'))
            {
                validBinary = false;
                break;
            }
        }
        return validBinary;
    }
    public static String toBinary(int inValue) throws NumberFormatException
    {
        final int BYTE_LENGTH = 8;
        if(inValue > 255 || inValue < 0)
        {
            throw new NumberFormatException("");
        }
        StringBuilder outValue = new StringBuilder();
        for(int i = 0; i < BYTE_LENGTH; i++)
        {
            outValue.append(inValue % 2);
            inValue = inValue/2;
        }
        return outValue.toString();
    }
}
