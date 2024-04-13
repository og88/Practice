package com.og.videogamebacklog.main;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class listener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent e) {
      System.out.println("MyServletContextListener Context Initialized");
    }
  
    @Override
    public void contextDestroyed(ServletContextEvent e) {
      System.out.println("MyServletContextListener Context Destroyed");
    }
  
}
