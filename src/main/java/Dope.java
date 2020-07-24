/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package dope;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author prathitaswar
 */
public class Dope {
    
    private static final int WIDTH = 500;
    private static final int HEIGHT = 500;
    JFrame frame;
    JPanel panel;
    JButton begin;
    /**
     * @param args the command line arguments
     */
    
    Dope(){
        frame = new JFrame();
        frame.setTitle("QUIZ");
        frame.setSize(WIDTH,HEIGHT);
        
        panel = new JPanel();
        panel.setLayout(null);
        
        frame.add(panel);
        
        panel.setBackground(Color.LIGHT_GRAY);
        
        begin = new JButton();
        begin.setText("BEGIN");
        begin.setBackground(Color.white);
        
        panel.add(begin);
        begin.setBounds(200,200,100,100);
        
        begin.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent event){
                frame.setVisible(false);
                login page = new login(); 
            }
        });
        
        frame.add(panel);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
    }
    public static void main(String[] args) {
        // TODO code application logic here
        new Dope();
    }
    
}
