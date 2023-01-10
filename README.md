# CitizenProject
1. src dosyası react dosyasıdır.
2. Entity class oluşturuldu. Gerekli tüm annotations eklendi.
3. Repository class oluşturuldu. Extend edildi.
4. Endpointler için bir RestApi class oluşturuldu. Controller içinde kullanıldı. 
5. Exception package kuruldu. İçindeki classlarda Http hataları tanımlanıp, gerekli methodlarda kullanildi. 
6. Service class icerisimde CRUD icin gerekli tanımlamalar yapıldı.
7. Controller class içinden Service ile iletişim kuracak CRUD islemleri eklendi. 
8. Service icin kullanılan iki class var. IService ve ServiceManager. Genel kullanıma sahip iki class olup, extend ederek servis tanımlamalarıı yapıldı.
9. Children eklemek icin ekstra bir method tanımlandı. Citizen save dedikten sonra kisini cocuk ataması yapabiliyoruz.
10. React projesi hazırlandı. Listeleme,filtreleme ve kayıt sayısı görüntüleme tanımlandı.
