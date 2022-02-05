package mz.gov.misau.mpc;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import junit.framework.TestCase;
import mz.gov.misau.mpc.controller.AcessoController;
import mz.gov.misau.mpc.model.Acesso;
import mz.gov.misau.mpc.repository.AcessoRepository;
import mz.gov.misau.mpc.service.AcessoService;

@SpringBootTest(classes = ModuloPlanoContratacaoApplication.class)
public class ModuloPlanoContratacaoApplicationTests extends TestCase {

	@Autowired
	private AcessoController acessoController;

	@Autowired
	private AcessoRepository acessoRepository;

	@Test
	public void testCadastrarAcesso() {
		Acesso acesso = new Acesso();

		acesso.setDescricao("FONDO");

		assertEquals(true, acesso.getId() == null);

		acesso = acessoController.salvaAcesso(acesso).getBody();

		assertEquals(true, acesso.getId() > 0);

		/* Testando o carregamento */
		Acesso acesso2 = acessoRepository.findById(acesso.getId()).get();

		assertEquals(acesso.getId(), acesso2.getId());

		/* Teste de delete */
		acessoRepository.deleteById(acesso2.getId());
		acessoRepository.flush();
		Acesso acesso3 = acessoRepository.findById(acesso2.getId()).orElse(null);

		assertEquals(true, acesso3 == null);
		
		
		
		/*Teste de query
		acesso=new Acesso();
		acesso.setDescricao("FONDO");
		
		acesso=acessoController.salvaAcesso(acesso).getBody();
		
		List<Acesso> acessos=acessoRepository.buscaAcessoDesc("FONDO".trim().toUpperCase());
		
		assertEquals(1, acessos.size());
		
		
		acessoRepository.deleteById(acesso.getId());*/
	}

}
