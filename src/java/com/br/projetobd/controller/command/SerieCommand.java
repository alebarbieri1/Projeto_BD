/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.projetobd.controller.command;

import com.br.projetobd.model.dao.SerieDAO;
import com.br.projetobd.model.entities.Serie;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Alexandre Barbieri
 */
public class SerieCommand implements Command {

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
            case "listar":
                listar();
                break;
        }
    }
    
    public void listar(){
        SerieDAO serie_dao = new SerieDAO();
        List<Serie> series = serie_dao.read();
        request.getSession().setAttribute("series", series);
        responsePage = "home.jsp";
    }

    @Override
    public String getResponsePage() {
        return responsePage;
    }

}
