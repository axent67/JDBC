import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Scanner;

public class JDBC {
 
	public static void main(String[] argv) throws ClassNotFoundException, SQLException {
		
		// Для ввода данных.
        Scanner in = new Scanner(System.in);
		
            // Загрузка драйвера, только после этого драйвер появится в списке зарег. драйверов в классе DriverManager.    
			Class.forName("org.postgresql.Driver");
        
		// Создание соединения.	
		Connection con = null;
		    // Метод устанавливающий соединение с БД.
			con = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/postgres", "postgres", "postgres");
		    // Проверка подключения.
			if (con != null) {
			System.out.println("Connected");
		}	
			else
				System.out.println("Connection Error.");
		
	    // Создаем объект Statement, чтобы можно было отсылать SQL-запросы к драйверу.	
		Statement stmt1 =  con.createStatement();
	     // Текст запроса.	
		 String query1 = "select * from users";
		// Отсылаем запрос, получаем объект.
		ResultSet rs1 = stmt1.executeQuery(query1);
		// Выводим результат.
		//dispResultSet(rs1);
		// Закрываем объект.
		rs1.close();
		// Закрываем оператор.
		stmt1.close();
		// Закрываем соединение.
		con.close();
		}	
}
