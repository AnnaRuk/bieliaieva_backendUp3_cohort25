package de.ait.shop.validation.impl;

import de.ait.shop.validation.PasswordValidator;


public class PasswordNotEmptyValidatorImpl implements PasswordValidator {

    @Override
    public void validate(String password) {
        if (password == null || password.isBlank()) { // валидируем password
            throw new IllegalArgumentException("Password не может быть пустым");
        }
    }
}
