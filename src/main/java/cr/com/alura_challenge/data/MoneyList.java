package cr.com.alura_challenge.data;

/**
 * Esta clase contiene las tazas de conversión de moneda permitidas por la
 * aplicación.
 */
public class MoneyList extends ConvertableList {

	public MoneyList() {
		values.put("Colón->Colón", 1.0);
		values.put("Colón->Dólar", 0.0015);
		values.put("Colón->Euro", 0.0016);

		values.put("Dólar->Dólar", 1.0);
		values.put("Dólar->Colón", 670.27);
		values.put("Dólar->Euro", 0.98);

		values.put("Euro->Euro", 1.0);
		values.put("Euro->Dólar", 1.02);
		values.put("Euro->Colón", 681.22);
	}

}