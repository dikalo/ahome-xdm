/*
 Copyright (c) 2014 Ahomé Innovation Technologies. All rights reserved.

 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at

 http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
 */
package com.ait.toolkit.xdm.client;

import com.ait.toolkit.xdm.client.resources.EasyXdmResources;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.ScriptInjector;

public class XDM {

	static final String NAME_HTML_URL = GWT.getModuleBaseURL()
			+ "ahomeeasyxdm/name.html";

	private XDM() {

	}

	static void load() {
		if (!isLoaded()) {
			EasyXdmResources resources = GWT.create(EasyXdmResources.class);
			ScriptInjector.fromString(resources.js().getText())
					.setWindow(ScriptInjector.TOP_WINDOW).inject();
		}
	}

	static native boolean isLoaded()/*-{
		if (typeof $wnd.easyXDM === "undefined" || $wnd.easyXDM === null) {
			return false;
		}
		return true;
	}-*/;

}
