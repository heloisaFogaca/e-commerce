package com.api.ecommerce.exception;

public class FalhaCadastroException extends  RuntimeException{
    public FalhaCadastroException(){
        super("Falha no cadastro, algum dado informado está errado!");
    }
}
