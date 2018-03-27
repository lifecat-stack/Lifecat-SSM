package srsjava.bean;
/**
 * 日记类
 * @author 59682
 *
 */
public class Diary {
	/**
	 * id:所属用户的id
	 * name:日记名称
	 * description:日记内容
	 * date:日记的时间
	 * path:日记存储路径
	 */
	
	private int id;
	private String name;
	private String description;
	private String date;
	private String path;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
}
