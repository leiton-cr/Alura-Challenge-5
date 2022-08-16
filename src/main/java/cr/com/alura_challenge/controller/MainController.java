package cr.com.alura_challenge.controller;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import cr.com.alura_challenge.data.ConvertableList;
import cr.com.alura_challenge.data.LiquidList;
import cr.com.alura_challenge.data.MoneyList;
import cr.com.alura_challenge.utils.Alerts;
import cr.com.alura_challenge.view.MainFrame;

/**
 * Clase encargada de controlar el frame principal.
 */
public class MainController {

	/**
	 * Constante para una entrada inválida.
	 */
	private static final double INVALID_INPUT = -1;

	/**
	 * Frame principal.
	 */
	private MainFrame frame;

	/**
	 * Monto ingresado a convertir.
	 */
	private double ammount;

	/**
	 * Taza de conversión actual
	 */
	private double conversionValue;

	/**
	 * Denominaciones de conversión segun combobox
	 */
	private ConvertableList denominations;

	public MainController() {

		denominations = new MoneyList();

		ammount = INVALID_INPUT;
		frame = new MainFrame();

		setListeners();
		setConversionValue();
	}

	/**
	 * Este metodo asigna los listener y eventos para los campos de la aplicación.
	 */
	private void setListeners() {
		frame.getBtnClear().addActionListener(e -> {
			frame.clearResults(); 
			ammount = 0;
		});

		frame.getBtnCalculate().addActionListener(e -> handleCalculate());

		frame.getTfAmmount().addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				frame.getTfResult().setText("0");

				ammount = handleAmmountChange();

				if (ammount == INVALID_INPUT) {
					frame.getTfAmmount().setText("0");
				}
			}
		});

		frame.getCbType().addActionListener(e -> handleConversionChange());

	}

	/**
	 * Este método maneja el proceso al presionar el boton de calcular
	 */
	private void handleCalculate() {
		setConversionValue();

		if (ammount == INVALID_INPUT) {
			Alerts.simpleAlert("El monto a convertir no es válido");
			return;
		}

		frame.getTfResult().setText(String.valueOf(ammount * conversionValue));
	}

	/**
	 * Este método maneja el tipo de conversión a realizar según el combobox
	 * seleccionado
	 */
	private void handleConversionChange() {
		frame.clearResults();
		ammount = 0;
		
		switch (frame.getCbType().getSelectedIndex()) {
			case 0:
				denominations = new MoneyList();

				String[] moneyTypes = { "Dólar", "Colón", "Euro" };

				frame.setComboAmmount(moneyTypes);
				frame.setComboDestination(moneyTypes);
				break;

			case 1:
				denominations = new LiquidList();

				String[] liquidTypes = { "Litro", "Taza", "Galón" };

				frame.setComboAmmount(liquidTypes);
				frame.setComboDestination(liquidTypes);
				break;
		}
	}

	/**
	 * Este método asigna una taza de conversión según los combobox de origen y
	 * destino.
	 */
	private void setConversionValue() {
		conversionValue = denominations.getValue(frame.getCbOrigin().getSelectedItem().toString(),
				frame.getCbDestination().getSelectedItem().toString());
	}

	/**
	 * Este metodo valida el cambio del combobox de monto a convertir.
	 * 
	 * @return double - El monto ingresado por el usuario.
	 */
	private double handleAmmountChange() {
		try {
			double data = Double.parseDouble(frame.getTfAmmount().getText());

			if (data < 0) {
				throw new IllegalArgumentException();
			}

			return data;

		} catch (NumberFormatException e) {
			Alerts.simpleAlert("El monto ingresado no es válido.");
		} catch (IllegalArgumentException e) {
			Alerts.simpleAlert("El monto ingresado menor a 0.");
		}

		return INVALID_INPUT;
	}

}