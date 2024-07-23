/**
 * The studentGUI class represents a simple Swing GUI window that allows users to input text
 * and counts the number of vowels and consonants as they type.
 *
 * @author : Percy Ratheko
 * @version 1.8.
 */


package com.bcit.comp601assignment2;


import javax.swing.*;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import java.awt.*;

public class StudentGUI
{

    private final JFrame frame;
    private final JTextArea textArea;
    private final JLabel vowelLabel;
    private final JLabel consonantLabel;

    private static final int NOTHING;
    private static final int SEC_INDEX;

    static
    {
        NOTHING   = 0;
        SEC_INDEX = 1;

    }


    public StudentGUI()
    {
        frame = new JFrame("Vowel and Consonant Counter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 320);
        frame.setLayout(new BorderLayout());

        // create components
        textArea       = new JTextArea();
        vowelLabel     = new JLabel("Vowels: 0");
        consonantLabel = new JLabel("Consonants: 0");

        JPanel labelPanel = new JPanel();
        labelPanel.setLayout(new GridLayout(1, 2));
        labelPanel.add(vowelLabel);
        labelPanel.add(consonantLabel);

        frame.add(new JScrollPane(textArea), BorderLayout.CENTER);
        frame.add(labelPanel, BorderLayout.SOUTH);

        textArea.addCaretListener(new CaretListener() {
            @Override
            public void caretUpdate(CaretEvent e) {
                updateCounts();
            }
        });

        frame.setVisible(true);
    }

    // Keeps track of the count
    private void updateCounts()
    {
        String text      = textArea.getText();
        int vowels       = NOTHING;
        int consonants   = NOTHING;
        String vowelsSet = "AEIOUaeiou";

        for (char ch : text.toCharArray())
        {
            if (Character.isLetter(ch))
            {
                if (vowelsSet.indexOf(ch) != -SEC_INDEX)
                {
                    vowels++;
                } else {
                    consonants++;
                }
            }
        }

        vowelLabel.setText("Vowels: " + vowels);
        consonantLabel.setText("Consonants: " + consonants);
    }

    // returns frame
    public JFrame getFrame()
    {
        return frame;
    }

    // gets and returns textArea
    public JTextArea getTextArea()
    {
        return textArea;
    }

    // gets and returns the constantLabel
    public JLabel getVowelLabel()
    {
        return vowelLabel;
    }

    // gets and returns constantLabel
    public JLabel getConsonantLabel()
    {
        return consonantLabel;
    }



    /**
     * The main method to start the programme.
     *
     * @param args Command line arguments - not used.
     */
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(() -> {
            StudentGUI studentGUI = new StudentGUI();;
            studentGUI.setVisible(true);
        });
    }

    // set visible methode
    private void setVisible(boolean b) {
    }

}
