/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.projetobd.model.dao;

import com.br.projetobd.model.entities.Filme;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alexandre Barbieri
 */
public class FilmeDAO implements GenericDAO<Filme> {

    Connection conn;

    public FilmeDAO() {
        conn = ConnectionFactory.getInstance().getConnection();
    }

    @Override
    public void create(Filme e) {
    }

    @Override
    public List<Filme> read() {
        String sql = "SELECT * FROM filme";
        List<Filme> filmes = new ArrayList();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs != null && rs.next()) {
                String id_filme = rs.getString("id_filme");
                String nome_filme = rs.getString("nome_filme");
                double nota = rs.getDouble("nota");

                Filme f = new Filme();
                f.setId_filme(id_filme);
                f.setNome_filme(nome_filme);
                f.setNota(nota);
                filmes.add(f);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SerieDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return filmes;
    }

    @Override
    public Filme readById(Long id) {
        return null;
    }

    @Override
    public void update(Filme e) {

    }

    @Override
    public void delete(Filme e) {

    }

}
