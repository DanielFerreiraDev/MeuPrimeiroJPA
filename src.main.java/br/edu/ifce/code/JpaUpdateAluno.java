package br.edu.ifce.code;

import javax.persistence.EntityManager;

import br.edu.ifce.model.Aluno;
import br.edu.ifce.utils.JPAUtil;

public class JpaUpdateAluno {
	public static void main(String[] args) {
		EntityManager manager = JPAUtil.getEntityManager();
		
		Aluno a = manager.find(Aluno.class, 4l);
		
		//a.setBairro("JARDIM IRACEMA");
		manager.persist(a);
		manager.getTransaction().begin();
		manager.getTransaction().commit();
		manager.close();
	}
	
}
