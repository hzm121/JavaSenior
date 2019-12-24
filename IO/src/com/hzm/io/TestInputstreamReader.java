package com.hzm.io;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class TestInputstreamReader {
    public static void main(String[] args) {
        File srcFile = new File("/Users/huangzhenmin/Desktop/Test.txt");
        FileInputStream fis = null;
        FileOutputStream fos = null;
        InputStreamReader isr = null;
        OutputStreamWriter osw = null;
        Map<Character,Integer> map = new HashMap<>();
        try {
            File destFile = new File("IO/Test.txt");

            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(destFile,true);

            isr = new InputStreamReader(fis);
            osw = new OutputStreamWriter(fos);
            char[] buffer = new char[1024];
            int len;
            while ((len = isr.read(buffer, 0, buffer.length)) != -1) {
                for (char ch : buffer) {
                    if (!map.containsKey(ch)){
                        map.put(ch,1);
                    }else {
                        map.put(ch,map.get(ch)+1);
                        map.get(ch);
                    }
                }
                osw.write(buffer, 0, len);
            }
            for (Map.Entry<Character,Integer> m:map.entrySet()
                 ) {
                osw.write(m.getKey()+"----"+m.getValue()+"\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (isr != null) {
                try {
                    isr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (osw != null) {
                try {
                    osw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
