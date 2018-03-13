package show;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ReadValueTest {
	/*
	 * readValue의 기능 : 읽어와서 객체로 만들어줌
	 */
	public static void main(String[] args) {
		
		// ObjectMapper의 인스턴스 메서드를 위해 인스턴스 생성
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			
			// json 파일로부터 읽어와 VO에 넣기
			ShowVO1 vo1 = mapper.readValue(new File("C:/Users/PC17/Desktop/jackson/dataVO.json"), ShowVO1.class);
			ShowVO2 vo2 = mapper.readValue(new File("C:/Users/PC17/Desktop/jackson/dataVO.json"), ShowVO2.class);
			
			// String으로부터 읽어와 VO에 넣기
			// \" == " (문자열 " 로 인식한다)
			ShowVO2 vo3 = mapper.readValue("{\"id\":\"Bob\",\"pw\":\"123\", \"age\":26}", ShowVO2.class);

			
			System.out.println("vo1의 id : " + vo1.getId());
			System.out.println("vo1의 pw : " + vo1.getPw());
			System.out.println("vo1의 age : " + vo1.getAge());
			System.out.println("------------------------------------------");
			System.out.println("vo2의 id : " + vo2.getId());
			System.out.println("vo2의 pw : " + vo2.getPw());
			System.out.println("vo2의 age : " + vo2.getAge());
			System.out.println("------------------------------------------");
			System.out.println("vo3의 id : " + vo3.getId());
			System.out.println("vo3의 pw : " + vo3.getPw());
			System.out.println("vo3의 age : " + vo3.getAge());
			System.out.println("==========================================");
			
			
			System.out.println("========= DbVO 읽어오기 =========");
			DbVO db = mapper.readValue(new File("C:/Users/PC17/Desktop/jackson/dataDB.json"), DbVO.class);
			List<ShowVO1> list1 = db.getList1();
			List<ShowVO2> list2 = db.getList2();
			
			for (ShowVO1 showVO1 : list1) {
				System.out.println("vo1의 id : " + showVO1.getId());
				System.out.println("vo1의 pw : " + showVO1.getPw());
				System.out.println("vo1의 age : " + showVO1.getAge());
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			}
			System.out.println("################################");
			
			for (ShowVO2 showVO2 : list2) {
				System.out.println("vo2의 id : " + showVO2.getId());
				System.out.println("vo2의 pw : " + showVO2.getPw());
				System.out.println("vo2의 age : " + showVO2.getAge());
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
