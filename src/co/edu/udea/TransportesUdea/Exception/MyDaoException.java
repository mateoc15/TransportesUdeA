package co.edu.udea.TransportesUdea.Exception;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class MyDaoException extends Exception {

	Logger  log = Logger.getLogger(this.getClass());

	public MyDaoException() {
		super();
		PropertyConfigurator.configure("log4j.properties");
		BasicConfigurator.configure();
	}

	private static final long serialVersionUID = 1L;

	public MyDaoException(String message, Throwable cause) {
		super(message, cause);
		PropertyConfigurator.configure("log4j.properties");
		BasicConfigurator.configure();
		log.error(message);
		// TODO Auto-generated constructor stub
	}

	public MyDaoException(Throwable cause) {
		super(cause);
		PropertyConfigurator.configure("log4j.properties");
		BasicConfigurator.configure();
		
		log.error(cause.getMessage());
		// TODO Auto-generated constructor stub
	}

	public MyDaoException(String message) {
		super(message);
		PropertyConfigurator.configure("log4j.properties");
		BasicConfigurator.configure();
		log.error(message);
		// TODO Auto-generated constructor stub
	}
	
	

	
	
	
	

}
