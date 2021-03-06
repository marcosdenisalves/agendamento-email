package br.com.alura.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.alura.entidade.AgendamentoEmail;

@Stateless
public class AgendamentoEmailDAO {
	
	@PersistenceContext
	private EntityManager manager;
	
	public List<AgendamentoEmail> listar(){
		return manager.createQuery("SELECT ae FROM AgendamentoEmail ae",
				 AgendamentoEmail.class).getResultList();
	}
	
	public void inserir(AgendamentoEmail agendamentoEmail) {
		manager.persist(agendamentoEmail);
	}
	
	public List<AgendamentoEmail> listarPorNaoAgendado() {
		return manager
			.createQuery("SELECT ae FROM AgendamentoEmail ae WHERE ae.agendado = false",
				AgendamentoEmail.class).getResultList();
	}
	
	public void alterarStatusAgendado(AgendamentoEmail agendamentoEmail) {
		manager.merge(agendamentoEmail);
	}
}
