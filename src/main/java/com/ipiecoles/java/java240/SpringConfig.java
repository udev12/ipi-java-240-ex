package com.ipiecoles.java.java240;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;


@Configuration
public class SpringConfig {
    @Bean
//    @Scope(value = "singleton") facultatif car défaut singleton
    public BitcoinService bitcoinService(){
        BitcoinService b = new BitcoinService(); // injection webpagemanager
        b.setWebPageManager(webPageManager());
//        return new BitcoinService();
        return b;
    }


    @Bean
    public ProduitManager produitManager(){
//        return new ProduitManager();
        ProduitManager p = new ProduitManager();
        p.setWebPageManager(webPageManager()); // injection webpagemanager
        p.setBitcoinService(bitcoinService());
        return p;
    }

    @Bean
    public WebPageManager webPageManager() {
//        WebPageManager w = new WebPageManager();
//        ProduitManager pm = new ProduitManager();
//        pm.setWebPageManager(w);
        System.out.println("Initialisation du WebPageManager");
        return new WebPageManager();
    }
}

//@Configuration
//public class SpringConfig {
////    @Bean(initMethod = "init", destroyMethod = "cleanup")
////    @Scope("prototype")
////    public BeanExemple beanExemple(){
////        BeanExemple be = new BeanExemple("Hello ");
////        be.setNom("World");
////        return be;
////    }
//
//
//    @Bean
////    @Scope(value = "singleton") facultatif car défaut singleton
//    public BitCoinService bitcoinService(){
//        return new BitcoinService();
//    }
//
//}
