FROM python:latest

WORKDIR /usr/src/app

COPY rand_data.py requirements.txt ./
RUN pip install requests
RUN pip install --no-cache-dir -r requirements.txt

COPY rand_data.py ./
COPY . .
EXPOSE 8080
CMD ["python", "./rand_data.py"]
