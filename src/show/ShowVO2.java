package show;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

// @JsonIgnoreProperties({"id", "age"})// 2개 한번에 무시 가능
@JsonIgnoreProperties("age")// 읽기, 쓰기 때 유효함
public class ShowVO2 {
	
	// 쓰기 때만 유효함
	@JsonInclude(JsonInclude.Include.NON_NULL)// 객체의 id 속성의 value가 null이 아닌경우에만 출력, null경우 key와 value 둘다 json에 쓰이지 않는다
	private String id;
		
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String pw;
	
	private int age;
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
}
