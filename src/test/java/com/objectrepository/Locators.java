package com.objectrepository;

import org.openqa.selenium.By;

public class Locators {
	 public static By homeLoginBtn = By.xpath("//*[@id=\"commercialIndex\"]/header/section[1]/div/div[2]/div[2]/a");
	 public static By innerLoginBtn = By.xpath("//*[@id=\"commercialIndex\"]/header/section[1]/div/div[2]/div[2]/div/div[2]/a");
	 public static By googleLoginBtn = By.xpath("//*[@id=\"my-signin2\"]/div/div");
	 public static By phonenumber = By.xpath("//*[@id=\"emailOrMobile\"]");
	 public static By nextbtn = By.id("btnStep1");
	 
	 
	 public static By captacha = By.xpath("//*[@id=\"captchaCodeSignIn\"]");
	 public static By otp1 = By.id("verify01");
	 public static By otp2 = By.id("verify02");
	 public static By otp3 = By.id("verify03");
	 public static By otp4 = By.id("verify04");
	 
	 
     public static By continuebtn = By.xpath("//*[@id=\"verifyOtpDiv\"]/div[2]/div[3]/button");
     public static By closepopup = By.xpath("//*[@id=\"userOnboardingWidget\"]/div/div[1]");
     
   
     
    public static By enterlocation = By.id("keyword");
    //ivalid loc
     
    // public static By clicklocation=By.xpath("//*[@id=\"keyword\"]");
     public static By deselectchennai=By.xpath("//*[@id=\"keyword_autoSuggestSelectedDiv\"]/div/div[2]");
     public static By loc=By.xpath("//*[@id=\"keyword\"]");
     public static By selectbgl =By.xpath("//*[@id=\"serachSuggest\"]/div[2]/span");
     
     
     
     
     
     
     public static By clickPropertType = By.xpath("//*[@id=\"buy_proertyTypeDefault\"]");
     public static By dropdownProperType = By.xpath("//*[@id=\"propType_buy\"]/div[1]");
     public static By selectPropertyType = By.xpath("//*[@id=\"10002_10003_10021_10022\"]");//deselect flats
     public static By closePropertyType = By.xpath("//*[@id=\"buy_proertyTypeDefault\"]");
    // public static By clearPropertyType = By.xpath("//*[@id=\"propType_buy\"]/div[2]/div/div/div[1]/div[2]/div[4]");
     
     public static By clickBudget = By.id("rent_budget_lbl");
     public static By mindropdown=By.xpath("//*[@id=\"budgetMin\"]");
     public static By maxdropdown=By.xpath("//*[@id=\"budgetMax\"]");
     public static By closeBudget = By.xpath("//*[@id=\"rent_budget_lbl\"]");
     
     
     public static By searchButton = By.xpath("//*[@id=\"searchFormHolderSection\"]/section/div/div[1]/div[3]/div[4]");
    
     
     
     public static By sortBy = By.xpath("//*[@id=\"body\"]/div[5]/div/div/div[1]/div[1]/div/div[1]");
     public static By mostrecent = By.xpath("//*[@id=\"body\"]/div[5]/div/div/div[1]/div[1]/div/div[2]/ul/li[2]");
     
     
     public static By shortlistButton = By.xpath("//*[@id=\"cardid77759225\"]/div/div[1]/div[2]/span[2]");
    // public static By shortlistedPropertyCard = By.xpath("//*[@id=\"cardid81313823\"]/div[2]/div[1]");
     public static By shortlistTabHeader = By.xpath("//*[@id=\"m-tab-Shortlisted\"]");
     
     public static By mainshortlistbtn = By.xpath("//*[@id=\"propertysrp\"]/div[1]/div/div/div[2]/div[5]/span");
     public static By viewShortlistBtn = By.xpath("//*[@id=\"propertysrp\"]/div[1]/div/div/div[2]/div[5]/div/div/a");
    
     
     
     public static By shortlistedPropertyCard2 = By.xpath("//*[@id=\"cardid81259709\"]/div[2]/div[1]");
     
     
     
//     public static By photos=By.xpath("//*[@id=\"details\"]/div/div[4]/div[1]");
//     public static By firstphoto=By.xpath("//*[@id=\"propertyDetail\"]/div[4]/div[2]/div/div/div[1]/div[3]/div/div[1]/div[3]/div/ul/li[1]/img");
//     public static By rightarrow=By.xpath("//*[@id=\"myGallery\"]/div/a/div");
//     public static By cross=By.xpath("//*[@id=\"propertyDetail\"]/div[4]/div[2]/div/div/div[1]/div[3]/div/div/div/div[1]/div[1]/span[1]/a");
//     public static By navback=By.xpath("//*[@id=\"propertyDetail\"]/div[4]/div[2]/div/div/div[1]/div[3]/div/div[1]/div[1]/div/div[1]/span[1]");
     
     public static By offerElement = By.xpath("//*[@id=\"more-details\"]/div[2]/ul/li[4]/div[2]/a/div[1]");
     
     public static By aboutloc=By.xpath("//*[@id=\"stickyWebHeader\"]/div/div/div[2]/nav/ul/li[3]/a");
     public static By rightarrow=By.xpath("//*[@id=\"swiper-button-next\"]");
     public static By rating=By.xpath("//*[@id=\"localityDetailTabId\"]/div[2]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/span");
     
     
     
     
}