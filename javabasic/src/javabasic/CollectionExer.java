//Collection 실습
//	3개의 반에 각각 3명의 국어,영어 수학 점수가 있다.
// 반별 각 학생의 국영수 총점을 산출해 반, 이름, 총점 을 출력하는 프로그램을 만들어 보자
//
//

package javabasic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class CollectionExer {
	
	public static void main(String[] args) {
		
	Report student11 = new Report(1, 1, "홍길동", 70, 80, 90, 0);
	Report student12 = new Report(1, 2, "홍감찬", 90, 70, 60, 0);
	Report student13 = new Report(1, 3, "홍순신", 50, 80, 70, 0);
	Report student21 = new Report(2, 1, "이길동", 50, 40, 30, 0);
	Report student22 = new Report(2, 2, "이감찬", 50, 50, 70, 0);
	Report student23 = new Report(2, 3, "이순신", 70, 80, 10, 0);
	Report student31 = new Report(3, 1, "강길동", 10, 70, 70, 0);
	Report student32 = new Report(3, 2, "강감찬", 20, 90, 100, 0);
	Report student33 = new Report(3, 3, "강순신", 100, 100, 100, 0);
	
//	Map<String, Report> map = new LinkedHashMap<String, Report>();
	Map<String, Report> map = new HashMap<String, Report>();
	
	map.put("s11", student11);
	map.put("s12", student12);
	map.put("s13", student13);
	map.put("s21", student21);
	map.put("s22", student22);
	map.put("s23", student23);
	map.put("s31", student31);
	map.put("s32", student32);
	map.put("s33", student33);
	
	List<String> keyList = new ArrayList<>(map.keySet());
	keyList.sort((classNum, studantNum) -> classNum.compareTo(studantNum));
	for (String key : keyList) {
        System.out.println(map.get(key));
    }
	
//	map.values().forEach(studentScore -> System.out.println(studentScore));

	
	}
}
