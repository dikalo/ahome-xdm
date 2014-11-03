package com.ait.toolkit.xdm.client;

import com.ait.toolkit.core.client.Function;
import com.ait.toolkit.core.client.JsoHelper;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayString;
import com.google.gwt.dom.client.Element;

public class XdmSocket {

	private JavaScriptObject peer;
	private JavaScriptObject proxyConfig;

	static {
		XDM.load();
	}

	public XdmSocket(String remoteUrl) {
		proxyConfig = JsoHelper.createObject();
		JsoHelper.setAttribute(proxyConfig, "local", XDM.NAME_HTML_URL);
		setRemoteUrl(remoteUrl);
	}

	/**
	 * the path to the provider
	 */
	private XdmSocket setRemoteUrl(String remoteUrl) {
		JsoHelper.setAttribute(proxyConfig, "remote", remoteUrl);
		return this;
	}

	/**
	 * To enable the FlashTransport for IE6/7 you need to point this towards
	 * your easyxdm.swf
	 * 
	 * 
	 */
	public XdmSocket setSwf(String value) {
		JsoHelper.setAttribute(proxyConfig, "swf", value);
		return this;
	}

	/**
	 * Use this to only allow specific domains to consume this provider. The
	 * patterns can contain the wildcards ? and * as in the examples
	 * 'http://example.com', '.foo.com' and 'dom?.com', or they can be regular
	 * expressions starting with ^ and ending with $. If none of the patterns
	 * match an Error will be thrown.
	 */
	public XdmSocket setAcl(JsArrayString value) {
		JsoHelper.setAttribute(proxyConfig, "acl", value);
		return this;
	}

	/**
	 * If you set this to a function, then this will be called once the
	 * communication has been
	 */
	public native XdmSocket setOnReady(Function callback)/*-{
		var config = this.@com.ait.toolkit.xdm.client.XdmSocket::proxyConfig;
		config.onMessage = function() {
			callback.@com.ait.toolkit.core.client.Function::execute()();
		};
		return this;
	}-*/;

	public native XdmSocket setMessageCallback(XdmMessageCallback callback)/*-{
		var config = this.@com.ait.toolkit.xdm.client.XdmSocket::proxyConfig;
		config.onMessage = function(message, origin) {
			callback.@com.ait.toolkit.xdm.client.XdmMessageCallback::onMessage(Ljava/lang/String;Ljava/lang/String;)(message, origin);
		};
		return this;
	}-*/;

	/**
	 * Set this to true if you want to have the swf/iframe placed visibly
	 * (20x20px top right corner) in order to avoid being throttled in newer
	 * versions of Flash
	 * 
	 * 
	 */
	public XdmSocket setSwfNoThrottle(boolean value) {
		JsoHelper.setAttribute(proxyConfig, "swfNoThrottle", value);
		return this;
	}

	/**
	 * Set this if you want to control where the swf is placed.
	 * 
	 * 
	 */
	public XdmSocket setSwfContainer(String value) {
		JsoHelper.setAttribute(proxyConfig, "swfContainer", value);
		return this;
	}

	/**
	 * Set this if you want to control where the swf is placed.
	 * 
	 * 
	 */
	public XdmSocket setSwfContainer(Element value) {
		JsoHelper.setAttribute(proxyConfig, "swfContainer", value);
		return this;
	}

	// These properties can be set only on the consumer
	/**
	 * If you set this to true then the iframe will not be created until the
	 * first use of the Socket
	 */
	public XdmSocket setLazy(boolean value) {
		JsoHelper.setAttribute(proxyConfig, "lazy", value);
		return this;
	}

	/**
	 * Set this to an id if you want the iframe to be visible for interaction.
	 * 
	 * 
	 */
	public XdmSocket setContainer(String value) {
		JsoHelper.setAttribute(proxyConfig, "container", value);
		return this;
	}

	/**
	 * Set this to an element if you want the iframe to be visible for
	 * interaction.
	 * 
	 * 
	 */
	public XdmSocket setContainer(Element value) {
		JsoHelper.setAttribute(proxyConfig, "container", value);
		return this;
	}

	/**
	 * The key/value pairs of this object will be deep-copied onto the iframe.
	 * As an example, use props: {style: {border: "1px solid red"} } to set the
	 * border of the iframe to 1px solid red.
	 * 
	 * 
	 */
	public XdmSocket setProps(JavaScriptObject value) {
		JsoHelper.setAttribute(proxyConfig, "props", value);
		return this;
	}

	/**
	 * To enable the NameTransport as a fallback, set this to point to the
	 * name.html file on the provider.
	 * 
	 * 
	 */
	public XdmSocket setRemoteHelper(String value) {
		JsoHelper.setAttribute(proxyConfig, "remoteHelper", value);
		return this;
	}

	/**
	 * Whether to pass the setup data using the hash instead of using the query.
	 * This is mainly useful in scenarios where query arguments affects
	 * efficient caching or where the providers HTTP server does not support
	 * URL's with query parameters. Using the hash is not compatible with hash
	 * based history managers etc.
	 */
	public XdmSocket setHash(boolean value) {
		JsoHelper.setAttribute(proxyConfig, "hash", value);
		return this;
	}

	// These properties can be set only on the consumer

	/**
	 * Use this to only allow specific domains to consume this provider. The
	 * patterns can contain the wildcards ? and * as in the examples
	 * 'http://example.com', '.foo.com' and 'dom?.com', or they can be regular
	 * expressions starting with ^ and ending with $. If none of the patterns
	 * match an Error will be thrown.
	 */
	public XdmSocket setAcl(String... acls) {
		JsArrayString values = JsArrayString.createArray().cast();
		for (String s : acls) {
			values.push(s);
		}
		return setAcl(values);

	}

	// Instance methods
	public native void postMessage(String message)/*-{
		var peer = this.@com.ait.toolkit.xdm.client.XdmSocket::peer;
		var config = this.@com.ait.toolkit.xdm.client.XdmSocket::proxyConfig;
		if (peer == null) {
			peer = new $wnd.easyXDM.Socket(config);
		}
		peer.postMessage(message);
	}-*/;

	public native void destroy()/*-{
		var peer = this.@com.ait.toolkit.xdm.client.XdmSocket::peer;
		if (peer == null) {
			peer.destroy();
		}
	}-*/;

}
