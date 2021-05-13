Optiim UI Automation Testing & Instructions
Prepared by:
Ahmet VURDEM

QA Test Automation Engineer

vurdemahmet@gmail.com

https://www.linkedin.com/in/ahmet-vurdem

- Build Tool: Maven

- Test Framework: TestNG

UI Automation Testing:
https://www.hepsiburada.com/

QA:
Generating automation framework for the given task.

System Requirements:

√ Java 13 + SDK

√ Selenium Webdriver

√ Maven

√ TestNG

√ apache.poi

√ Extend Reports



Unzip the project

Reload maven dependencies from POM

Go **src -> test > java > com > optiim > tests > EndToEnd

To generate "HTML Maven Cucumber Report" ;

Input following maven command to verify and generate report :

mvn clean verify

Finally, to open the report directly in default browser please run:
open test-output/report.html

The HTML report of the execution is under :  Optiim > Screen Shot 2021-05-13 at 20.43.28.png


TASK

1. <http://www.hepsiburada.com/> sitesini açılacak ve anasayfanın açıldığını onaylayacak

2. Login ekranını açıp, bir kullanıcı ile login olacak ( daha önce siteye üyeliğin varsa o olabilir )

3. Ekranın üstündeki Search alanına 'samsung' yazip 'Ara' butonuna tıklayacak

4. Sol menüden 'Telefon' sonrasında 'Cep Telefonu' tıklayacak

5. Gelen sayfada samsung için sonuç bulunduğunu onaylayacak

6. Arama sonuçlarından 2. sayfaya tıklayacak ve açılan sayfada 2. sayfanın şu an gösterimde olduğunu onaylayacak

7. Üstten 5. ürünü tıklayacak

8. Ürün detayında 'Beğen' butonuna tıklayacak

9. 'Ürün listenize eklendi.' popup kontrolü yapacak

10. Ekranın en üstündeki hesabım alanında 'Beğendiklerim' tıklayacak

11. Açılan sayfada bir önceki sayfada beğendiklerime alınmış ürünün bulunduğunu onaylayacak

12. Beğendiklerime alınmış ürün bulunup seçilecek ve sepete eklenecek

13. 'Ürün sepete eklendi' popup kontrolü yapacak

14. Sepetim sayfasına gidecek

15. Sepete eklenen bu ürünün içine girilip 'Kaldır' butonuna basılacak, sepetimden çıkarılacak

16. Bu ürünün artik sepette olmadığını onaylayacak

2021 May®
