package by.asrohau.library.service.impl;

import by.asrohau.library.bean.Book;
import by.asrohau.library.dao.BookDAO;
import by.asrohau.library.dao.DAOFactory;
import by.asrohau.library.service.BookService;

public class BookServiceImpl implements BookService{

	private final BookDAO bookDAO = DAOFactory.getInstance().getBookDAO();
	
	public BookServiceImpl(){}
	
	@Override
	public boolean validation(String title, String author) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addBook(String title, String author) {
		// TODO Auto-generated method stub
		bookDAO.findBook(title, author);
		bookDAO.saveBook(title, author);
		
		return false;
	}

	@Override
	public Book[] findBookWithTitle(String title) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Book[] findBookWithAuthor(String author) {
		// TODO Auto-generated method stub
		return null;
	}

}
