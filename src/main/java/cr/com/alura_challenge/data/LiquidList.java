package cr.com.alura_challenge.data;

/**
 * Esta clase contiene las tazas de conversión de liquidos permitidas por la
 * aplicación.
 */
public class LiquidList extends ConvertableList {

	public LiquidList() {
		values.put("Litro->Litro", 1.0);
		values.put("Litro->Taza", 4.22675);
		values.put("Litro->Galón", 0.264172);

		values.put("Taza->Taza", 1.0);
		values.put("Taza->Litro", 0.236588);
		values.put("Taza->Galón", 0.0625);

		values.put("Galón->Galón", 1.0);
		values.put("Galón->Taza", 16.0);
		values.put("Galón->Litro", 3.78541);
	}

}