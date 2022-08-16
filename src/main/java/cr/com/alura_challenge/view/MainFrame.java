package cr.com.alura_challenge.view;

import java.awt.Container;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.UIManager;

/**
 * Clase encargada de la creación del frame principal.
 */
public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	private JLabel lblAmmount, lblResult, lblOriginCoin, lblDestinationCoin;
	private JTextField tfAmmount, tfResult;
	private JComboBox<String> cbType, cbOrigin, cbDestination;
	private JButton btnClear, btnCalculate;

	public MainFrame() {
		super("Conversor Alura");

		try {
			UIManager.setLookAndFeel("mdlaf.MaterialLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}

		setForm();
		setProps();

	}

	/**
	 * Este método asigna las propiedades relacionadas a la ventana.
	 */
	private void setProps() {
		setLayout(null);

		this.setVisible(true);
		this.setSize(590, 250);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	/**
	 * Este método crea y asigna cada uno de los elementos de la ventana.
	 */
	private void setForm() {
		Container container = getContentPane();

		JPanel paOne = new JPanel();
		paOne.setLayout(null);
		paOne.setBounds(0, 0, 590, 50);
		container.add(paOne);

		JPanel paTwo = new JPanel();
		paTwo.setLayout(null);
		paTwo.setBounds(0, 50, 590, 50);
		container.add(paTwo);

		JPanel paButtons = new JPanel();
		paButtons.setLayout(null);
		paButtons.setBounds(0, 100, 590, 100);
		container.add(paButtons);

		lblAmmount = new JLabel("Monto");
		lblAmmount.setBounds(10, 10, 240, 15);
		paTwo.add(lblAmmount);

		lblOriginCoin = new JLabel("Origen");
		lblOriginCoin.setBounds(10, 10, 240, 15);
		paOne.add(lblOriginCoin);

		lblDestinationCoin = new JLabel("Destino");
		lblDestinationCoin.setBounds(300, 10, 240, 15);
		paOne.add(lblDestinationCoin);

		lblResult = new JLabel("Resultado");
		lblResult.setBounds(300, 10, 240, 15);
		paTwo.add(lblResult);

		tfAmmount = new JTextField("0");
		tfAmmount.setBounds(10, 25, 265, 30);
		paTwo.add(tfAmmount);

		tfResult = new JTextField("0");
		tfResult.setBounds(300, 25, 265, 30);
		tfResult.setEditable(false);
		paTwo.add(tfResult);

		cbType = new JComboBox<String>();
		cbType.addItem("Conversión de moneda");
		cbType.addItem("Conversión de liquidos");
		cbType.setBounds(10, 10, 265, 30);
		paButtons.add(cbType);

		cbOrigin = new JComboBox<String>();
		cbOrigin.addItem("Colón");
		cbOrigin.addItem("Euro");
		cbOrigin.addItem("Dólar");
		cbOrigin.setBounds(10, 25, 265, 25);
		paOne.add(cbOrigin);

		cbDestination = new JComboBox<String>();
		cbDestination.addItem("Dólar");
		cbDestination.addItem("Euro");
		cbDestination.addItem("Colón");
		cbDestination.setBounds(300, 25, 265, 25);
		paOne.add(cbDestination);

		btnCalculate = new JButton("Calcular");
		btnCalculate.setBounds(10, 65, 90, 25);
		paButtons.add(btnCalculate);

		btnClear = new JButton("Limpiar");
		btnClear.setBounds(105, 65, 90, 25);
		paButtons.add(btnClear);
	}

	/**
	 * Este método asigna las opciones al combo box de origen.
	 * @param args String[] - Opciones a asignar.
	 */
	public void setComboAmmount(String[] args) {
		this.cbOrigin.removeAllItems();
		for (String arg : args) {
			cbOrigin.addItem(arg);
		}
	}

	/**
	 * Este método asigna las opciones al combo box de destino.
	 * @param args String[] - Opciones a asignar.
	 */
	public void setComboDestination(String[] args) {
		this.cbDestination.removeAllItems();
		for (String arg : args) {
			cbDestination.addItem(arg);
		}
	}

	/**
	 * Este metodo limia los resultados de los combo box.
	 */
	public void clearResults() {
		tfAmmount.setText("0");
		tfResult.setText("0");
	}

	/* ----------------------------
    		Getters y Setters  
	   ---------------------------- */

	/**
	 * Getter de Field de monto
	 * @return JTextField - Monto
	 */
	public JTextField getTfAmmount() {
		return tfAmmount;
	}

	/**
	 * Getter de Field de resultado
	 * @return JTextField - Resultado
	 */
	public JTextField getTfResult() {
		return tfResult;
	}

	/**
	 * Getter de Combobox de tipo de conversión.
	 * @return JComboBox<String> - Tipo de conversión.
	 */
	public JComboBox<String> getCbType() {
		return cbType;
	}

	/**
	 * Getter de Combobox de origen
	 * @return JComboBox<String> - Origen
	 */
	public JComboBox<String> getCbOrigin() {
		return cbOrigin;
	}

	/**
	 * Getter de Combobox de destino
	 * @return JComboBox<String> - Destino
	 */
	public JComboBox<String> getCbDestination() {
		return cbDestination;
	}

	/**
	 * Getter de Botón de limpiar
	 * @return JButton - Limpiar
	 */
	public JButton getBtnClear() {
		return btnClear;
	}

	/**
	 * Getter de Botón de calcular
	 * @return JButton - Calcular
	 */
	public JButton getBtnCalculate() {
		return btnCalculate;
	}

}