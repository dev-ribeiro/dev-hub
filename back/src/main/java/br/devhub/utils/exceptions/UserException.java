package br.devhub.utils.exceptions;

public class UserException extends RuntimeException {

	private static final long serialVersionUID = 726721683416253836L;

	public UserException(String message) {
		super(message);
	}
}
