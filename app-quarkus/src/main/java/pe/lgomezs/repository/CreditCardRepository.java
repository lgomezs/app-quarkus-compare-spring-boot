package pe.lgomezs.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import pe.lgomezs.domain.transaction.CreditCardTransaction;

import java.util.UUID;

public interface CreditCardRepository extends JpaRepository<CreditCardTransaction, Long> {

    CreditCardTransaction findByProcessTraceId(UUID uuid);
}
