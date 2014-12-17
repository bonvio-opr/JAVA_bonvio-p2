package test;

/**
 * Created by Ivan on 12.12.2014.
 */
public class Test {

    public static void main (String [] args){

        String str1 = "aassddffgghhjjkk";
        String str2 = "qazwsxedcrfvtgby";

        String test1 = "nbc";
        String test2 = "111";


        byte[] array = encode(test1, test2);


        System.out.println("code"+new String(array) + "!"  + "hex (0)" + Integer.toHexString(array[0]));

       // System.out.println("char"+(char) array[0] + "!" );


        byte[] array2 = encode(new String(array), test2);


        System.out.println("decode " + new String(array2) + "!");


        System.out.println("hex = " + hexa(255) );


        System.out.println("testInt= " + Integer.toHexString(15));





    }
    public static int convert(int n) {
        return Integer.valueOf(String.valueOf(n), 16);
    }

    public static char hexa(int num) {
        int m = 0;
        if( (m = num >>> 4) != 0 ) {
            hexa( m );
        }
        //System.out.print((char)((m=num & 0x0F)+(m<10 ? 48 : 55)));
        return (char)((m=num & 0x0F)+(m<10 ? 48 : 55));
    }



    public static byte[] encode(String pText, String pKey) {
        byte[] txt = pText.getBytes();
        byte[] key = pKey.getBytes();
        byte[] res = new byte[pText.length()];

        for (int i = 0; i < txt.length; i++) {
            res[i] = (byte) (txt[i] ^ key[i % key.length]);
        }

        return res;
    }


}
