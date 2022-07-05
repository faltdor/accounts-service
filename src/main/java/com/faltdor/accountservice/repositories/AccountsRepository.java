package com.faltdor.accountservice.repositories;

import com.faltdor.accountservice.entity.Accounts;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface AccountsRepository extends CrudRepository<Accounts, Long> {

    Optional<Accounts> findByCustomerId(UUID customerId);

}