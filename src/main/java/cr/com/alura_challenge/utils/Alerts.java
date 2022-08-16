package cr.com.alura_challenge.utils;

import javax.swing.JOptionPane;

/**
 * Esta clase contiene el codigo necesario para lanzar las alertas de la
 * aplicación.
 */
public class Alerts {

	/**
	 * Este metodo muestra una alerta simple apartir de un mensaje recibido.
	 * 
	 * @param message String - Mensaje a mostrar en pantalla
	 */
	public static void simpleAlert(String message) {
		JOptionPane.showMessageDialog(null, message);
	}
}
