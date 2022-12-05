package by.bsuir.vt3.client.controller;

import by.bsuir.vt3.beans.*;

public interface ClientController {
	Request createRequest();
	void processResponse(Response response);
}
