package com.apress.prospring5.ch4;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.GenericApplicationContext;

public class ShutdownHookBean implements ApplicationContextAware {
    private ApplicationContext ctx;

    /** @Implements {@link ApplicationContextAware#setApplicationContext(ApplicationContext)}  }*/
    public void setApplicationContext(ApplicationContext ctx)
        throws BeansException {
        System.out.println("Setting application context aware from ApplicationContextAware");
        if (ctx instanceof GenericApplicationContext) {
            ((GenericApplicationContext) ctx).registerShutdownHook();
        }
    }
}
