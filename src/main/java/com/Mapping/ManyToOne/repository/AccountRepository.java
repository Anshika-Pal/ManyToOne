package com.Mapping.ManyToOne.repository;

import com.Mapping.ManyToOne.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Integer> {
}
