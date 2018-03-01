package by.asrohau.library.controller.command.impl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.asrohau.library.controller.command.Command;
import by.asrohau.library.controller.exception.ControllerException;

public class ChangeLanguageCommand  implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ControllerException {

		try {
			System.out.println(request.getContextPath());
			
			HttpSession httpSession = request.getSession(true);
			
			httpSession.setAttribute("local", request.getParameter("local"));
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);


		} catch (ServletException e) {
			throw new ControllerException(e);
		} catch (IOException e) {
			throw new ControllerException(e);
		}
	
	}
}
