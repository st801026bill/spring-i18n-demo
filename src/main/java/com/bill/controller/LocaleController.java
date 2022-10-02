package com.bill.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
public class LocaleController {
    @Autowired
    private MessageSource messageSource;

    @Operation(summary = "Message", description = "Message")
    @GetMapping("/message")
    public String message(@RequestParam(required = false) String lang) {
        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage("current.locale", null, locale);
    }
}
