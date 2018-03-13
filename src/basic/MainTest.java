package basic;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import com.fasterxml.jackson.databind.ObjectMapper;

public class MainTest {
	public static void main(String[] args) {
		
		// 1. API의 클래스인 ObjectMapper의 인스턴스 생성
		// ObjectMapper의 메서드 : readValue(), writeValue()
		ObjectMapper mapper = new ObjectMapper();
		try {
			// json 파일로부터 읽어와 VO에 넣기
			MemberVO member = mapper.readValue(new File("C:/Users/PC17/Desktop/jackson/data.json"), MemberVO.class);
			
			// String으로부터 읽어와 VO에 넣기
			// \" == " (문자열 " 로 인식한다)
			MemberVO member2 = mapper.readValue("{\"name\":\"Bob\", \"age\":13}", MemberVO.class);
			
			System.out.println("member.name : " + member.name);
			System.out.println("member.age : " + member.age);
			System.out.println("------------------------------------------");
			System.out.println("member2.name : " + member2.name);
			System.out.println("member2.age : " + member2.age);
			
			
			System.out.println("===========================================");
			
			
			MemberVO member3 = new MemberVO();
			member3.name = "hello";
			member3.name = "";
			member3.age = 123;
			member3.age = 0;
			member3.id = "ID1";
			member3.id2 = "ID2";
			
			
			// 1) VO를 json 파일로 저장
			mapper.writeValue(new File("C:/Users/PC17/Desktop/jackson/data2.json"), member3);
			
			// 2) VO를 json형태의 byte[]로 저장
			byte[] jsonBytes = mapper.writeValueAsBytes(member3);
			
			// 2-1) 바이트를 읽기 위한 io 선언 및 초기화
			ByteArrayInputStream input = new ByteArrayInputStream(jsonBytes);
			ByteArrayOutputStream output = new ByteArrayOutputStream();
			
			int data;// 읽어온 자료를 저장할 변수
			
			// 2-2) 입력 스트림의 read()메서드는 더이상 읽어올 자료가 없으면 -1을 반환한다.
			while ((data = input.read()) != -1) {
				output.write(data);// 출력하기
			}
			
			// 2-3) 출력된 스트림들을 배열로 변환해서 반환 
			byte[] outSrc = output.toByteArray();
			
			System.out.print("byte[]를 문자로 바꾸어 읽기 ==> ");
			for (byte b : outSrc) {
				System.out.print((char)b);
			}
			input.close();
			output.close();
			System.out.println();

			
			// 3) VO를 String으로 저장
			String jsonString = mapper.writeValueAsString(member3);
			System.out.println("String으로 저장 및 읽기 ==> "+ jsonString);
			
			System.out.println("=================================================================");
			
			// 보기 좋게 출력하려면 ObjectMapper.writerWithDefaultPrettyPrinter()를 사용하면 된다.
			
			// 4-1) 포맷팅하여 스트링으로 변환
			String jsonString2 = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(member3);
			System.out.println("포맷팅하여 스트링으로 변환 ==>");
			System.out.println(jsonString2);
			
			// 4-2) 포맷팅하여 파일로 저장
			mapper.writerWithDefaultPrettyPrinter().writeValue(new File("C:/Users/PC17/Desktop/jackson/data3.json"), member3);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
