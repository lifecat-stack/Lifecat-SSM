/*package srsjava.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import srsjava.bean.Course;
import srsjava.bean.UpImage;
import srsjava.util.DBUtil;

*//**
 * image 数据库管理类
 * 
 * @author ten
 *//*
public class ImageDAO {
	*//**
	 * 获取 image 数据的个数
	 * 
	 * @return
	 *//*
	public int getTotal() {
		int total = 0;

		String sql = "select count(*) from image ";
		try (Connection c = DBUtil.getConnection();
				Statement s = c.createStatement();) {

			ResultSet rs = s.executeQuery(sql);

			while (rs.next()) {
				total = rs.getInt(1);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return total;
	}

	*//**
	 * 添加 image 到数据库
	 * 
	 * @param bean
	 *//*
	public void add(UpImage bean) {
		String sql = "insert into image values(?,?,?,?,?,?)";
		try (Connection c = DBUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql);) {

			ps.setString(1, bean.getUser_id());
			ps.setString(2, bean.getUser_name());
			ps.setString(3, bean.getImage_path());
			ps.setString(4, bean.getImage_description());
			ps.setString(5, bean.getImage_number());
			ps.setString(6, bean.getImage_date());

			ps.execute();

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	*//**
	 * 更新 image 信息
	 * 
	 * @param bean
	 *//*
	public void update(UpImage bean) {

		String sql = "update image set user_name=?,image_path= ?,image_description=?,image_date=? " +
				"where user_id = ? and image_number=?";
		try (Connection c = DBUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql);) {

			ps.setString(1, bean.getUser_name());
			ps.setString(2, bean.getImage_path());
			ps.setString(3, bean.getImage_description());
			ps.setString(4, bean.getImage_date());
			
			ps.setString(5, bean.getUser_id());
			ps.setString(6, bean.getImage_number());

			ps.execute();

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}
	*//**
	 * 更新 image 的 描述 description
	 * 
	 * @param description
	 * @param cno
	 *//*
	public void updateDescription(String description, String user_id,
			String image_number) {
		// TODO Auto-generated method stub
		String sql = "update image set image_description=? where user_id=? and image_number=?";
		try (Connection c = DBUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql);) {

			ps.setString(1, description);
			ps.setString(2, user_id);
			ps.setString(3, image_number);

			System.out.println("执行更新描述操作--updateDescription");
			ps.execute();

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	*//**
	 * 删除 image
	 * 
	 * @param id
	 *//*
	public void remove(String user_id, String image_number) {
		// TODO Auto-generated method stub
		String sql = "delete from image where user_id = ? and image_number = ? ";
		try (Connection c = DBUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql);) {

			ps.setString(1, user_id);
			ps.setString(2, image_number);

			System.out.println("执行Remove描述操作");

			ps.execute(sql);

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}
	*//**
	 * get 获取 image 信息
	 * @param
	 * @return
	 *//*
	public UpImage get(String user_id) {
		UpImage bean = null;

		try (Connection c = DBUtil.getConnection();
				Statement s = c.createStatement();) {

			String sql = "select * from image where user_id = " + user_id;

			ResultSet rs = s.executeQuery(sql);

			if (rs.next()) {
				bean = new UpImage();
				
				String id = rs.getString(1);
				
				String name = rs.getString(2);
				
				String path = rs.getString(3);
				
				String description = rs.getString(4);
				
				String number = rs.getString(5);
				
				String date = rs.getString(6);
				
				bean.setUser_id(id);
				bean.setUser_name(name);
				bean.setImage_path(path);
				bean.setImage_description(description);
				bean.setImage_number(number);
				bean.setImage_date(date);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return bean;
	}

	public List<UpImage> list() {
		return list(0, Short.MAX_VALUE);
	}

	public List<UpImage> list(int start, int count) {
		List<Course> beans = new ArrayList<Course>();

		String sql = "select * from image where user_id=? order by image_number asc limit ?,? ";

		try (Connection c = DBUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql);) {

			
			ps.setInt(2, start);
			ps.setInt(3, count);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Course bean = new Course();
				int cno = rs.getInt(1);
				String cname = rs.getString(2);
				String description = rs.getString(3);
				int credit = rs.getInt(4);
				int tno = rs.getInt(5);
				String tname = rs.getString(6);
				int number = rs.getInt(7);
				int choosen = new CourseDAO().getTotalClass(cno);

				// if(choosen == number)
				// continue;

				bean.setCno(cno);
				bean.setCname(cname);
				bean.setDescription(description);
				bean.setCredit(credit);
				bean.setTno(tno);
				bean.setTname(tname);
				bean.setNumber(number);
				bean.setChoosen(choosen);
				beans.add(bean);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return beans;
	}

	


	public List<Course> search(String keyword, int start, int count) {
		List<Course> beans = new ArrayList<Course>();

		if (null == keyword || 0 == keyword.trim().length())
			return new CourseDAO().list();
		String sql = "select * from course where cname like ? or credit = ? or description like ? or tname like ?";

		try (Connection c = DBUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql);) {
			ps.setString(1, "%" + keyword.trim() + "%");
			ps.setString(4, "%" + keyword.trim() + "%");

			int i = 0;
			for (i = 0; i < keyword.length(); i++) {
				if (!Character.isDigit(keyword.charAt(i))) {
					break;
				}
			}
			if (i == keyword.length())
				ps.setInt(2, Integer.parseInt(keyword.trim()));
			else
				ps.setInt(2, 0);

			ps.setString(3, "%" + keyword.trim() + "%");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Course bean = new Course();
				int cno = rs.getInt("cno");
				String cname = rs.getString("cname");
				String description = rs.getString("description");
				int credit = rs.getInt("credit");
				int tno = rs.getInt("tno");
				String tname = rs.getString("tname");
				int number = rs.getInt(7);
				int choosen = new CourseDAO().getTotalClass(cno);

				bean.setCname(cname);
				bean.setCno(cno);
				bean.setTno(tno);
				bean.setDescription(description);
				bean.setCredit(credit);
				bean.setTname(tname);
				bean.setNumber(number);
				bean.setChoosen(choosen);

				beans.add(bean);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return beans;
	}


	public List<Course> alist() {
		// TODO Auto-generated method stub
		List<Course> beans = new ArrayList<Course>();

		String sql = "select * from course order by cno asc ";

		try (Connection c = DBUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql);) {

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Course bean = new Course();
				int cno = rs.getInt(1);
				String cname = rs.getString(2);
				String description = rs.getString(3);
				int credit = rs.getInt(4);
				int tno = rs.getInt(5);
				String tname = rs.getString(6);
				int number = rs.getInt(7);
				int choosen = new CourseDAO().getTotalClass(cno);

				// if(choosen == number)
				// continue;

				bean.setCno(cno);
				bean.setCname(cname);
				bean.setDescription(description);
				bean.setCredit(credit);
				bean.setTno(tno);
				bean.setTname(tname);
				bean.setNumber(number);
				bean.setChoosen(choosen);
				beans.add(bean);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return beans;
	}

}
*/