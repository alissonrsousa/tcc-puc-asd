package com.alissonrsousa.authserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alissonrsousa.authserver.domain.Credentials;

public interface CredentialRepository extends JpaRepository<Credentials,Long> {
    Credentials findByName(String name);
}
