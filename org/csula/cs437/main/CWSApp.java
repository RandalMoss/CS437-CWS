package org.csula.cs437.main;

import java.io.IOException;
import java.util.Arrays;

import org.csula.cs437.gui.cwsGUI;

import com.google.gson.JsonSyntaxException;

public class CWSApp {
	static CShirtController csContainer;
	static ActionContainer ac;
	static cwsGUI gui;
	@SuppressWarnings("static-access")
	public static void main(String[] args){
		try {
			csContainer = new CShirtController();
		} catch (JsonSyntaxException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		csContainer.getCurrentCShirt().addImage(new Image("bin/images/sample.jpg", "sample"));
		ac = new ActionContainer();
		gui = new cwsGUI(csContainer);
		gui.createAndShowUI();
		
		//get the voice command action = voce.getvoicestuff()
		//"chameleon wear shirt" is the "activation passphrase"
				voce.SpeechInterface.init("./lib", false, true, 
					"./lib/gram", "digits");
				String activation = "chameleon wear shirt";
				System.out.println("This is a speech recognition test. " 
					+ "Speak digits from 0-9 into the microphone. " 
					+ "Speak 'quit' to quit.");

				boolean quit = false;
				while (!quit)
				{
					// Normally, applications would do application-specific things 
					// here.  For this sample, we'll just sleep for a little bit.
					try
					{
						Thread.sleep(100);
					}
					catch (InterruptedException e)
					{
					}

					while (voce.SpeechInterface.getRecognizerQueueSize() > 0)
					{
						String s = voce.SpeechInterface.popRecognizedString();

						// Check if the string contains 'quit'.
						if (-1 != s.indexOf("quit"))
						{
							quit = true;
						}

						ac.setActions(s);
						ac.perform(csContainer, gui);
						
						System.out.println("You said: " + s);
						if(s.equals(activation)){
							System.out.println("Please enter the password: ");
						}
						//voce.SpeechInterface.synthesize(s);
					}
				}

				voce.SpeechInterface.destroy();
				System.exit(0);
		
	}
}
