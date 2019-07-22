package net.zdsoft.base64;

import org.junit.Test;

import java.util.Base64;

/**
 * @author shenke
 * @date 2019-07-10 09:52
 */
public class DecodeTest {


    @Test
    public void test() {
        String code = "BAh7C0kiD3Nlc3Npb25faWQGOgZFVEkiJTM1NTU3ZWUyYmY5ODQzMzI5NTc4NDQzMWFlZTNhOTYwBjsAVEkiGXdhcmRlbi51c2VyLnVzZXIua2V5BjsAVFsHWwZpA%2BuNHUkiIiQyYSQxMCQ0N2U4c0h6NXphNi5GOFpQZnd2MS9PBjsAVEkiHXdhcmRlbi51c2VyLnVzZXIuc2Vzc2lvbgY7AFR7BkkiFGxhc3RfcmVxdWVzdF9hdAY7AFRJdToJVGltZQ1B2R3AW3i8yAk6DW5hbm9fbnVtaQJ7AToNbmFub19kZW5pBjoNc3VibWljcm8iBzeQOgl6b25lSSIIVVRDBjsAVEkiFGFkZF9lbWFpbF9ndWlkZQY7AEZGSSIXYWN0aXZlX2VtYWlsX2d1aWRlBjsARkZJIhBfY3NyZl90b2tlbgY7AEZJIjFubFFqcVQreE51ZTJQRVFTRkxkWjJmRXBtb09KQ1NIWVIwWlkrSkp6YXFRPQY7AEY%3D--7d02e32ee20c708ca9454e2e21973fa1d0aef2e1";

        System.out.println(Base64.getDecoder().decode(code));
    }
}
