package com.ipiecoles.java.java240;

import java.io.IOException;

public class BitcoinService {

    WebPageManager webPageManager;

    private BitcoinService bitcoinService;

    public WebPageManager getWebPageManager() {
        return webPageManager;
    }

    public void setWebPageManager(WebPageManager webPageManager) {
        this.webPageManager = webPageManager;
    }

    //    public BitcoinService getbitcoinService() {
//        return bitcoinService;
//    }

    private Double rate = null;

    private Boolean forceRefresh = false;

    /**
     * Méthode qui renvoie le cours du Bitcoin
     * @return le cours du bitcoin
     * @throws IOException si impossible d'accéder à la bourse
     */
    public Double getBitcoinRate() throws IOException {
        if(rate != null && !forceRefresh){
            String apiResponse = webPageManager.getPageContents("file:/C:/Users/p.villoud/price.json");
            System.out.println("Récupération du cours du bitcoin en cache...");
            return rate;
        }

        System.out.println("Récupération du cours du bitcoin sur site distant");
//        WebPageManager webPageManager = new WebPageManager();

//        String apiResponse = webPageManager.getPageContents("https://min-api.cryptocompare.com/data/price?fsym=BTC&tsyms=EUR");
        String apiResponse = webPageManager.getPageContents("file:/C:/Users/p.villoud/price.json");
        apiResponse = apiResponse.replace("{\"EUR\":","");
        apiResponse = apiResponse.replace("}","");
        rate = Double.parseDouble(apiResponse);
        return rate;
    }

    /**
     * Méthode qui renvoie l'équivalent en bitcoin du prix en euro passé en paramètre
     * @param prixEnEuro le prix à convertir
     * @return le prix en bitcoin au taux actuel
     * @throws IOException si impossible d'accéder à la bourse
     */
    public Double getBitcoinPrice(Double prixEnEuro) throws IOException {
        if(rate == null){
            getBitcoinRate();
        }
        return prixEnEuro / rate;
    }

}
