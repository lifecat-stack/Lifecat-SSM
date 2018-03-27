package srsjava.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sun.crypto.provider.RSACipher;

import srsjava.bean.User;
import srsjava.util.DBUtil;

/**
 * user 数据库管理
 * 
 * @author 59682
 * 
 *         登录--查询--是否已有用户名username的用户存在
 * 
 *         注册--添加--将username和password添加到数据库user 注册--获取Id--获取username的唯一Id号
 * 
 *         更新数据--更新用户username或password,id号唯一、不变
 * 
 *         删除--删除用户username
 */
public class UserDAO {

	/*******************************************************************
	 * 用户注册逻辑
	 * 
	 * @param bean
	 ***************************************************************** */

	/**
	 * 判断username用户名是否已经存在
	 * 
	 * @return 若存在，返回true
	 * 
	 * @return 若不存在，返回false
	 */
	public boolean isNameExisted(String username) throws SQLException {
		Connection connection = DBUtil.getConnection();
		System.out.println("hhhhhhhhhhhhhhhhhhhhhhhhhhhhhh");
		
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		User user = null;

		int count = -1;

		try {
			// 获取用户名username的count的值
			String sql = "select count(*) as count from user where name=? limit 1";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, username);
			resultSet = preparedStatement.executeQuery();

			resultSet.next();
			count = resultSet.getInt("count");

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			resultSet.close();
			connection.close();
		}

		// true存在 false不存在
		if (count == 0) {
			return false;
		} else if (count > 0) {
			return true;
		} else {
			System.out.println("判断username是否存在时出错");
			return true;
		}
	}

	/**
	 * 当username存在时--验证密码
	 * 
	 * 密码正确--登录--返回user对象 密码错误--返回错误
	 * 
	 * @param username
	 * @param password
	 * @throws SQLException
	 */
	public boolean login(String username, String password) throws SQLException {
		Connection connection = DBUtil.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		User user = null;
		String psw = null;

		try {
			String sql = "select password as psw from user where name=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, username);
			resultSet = preparedStatement.executeQuery();

			resultSet.next();
			psw = resultSet.getString("psw");

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			resultSet.close();
			connection.close();
		}

		// 判断密码是否匹配
		if (password == psw) {
			// 匹配
			System.out.println("密码正确");
			return true;
		} else {
			System.out.println("密码正错误");
			return false;
		}
	}

	/**
	 * 登录成功后--通过id获取user对象
	 * 
	 * @param id
	 * @return
	 */
	public User getByID(int id) {
		User bean = null;

		String sql = "select * from user where id = " + id;

		try (Connection c = DBUtil.getConnection();
				Statement s = c.createStatement();) {

			ResultSet rs = s.executeQuery(sql);

			if (rs.next()) {
				bean = new User();
				int oid = rs.getInt("id");
				String name = rs.getString("name");
				String password = rs.getString("password");
				String level = rs.getString("level");
				bean.setName(name);
				bean.setLevel(level);
				bean.setPassword(password);
				bean.setId(oid);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bean;
	}

	/**
	 * 登录成功后--通过username获取user对象
	 * 
	 * @param user
	 * @return
	 */
	public User getByName(String username) {
		User bean = null;

		try (Connection c = DBUtil.getConnection();
				Statement s = c.createStatement();) {

			String sql = "select * from user where name = " + username;

			ResultSet rs = s.executeQuery(sql);

			if (rs.next()) {
				bean = new User();
				int oid = rs.getInt("id");
				String name = rs.getString("name");
				String password = rs.getString("password");
				String level = rs.getString("level");
				bean.setId(oid);
				bean.setName(name);
				bean.setPassword(password);
				bean.setLevel(level);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bean;
	}

	/*******************************************************************
	 * 用户注册逻辑
	 * 
	 * @param bean
	 ***************************************************************** */

	/**
	 * 注册user到user数据表
	 * 
	 * @param bean
	 */
	public void add(User bean) {
		// values(id,name,password,level)

		String sql = "insert into user values(?,?,?,?)";

		try (Connection c = DBUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql);) {

			ps.setInt(1, bean.getId());// id
			ps.setString(3, bean.getName());// name
			ps.setString(2, bean.getPassword());// password
			ps.setString(4, bean.getLevel());// level
			ps.execute();

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	/**
	 * 获取新注册用户的id号 计算已有的id数,新id为总数+1
	 * 
	 * @param id
	 * @throws SQLException
	 */
	public int getIdCount() throws SQLException {
		Connection connection = DBUtil.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		int count = 0;

		try {
			String sql = "select count(id) as count from user";
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();

			resultSet.next();
			count = resultSet.getInt("count");

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			resultSet.close();
			connection.close();
		}
		return count;
	}

	/**
	 * 更新用户密码--通过“修改密码”触发
	 * 
	 * @param bean
	 */
	public void updatePassword(User bean) {

		String sql = "update user set password = ? where id = ? ";
		try (Connection c = DBUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql);) {

			ps.setString(1, bean.getPassword());
			ps.setInt(2, bean.getId());

			ps.execute();
			System.out.println("密码修改成功");

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	/*******************************************************************
	 * 管理员管理逻辑
	 * 
	 * @param bean
	 * @throws SQLException
	 ***************************************************************** */

	/**
	 * 获取所有的user对象--返回List列表
	 * 
	 * @return
	 * @throws SQLException
	 */
	public List<User> list() throws SQLException {
		return list(0, getIdCount());
	}

	// 获取User对象的列表
	public List<User> list(int start, int count) {
		List<User> beans = new ArrayList<User>();

		String sql = "select * from User order by id desc limit ?,? ";

		try (Connection c = DBUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql);) {

			ps.setInt(1, start);
			ps.setInt(2, count);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				User bean = new User();
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String password = rs.getString("password");
				String level = rs.getString("level");
				bean.setId(id);
				bean.setName(name);
				bean.setPassword(password);
				bean.setLevel(level);
				beans.add(bean);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return beans;
	}
}