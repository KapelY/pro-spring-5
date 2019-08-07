package com.apress.prospring5.ch5;

import org.springframework.context.support.GenericXmlApplicationContext;

public class AspectJAnnotationDemo {
    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("classpath:spring/app-context-xml.xml");
        context.refresh();

        NewDocumentarist newDocumentarist = context.getBean(
                "documentarist", NewDocumentarist.class
        );
        newDocumentarist.execute();
    }
}
