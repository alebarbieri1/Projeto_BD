/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.projetobd.model.dao;

import com.br.projetobd.model.entities.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alexandre Barbieri
 */
public class UsuarioDAO implements GenericDAO<Usuario> {

    Connection conn;

    public UsuarioDAO() {
        conn = ConnectionFactory.getInstance().getConnection();
    }

    @Override
    public void create(Usuario e) {

    }

    @Override
    public List<Usuario> read() {
        return null;
    }

    @Override
    public Usuario readById(Long id) {
        return null;
    }

    public Usuario readByName(String name) {
        String sql = "SELECT * FROM usuario WHERE nome_usuario = ?";
        Usuario usuario = null;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            while (rs != null && rs.next()){
                usuario = new Usuario();
                usuario.setNome_usuario(rs.getString("nome_usuario"));
                usuario.setSenha(rs.getString("senha"));
                usuario.setAcesso(rs.getInt("acesso"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usuario;
    }

    @Override
    public void update(Usuario e) {

    }

    @Override
    public void delete(Usuario e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
