package Mastermind.Mastermind;

import javax.swing.SwingUtilities;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        System.out.println( "Hello World2!" );
        
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new VentanaGame().setVisible(true);
            }
        });
    }
}
