package com.alessandro.computershare.i18n;

import org.springframework.context.NoSuchMessageException;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ApplicationObjectSupport;
import org.springframework.stereotype.Component;

@Component
public class ObjectSupport extends ApplicationObjectSupport {

  public ObjectSupport() {
  }

  boolean isTranslatingVariation() {
    String variant = LocaleContextHolder.getLocale().getDisplayVariant();
    return variant != null && variant.equals("TRN");
  }

  public String getMessage(String key) {
    if (isTranslatingVariation()) {
      return key;
    } else {
      try {
        return getMessageSourceAccessor().getMessage(key);
      } catch (NoSuchMessageException e) {
        return null;
      }
    }
  }

  public String getMessage(String key, String... args) {

    if (isTranslatingVariation()) {
      return key + ":" + args;
    }

    try {
      return getMessageSourceAccessor().getMessage(key, args);
    } catch (NoSuchMessageException e) {
      return null;
    }
  }
}
