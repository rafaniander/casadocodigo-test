package br.com.casadocodigo.loja.validation;

import br.com.casadocodigo.loja.models.Product;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class ProductValidator implements Validator {

    @Override
    public boolean supports(Class<?> classe) {
        return Product.class.isAssignableFrom(classe);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "field.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", "field.required");
        
        Product product = (Product) target;
        
        if (product.getPages() == 0) {
            errors.reject("pages", "field.required");
        }
    }
    
}
