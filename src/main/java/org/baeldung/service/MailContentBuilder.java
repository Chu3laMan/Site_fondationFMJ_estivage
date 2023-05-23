package org.baeldung.service;

import org.baeldung.web.util.MailContent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Service
public class MailContentBuilder {

    private TemplateEngine templateEngine;

    @Autowired
    public MailContentBuilder(TemplateEngine templateEngine) {
        this.templateEngine = templateEngine;
    }

    public String buildCustom(MailContent mailContent) {
        Context context = new Context();
        context.setVariable("mailContent", mailContent); 
        return templateEngine.process("Admin/email_templates/action", context);
    }
    
    public String build(String message) {
        Context context = new Context();
        context.setVariable("message", message);
        return templateEngine.process("Admin/email_templates/action", context);
    }
}