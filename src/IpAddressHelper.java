 /**************************************************\
 *    Eric Boyd, SDEV 301, Winter 2024 07Feb2024    *
 *     Individual Assignment: IPAddressHelper       *
 \**************************************************/
public class IpAddressHelper
{
    public static String binaryStringToDottedDecimal(String binaryIPAddress) throws IllegalArgumentException {
        if (!validateBinaryIPAddress(binaryIPAddress)) {
            throw (new IllegalArgumentException(binaryIPAddress + " is an invalid binary IP address."));
        }
        final int BYTE_LENGTH = 8;
        StringBuilder returnLine = new StringBuilder("" + (Integer.parseInt(binaryIPAddress.substring(0, BYTE_LENGTH), 2)));
        for (int i = BYTE_LENGTH; i < 32; i += BYTE_LENGTH) {
            returnLine.append(".").append(Integer.parseInt(binaryIPAddress.substring(i, i + BYTE_LENGTH), 2));
        }
        return returnLine.toString();
    }
    //I wanted to make dotted Decimal cleaner but couldn't figure out how to make it
    //as clean as binary String function.
    public static String dottedDecimalToBinaryString(String dottedIPAddress) throws IllegalArgumentException
    {
        //Big block to create substrings and check for errors.
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

        //Now that substrings are made we check for errors in each substring and
        //start building our binary string output.

        try
        {
            returnLine.append(toBinary(Integer.parseInt(sub1)));
        }
        catch(NumberFormatException e)
        {
            throw (new IllegalArgumentException(dottedIPAddress + " is an invalid binary IP address. " +
                    sub1 + " is the source of the problem."));
        }
        try
        {
            returnLine.append(toBinary(Integer.parseInt(sub2)));
        }
        catch(NumberFormatException e)
        {
            throw (new IllegalArgumentException(dottedIPAddress + " is an invalid binary IP address. " +
                    sub2 + " is the source of the problem."));
        }
        try
        {
            returnLine.append(toBinary(Integer.parseInt(sub3)));
        }
        catch(NumberFormatException e)
        {
            throw (new IllegalArgumentException(dottedIPAddress + " is an invalid binary IP address. " +
                    sub3 + " is the source of the problem."));
        }
        try
        {
            returnLine.append(toBinary(Integer.parseInt(sub4)));
        }
        catch(NumberFormatException e)
        {
            throw (new IllegalArgumentException(dottedIPAddress + " is an invalid binary IP address. " +
                    sub4 + " is the source of the problem."));
        }

        return returnLine.toString();
    }
    //validation checks the binary string is exactly 32 bit long
    //and consists of only 0s and 1s if not returns false and lets
    //parent function throw the error.
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
    //converts any number between 0&255 to string of 8bit binary (with all leading 0's)
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
            outValue.insert(0, (inValue % 2));
            inValue = inValue/2;
        }
        return outValue.toString();
    }
}
