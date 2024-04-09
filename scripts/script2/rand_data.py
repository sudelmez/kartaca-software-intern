import requests
import random
import time

def add_random_earthquake_data():
    lat = random.uniform(-90, 90)
    lon = random.uniform(-180, 180)
    magnitude = random.uniform(1, 10)
    
    url = 'http://spring-boot:8080/earthquakes'
    data = {'lat': lat, 'lon': lon, 'magnitude': magnitude}
    response = requests.post(url, json=data, headers={"Content-Type": "application/json"})
    if response.status_code == 200:
        print("Rastgele veri başarıyla eklendi.")
    else:
        print("Rastgele veri eklenirken bir hata oluştu.")

def main():
    while True:
        try:
            add_random_earthquake_data()
            time.sleep(5) 
        except:
            print("Connection refused by the server..")
            print("Let me sleep for 1 seconds")
            print("ZZzzzz...")
            time.sleep(5)
            print("Was a nice sleep, now let me continue...")
            continue

if __name__ == "__main__":
    main()
