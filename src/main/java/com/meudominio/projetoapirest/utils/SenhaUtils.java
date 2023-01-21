package com.meudominio.projetoapirest.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class SenhaUtils {

    /**
     * Gera um hash utilizando BCrypt
     *
     * @param senha
     * @return String
     */
    public static String gerarBCrypt(String senha) {
        if (senha == null) {
            return senha;
        }
        BCryptPasswordEncoder bCryptEncoder = new BCryptPasswordEncoder();
        return bCryptEncoder.encode(senha);
    }
    /**
     * Verifica se a senha é valida
     *
     * @param senha
     * @param senhaEncoded
     * @return boolean
     */
    public boolean senhaValida(String senha, String senhaEncoded) {
        BCryptPasswordEncoder bCryptEncoder = new BCryptPasswordEncoder();
        return bCryptEncoder.matches(senha, senhaEncoded);
    }
    /*
    Com a classe criada, por ela conter métodos estáticos, basta chamá-los diretamente onde
    desejar em seu código, como por exemplo:
    */
}
