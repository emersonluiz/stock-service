package br.com.controlunion.stock.exception;

public class BadRequestException extends Exception {

	private static final long serialVersionUID = 6059882660180710398L;

	public BadRequestException(String message) {
        super(message);
    }
}