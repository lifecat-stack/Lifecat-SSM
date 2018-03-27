package srsjava.bean;
/**
 * upimage 上传的图片类
 * @author ten
 */
public class UpImage {
	/**
	 * id:用户user的id号,外键约束于user-id
	 * imagename:图片名称
	 * imagedescription:图片描述
	 * imagedate:图片时间
	 * imagepath:图片存储路径
	 */

	private int id;
	private String imagename;
	private String imagedescription;
	private String imagedate;
	private String imagepath;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getImagename() {
		return imagename;
	}
	public void setImagename(String imagename) {
		this.imagename = imagename;
	}
	public String getImagedescription() {
		return imagedescription;
	}
	public void setImagedescription(String imagedescription) {
		this.imagedescription = imagedescription;
	}
	public String getImagedate() {
		return imagedate;
	}
	public void setImagedate(String imagedate) {
		this.imagedate = imagedate;
	}
	public String getImagepath() {
		return imagepath;
	}
	public void setImagepath(String imagepath) {
		this.imagepath = imagepath;
	}
}
