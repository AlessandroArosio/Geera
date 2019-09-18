package com.alessandro.computershare.i18n;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

@Component
public class I18NSupport {

  public I18NSupport() {
  }

  @Autowired
  MessageSource messageSource;

  public String getMessage(String key) {
    if (key == null) {
      return null;
    }
    return messageSource.getMessage(key, null, null);
  }
}
