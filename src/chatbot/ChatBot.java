/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatbot;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;

/**
 *
 * @author Phucdz
 */
public class ChatBot {

	/**
	 * @param args the command line arguments
	 */
	// TODO code application logic here
	private static void displayMenu(boolean start) {
		if (start) {
			System.out.println("Please Enter a command");
		}
		System.out.println("> ");
	}
	
	private static int getLines(String filename) throws Exception {
		int lines = 0;
		BufferedReader br = new BufferedReader(new FileReader(filename));
		while (br.readLine() != null) {
			lines++;
		}
		return lines;
	}

	private static String getUserInput() throws Exception {
		String userInput = null;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		userInput = br.readLine();
		return userInput;
	}
	
	private static String[] getAllReponseArray(String filename, int lines) throws Exception {
		int lineCount = 0;
		String line;
		String reponsesArray[] = new String[lines];
		BufferedReader br = new BufferedReader(new FileReader(filename));
		do {
			line = br.readLine();
			if(line!=null) {
				reponsesArray[lineCount] = line;
				lineCount++;
			}
		} while(line!=null);
		return reponsesArray;
	}
	private static String getReponses(String reponses[], String userInput) {
		String tag, reponse;
		String array[];
		for(String reponseLine: reponses) {
			if(reponseLine != null) {
				array = reponseLine.split(" - ");
				tag = array[0];
				reponse = array[1];
				if(tag.compareToIgnoreCase(userInput) == 0) {
					return reponse;
				}
			}
		}
		return "No Reponse....";
	}
//	Run
	public static void main(String[] args) throws Exception{
		String userInput, reponse;
		String filename = "./src/chatbot/reponses.txt";
		int lines = getLines(filename);
		String reponses[] = getAllReponseArray(filename, lines);
		displayMenu(true);
		do {
			userInput = getUserInput();
			reponse = getReponses(reponses, userInput);
			System.out.println("ChatBot: " + reponse);
			if(!userInput.equals("bye")) {
				displayMenu(false);
			}
		}while(!userInput.equals("Bye"));
		
	}
}
