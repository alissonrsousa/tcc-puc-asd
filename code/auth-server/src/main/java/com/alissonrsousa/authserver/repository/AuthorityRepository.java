package com.alissonrsousa.authserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alissonrsousa.authserver.model.Authority;

public interface AuthorityRepository extends JpaRepository<Authority, String>{
	Authority findByName(String name);
}