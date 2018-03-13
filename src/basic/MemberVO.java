package basic;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties({"id", "id2"})
public class MemberVO {
//	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	public String name;
	
	public int age;
	
	public String id;
	public String id2;
}
