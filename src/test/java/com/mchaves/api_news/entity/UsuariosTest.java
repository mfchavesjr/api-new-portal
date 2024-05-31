package com.mchaves.api_news.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

@JsonTest
public class UsuariosTest {

    @Autowired
    private JacksonTester<Usuario> json;

    private Usuario usuario;

    @BeforeEach
    public void setup() {
        usuario = new Usuario();
        usuario.setUsername("Mauricio");
        usuario.setPassword("12345");
        usuario.setRole(Usuario.Role.ROLE_USUARIO);
        usuario.setCriadoPor("Mauricio");
        usuario.setDataCriacao(null);
        usuario.setDataModificacao(null);
        usuario.setModificadoPor(null);
    }

    @Test
    public void testSerializeUsuario() throws IOException {
        String content = """
                {"id":null,
                "username":"Mauricio",
                "password":"12345",
                "role":"ROLE_USUARIO",
                "criadoPor":"Mauricio",
                "dataCriacao": null,
                "dataModificacao": null,
                "modificadoPor": null}""";
        assertThat(this.json.write(usuario)).isStrictlyEqualToJson(content);
    }

    @Test
    public void testDeserializeUsuario() throws IOException {
        String content = """
                {"id":null,
                "username":"Mauricio",
                "password":"12345",
                "role":"ROLE_USUARIO",
                "criadoPor":"Mauricio",
                "dataCriacao": null,
                "dataModificacao": null,
                "modificadoPor": null}""";
        assertThat(this.json.parse(content)).isEqualTo(usuario);
    }

}
