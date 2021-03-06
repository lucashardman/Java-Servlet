package br.com.alura.gerenciador.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Banco {

	private static List<Empresa> lista = new ArrayList<>();
	private static List<Usuario> listaUsuarios= new ArrayList<>();
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
		
		Usuario u1 = new Usuario();
	    u1.setLogin("nico");
	    u1.setSenha("12345");

	    Usuario u2 = new Usuario();
	    u2.setLogin("ana");
	    u2.setSenha("12345");

	    listaUsuarios.add(u1);
	    listaUsuarios.add(u2);
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
	public Usuario existeUsuario(String login, String senha) {
		for (Usuario u: listaUsuarios) {
			if (u.ehIgual(login, senha)) {
				return u;
			}
			
		}
		return null;
	}
}
