import java.awt.*;
import java.awt.event.*;

/**
 * Sample application using Frame.
 *
 *
 *
 */
public class AtmSimulatorFrame extends Frame {

    /**
     * The constructor.
     */
    public AtmSimulatorFrame() {

        MenuBar menuBar = new MenuBar();
        Menu menuFile = new Menu();
        MenuItem menuFileExit = new MenuItem();

        menuFile.setLabel("File");
        menuFileExit.setLabel("Exit");

        // Add action listener.for the menu button
        menuFileExit.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        AtmSimulatorFrame.this.windowClosed();
                    }
                });
        menuFile.add(menuFileExit);
        menuBar.add(menuFile);

        setTitle("AtmSimulator");
        setMenuBar(menuBar);
        setSize(new Dimension(400, 400));

        // Add window listener.
        this.addWindowListener(
                new WindowAdapter() {
                    public void windowClosing(WindowEvent e) {
                        AtmSimulatorFrame.this.windowClosed();
                    }
                });
    }

    /**
     * Shutdown procedure when run as an application.
     */
    protected void windowClosed() {

        // Exit application.
        System.exit(0);
    }
}
