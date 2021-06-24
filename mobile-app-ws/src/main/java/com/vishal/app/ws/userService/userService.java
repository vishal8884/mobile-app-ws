package com.vishal.app.ws.userService;

import com.vishal.app.ws.ui.model.request.UserDetailsRequestModel;
import com.vishal.app.ws.ui.model.response.UserRest;

public interface userService {
	
	public UserRest getUserRest(UserDetailsRequestModel userDetailsRequestModel);

}
