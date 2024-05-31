package com.mchaves.api_news.repositoty;

import com.mchaves.api_news.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}