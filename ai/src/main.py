import io
import base64
import json
from pathlib import Path

from fastapi import FastAPI
from fastapi.responses import JSONResponse
from PIL import Image

from ocr import preprocess, split, enhance
from read_utils import setup_ocr_tool

DATA_PATH = Path(__file__).parents[1].joinpath('data')

tool_path = '/usr/bin/tesseract'
file_name = 'test_heian_cut.png'
key_maps = {'縁談': 1, '学業': 2, '商業': 3, '願望': 4, '失物': 5, '病気': 6}
tool, builder = setup_ocr_tool(tool_path)

app = FastAPI()

def decode_base64_image(image_base64) -> Image.Image:
    """
    base64エンコードされた画像をデコードしてPIL画像に変換する関数
    """
    data = base64.b64decode(image_base64)
    img = Image.open(io.BytesIO(data))
    return img

@app.get('/')
def read_root():
    return {'health': 'ok'}


@app.post('/omikuji/scan')
def scan(img_base64: str):
    try:
        # decoded_image = decode_base64_image(img_base64)
        # 画像の読み込みと対照箇所の分割
        img = Image.open(DATA_PATH.joinpath(file_name))
        imgs = split(enhance(img))

        # OCRの処理
        texts = []
        for img in imgs:
            # 前処理(リサイズ, 膨張)
            img = preprocess(img)
            text = tool.image_to_string(img, lang='jpn_vert', builder=builder)
            texts.append(text)

        # 特定のカテゴリを抽出
        oracles = []
        texts = sum([text.split('\n') for text in texts], [])  # flatten
        for text in texts:
            for key in key_maps.keys():
                if key in text:
                    # おみくじは「⚪︎{カテゴリ名} {内容}」のフォーマット
                    element = {
                        'content': text.split(' ')[1],
                        'category': key_maps[key]
                    }
                    oracles.append(element)
                else:
                    continue

        response = {
            'fortune': '中吉',
            'category_fortune': oracles
        }
        # print(response)
        # return JSONResponse(status_code=200, content={'test': 'ok'})
        return response
    except Exception as e:
        return JSONResponse(status_code=500, content={"error": f"Failed to process image: {str(e)}"})

@app.post('/omikuji/score')
def score(params):
    try:
        # speciality = params['speciality']
        # categories = params['categories']

        ### ChatGPT API
        with open(DATA_PATH.joinpath('gpt_response.json'), 'r') as f:
            response = json.load(f)
        # print(response)
        # return JSONResponse(status_code=200, content={response})
        return response

    except Exception as e:
        return JSONResponse(status_code=500, content={"error": f"Failed to process scoring: {str(e)}"})
