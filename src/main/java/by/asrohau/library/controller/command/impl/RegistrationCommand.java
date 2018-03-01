package by.asrohau.library.controller.command.impl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.asrohau.library.controller.command.Command;
import by.asrohau.library.controller.exception.ControllerException;
import by.asrohau.library.service.ServiceFactory;
import by.asrohau.library.service.UserService;
import by.asrohau.library.service.exception.ServiceException;

public class RegistrationCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ControllerException {
		System.out.println("We got to REGISTRATION");
		boolean isRegistered = false;
		String login = request.getParameter("login");
		String password = request.getParameter("password");

		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		UserService userService = serviceFactory.getUserService();

		try {
			isRegistered = userService.registration(login.trim(), password.trim());
			
			String goToPage;
			if (isRegistered) {
				request.setAttribute("isRegistered", "You registered successfully");
				goToPage = "index.jsp";
			} else {
				goToPage = "error.jsp";
				request.setAttribute("errorMessage", "cant register");
			}
			
			RequestDispatcher dispatcher = request.getRequestDispatcher(goToPage);
			dispatcher.forward(request, response);
			
		} catch (ServiceException e) {
			throw new ControllerException(e);
		} catch (ServletException e) {
			throw new ControllerException(e);
		} catch (IOException e) {
			throw new ControllerException(e);
		}

	}

}
