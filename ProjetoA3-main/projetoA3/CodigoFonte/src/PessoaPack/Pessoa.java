package PessoaPack;

public class Pessoa {
    
    protected String nome;
    protected String sobrenome;
    protected String CPF;
    protected String fone;
    protected String endereço;
    protected int cep;

 
    public Pessoa(String nome, String sobrenome, String cPF, String fone, String endereço, int cep) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        CPF = cPF;
        this.fone = fone;
        this.endereço = endereço;
        this.cep = cep;
    }

    //Usando o get para podemos utilizar em outros package de forma publica 
    public String getNome(){
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }


    public String getSobrenome(){
        return sobrenome;
    }
    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }


    public String getCPF(){
        return CPF;
    }
    public void setCPF(String cPF) {
        CPF = cPF;
    }


    public String getfone(){
        return fone;
    }
    public void setFone(String fone) {
        this.fone = fone;
    }


    public String getendereço(){
        return endereço;
    }
    public void setEndereço(String endereço) {
        this.endereço = endereço;
    }


    public int getcep(){
        return cep;
    }
    public void setCep(int cep) {
        this.cep = cep;
    }

    
}

