package TicTacToe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUISetup {
    private GUI gui;

    public GUISetup() {
        setupGUI();
    }

    private void setupGUI() {
        this.gui = new GUI();
        this.gui.createGUI();
        setActionListeners();

        this.gui.resetGameField();
    }

    private void setActionListeners() {
        getGUI().getButtons().forEach((field) -> {
            getGUI().addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {

                }
            });
        });
    }


    private GUI getGUI() {
        return this.gui;
    }

}
