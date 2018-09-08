package contazul.com.desafio.repositories;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import contazul.com.desafio.models.Bankslip;

@Repository("bankslipRepository")
public interface BankslipRepository extends JpaRepository<Bankslip, UUID> {

}