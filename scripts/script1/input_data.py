import requests

def add_earthquake_data(lat, lon, magnitude):
    url = 'http://spring-boot:8080/earthquakes'
    data = {'lat': lat, 'lon': lon, 'magnitude': magnitude}
    response = requests.post(url, json=data, headers={"Content-Type": "application/json"})
    if response.status_code == 200:
        print("Veri başarıyla eklendi.")
    else:
        print("Veri eklenirken bir hata oluştu.")

def main():
    lat = float(input("Lattitude değerini girin: "))
    lon = float(input("Longitude değerini girin: "))
    magnitude = float(input("Şiddet değerini girin: "))
    
    add_earthquake_data(lat, lon, magnitude)

if __name__ == "__main__":
    main()
