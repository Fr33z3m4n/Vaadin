package de.fastwebs24;

import com.vaadin.flow.data.binder.ErrorMessageProvider;
import com.vaadin.flow.data.binder.Result;
import com.vaadin.flow.data.binder.ValueContext;
import com.vaadin.flow.data.converter.Converter;

public class DoubleToIntegerConverter implements Converter<Double, Integer> {

	private static final long serialVersionUID = 1L;

	private ErrorMessageProvider errorMessageProvider;
	private Integer emptyValue;

	public DoubleToIntegerConverter(String errorMessage) {
		this(ctx -> errorMessage);
	}

	public DoubleToIntegerConverter(ErrorMessageProvider errorMessageProvider) {
		this(0, errorMessageProvider);
	}
	
	public DoubleToIntegerConverter(Integer emptyValue, ErrorMessageProvider errorMessageProvider) {
		this.emptyValue = emptyValue;
		this.errorMessageProvider = errorMessageProvider;
	}

	protected String getErrorMessage(ValueContext context) {
		return errorMessageProvider.apply(context);
	}

	@Override
	public Result<Integer> convertToModel(Double presentation, ValueContext valueContext) {
		if (presentation == null)
			return Result.error(getErrorMessage(valueContext));
		return Result.ok(presentation.intValue());
	}

	@Override
	public Double convertToPresentation(Integer model, ValueContext valueContext) {
		return model == null ? emptyValue : model.doubleValue();
	}
}
