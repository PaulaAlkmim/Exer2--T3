package view;

import controller.KillController;

public class Main {

	public static void main(String[] args) {
		
		KillController kc = new KillController ();
		String os = kc.os();
		System.out.println(os);
		
		String p = "TASKLIST";
		String lp = "ps -ef";
		kc.listaProcessos(p, os, lp);
		
		String pid = "15536";
		String lpid = "1131";
		kc.mataPid (pid, os, lpid);
		
		
		
		String nome = "wordpad.exe";
		String lnome = "mousepad";
		kc.mataNome (nome, os, lnome);
	}

}
