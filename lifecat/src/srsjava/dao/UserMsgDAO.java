package srsjava.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import srsjava.bean.User;
import srsjava.bean.UserMsg;
import srsjava.util.DBUtil;

public class UserMsgDAO {
	/**
	 * 更新用户MSG信息
	 * 
	 * @param bean
	 */
	public void update(UserMsg bean) {
		// values(id,name,password,level)

		String sql = "insert into usermsg values(?,?,?,?,?,?)";

		try (Connection c = DBUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql);) {

			ps.setInt(1, bean.getId());// id
			ps.setString(2, bean.getNickname());// nickname
			ps.setString(3, bean.getSex());// sex
			ps.setString(4, bean.getAge());// age
			ps.setString(5, bean.getBirthday()); //birthday
			ps.setString(6, bean.getEmail()); //email
			ps.execute();

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
	
	/**
	 * 获取用户MSG信息
	 * 
	 */
	public UserMsg getMsg(int id){
		UserMsg bean=new UserMsg();
		
		String sql = "select * from usermsg where id = "+id;

		try (Connection c = DBUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql);) {
			
			ResultSet resultSet = ps.executeQuery();

			ps.setInt(1, bean.getId());// id
			ps.setString(2, bean.getNickname());// nickname
			ps.setString(3, bean.getSex());// sex
			ps.setString(4, bean.getAge());// age
			ps.setString(5, bean.getBirthday()); //birthday
			ps.setString(6, bean.getEmail()); //email
			ps.execute();

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return bean;
	}
}
