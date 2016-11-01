/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.projetobd.model.entities;

/**
 *
 * @author Alexandre Barbieri
 */
public class Serie {
    
    private String id_serie;
    private String nome_serie;
    private String episodios;
    private double nota;

    public Serie() {
    }

    public String getId_serie() {
        return id_serie;
    }

    public void setId_serie(String id_serie) {
        this.id_serie = id_serie;
    }

    public String getNome_serie() {
        return nome_serie;
    }

    public void setNome_serie(String nome_serie) {
        this.nome_serie = nome_serie;
    }

    public String getEpisodios() {
        return episodios;
    }

    public void setEpisodios(String episodios) {
        this.episodios = episodios;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }  
}
