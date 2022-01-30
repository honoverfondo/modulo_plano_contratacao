package mz.gov.misau.mpc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mz.gov.misau.mpc.model.Acesso;
import mz.gov.misau.mpc.repository.AcessoRepository;

@Service
public class AcessoService {
	@Autowired
	private AcessoRepository acessoRepository;
	
	
	public Acesso save(Acesso acesso) {
		return acessoRepository.save(acesso);
	}
}
