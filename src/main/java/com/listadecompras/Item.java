package com.listadecompras;

public class Item {
    private int id;
    private String nome;
    private int quantidade;
    private boolean comprado;

    public Item(String nome, int quantidade) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.comprado = false;
    }

    public Item(int id, String nome, int quantidade, boolean comprado) {
        this.id = id;
        this.nome = nome;
        this.quantidade = quantidade;
        this.comprado = comprado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public boolean isComprado() {
        return comprado;
    }

    public void setComprado(boolean comprado) {
        this.comprado = comprado;
    }
}
