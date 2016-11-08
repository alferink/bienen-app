package de.alferink.bee

import grails.util.Holders
import org.springframework.context.MessageSource
import org.springframework.context.i18n.LocaleContextHolder

class I18nUtils {

    static getLabel(Enum value) {
        MessageSource messageSource = Holders.applicationContext.getBean(MessageSource)
        return messageSource.getMessage("${value.getClass().name}.${value.name()}", new Object[0], value.name(),LocaleContextHolder.locale)
    }
}
