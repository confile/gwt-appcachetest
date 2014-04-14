package test.client.app;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewImpl;

public class AppView extends ViewImpl implements
		AppPresenter.MyView {

	

	public interface Binder extends UiBinder<Widget, AppView> {
	}

	@Inject
	public AppView(final Binder binder) {
		
		initWidget(binder.createAndBindUi(this));
		
	}

	
	
	
	
	
	
	
	
	
}
