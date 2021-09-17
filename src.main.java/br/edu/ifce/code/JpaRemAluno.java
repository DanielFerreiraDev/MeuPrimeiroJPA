package br.edu.ifce.code;

import javax.persistence.EntityManager;

import br.edu.ifce.model.Aluno;
import br.edu.ifce.utils.JPAUtil;

public class JpaRemAluno {
	
	public static void main(String[] args) {
		EntityManager manager = JPAUtil.getEntityManager();
		
		Aluno a = manager.getReference(Aluno.class, 4L);
		/**
		 * O método find() recupera os dados desejados imediatamente.
		 * O método getReference() posterga essa tarefa até a primeira chamada
		 * de um método get no objeto desejado
		 */
		manager.remove(a);
		manager.getTransaction().begin();
		manager.getTransaction().commit();
		manager.close();
	}
	/**
	 * 4 = int
	 * 4.2 = float
	 * 4000000000000000 = long
	 */

}
