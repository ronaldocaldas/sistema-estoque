package com.javaelinux.sistemaestoque.action;

import javax.ejb.Local;

@Local
public interface Authenticator {

	boolean authenticate();

}
