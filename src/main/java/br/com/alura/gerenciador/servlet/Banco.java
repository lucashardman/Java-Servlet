package br.com.alura.gerenciador.servlet;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Banco {

	private static List<Empresa> lista = new ArrayList<>();
	private static Integer chaveSequencial = 1;
	
	static {
		Empresa empresa = new Empresa();
		Empresa empresa2 = new Empresa();
		
		empresa.setNome("Alura");
		empresa2.setNome("Caelum");
		
		empresa.setId(chaveSequencial++);
		empresa2.setId(chaveSequencial++);
		
		lista.add(empresa);
		lista.add(empresa2);
	}
	
	public void adiciona(Empresa empresa) {
		empresa.setId(chaveSequencial++);
		Banco.lista.add(empresa);
		
	}
	public List<Empresa> getEmpresas(){
		return Banco.lista;
	}
	public void removeEmpresa(int id) {
		
		Iterator<Empresa> it = lista.iterator();
		while(it.hasNext()) {
			 Empresa emp = it.next();
			 if(emp.getId() == id) {
				 it.remove(); 
			 }
		} 
		
	}
	public Empresa buscaEmpresa(int id) {
		for (Empresa empresa: lista) {
			if(empresa.getId() == id) {
				 return empresa;
			 }
		}
		return null;
	}
}
