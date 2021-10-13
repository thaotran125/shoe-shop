package BUSlogic;

	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.SQLException;

	public class SQLConncect {
		private static Connection conn;
		public static Connection getConn() throws SQLException {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				String url="jdbc:mysql://localhost:3306/ban_hang?useUnicode=true&characterEndcoding=UTF-8";
				conn=DriverManager.getConnection(url, "root", "");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return conn;
		}
		
		public static void main(String[] args) {
			try {
				Connection cnn=getConn();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
}
