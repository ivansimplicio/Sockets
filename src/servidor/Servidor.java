package servidor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Servidor {
	
	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(12345);
		System.out.println("Porta 12345 aberta!");
		
		Socket client = server.accept();
		System.out.println("Nova conexão com o cliente: "+ client.getInetAddress().getHostAddress()+"\n");
		
		Scanner entrada = new Scanner(client.getInputStream());
		while(entrada.hasNextLine()){
			System.out.println("Mensagem recebida: "+entrada.nextLine());
		}

		entrada.close();
		client.close();
		server.close();
	}
}