package mz.gov.misau.mpc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import mz.gov.misau.mpc.model.Acesso;
@Repository
@Transactional
public interface AcessoRepository extends JpaRepository<Acesso, Long>{

}
