package srsjava.bean;
/**
 * usermsg 信息类
 * @author 59682
 *
 */
public class UserMsg {
	/**
	 * id:id号,int,唯一,外键约束于user类
	 * nickname:昵称
	 * sex:性别
	 * age:年龄
	 * birthday:生日
	 * email:邮箱
	 */
	
	private int id;
	private String nickname;
	private String sex;
	private String age;
	private String birthday;
	private String email;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
