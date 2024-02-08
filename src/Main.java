public class Main {

    public static void main(String[] args)
    {
        System.out.println(IpAddressHelper.binaryStringToDottedDecimal("00000000000000000000000000000000"));
        System.out.println(IpAddressHelper.binaryStringToDottedDecimal("11111111111111111111111111111111"));
        System.out.println(IpAddressHelper.dottedDecimalToBinaryString("0.0.0.0"));
        System.out.println(IpAddressHelper.dottedDecimalToBinaryString("255.255.255.255"));
        System.out.println(IpAddressHelper.binaryStringToDottedDecimal("01010101010101010101010101010101"));
        System.out.println(IpAddressHelper.binaryStringToDottedDecimal("10101010101010101010101010101010"));
        System.out.println(IpAddressHelper.binaryStringToDottedDecimal("00001111000011110000111100001111"));
        System.out.println(IpAddressHelper.binaryStringToDottedDecimal("11110000111100001111000011110000"));
        System.out.println(IpAddressHelper.binaryStringToDottedDecimal("00000000111111110000000011111111"));
        System.out.println(IpAddressHelper.binaryStringToDottedDecimal("11111111000000001111111100000000"));
        System.out.println(IpAddressHelper.dottedDecimalToBinaryString("127.0.0.1"));
        System.out.println(IpAddressHelper.dottedDecimalToBinaryString("192.168.0.0"));
        System.out.println(IpAddressHelper.dottedDecimalToBinaryString("80.16.0.1"));
        System.out.println(IpAddressHelper.binaryStringToDottedDecimal("01010000000100000000000000000001"));
    }
}
