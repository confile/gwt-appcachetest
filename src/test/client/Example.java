package test.client;

import javax.annotation.Nonnull;

import org.realityforge.gwt.appcache.client.ApplicationCache;
import org.realityforge.gwt.appcache.client.event.CachedEvent;
import org.realityforge.gwt.appcache.client.event.CachedEvent.Handler;
import org.realityforge.gwt.appcache.client.event.CheckingEvent;
import org.realityforge.gwt.appcache.client.event.DownloadingEvent;
import org.realityforge.gwt.appcache.client.event.ErrorEvent;
import org.realityforge.gwt.appcache.client.event.NoUpdateEvent;
import org.realityforge.gwt.appcache.client.event.ObsoleteEvent;
import org.realityforge.gwt.appcache.client.event.ProgressEvent;
import org.realityforge.gwt.appcache.client.event.UpdateReadyEvent;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.InlineHTML;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public final class Example  implements EntryPoint {

	
//	private static final ApplicationController controller = GWT.create(ApplicationController.class);
	
	
	public void onModuleLoad() {
		
//	    controller.init();
		
    final VerticalPanel panel = new VerticalPanel();
   
    final ApplicationCache cache = ApplicationCache.getApplicationCacheIfSupported();
    if ( null == cache )
    {
      Window.alert( "ApplicationCache not available!" );
    }
    else
    {
      final VerticalPanel textPanel = new VerticalPanel();

      cache.addCachedHandler( new Handler()
      {
        @Override
        public void onCachedEvent( @Nonnull final CachedEvent event )
        {
          appendText( textPanel, "Cached", "blue" );
        }
      } );
      cache.addCheckingHandler( new CheckingEvent.Handler()
      {
        @Override
        public void onCheckingEvent( @Nonnull final CheckingEvent event )
        {
          appendText( textPanel, "Checking", "yellow" );
        }
      } );
      cache.addDownloadingHandler( new DownloadingEvent.Handler()
      {
        @Override
        public void onDownloadingEvent( @Nonnull final DownloadingEvent event )
        {
          appendText( textPanel, "Downloading", "orange" );
        }
      } );
      cache.addErrorHandler( new ErrorEvent.Handler()
      {
        @Override
        public void onErrorEvent( @Nonnull final ErrorEvent event )
        {
          appendText( textPanel, "Error", "red" );
        }
      } );
      cache.addNoUpdateHandler( new NoUpdateEvent.Handler()
      {
        @Override
        public void onNoUpdateEvent( @Nonnull final NoUpdateEvent event )
        {
          appendText( textPanel, "NoUpdate", "green" );
        }
      } );
      cache.addObsoleteHandler( new ObsoleteEvent.Handler()
      {
        @Override
        public void onObsoleteEvent( @Nonnull final ObsoleteEvent event )
        {
          appendText( textPanel, "Obsolete", "yellow" );
        }
      } );
      cache.addProgressHandler( new ProgressEvent.Handler()
      {
        @Override
        public void onProgressEvent( @Nonnull final ProgressEvent event )
        {
          if ( event.isLengthComputable() )
          {
            appendText( textPanel, "Progress[" + event.getLoaded() + " of " + event.getTotal() + "]", "orange" );
          }
          else
          {
            appendText( textPanel, "Progress", "orange" );
          }
        }
      } );
      cache.addUpdateReadyHandler( new UpdateReadyEvent.Handler()
      {
        @Override
        public void onUpdateReadyEvent( @Nonnull final UpdateReadyEvent event )
        {
          appendText( textPanel, "UpdateReady", "green" );
        }
      } );
      {
        final Button button = new Button( "Request cache update" );
        button.addClickHandler( new ClickHandler()
        {
          @Override
          public void onClick( final ClickEvent event )
          {
            cache.requestUpdate();
          }
        } );
        panel.add( button );
      }

      {
        final Button button = new Button( "Request removal of cache" );
        button.addClickHandler( new ClickHandler()
        {
          @Override
          public void onClick( final ClickEvent event )
          {
            cache.removeCache();
          }
        } );
        panel.add( button );
      }

      {
        final Button button = new Button( "Request cache swap" );
        button.addClickHandler( new ClickHandler()
        {
          @Override
          public void onClick( final ClickEvent event )
          {
            cache.swapCache();
          }
        } );
        panel.add( button );
      }
      {
        final Button button = new Button( "Abort cache download" );
        button.addClickHandler( new ClickHandler()
        {
          @Override
          public void onClick( final ClickEvent event )
          {
            cache.abort();
          }
        } );
        panel.add( button );
      }

      {
        final Button button = new Button( "Show image from cache" );
        button.addClickHandler( new ClickHandler()
        {
          @Override
          public void onClick( final ClickEvent event )
          {
        	  GWT.log("GWT.getModuleBaseURL(): "+GWT.getModuleBaseURL());
        	  
            panel.add( new Image( "http://127.0.0.1:8080/bonsaitree.jpg" ) );
          }
        } );
        panel.add( button );
      }
      panel.add( textPanel );
      RootPanel.get().add( panel );
    }
    
    

    
  }

  private void appendText( final VerticalPanel panel, final String eventName, final String color )
  {
    panel.add( new InlineHTML( "<span style=\"color:" + color + "\">" + eventName + "</span><br />" ) );
  }
}
