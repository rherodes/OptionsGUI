import javax.swing.JFrame;

public class OptionsGUI
{
	//-----------------------------------------------------------------
	//  Creates and displays the main program frame.
	//-----------------------------------------------------------------
	public static void main(String[] args)
	{
		JFrame frame = new JFrame("Options GUI");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.getContentPane().add(new OptionGUIPanel());

		frame.pack();
		frame.setVisible(true);
		frame.setResizable(false);
	}
}
