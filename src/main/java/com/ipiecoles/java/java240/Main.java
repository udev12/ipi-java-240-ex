package com.ipiecoles.java.java240;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws IOException {

        ApplicationContext ctx = null;
        ctx = new AnnotationConfigApplicationContext(SpringConfig.class); // config java
        // ou ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class); // config java

//        ApplicationContext ctx1 = new
//        ctx = new ClassPathXmlApplicationContext("applicationContext.xml"); // config xml
        BitcoinService bitcoinService = ctx.getBean((BitcoinService.class));



//        ProduitManager pm = new ProduitManager();
        ProduitManager pm = ctx.getBean(ProduitManager.class);

//        WebPageManager webPageManager = ctx.getBean(WebPageManager.class);
//        WebPageManager webPageManager = new WebPageManager();
//        pm.setWebPageManager(webPageManager);
//        BitcoinService bitcoinService = new BitcoinService();
//        bitcoinService.setWebPageManager(webPageManager);
//        pm.setBitcoinService(bitcoinService);




        System.out.println("Bienvenue !");
        while(true){
            System.out.println("Vous souhaitez : ");
            System.out.println("1 - Connaître le cours du bitcoin");
            System.out.println("2 - Ajouter un produit au catalogue");
            System.out.println("3 - Voir tous les produits du catalogue");
            System.out.println("4 - Voir les détails d'un produit");
            System.out.println("5 - Initialiser le catalogue");
            System.out.println("0 - Quitter");
            Scanner scanner = new Scanner(System.in);
            int saisie = scanner.nextInt();
            switch (saisie){
                case 1:
                    System.out.println("1 BTC = " + bitcoinService.getBitcoinRate() + " €");
                    break;
                case 2:
                    pm.ajouterProduit();
                    break;
                case 3:
                    pm.afficherTousLesProduits();
                    break;
                case 4:
                    System.out.println("Quel numéro de produit ?");
                    pm.afficherDetailProduit(scanner.nextInt());
                    break;
                case 5:
                    pm.initialiserCatalogue();
                    break;
                case 0:
                    System.out.println("Au revoir !");
                    return;
            }
        }
    }
}


//public class Main {
//
//    public static void main(String[] args) throws IOException {
//        ProduitManager pm = new ProduitManager();
//        WebPageManager webPageManager = new WebPageManager();
//        pm.setWebPageManager(webPageManager);
//
//
//
//        BitcoinService bitcoinService = new BitcoinService();
//        bitcoinService.setWebPageManager(webPageManager);
//        pm.setBitcoinService(bitcoinService);
////        private BitcoinService bitcoinService;
////        public BitcoinService getbitcoinService() {
////            return bitcoinService;
////        }
//
//        System.out.println("Bienvenue !");
//        while(true){
//            System.out.println("Vous souhaitez : ");
//            System.out.println("1 - Connaître le cours du bitcoin");
//            System.out.println("2 - Ajouter un produit au catalogue");
//            System.out.println("3 - Voir tous les produits du catalogue");
//            System.out.println("4 - Voir les détails d'un produit");
//            System.out.println("5 - Initialiser le catalogue");
//            System.out.println("0 - Quitter");
//
//            Scanner scanner = new Scanner(System.in);
//            int saisie = scanner.nextInt();
//            switch (saisie){
//                case 1:
//                    BitcoinService bitcoinService = new BitcoinService();
//                    System.out.println("1 BTC = " + bitcoinService.getBitcoinRate() + " €");
//                    break;
//                case 2:
//                    pm.ajouterProduit();
//                    break;
//                case 3:
//                    pm.afficherTousLesProduits();
//                    break;
//                case 4:
//                    System.out.println("Quel numéro de produit ?");
//                    pm.afficherDetailProduit(scanner.nextInt());
//                    break;
//                case 5:
//                    pm.initialiserCatalogue();
//                    break;
//                case 0:
//                    System.out.println("Au revoir !");
//                    return;
//            }
//        }
//    }
//}
