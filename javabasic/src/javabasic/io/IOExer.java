package javabasic.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class IOExer {
/*
 * IO실습 2)
 * 
 * 1.StudentScore 데이터클래스 생성(int sno,String name, int kor, int eng int math, int total)
 * 2.IOEser에서 5개의 StudentScore객체 생성 후  assets/studentscore.dat에 직렬화
 * 3,직렬화된 객체를 역직렬화 하여 학생 성적 데이터 출력'
 * 4.출력시 과목별 총점도 출력
 * 
 */
	
	public static void main(String[] args) {
		
		List<StudentScore> ssList = new ArrayList<StudentScore>();
		ssList.add(new StudentScore(1, "홍길동", 90, 70, 60, 0));
		ssList.add(new StudentScore(2, "강감찬", 100, 60, 30, 0));
		ssList.add(new StudentScore(3, "홍길동", 60, 40, 100, 0));
		ssList.add(new StudentScore(4, "영의정", 80, 100, 100, 0));
		ssList.add(new StudentScore(5, "방정환", 30, 10, 80, 0));
	
		
		File file = null;
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		
		try {
			file = new File("C:\\embeded\\workspace\\Embeded-KITA2024-Lecture\\javabasic\\src\\assets\\studentscore.dat");
			fos =  new FileOutputStream(file);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(ssList);
			
			fis = new FileInputStream(file);
			ois = new ObjectInputStream(fis);
			List<StudentScore> readList = (ArrayList<StudentScore>)ois.readObject();
			int korTotal = 0;
			int engTotal = 0;
			int mathTotal = 0;
			for (StudentScore ss : readList) {
				ss.setTotal(0);
				korTotal += ss.getKor();
				engTotal += ss.getEng();
				mathTotal += ss.getMath();
				System.out.println(ss);
			}
			System.out.println("국어총점 : " + korTotal + " 영어총점 : " + engTotal + " 수학총점 : " + mathTotal);
		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		}catch (IOException ioe) {
			ioe.printStackTrace();
		}catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}catch (ClassCastException cce) {
			cce.printStackTrace();
		}finally {
			try {
				ois.close();
				oos.close();
			}catch(IOException ioe){
				ioe.printStackTrace();
			}
		}
		
		
	}
}
