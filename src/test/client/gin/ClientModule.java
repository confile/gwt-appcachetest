package test.client.gin;

import test.client.app.ApplicationModule;
import test.client.gin.places.NameTokens;

import com.gwtplatform.mvp.client.annotations.DefaultPlace;
import com.gwtplatform.mvp.client.annotations.ErrorPlace;
import com.gwtplatform.mvp.client.annotations.UnauthorizedPlace;
import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;
import com.gwtplatform.mvp.client.gin.DefaultModule;


public class ClientModule extends AbstractPresenterModule {
	

	@Override
	protected void configure() {
		install(new DefaultModule());
		
			install(new ApplicationModule());
		
		// for REST Dispatcher
//		install(new RestDispatchAsyncModule.Builder().build());
		
		
	
		
		// for client side caching https://groups.google.com/forum/#!searchin/gwt-platform/caching/gwt-platform/4GjHFL2_Sxo/eEk0ZgDcF9kJ
//		bind(Cache.class).to(DefaultCacheImpl.class).asEagerSingleton();
		
	
		bindConstant().annotatedWith(DefaultPlace.class).to(NameTokens.start);
		bindConstant().annotatedWith(ErrorPlace.class).to(NameTokens.start);
		bindConstant().annotatedWith(UnauthorizedPlace.class).to(NameTokens.start);


		// bind providers
			
		
	}
}
