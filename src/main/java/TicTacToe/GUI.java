package TicTacToe;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GUI {
    private final JFrame frame = new JFrame();
    private final JPanel panel = new JPanel();
    private JButton field1;
    private JButton field2;
    private JButton field3;
    private JButton field4;
    private JButton field5;
    private JButton field6;
    private JButton field7;
    private JButton field8;
    private JButton field9;

    private ArrayList<JButton> buttons = new ArrayList<>();

    public GUI() {
        this.field1 = new JButton();
        this.field2 = new JButton();
        this.field3 = new JButton();
        this.field4 = new JButton();
        this.field5 = new JButton();
        this.field6 = new JButton();
        this.field7 = new JButton();
        this.field8 = new JButton();
        this.field9 = new JButton();

        this.getFrame().setTitle("TicTacToe");
    }

    private void setButtonLayout() {
        getButtons().forEach((field) -> {
            field.setPreferredSize(new Dimension(120, 120));
        });
    }

    private void addButtonsToPanel() {
        this.addButtonsToList();

        getButtons().forEach((field) -> {
            System.out.println(field.getName());
            getPanel().add(field);
        });
    }

    private void addButtonsToList() {
        getButtons().add(field1);
        getButtons().add(field2);
        getButtons().add(field3);
        getButtons().add(field4);
        getButtons().add(field5);
        getButtons().add(field6);
        getButtons().add(field7);
        getButtons().add(field8);
        getButtons().add(field9);
    }

    private void setPanelLayout() {
        getPanel().setBorder(new EmptyBorder(7, 7, 7, 7));
        getPanel().setLayout(new GridLayout(3, 3, 7, 7));
    }

    private void addComponents() {
        getFrame().add(getPanel());
    }

    private void setDefaultSettings() {
        getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getFrame().setResizable(false);
    }

    private void buildFrame() {
        getFrame().setVisible(true);
        getFrame().setLayout(new FlowLayout());
        getFrame().pack();
    }

    private void prepareGameField() {
        getButtons().forEach((field) -> {
            field.setFont(new Font("Arial", Font.PLAIN, 80));
            field.setFocusPainted(false);
            field.setEnabled(false);
        });
    }



    /**
     * Action-Stuff
     */
    public void addActionListener(ActionListener actionListener) {
        getButtons().forEach((field) -> {
            field.addActionListener(actionListener);
        });
    }

    public void setButtonValue(JButton field, String text) {
        if(!getButtons().contains(field))
            return;

        field.setText(text);
    }

    public boolean canUseButton(JButton field) {
        if(!getButtons().contains(field))
            return false;

        return "".equals(field.getText());
    }

    public void setGamefieldEnabled(boolean enabled) {
        getButtons().forEach((field) -> {
            field.setEnabled(enabled);
        });
    }

    public void resetGameField() {
        getButtons().forEach((field) -> {
            field.setText("");
        });
    }

    public void createGUI() {
        // Layouts
        addButtonsToPanel();
        setButtonLayout();
        setPanelLayout();

        // Actions
        addComponents();
        setDefaultSettings();
        buildFrame();
        prepareGameField();
    }



    /**
     * Getter
     */
    private JFrame getFrame() {
        return this.frame;
    }

    private JPanel getPanel() {
        return this.panel;
    }

    public ArrayList<JButton> getButtons() {
        return this.buttons;
    }
}
