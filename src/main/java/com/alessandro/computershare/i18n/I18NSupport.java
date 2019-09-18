package com.alessandro.computershare.i18n;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component
public class I18NSupport {

  @Autowired
  protected ObjectSupport objectSupport;


  @Autowired MessageSource messageSource;

  public I18NSupport() {
  }

  public List<String> getSearchKeys(String initialKey) {
    /* Strip off any trailing dot */
    String currentKey = initialKey.endsWith(".") ? initialKey.substring(0, initialKey.length() - 1) : initialKey;

    List<String> keysToSearchFor = new ArrayList<String>();
    keysToSearchFor.add(currentKey);

    int lastDotIx = currentKey.lastIndexOf('.');
    while (lastDotIx > -1) {
      /* Find the penultimate dot */
      String tmp = currentKey.substring(0, lastDotIx);
      int lastButOneDotIx = tmp.lastIndexOf('.');
      if (lastButOneDotIx < 0) {
        currentKey = currentKey.substring(lastDotIx + 1);
      } else {
        /* Current key is the beginning to penultimate dot, and lastDot -> end */
        currentKey = currentKey.substring(0, lastButOneDotIx + 1) + currentKey.substring(lastDotIx + 1);
      }

      keysToSearchFor.add(currentKey);

      lastDotIx = currentKey.lastIndexOf('.');
    }
    return keysToSearchFor;
  }

  public String getMessage(String key) {
    if (key == null) {
      return null;
    }
    return getMessage(key, (String[]) null);
  }

  public String getMessage(String key, String... args) {
    List<String> keys = getSearchKeys(key);
    String message = getMessage(keys, args);
    return message == null ? key : message;
  }

  private String getMessage(List<String> keys, String... args) {
    String message = null;
    for (Iterator<String> it = keys.iterator(); it.hasNext() && message == null;) {
      String searchKey = it.next();
      if (args == null) {
        message = objectSupport.getMessage(searchKey);
      } else {
        message = objectSupport.getMessage(searchKey, args);
      }
    }

    return message;
  }
}
