package org.project.templates;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ComponentCreator {

    String[] fieldName = {"marka","model", "Kolor", "rok produkcji","Pojemość silnika","Rodzaj nadwozia","Numer rejestracyjny","Numer VIN"
    ,"Cena zakupu","Data ważności polisy OC","Data ważności przeglądu"};

    public static void JTextFieldCreator (String[] fieldName, JDialog dialog){

        for (int i=0; i<= fieldName.length; i++) {
            JTextField field = new JTextField(fieldName[i]);
            field.setHorizontalAlignment(SwingConstants.CENTER);
            field.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    field.setText("");
                }

                @Override
                public void mousePressed(MouseEvent e) {

                }

                @Override
                public void mouseReleased(MouseEvent e) {

                }

                @Override
                public void mouseEntered(MouseEvent e) {

                }

                @Override
                public void mouseExited(MouseEvent e) {

                }
            });
         field.setToolTipText(fieldName[i]);
         dialog.add(field);
        }
        }
    };

