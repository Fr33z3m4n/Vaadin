package de.fastwebs24;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.PWA;
import de.fastwebs24.DoubleToIntegerConverter;
import de.fastwebs24.Person;


/**
 * The main view contains a button and a click listener.
 */
@Route("")
@PWA(name = "Project Base for Vaadin", shortName = "Project Base")
public class MainView extends VerticalLayout {

    public MainView() {
	
		//BeanValidationBinder<Person> binder = new BeanValidationBinder<Person>(Person.class);
		Binder<Person> binder = new Binder<Person>(Person.class);
		binder.setBean(new Person());

		NumberField numberField = new NumberField("Number");
		numberField.setHasControls(true);
		numberField.setMin(0);
		numberField.setMax(999);
		add(numberField);
		
		binder.forField(numberField).withConverter(new DoubleToIntegerConverter("Only Numbers allowed")).bind("number");
		
		Label lblValue = new Label("Number");
		add(lblValue);
		
		numberField.addValueChangeListener(e -> {
			lblValue.setText(binder.getBean().getNumber().toString());
		});
    }
}
