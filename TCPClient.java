package PC2;

import java.net.*;  
import java.io.*;  
 public class TCPClient{  
	public static void main(String args[])throws Exception{  
		String sentence=" ";
		String modifiedSentence=" "; 
		Socket clientSocket=new Socket("localhost",4444);  
		DataInputStream FromServer=new DataInputStream(clientSocket.getInputStream());  
		DataOutputStream ToServer=new DataOutputStream(clientSocket.getOutputStream());  
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		sentence=br.readLine(); 
	while(!sentence.equals("CONNECT"))
		{ System.out.println("Enter the keyword 'CONNECT'");
		sentence=br.readLine();}
		while(true){   
		if(!sentence.equals("STOP")){
			ToServer.writeUTF(sentence);  
			ToServer.flush();  
			modifiedSentence=FromServer.readUTF();  
			System.out.println("Server says: "+modifiedSentence+" ");  
									}
		else
			{ToServer.writeUTF(sentence);  
			ToServer.flush(); 
			System.out.println("Connection terminated");
			break;}
		sentence=br.readLine();}
	clientSocket.close();
														}  
					}