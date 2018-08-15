package com.alissonrsousa.authserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alissonrsousa.authserver.domain.Credentials;

/**
 * Created by ahmed on 21.5.18.
 */
public interface CredentialRepository extends JpaRepository<Credentials,Long> {
    Credentials findByName(String name);
}
