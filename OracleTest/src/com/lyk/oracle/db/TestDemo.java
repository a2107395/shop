package com.lyk.oracle.db;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import Decoder.BASE64Decoder;

public class TestDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			game1111_9();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void game1111_9() throws IOException {
        File file = new File("D:\\code.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        StringBuffer sb = new StringBuffer();
        String line = null;
        while ((line = br.readLine()) != null) {
            String[] codes=line.split(" ");
            for(String code:codes){
                char c=(char) Integer.parseInt(code, 2);
                sb.append(c);
            }
        }
        System.out.println(sb);
        BASE64Decoder decoder = new BASE64Decoder();
        byte[] decodeBuffer = decoder.decodeBuffer(sb.toString());
        File decodeFile = new File("D:\\decode.zip");
        FileOutputStream fileOutputStream = new FileOutputStream(decodeFile);
        fileOutputStream.write(decodeBuffer);
        fileOutputStream.close();
        br.close();
    }
}
