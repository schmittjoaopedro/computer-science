package leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.io.*;

public class XORDecode {

    @Test
    public void test() {
        int[] response1 = decode(readInput());
        int[] response2 = decode2(readInput());
        for (int i = 0; i < response1.length; i++) {
            Assert.assertEquals(response1[i], response2[i]);
        }
    }

    public int[] decode2(int[] encoded) {
        int len = encoded.length;
        int first = (len + 2 >> 1) % 2;
        for (int i = 1; i < len; i += 2)
            first ^= encoded[i];
        int[] perm = new int[len + 1];
        perm[0] = first;
        for (int i = 0; i < len; i++)
            perm[i+1] = perm[i] ^ encoded[i];
        return perm;
    }

    public int[] decode(int[] encoded) {
        int n = encoded.length + 1;
        int[] res = new int[n];
        outer : for (int a = 1; a <= n; a++) {
            res[0] = a;
            for (int i = 0; i < encoded.length; i++) {
                int n2 = decode(res[i], encoded[i]);
                if (n2 <= n && n2 > 0) {
                    res[i+1] = n2;
                } else {
                    continue outer;
                }
            }
            break;
        }
        return res;
    }

    private int decode(int c, int a) {
        int b = c ^ a;
        return b;
    }

    private int[] readInput() {
        try {
            InputStream ioStream = this.getClass().getClassLoader().getResourceAsStream("input.txt");
            String[] content = readInputStreamAsString(ioStream).split(",");
            int[] input = new int[content.length];
            for (int i = 0; i < content.length; i++) {
                input[i] = Integer.parseInt(content[i].trim());
            }
            return input;
        } catch (Exception e) {
            return null;
        }
    }

    public static String readInputStreamAsString(InputStream in) throws IOException {
        BufferedInputStream bis = new BufferedInputStream(in);
        ByteArrayOutputStream buf = new ByteArrayOutputStream();
        int result = bis.read();
        while(result != -1) {
            byte b = (byte)result;
            buf.write(b);
            result = bis.read();
        }
        return buf.toString();
    }

}
