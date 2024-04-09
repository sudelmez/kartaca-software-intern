Bu proje, arayüz olarak React kullanmaktadır. 
Cesium map ile 3 boyutlu bir şekilde dünya haritası üzerinde backend'den gelen depremler anlık olarak gösterilmektedir.
Backend, java- spring boot projesidir. 
Scriptler python ile yazılmıştır. Her türlü bağımlığın indirilmesi için docker-compose üzerindeki herbir
container için Dockerfile dosyaları yer almaktadır.

Projede, compose.yml dosyasına `apache-flinki` eklenip çalıştırılmaktadır. 
`Fakat java üzerine entegre edilmemiştir. Scriptten gelen verileri, sql veritabanına kaydedilip arayüzde gösterilmektedir.`

Makefile içerisindeki komutlar, tüm projeyi ayağa kaldırmak için yeterlidir.

```bash
    make build_docker_compose
````
direkt olarak projeyi çalıştıracaktır.
ardından, 
```bash
    make run_py
````
komutu, input alan python script dosyasını çalıştıracaktır.

Kullanılan Portlar:
    - 3000 (arayüz)
    - 8080 (backend)
    - 8083 , 8082 (scripts)
    - 8081 (apache flink)
    