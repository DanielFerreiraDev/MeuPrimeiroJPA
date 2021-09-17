package br.edu.ifce.code;

import java.io.IOException;
import java.util.Calendar;

import javax.persistence.EntityManager;
import br.edu.ifce.model.Aluno;
import br.edu.ifce.model.Endereco;
import br.edu.ifce.model.ExtraCurricular;
import br.edu.ifce.model.Sede;
import br.edu.ifce.model.Telefone;
import br.edu.ifce.utils.JPAUtil;
import br.edu.ifce.utils.Read;

public class JpaAluno {

	public static void main(String[] args) throws IOException {
		EntityManager manager = JPAUtil.getEntityManager();
		
		//Em representa, entre outras coisas, uma conexão com a unidade de persistencia
		manager.getTransaction().begin(); 
		byte [] foto = new Read().getFoto("C:\\Users\\ferre\\Desktop\\TrabalhoDevops\\build.png");
		
		Calendar c = Calendar.getInstance();
		c.set(2020, 00, 01);
		
		
		Aluno a = new Aluno();
		a.setNome("Carlos");
		a.setRG("999999");
		a.setCPF("999.999.999-99");
		
		Endereco e = new Endereco();
		e.setCep("60000-000");
		e.setCidade("Maracanau");
		e.setLogradouro("Rua dos amores");
		e.setBairro("Timbo");
		
		Telefone t1 = new Telefone();
		t1.setTelefone("99999-9999");
		t1.setTipo("Celular");
		
		Telefone t2 = new Telefone();
		t2.setTelefone("3333-3333");
		t2.setTipo("Fixo");
		
		a.getTelefone().add(t1);
		a.getTelefone().add(t2);
		
		//Aqui ocorre a definição que "e" está relacionado a "a"
		a.setEndereco(e);
		a.setIra(9.81);
		a.setFotografia(foto);
		a.setNascimento(c);
		
		Sede s = new Sede();
		s.setNome("IFCE-Maracanau");
		s.setDiretor("Julio Cesar");
		
		a.setSede(s);
		
		ExtraCurricular atv1 = new ExtraCurricular();
		atv1.setNome("Judo");
		atv1.setValor("50,00");
		
		ExtraCurricular atv2 = new ExtraCurricular();
		atv2.setNome("Reforço escolar");
		atv2.setValor("100,00");
		
		a.getAtividadesExtras().add(atv1);
		a.getAtividadesExtras().add(atv2);
		
		manager.persist(atv1);
		manager.persist(atv2);
		manager.persist(s);
		manager.persist(t1);
		manager.persist(t2);
		manager.persist(e);
		manager.persist(a);
		
		manager.getTransaction().commit();
		manager.close(); 
		 
	}

}
