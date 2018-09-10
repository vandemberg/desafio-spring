package contazul.com.desafio.repositories;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import contazul.com.desafio.models.Bankslip;

@Repository("bankslipRepository")
public interface BankslipRepository extends JpaRepository<Bankslip, UUID> {
	
	@Query("SELECT CASE WHEN COUNT(bs) > 0 THEN true ELSE false END FROM Bankslip bs WHERE bs.id = :id")
    boolean existsById(UUID id);
	
}