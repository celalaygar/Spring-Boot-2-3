package postgresql.last.control.demo;

import com.impossibl.postgres.api.jdbc.PGConnection;
import com.impossibl.postgres.api.jdbc.PGNotificationListener;
import com.impossibl.postgres.jdbc.PGDataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import javax.management.NotificationListener;
import java.lang.ref.WeakReference;
import java.sql.Statement;
import java.util.Map;
import java.util.regex.Pattern;

@SpringBootApplication
public class PostgreSQLListenerApplication {

	public static void main(String[] args) {
		SpringApplication.run(PostgreSQLListenerApplication.class, args);
	}



	@EventListener(ApplicationReadyEvent.class)
	public void init(){
		System.out.println("ListenToNotify start");
		PGDataSource dataSource = new PGDataSource();
		dataSource.setHost("localhost");
		dataSource.setPort(5432);
		dataSource.setDatabaseName("login");
		dataSource.setUser("login");
		dataSource.setPassword("login");

		PGNotificationListener insertListener = new PGNotificationListener() {
			@Override
			public void notification(int processId, String channelName, String payload) {
				System.out.println("notification = " + payload);
			}
		};
		PGNotificationListener updateListener = new PGNotificationListener() {
			@Override
			public void notification(int processId, String channelName, String payload) {
				System.out.println("notification = " + payload);
			}
		};

		PGNotificationListener deleteListener = new PGNotificationListener() {
			@Override
			public void notification(int processId, String channelName, String payload) {
				System.out.println("notification = " + payload);
			}
		};
		try{
			PGConnection connection1 = (PGConnection) dataSource.getConnection();
			Statement statement1 = connection1.createStatement();
			statement1.execute("LISTEN insert");
			statement1.close();
			connection1.addNotificationListener( insertListener);

			PGConnection connection2 = (PGConnection) dataSource.getConnection();
			Statement statement2 = connection2.createStatement();
			statement2.execute("LISTEN update");
			statement2.close();
			connection2.addNotificationListener( updateListener);

			PGConnection connection3 = (PGConnection) dataSource.getConnection();
			Statement statement3 = connection3.createStatement();
			statement3.execute("LISTEN delete");
			statement3.close();
			connection3.addNotificationListener( deleteListener);
			while (true){ }
		} catch (Exception e) {
			System.err.println(e);
		}
		System.out.println("ListenToNotify end 2");
	}

}
