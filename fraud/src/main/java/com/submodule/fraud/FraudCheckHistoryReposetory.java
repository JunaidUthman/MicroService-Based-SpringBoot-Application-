package com.submodule.fraud;


import org.springframework.data.jpa.repository.JpaRepository;

public interface FraudCheckHistoryReposetory extends JpaRepository<FraudCheckHistory, Integer> {
}
