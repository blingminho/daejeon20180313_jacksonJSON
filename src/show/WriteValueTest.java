package show;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class WriteValueTest {
	public static void main(String[] args) {
		ObjectMapper mapper = new ObjectMapper();
		
		ShowVO1 vo1 = new ShowVO1();
		vo1.setId("id1");
		vo1.setPw("pw1");
		vo1.setAge(1);
		
		ShowVO2 vo2 = new ShowVO2();
		vo2.setId(null);
		vo2.setPw("");
		vo2.setAge(2);
		
		// 1) VO를 json 파일로 저장
		try {
			mapper.writeValue(new File("C:/Users/PC17/Desktop/jackson/data1.json"), vo1);
			mapper.writeValue(new File("C:/Users/PC17/Desktop/jackson/data2.json"), vo2);
		
		// 2) VO를 String으로 저장
		String jsonString1 = mapper.writeValueAsString(vo1);
		String jsonString2 = mapper.writeValueAsString(vo2);
		System.out.println("String으로 저장 및 읽기 1 ==> "+ jsonString1);
		System.out.println("String으로 저장 및 읽기 2 ==> "+ jsonString2);
		
		System.out.println("=================================================================");
		
		// 보기 좋게 출력하려면 ObjectMapper.writerWithDefaultPrettyPrinter()를 사용하면 된다.
		
		// 4-1) 포맷팅하여 스트링으로 변환
		String jsonStringPretty = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(vo2);
		System.out.println("포맷팅하여 스트링으로 변환 ==>");
		System.out.println(jsonStringPretty);
		
		// 4-2) 포맷팅하여 파일로 저장
		mapper.writerWithDefaultPrettyPrinter().writeValue(new File("C:/Users/PC17/Desktop/jackson/dataPretty.json"), vo2);
		
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
