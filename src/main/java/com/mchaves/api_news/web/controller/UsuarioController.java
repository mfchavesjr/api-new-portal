package com.mchaves.api_news.web.controller;

import com.mchaves.api_news.entity.Usuario;
import com.mchaves.api_news.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<Usuario> create(@RequestBody Usuario usuario, UriComponentsBuilder ucb) {
        Usuario user = usuarioService.save(usuario);
        URI locationOfNewUsuario = ucb
                .path("usuarios/{id}")
                .buildAndExpand(user.getId())
                .toUri();
        return ResponseEntity.created(locationOfNewUsuario).body(user);
    }
}
