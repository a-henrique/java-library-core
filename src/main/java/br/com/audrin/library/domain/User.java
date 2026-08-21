package br.com.audrin.library.domain;

public class User {
    private Long id;
    private String name;
    private String email;

    User(Long id, String name, String email){
        this.id = id;
        this.name = name;
        this.email = email;
    }
}
