package pe.lgomezs.appservicetransaction.repository;




import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.lgomezs.appservicetransaction.domain.CreditCardTransaction;

import java.util.UUID;

@Repository
public interface CreditCardRepository extends JpaRepository<CreditCardTransaction, Long> {

    CreditCardTransaction findByProcessTraceId(UUID uuid);
}
