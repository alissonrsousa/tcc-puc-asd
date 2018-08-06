package com.alissonrsousa.segurancaservice.repository;

import org.springframework.data.repository.CrudRepository;
import com.alissonrsousa.segurancaservice.model.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {

}
