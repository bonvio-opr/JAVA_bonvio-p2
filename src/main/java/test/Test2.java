package test;

import java.math.BigInteger;
import java.util.Arrays;

/**
 * Created by Ivan on 12.12.2014.
 */
public class Test2 {

    public static void main(String[] args) {

        String resv = encodeString("0011223344556677", "qazwsxedyqqazwsx");
        System.out.println("resv1=" + resv);


        //resv = decodeString("BEAEB4B9BEB5A9A8B2BABBABB3BEBBB0", "qazwsxedyqqazwsxed]");
        resv = decodeString(resv,"qazwsxedyqqazwsxed]" );
        System.out.println("resv2=" + resv);

        int x = 241;
        byte y = (byte) x;
        System.out.println("y ="+y);

    }

    public static String encodeString(String code, String key) {
        String result = new String();
        byte[] byteArrayCode = code.getBytes();
        byte[] byteArrayKey = key.getBytes();
        byte[] resultByte = new byte[byteArrayCode.length];

        for (int j = 0; j < byteArrayCode.length; j++) {
            resultByte[j] = (byte) (byteArrayCode[j] ^ byteArrayKey[j]);

            String print = Integer.toHexString(resultByte[j]);
            if (print.length() < 2) {
                print = "0" + print;
            }
            result += print;
        }
        result = result.toUpperCase();

        return result;
    }



    public static String decodeString(String encodeString, String key) {
        String result = new String();

        System.out.println("encodeString32=" + encodeString.length()+"!");

        int len = encodeString.length();
        byte[] byteArray = new byte[len / 2];
        int[] intArray = new int[len / 2];

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < len; i += 2) {
            String temp = encodeString.charAt(i) +"" + encodeString.charAt(i + 1);

            int test = Integer.parseInt(temp, 16);

            sb.append((char)test);

            intArray [i / 2] = new Integer (new Integer (Integer.parseInt(temp, 16)).toString());

            byteArray[i / 2] = new Integer (new Integer (Integer.parseInt(temp, 16)).toString()).byteValue();
        }
        System.out.println("sb.toString()= " + sb.toString() +  "  " + sb.length());

        byte[] byteArrayKey = key.getBytes();
        byte[] resultByte = new byte[byteArray.length];
        int[] resultInt = new int[byteArray.length];


        for (int j = 0; j < intArray.length; j++) {
            resultInt[j] = intArray[j] ^ byteArrayKey[j];
            resultByte[j]= (byte)resultInt[j];
            System.out.print(resultByte[j] + " ");
        }

        result = new String(resultByte);
        return result;

    }


}
