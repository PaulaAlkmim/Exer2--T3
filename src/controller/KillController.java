package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class KillController {


	public KillController () {
	
    }
	public String os() {
		String os = System.getProperty("os.name");
		return os;
	}	
	
	public void listaProcessos(String p, String os, String lp) {
		if (os.contains ("w")){
			try {
				Process pr = Runtime.getRuntime().exec(p);
				InputStream fluxo = pr.getInputStream();
				InputStreamReader leitor = new InputStreamReader (fluxo);
				BufferedReader buffer = new BufferedReader (leitor);
				String linha = buffer.readLine();
				while (linha != null) {
					System.out.println(linha);
					linha = buffer.readLine();		
				}
			    buffer.close();
			    leitor.close();
			    fluxo.close();
			}

			catch (IOException e) {
			e.printStackTrace();	
			
			}
		}
		else { 
			try {
				Process pr = Runtime.getRuntime().exec(lp);
				InputStream fluxo = pr.getInputStream();
				InputStreamReader leitor = new InputStreamReader (fluxo);
				BufferedReader buffer = new BufferedReader (leitor);
				String linha = buffer.readLine();
				while (linha != null) {
					System.out.println(linha);
					linha = buffer.readLine();		
				}
			    buffer.close();
			    leitor.close();
			    fluxo.close();
			}

			catch (IOException e) {
			e.printStackTrace();	
			
			}
		}
	}
	public void mataPid (String pid, String os, String lpid) {
		if (os.contains ("w")){
		String tk = ("TASKKILL /PID");
		StringBuffer buffer = new StringBuffer();
		
		try {
		buffer.append(tk);
		buffer.append(" ");
		buffer.append(pid);
		}
		catch (Exception e) {
			e.printStackTrace();
			
		}
		try {
			Runtime.getRuntime().exec(buffer.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}

		
	}
		else {	
			String ltk = ("kill -9");
			StringBuffer buffer = new StringBuffer();
			
			try {
			buffer.append(ltk);
			buffer.append(" ");
			buffer.append(lpid);
			}
			catch (Exception e) {
				e.printStackTrace();
				
			}
			try {
				Runtime.getRuntime().exec(buffer.toString());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
  }
	public void mataNome (String nome, String os, String lnome) {
		if (os.contains ("w")){
			String tkn = ("TASKKILL /IM");
			StringBuffer buffer = new StringBuffer();
			
			try {
			buffer.append(tkn);
			buffer.append(" ");
			buffer.append(nome);
			}
			catch (Exception e) {
				e.printStackTrace();
				
			}
			try {
				Runtime.getRuntime().exec(buffer.toString());
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		else { 
			String ltkn = ("pkill -f");
			StringBuffer buffer = new StringBuffer();
			
			try {
			buffer.append(ltkn);
			buffer.append(" ");
			buffer.append(lnome);
			}
			catch (Exception e) {
				e.printStackTrace();
				
			}
			try {
				Runtime.getRuntime().exec(buffer.toString());
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
	}
		
}
