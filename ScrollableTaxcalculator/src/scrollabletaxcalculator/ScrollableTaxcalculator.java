/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scrollabletaxcalculator;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.text.DecimalFormat;
/**
 *
 * @author YannErv
 */
public class ScrollableTaxcalculator extends JFrame {

    /**
     * @param args the command line arguments
     */
    // imput the Jlabel button
    private JLabel label1, label2, label3;
    private JTextField priceAmount;
    private JTextField salesTax;
    private JTextField salesTotal;
    private JPanel pricepanel;
    private JPanel salespanel;
    private JPanel totalpanel;
    private JPanel sliderpanel;
    private JSlider slider;
    
    public ScrollableTaxcalculator() {
     //set the title
     setTitle("Scrollable Tax Calculator");
     //set the frame
     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     // create the textfield box
     label1 = new JLabel("Price Amount: ");
     label2 = new JLabel("Sales tax: ");
     label3 = new JLabel("Total Sales: ");
     
     // textfield box size character
     priceAmount = new JTextField("0.0", 10);
     priceAmount.setEditable(true);
     
     salesTax = new JTextField("0.0", 10);
     salesTax.setEditable(false);
     
     salesTotal = new JTextField("0.0", 10);
     salesTotal.setEditable(false);
     
     //create and set slider
     slider = new JSlider(JSlider.HORIZONTAL);
     slider.setMajorTickSpacing(1);
     slider.setMinorTickSpacing(1);
     slider.setPaintTicks(true);
     slider.setPaintLabels(true);
     slider.addChangeListener(new SliderListener());
     
     // add the price panel
     
     pricepanel = new JPanel();
     pricepanel.add(label1);
     pricepanel.add(priceAmount);
     
     salespanel = new JPanel();
     salespanel.add(label2);
     salespanel.add(salesTax);
     
     totalpanel = new JPanel();
     totalpanel.add(label3);
     totalpanel.add(salesTotal);
     
     sliderpanel = new JPanel();
     sliderpanel.add(slider);
     
     setLayout(new GridLayout(4, 1));
     add(pricepanel);
     add(salespanel);
     add(totalpanel);
     add(sliderpanel);
     
     pack();
     setVisible(true);
    }
    // implement the sliderlistener class
    
    private class SliderListener implements ChangeListener
    {
        public void stateChanged(ChangeEvent e) {
            double price, tax, total;
            DecimalFormat fmt = new DecimalFormat("0.0");
            price = Double.parseDouble(priceAmount.getText());
            tax = slider.getValue();
            total = price * (1 + (tax/100));
            
            priceAmount.setText(Double.toString(price));
            salesTax.setText(fmt.format(price));
            salesTotal.setText(fmt.format(price));
        }
    }
    public static void main(String[] args) {
        // TODO code application logic here
        new ScrollableTaxcalculator();
    }
    
}
