import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
//import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.border.Border;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
//import java.net.URL;
import java.net.http.*;
import java.net.http.HttpResponse.BodyHandlers;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class OptionsGUIPanel extends JPanel
{
   private final int WIDTH = 1900, HEIGHT = 950;

   //private ImageIcon[] cards = new ImageIcon[52];
	//private JButton hit, stand, split, doubleDown, surrender;
	//private JLabel[] results = new JLabel[6];
   private JLabel bet;
   private JTextField input;
   private JButton sendQuery;

   public OptionsGUIPanel()
	{
      setLayout(new BorderLayout());

		//create JPanel with grid layoutfor buttons
		JPanel guiLayout	= new JPanel();
		guiLayout.setLayout(new GridLayout(6,1));

		//create bet JLabel
		bet = new JLabel("Title");
		bet.setFont(new Font("Helvetica", Font.PLAIN, 48));
		bet.setHorizontalAlignment(JLabel.CENTER);
		bet.setForeground(Color.white);

		//add bet text to betLayout
		guiLayout.add(bet);

		input = new JTextField(5);
		input.setFont(new Font("Helvetica", Font.PLAIN, 48));
		input.setHorizontalAlignment(JLabel.CENTER);
		input.addActionListener(new ButtonListener());
		input.setEnabled(true);
		input.requestFocus();

		//create and add hit button to button layout
		sendQuery = new JButton("Fart");
		sendQuery.setFont(new Font("Helvetica", Font.PLAIN, 48));
		sendQuery.setBackground(Color.blue);
      sendQuery.setForeground(Color.white);
		sendQuery.addActionListener(new ButtonListener());
		sendQuery.setEnabled(true);
		guiLayout.add(sendQuery);

		//add buttonLayout to right side of window
		add(guiLayout, BorderLayout.WEST);

		//add textLayout, header, and spacing to bottom of window
		//add(textLayout, BorderLayout.WEST);

		//set screen size
		setPreferredSize(new Dimension(WIDTH+900, HEIGHT));
   }
   
   private class ButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			//If stand button pressed
			if( event.getSource() == sendQuery )
			{
				try{
					//get info
					// URL url = new URL("https://pokeapi.co/api/v2/pokemon/ditto");
					// HttpURLConnection http = (HttpURLConnection)url.openConnection();
					// System.out.println(http.getResponseCode() + " " + http.getResponseMessage());
					// http.disconnect();

					
					String ending = "pokemon/ditto";
					HttpClient client = HttpClient.newHttpClient();
					HttpRequest request = HttpRequest.newBuilder()
					   	.uri(URI.create("https://pokeapi.co/api/v2/" + ending))
							.build();
					String responsePreJSON = client.send(request, BodyHandlers.ofString()).body();

               // convert to json
					JSONParser parser = new JSONParser();
					JSONObject responseJSON = (JSONObject) parser.parse(responsePreJSON);

					//String name = (String) responseJSON.get("game_indices.height");
					System.out.println(responseJSON.values());
					



					//JSONTokener tokener = new JSONTokener(wikiRequest.openStream());
					//JSONObject root = new JSONObject(tokener);
				}
				catch (Exception e) {
					System.out.println("Error");
				}
				
			}
			//end if
		}
		//end actionPerformed
	}
	//end ButtonListener

} // end panel
