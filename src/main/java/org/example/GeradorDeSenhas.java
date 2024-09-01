package org.example;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

public class GeradorDeSenhas {
    private static final String LETRAS_MINUSCULAS = "abcdefghijklmnopqrstuvwxyz";
    private static final String LETRAS_MAIUSCULAS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String NUMEROS = "0123456789";
    private static final String SIMBOLOS_ESPECIAIS = "!@#$%^&*()-_=+[]{}|;:',.<>?/";

    private final SecureRandom random = new SecureRandom();
    private final List<String> caracteres = new ArrayList<>();

    public void LetrasMinusc() {
        caracteres.add(LETRAS_MINUSCULAS);
    }

    public void LetrasMaiusc() {
        caracteres.add(LETRAS_MAIUSCULAS);
    }

    public void Numeros() {
        caracteres.add(NUMEROS);
    }

    public void Simbolos() {
        caracteres.add(SIMBOLOS_ESPECIAIS);
    }

    public String gerarSenha(int tamanho) {
        if (caracteres.isEmpty()) {
            throw new IllegalArgumentException("Pelo menos uma categoria de caracteres deve ser selecionada.");
        }

        StringBuilder poolCaracteres = new StringBuilder();
        for (String categoria : caracteres) {
            poolCaracteres.append(categoria);
        }

        StringBuilder senha = new StringBuilder(tamanho);
        for (int i = 0; i < tamanho; i++) {
            int indiceAleatorio = random.nextInt(poolCaracteres.length());
            senha.append(poolCaracteres.charAt(indiceAleatorio));
        }

        return senha.toString();
    }
}

