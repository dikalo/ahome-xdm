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
