
/*  Develop By Bushra Aboubida Ahmed    */

package ip_finder;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.InetAddress;
import java.net.UnknownHostException;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class Main extends JFrame implements ActionListener {

    JPanel backgroundPanel;
    JLabel label, labelResult, backgroundImage;
    JTextField textField;
    JButton buttonFind;
    
    public Main() {
        createAndShowGUI();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Main();
            }
        });
    }
    
    private void createAndShowGUI() {
        
        backgroundPanel = new JPanel(null);
        backgroundImage = new JLabel(new ImageIcon(this.getClass().getResource("/images/world-map.png")));
        label = new JLabel("Enter URL", JLabel.CENTER);
        textField = new JTextField();
        buttonFind = new JButton("Get IP");
        labelResult = new JLabel("", JLabel.CENTER);
        
        backgroundPanel.setPreferredSize(new Dimension(600, 340));
        backgroundImage.setBounds(0, 0, 600, 340);
        label.setBounds(200, 75, 200, 30);
        textField.setBounds(200, 115, 200, 36);
        buttonFind.setBounds(200, 165, 200, 36);
        labelResult.setBounds(0, 225, 600, 30);
        
        label.setFont(new Font("Arial", Font.PLAIN, 20));
        label.setForeground(Color.WHITE);
        
        textField.setFont(new Font("Arial", Font.PLAIN, 18));
        textField.setForeground(Color.lightGray);
        textField.setBackground(new Color(10, 10, 10));
        textField.setCaretColor(Color.white);
        textField.setFocusable(true);
        textField.setBorder(BorderFactory.createCompoundBorder(
                            textField.getBorder(), 
                            BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        
        buttonFind.setFont(new Font("Arial", Font.BOLD, 16));
        buttonFind.setForeground(Color.lightGray);
        buttonFind.setBackground(Color.darkGray);
        buttonFind.setBorder(BorderFactory.createLineBorder(Color.gray, 2));
        buttonFind.setFocusable(false);
        
        labelResult.setFont(new Font("Arial", Font.PLAIN, 18));
                
        backgroundPanel.add(label);
        backgroundPanel.add(textField);
        backgroundPanel.add(buttonFind);
        backgroundPanel.add(labelResult);
        backgroundPanel.add(labelResult);
        backgroundPanel.add(backgroundImage);

        buttonFind.addActionListener(this);
        
        add(backgroundPanel);
        setTitle("IP Finder");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String url = textField.getText();  
        
        if(!url.isEmpty())
        {
            try {  
                InetAddress address = InetAddress.getByName(url);  
                String ip = address.getHostAddress();
                labelResult.setText(ip);
                labelResult.setForeground(Color.GREEN);
            } 
            catch (UnknownHostException ex) {  
                labelResult.setText("Invalid URL or Network is Down");
                labelResult.setForeground(Color.RED);
            } 
        }
        else {
            labelResult.setText("Please enter a valid URL in the above field");
            labelResult.setForeground(Color.RED);
        }
    }

}