package test.server;

import org.realityforge.gwt.appcache.server.mgwt.AbstractMgwtManifestServlet;
import org.realityforge.gwt.appcache.server.mgwt.MobileUserAgentProvider;
import org.realityforge.gwt.appcache.server.mgwt.PhoneGapPropertyProvider;

//@WebServlet(urlPatterns = { "/example.appcache" })
//@WebServlet("/example/example.appcache")
//public class ManifestServlet extends AbstractManifestServlet
//{
//  /**
//	 * 
//	 */
//	private static final long serialVersionUID = -1788095762627945145L;
//
//public ManifestServlet()
//  {
//    addPropertyProvider( new UserAgentPropertyProvider() );
//    
//    addClientSideSelectionProperty("mgwt.os");
//    addClientSideSelectionProperty("mobile.user.agent");
//    
//   
//    addPropertyProvider( new UserAgentPropertyProvider() );
//  }
//}

//AbstractMgwtManifestServlet
// AbstractManifestServlet

public class ManifestServlet extends AbstractMgwtManifestServlet {

	private static final long serialVersionUID = -1788095762627945145L;

	public ManifestServlet() {
//		addPropertyProvider( new MgwtOsPropertyProvider() );
//	    addPropertyProvider( new UserAgentPropertyProvider() );
	    addPropertyProvider( new MobileUserAgentProvider() );
	    addPropertyProvider( new PhoneGapPropertyProvider() );
	}
	
}
