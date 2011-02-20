/*
 *    Copyright 2010 Peter Backx, streamhead.com
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *    
 *    http://www.apache.org/licenses/LICENSE-2.0
 *    
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package com.pow.ui.user.function;

import com.pow.MainApplication;
import com.pow.domain.user.User;

public class AdminFunction implements Function {

	private static final long serialVersionUID = 1L;

	@Override
	public String getCaptionKey() {
		return "AdminFunction.caption";
	}

	@Override
	public boolean isAvailable(User user) {
//		final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//		if(authentication!=null && authentication.getAuthorities().contains(new GrantedAuthorityImpl("ROLE_ADMIN")))
//		{
//			return true;
//		}
		return false;
	}

	@Override
	public void launch(MainApplication application) {
		application.getMainWindow().showNotification("executing sample admin function");
	}

}
