package com.mchaves.api_news.web.controller;

import com.mchaves.api_news.entity.Usuario;
import com.mchaves.api_news.service.UsuarioService;
import com.mchaves.api_news.web.dto.UsuarioCreateDto;
import com.mchaves.api_news.web.dto.UsuarioResponseDto;
import com.mchaves.api_news.web.dto.UsuarioSenhaDto;
import com.mchaves.api_news.web.dto.mapper.UsuarioMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<UsuarioResponseDto>> getAll(){
        List<Usuario> users = usuarioService.gelAll();
        return ResponseEntity.ok().body(UsuarioMapper.ToListDto(users));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getById(@PathVariable Long id){
        Usuario user = usuarioService.findById(id);
        return ResponseEntity.ok().body(user);
    }

    @PostMapping
    public ResponseEntity<UsuarioResponseDto> create(@Valid @RequestBody UsuarioCreateDto createDto, UriComponentsBuilder ucb) {
        Usuario user = usuarioService.save(UsuarioMapper.toUsuario(createDto));
        URI locationOfNewUsuario = ucb
                .path("usuarios/{id}")
                .buildAndExpand(user.getId())
                .toUri();
        return ResponseEntity.created(locationOfNewUsuario).body(UsuarioMapper.toDto(user));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> updatePassword(@PathVariable Long id, @Valid @RequestBody UsuarioSenhaDto usuarioSenhaDto){
        Usuario user = usuarioService.updatePassword(id, usuarioSenhaDto.getSenhaAtual(), usuarioSenhaDto.getNovaSenha(), usuarioSenhaDto.getConfirmaSenha());
        return ResponseEntity.noContent().build();
    }
}
