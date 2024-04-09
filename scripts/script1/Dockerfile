FROM python:latest

WORKDIR /usr/src/app

COPY input_data.py requirements.txt ./
RUN pip install --no-cache-dir -r requirements.txt

COPY input_data.py ./
COPY . .
EXPOSE 8080
CMD ["bash", "-c", "python ./input_data.py"]

