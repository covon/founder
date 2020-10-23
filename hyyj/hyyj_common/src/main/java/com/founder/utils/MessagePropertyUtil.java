package com.founder.utils;

import org.springframework.context.MessageSource;

import java.util.Locale;

public class MessagePropertyUtil {

	private MessageSource messages;

    private Locale locale = Locale.CHINA;

	public void setMessages(MessageSource messages) {
        this.messages = messages;
    }

	/**
	 * @return the messages
	 */
	public MessageSource getMessages() {
		return messages;
	}

    public String getMessage(String code) {
        String msg = messages.getMessage(code, null, locale);
        return msg;
    }

    public String getMessage(String code, String[] params) {
        String msg;
        if (params == null || params.length == 0) {
            msg = getMessage(code);
        } else {
            msg = messages.getMessage(code, params, locale);
        }
        return msg;
    }

    public String getMessage(String code, String param) {
        String msg;
        if (param == null) {
            msg = getMessage(code);
        } else {
            msg = messages.getMessage(code, new String[] { param }, locale);
        }
        return msg;
    }

}
