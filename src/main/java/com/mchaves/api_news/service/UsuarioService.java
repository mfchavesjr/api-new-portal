package com.mchaves.api_news.service;

import com.mchaves.api_news.entity.Usuario;
import com.mchaves.api_news.repositoty.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    @Transactional
    public Usuario save(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Transactional(readOnly = true)
    public Usuario findById(Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(
                        () -> new EntityNotFoundException(String.format("Usuário id=%s não encontrado", id))
                );
    }

    @Transactional(readOnly = true)
    public List<Usuario> gelAll() {
        return usuarioRepository.findAll();
    }

    @Transactional
    public Usuario updatePassword(Long id, String senhaAtual, String novaSenha, String confirmaSenha) {

        if (!novaSenha.equals(confirmaSenha)) {
            throw new RuntimeException("Nova senha não confere com a de confirmação");
        }
        Usuario user = findById(id);
        if (!senhaAtual.equals(user.getPassword())) {
            throw new RuntimeException("Senhas não conferem");
        }
        user.setPassword(novaSenha);
        return user;
    }
}
