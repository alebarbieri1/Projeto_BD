/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.projetobd.model.dao;

import com.br.projetobd.model.entities.Serie;
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
public class SerieDAO implements GenericDAO<Serie> {

    Connection conn;

    public SerieDAO() {
        conn = ConnectionFactory.getInstance().getConnection();
    }

    @Override
    public void create(Serie e) {
        
    }

    @Override
    public List<Serie> read() {
        String sql = "SELECT * FROM serie";
        List<Serie> series = new ArrayList();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs != null && rs.next()){
                String id_serie = rs.getString("id_serie");
                String nome_serie = rs.getString("nome_serie");
                String episodios = rs.getString("episodios");
                double nota = rs.getDouble("nota");
                
                Serie s = new Serie();
                s.setEpisodios(episodios);
                s.setId_serie(id_serie);
                s.setNome_serie(nome_serie);
                s.setNota(nota);
                
                series.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SerieDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return series;
    }

    @Override
    public Serie readById(Long id) {
        return null;
    }

    @Override
    public void update(Serie e) {
        
    }

    @Override
    public void delete(Serie e) {
        
    }
}
