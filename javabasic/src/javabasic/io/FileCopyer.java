package javabasic.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/*
 * IO실습 1)
 * 
 * assets 폴더에 이미지파일 하나, 문자파일 하나를 준비
 * 
 * 1.사용자에게 1 또는 2를 입력받는다.
 * 2.사용자가 1을 입력하면 이미지 파일을 복사해서 assets에 저장
 * 3.사용자가 2를 입력하면 문자파일을 복사해서 assets에 저장
 *  파일명이 image.jpg > 복사한 파일명은 image_copy.jpg
 *  파일명이 txt.jpg > 복사한 파일명은 txt_copy.jpg
 * 
 */



public class FileCopyer {
	
	public static void main(String[] args) throws FileNotFoundException {
		
		FileInputStream fis = null;
		FileOutputStream fos = null;
		
		FileWriter fw = null;
		FileReader fr = null;
		
		Scanner sc = new Scanner(System.in);
		String inputValue = sc.next();
		if(inputValue.equals("1")) {
			//이미지 파일 복사
			try {	
				fis = new FileInputStream("C:/embeded/workspace/Embeded-KITA2024-Lecture/javabasic/src/assets/cat2.jpg");
				fos = new FileOutputStream("C:/embeded/workspace/Embeded-KITA2024-Lecture/javabasic/src/assets/cat2_copy.jpg");
				
				byte[] readBytes = new byte[1024];
				while(true) {
					int readCount = fis.read(readBytes);
					fos.write(readBytes);
					int readBytesLeng = readBytes.length;
					if(readCount < readBytesLeng) {
						break;
					}
				}
				}catch(FileNotFoundException fnfe) {
					fnfe.printStackTrace();
				}catch(IOException ioe) {
					ioe.printStackTrace();
				}finally{
					try {
						fis.close();
						fos.close();
					}catch(IOException ioe) {
						ioe.printStackTrace();
					}
				}	
		}else if(inputValue.equals("2")) {
			//텍스트 파일 복사
			try {
				fr = new FileReader("C:/embeded/workspace/Embeded-KITA2024-Lecture/javabasic/src/assets/today.txt");
				fw = new FileWriter("C:/embeded/workspace/Embeded-KITA2024-Lecture/javabasic/src/assets/today_copy.txt");
				char[] readChars = new char[8];
				int readCount = 0;
				while((readCount = fr.read(readChars)) > -1) {
					fw.write(readChars, 0, readCount);
					}
				fw.flush();
			}catch(FileNotFoundException fnfe) {
				fnfe.printStackTrace();
			}catch(IOException ioe) {
				ioe.printStackTrace();
			}finally {
				try {
					fw.close();
					fr.close();
				}catch(IOException ioe) {
					ioe.printStackTrace();
				}
				
			}	
			
		}
		
	}
	
}
