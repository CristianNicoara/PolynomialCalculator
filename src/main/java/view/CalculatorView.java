package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class CalculatorView extends JFrame{
    private JTextField pol1Field;
    private JTextField pol2Field;
    private JTextField rezField;

    private JButton btnAdunare;
    private JButton btnScadere;
    private JButton btnInmultire;
    private JButton btnImpartire;
    private JButton btnDerivare;
    private JButton btnIntegrare;

    private JComboBox polDropDown;

    public CalculatorView(){
        this.getContentPane().setBackground(new Color(176, 224, 230));
        this.setBounds(100, 100, 481, 519);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("CALCULATOR DE POLINOAME");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 19));
        lblNewLabel.setBounds(0, 11, 465, 36);
        this.getContentPane().add(lblNewLabel);

        pol1Field = new JTextField();
        pol1Field.setHorizontalAlignment(SwingConstants.CENTER);
        pol1Field.setBounds(150, 77, 283, 20);
        this.getContentPane().add(pol1Field);
        pol1Field.setColumns(10);

        JLabel lblPolinom1 = new JLabel("Polinom 1");
        lblPolinom1.setHorizontalAlignment(SwingConstants.CENTER);
        lblPolinom1.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblPolinom1.setBounds(36, 77, 104, 20);
        this.getContentPane().add(lblPolinom1);

        JLabel lblPolinom2 = new JLabel("Polinom 2");
        lblPolinom2.setHorizontalAlignment(SwingConstants.CENTER);
        lblPolinom2.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblPolinom2.setBounds(36, 121, 104, 20);
        this.getContentPane().add(lblPolinom2);

        pol2Field = new JTextField();
        pol2Field.setHorizontalAlignment(SwingConstants.CENTER);
        pol2Field.setColumns(10);
        pol2Field.setBounds(150, 123, 283, 20);
        this.getContentPane().add(pol2Field);

        btnAdunare = new JButton("ADUNARE");
        btnAdunare.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnAdunare.setBounds(36, 196, 104, 30);
        this.getContentPane().add(btnAdunare);

        btnScadere = new JButton("SCADERE");
        btnScadere.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnScadere.setBounds(180, 196, 104, 30);
        this.getContentPane().add(btnScadere);

        btnInmultire = new JButton("INMULTIRE");
        btnInmultire.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnInmultire.setBounds(318, 196, 115, 30);
        this.getContentPane().add(btnInmultire);

        btnImpartire = new JButton("IMPARTIRE");
        btnImpartire.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnImpartire.setBounds(36, 261, 104, 30);
        this.getContentPane().add(btnImpartire);

        btnDerivare = new JButton("DERIVARE");
        btnDerivare.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnDerivare.setBounds(180, 261, 104, 30);
        this.getContentPane().add(btnDerivare);

        btnIntegrare = new JButton("INTEGRARE");
        btnIntegrare.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnIntegrare.setBounds(318, 261, 115, 30);
        this.getContentPane().add(btnIntegrare);

        polDropDown = new JComboBox();
        polDropDown.setFont(new Font("Tahoma", Font.PLAIN, 16));
        polDropDown.setMaximumRowCount(2);
        polDropDown.setModel(new DefaultComboBoxModel(new String[] {"Polinom 1", "Polinom 2"}));
        polDropDown.setSelectedIndex(0);
        polDropDown.setBounds(303, 319, 130, 30);
        this.getContentPane().add(polDropDown);

        JLabel lblAlegere = new JLabel("Pentru derivare sau integrare: ");
        lblAlegere.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblAlegere.setHorizontalAlignment(SwingConstants.CENTER);
        lblAlegere.setBounds(36, 319, 248, 30);
        this.getContentPane().add(lblAlegere);

        JLabel lblRezultat = new JLabel("Rezultat");
        lblRezultat.setHorizontalAlignment(SwingConstants.CENTER);
        lblRezultat.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblRezultat.setBounds(36, 381, 104, 20);
        this.getContentPane().add(lblRezultat);

        rezField = new JTextField();
        rezField.setHorizontalAlignment(SwingConstants.CENTER);
        rezField.setEditable(false);
        rezField.setColumns(10);
        rezField.setBounds(150, 383, 283, 20);
        this.getContentPane().add(rezField);

        this.setVisible(true);
    }

    public String getPol1Field(){
        return pol1Field.getText();
    }

    public String getPol2Field(){
        return pol2Field.getText();
    }

    public String getPolinomDropDown(){
        return (String) polDropDown.getSelectedItem();
    }

    public void setRezField(String rezField){
        this.rezField.setText(rezField);
    }

    public void addAdunareListener(ActionListener action){
        btnAdunare.addActionListener(action);
    }

    public void addScadereListener(ActionListener action){
        btnScadere.addActionListener(action);
    }

    public void addInmultireListener(ActionListener action){
        btnInmultire.addActionListener(action);
    }

    public void addImpartireListener(ActionListener action){
        btnImpartire.addActionListener(action);
    }

    public void addDerivareListener(ActionListener action){
        btnDerivare.addActionListener(action);
    }

    public void addIntegrareListener(ActionListener action){
        btnIntegrare.addActionListener(action);
    }

    public void showMessage(String message){
        JOptionPane.showMessageDialog(this, message);
    }

    public void refresh(){
        rezField.setText(null);
    }
}
