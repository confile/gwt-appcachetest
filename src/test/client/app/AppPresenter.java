package test.client.app;



import test.client.gin.places.NameTokens;

import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplit;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.gwtplatform.mvp.client.proxy.RevealRootContentEvent;

public class AppPresenter extends Presenter<AppPresenter.MyView, AppPresenter.MyProxy>  {


	
	public interface MyView extends View {

	}
	

	@NameToken(NameTokens.start)
	@ProxyCodeSplit
	public interface MyProxy extends ProxyPlace<AppPresenter> {
	}


	
	@Inject
	public AppPresenter(final EventBus eventBus, final MyView view,
			final MyProxy proxy) {
		super(eventBus, view, proxy);
	}

	
	@Override
	protected void revealInParent() {
//		RootPanel.get("loading").getElement().getStyle().setProperty("display", "none");
		RevealRootContentEvent.fire(this, this);
	}

	
	
	
}
