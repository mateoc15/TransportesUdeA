package co.edu.udea.TransportesUdea.Exception;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 * Esta clase representa una excepcion lanzada desde la logica de negocio.
 * @author CristianCamilo
 *
 */
public class BLException extends Exception{
	
	private static final long serialVersionUID = 1L;
	private final Logger LOG = Logger.getLogger(this.getClass());

	/**
	 * Constructor vacio de la clase.
	 */
	public BLException() {
		super();
		PropertyConfigurator.configure("log4j.properties");
		BasicConfigurator.configure();
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public BLException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		PropertyConfigurator.configure("log4j.properties");
		BasicConfigurator.configure();
		LOG.error(message);
		
	}

	/**
	 * @param message
	 * @param cause
	 */
	public BLException(String message, Throwable cause) {
		super(message, cause);
		PropertyConfigurator.configure("log4j.properties");
		BasicConfigurator.configure();
		LOG.error(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public BLException(String message) {
		super(message);
		//BasicConfigurator.configure();
		LOG.error(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param cause
	 */
	public BLException(Throwable cause) {
		super(cause);
		PropertyConfigurator.configure("log4j.properties");
		BasicConfigurator.configure();
		// TODO Auto-generated constructor stub
	}

	
}
