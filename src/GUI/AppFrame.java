/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

/**
 *
 * @author DELL
 */
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import Compressor_Decompressor.compressor;
import Compressor_Decompressor.decompressor;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.io.File;
/**
 *
 * @author DELL
 */
public class AppFrame extends JFrame implements ActionListener {
    JButton compressButton;
    JButton decompressButton;
    
    String ext="";
    
    public static String getFileExtension(String filePath) {
        File file = new File(filePath);
        String fileName = file.getName();
        int dotIndex = fileName.lastIndexOf(".");
        
        if (dotIndex == -1 || dotIndex == 0 || dotIndex == fileName.length() - 1) {
            return ""; // No file extension found
        }
        
        return fileName.substring(dotIndex + 1);
    }
    
    public AppFrame() {
        compressButton = new JButton("Chose File to Compress");
        compressButton.setBounds(50, 150, 200, 50);
        compressButton.addActionListener(this);
        compressButton.setBackground(Color.yellow);
        
        decompressButton = new JButton("Chose File to Decompress");
        decompressButton.setBounds(350, 150, 200, 50);
        decompressButton.addActionListener(this);
        decompressButton.setBackground(Color.yellow);
        
        this.add(compressButton);
        this.add(decompressButton);
        this.setTitle("Compressor & Decompressor");
        this.setLayout(new BorderLayout());
        this.setSize(600, 400);
        this.getContentPane().setBackground(Color.orange);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
      }

    @Override 
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == compressButton){
            JFileChooser fileChooser = new JFileChooser();
            int response = fileChooser.showSaveDialog(null);
            if(response == JFileChooser.APPROVE_OPTION) {
            	String filePath = fileChooser.getSelectedFile().getAbsolutePath();
                File file = new File(filePath);
                ext = "."+getFileExtension(filePath);
                try {
                    compressor.method(file);
                }
                catch(Exception ee) {
                	System.out.println(ee);
                    JOptionPane.showMessageDialog(null, ee.toString());
                }
            }
        }
        if(e.getSource() == decompressButton) {
            JFileChooser fileChooser = new JFileChooser();
            int response = fileChooser.showSaveDialog(null);
            if(response == JFileChooser.APPROVE_OPTION) {
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                System.out.print(file);
                try {
                    decompressor.method(file, ext);
                }
                catch(Exception ee) {
                    JOptionPane.showMessageDialog(null, ee.toString());
                }
            }
        }
    }
}
