package com.mchaves.api_news.service;

import com.mchaves.api_news.repositoty.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UsuarioService {

    private final UsuarioRepository  usuarioRepository;
}
