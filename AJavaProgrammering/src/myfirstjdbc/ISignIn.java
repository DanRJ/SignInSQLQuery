package myfirstjdbc;

public interface ISignIn {
	enum LoginState {
		LOGIN, BAD_LOGIN, LOGIN_CHECK, GOOD_LOGIN, SQL_VIEW
	}
}
