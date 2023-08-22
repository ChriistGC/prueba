package com.prueba.sesion;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ConfigurationClassUtils;

/**
 * Bean definitions for {@link SesionApplication}.
 */
public class SesionApplication__TestContext001_BeanDefinitions {
  /**
   * Get the bean definition for 'sesionApplication'.
   */
  public static BeanDefinition getSesionApplicationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(SesionApplication.class);
    beanDefinition.setTargetType(SesionApplication.class);
    ConfigurationClassUtils.initializeConfigurationClass(SesionApplication.class);
    beanDefinition.setInstanceSupplier(SesionApplication$$SpringCGLIB$$0::new);
    return beanDefinition;
  }
}
