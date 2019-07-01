package cliente;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ConnectException;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
	
	public static void main(String[] args) throws IOException {
		Socket client = null;
		Scanner input = null;
		PrintStream output = null;
		
		try {
			client = new Socket("localhost", 12345);
			System.out.println("Conectado ao servidor!\n");
			
			System.out.print("Enviar: ");
			input = new Scanner(System.in);
			output = new PrintStream(client.getOutputStream());
			while(input.hasNextLine()){
				System.out.print("Enviar: ");
				String conteudo = input.nextLine();
				if(conteudo.equals("exit")){
					System.exit(0);
				}else{
					output.println(conteudo);
				}
			}
		} catch(ConnectException e) {
			System.out.println("Não foi possível conectar!");
			System.out.println("Primeiro é necessário iniciar o servidor!");
		} finally {
			if(client != null)client.close();
			if(input != null)input.close();
			if(output != null)output.close();
		}
	}
}