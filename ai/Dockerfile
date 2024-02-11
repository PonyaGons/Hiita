FROM python:3.10

RUN apt -y update \
&& apt -y install tesseract-ocr tesseract-ocr-jpn libtesseract-dev libleptonica-dev tesseract-ocr-script-jpan tesseract-ocr-script-jpan-vert\
&& pip install pytesseract pillow pyocr numpy fastapi uvicorn \
&& wget -P /usr/share/tesseract-ocr/5/tessdata https://github.com/tesseract-ocr/tessdata_best/raw/main/jpn_vert.traineddata

COPY src /src
COPY data /data

WORKDIR /src

CMD [ "uvicorn", "main:app", "--host", "0.0.0.0" ]
