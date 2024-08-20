package PC1;

  import java.net.*;  
  import java.io.*;  
  public class TCPServer{  
    public static void main(String args[])throws Exception{  
		String clientSentence="";
		String capitalizedSentence=""; 
		
		ServerSocket welcomeSocket=new ServerSocket(4444);  
		Socket connectionSocket=welcomeSocket.accept();  
		DataInputStream FromClient=new DataInputStream(connectionSocket.getInputStream());  
		DataOutputStream ToClient=new DataOutputStream(connectionSocket.getOutputStream());  
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));  
		clientSentence=FromClient.readUTF(); 
		if(clientSentence.equals("CONNECT")){
			System.out.println("client says: "+clientSentence+" ");  
			capitalizedSentence=br.readLine();  
			ToClient.writeUTF(capitalizedSentence); 
			ToClient.flush();  
			clientSentence=FromClient.readUTF();
		while(!clientSentence.equals("STOP")){  
			System.out.println("client says: "+clientSentence+" ");  
			capitalizedSentence=br.readLine();  
			ToClient.writeUTF(capitalizedSentence); 
			ToClient.flush(); 
			clientSentence=FromClient.readUTF();} 
		welcomeSocket.close();
		System.out.println("Server closed");
		connectionSocket.close(); 
		FromClient.close(); 			}
		
															}
    				}