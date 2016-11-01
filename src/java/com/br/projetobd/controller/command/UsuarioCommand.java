/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.projetobd.controller.command;

import com.br.projetobd.model.dao.UsuarioDAO;
import com.br.projetobd.model.entities.Usuario;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Alexandre Barbieri
 */
public class UsuarioCommand implements Command {

    private HttpServletRequest request;
    private HttpServletResponse response;
    private String responsePage;

    @Override
    public void init(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
    }

    @Override
    public void execute() {
        String action = request.getParameter("command").split("\\.")[1];
        switch (action) {
            case "login":
                login();
                break;
            case "logout":
                logout();
                break;
        }
    }

    public void login() {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Usuario usuario;
        String username = request.getParameter("usuario");
        String password = request.getParameter("senha");

        usuario = usuarioDAO.readByName(username);

        if (usuario == null) {
            // Não encontrou nenhum usuário
            responsePage = "error.jsp";
            request.getSession().setAttribute("erro", "Usuário não encontrado");
            request.getSession().setAttribute("previousPage", "index.jsp");
            return;
        }
        if (!password.equals(usuario.getSenha())) {
            responsePage = "error.jsp";
            request.getSession().setAttribute("erro", "Senha incorreta");
            request.getSession().setAttribute("previousPage", "index.jsp");
        } else {
            request.getSession().setAttribute("usuario", usuario);
            responsePage = "home.jsp";
        }

    }
    
    public void logout(){
        this.request.getSession().invalidate();
        responsePage = "index.jsp";
    }

    @Override
    public String getResponsePage() {
        return this.responsePage;
    }
}
