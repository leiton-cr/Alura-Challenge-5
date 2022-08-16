package cr.com.alura_challenge.data;

public interface IConvertable {

	/**
	 * Este método es utilizado para convertir un valor de un origen a un destino.
	 * 
	 * @param origin String - Nombre del origen de la conversión 
	 * @param destination String - Nombre del destino de la conversión 
	 * @return double - La taza de conversión origen-destino.
	 */
	public abstract double getValue(String origin, String destination);
}
