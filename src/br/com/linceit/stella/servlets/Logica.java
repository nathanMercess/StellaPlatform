package br.com.linceit.stella.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Logica {
	
	String execute(HttpServletRequest req, HttpServletResponse res) throws ServletException;
	
}
