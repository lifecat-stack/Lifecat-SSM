package srsjava.bean;
 /**
  * user 数据类
  * @author ten
  *
  */
public class User {
	/**
	 * id:唯一id号,int
	 * name:用户名
	 * password:用户密码
	 * level:用户权限
	 */
  
    private int id;
    private String name; 
    private String password;
    private String level;
    
    public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
        return id;
    }
 
    public void setId(int id) {
        this.id = id;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }  
}