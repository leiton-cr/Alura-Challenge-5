package cr.com.alura_challenge.data;

import java.util.HashMap;

public class ConvertableList implements IConvertable{
	
	/**
	 * Listado de valores de conversión.
	 */
	protected HashMap<String, Double> values = new HashMap<String, Double>();

	@Override
	public double getValue(String origin, String destination) {
		return values.get(String.format("%s->%s", origin, destination));
	}
	
}