package srsjava.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @name 数据库连接
 * @author ten
 * @description 连接jdbc
 */
public class DBUtil {
	/* 数据库登录信息 */
	static String ip = "111.230.244.153";
	static int port = 3306;
	static String database = "student";
	static String encoding = "UTF-8";
	static String loginName = "root";
	static String password = "wangshihao";
	
	/* 反射加载jdbc.Driver类 */
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("success to classify jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 获取数据库连接
	 * @return
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException {
		//字符格式:?useUnicode=true&&characterEncoding=%s  , encoding
		String url = String.format(
				"jdbc:mysql://%s:%d/%s",
				ip, port, database);
		System.out.println("try to connect database!");
		Connection c= DriverManager.getConnection(url, loginName, password);
		if(!c.isClosed()){
			System.out.println("Succeeded connecting to the Database!");
		}else{
			System.out.println("connecting error!");
		}
		return c;
	}

	public static void main(String[] args) throws SQLException {
		System.out.println(getConnection());

	}

}