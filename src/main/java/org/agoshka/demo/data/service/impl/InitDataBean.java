package org.agoshka.demo.data.service.impl;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.agoshka.demo.data.service.DataGenerator;

/**
 *
 * @author go
 */
@Component
public class InitDataBean implements InitializingBean {

    @Autowired
    DataGenerator serv;
    
    @Override
    public void afterPropertiesSet() throws Exception {
       serv.generateTemplateData();
    }
    
}
