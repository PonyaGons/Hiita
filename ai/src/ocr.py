from pathlib import Path

from PIL import Image, ImageEnhance, ImageFilter
from PIL.JpegImagePlugin import JpegImageFile
import numpy as np

from read_utils import setup_ocr_tool

DATA_PATH = Path(__file__).parents[1].joinpath('data')

def split(img: JpegImageFile) -> list[JpegImageFile]:
    """おみくじの各テーブルを分割した画像を返す.
    物体検出モデルの使用を想定しているが，ひとまずはハードコーディング.

    Args:
        img (JpegImageFile): おみくじのPILイメージ

    Returns:
        list[JpegImageFile]: おみくじの各テーブルを分割した結果のPILイメージのリスト
    """
    img = np.array(img)
    
    # 物体検出処理
    img_first = img[330:640, 180:350]
    img_second = img[640:950, 180:350]
    img_third = img[970:1350, 180:350]

    return [img_first, img_second, img_third]

def enhance(img: JpegImageFile) -> JpegImageFile:
    """画像を二値化し，コントラストを上げて返す.

    Args:
        img (JpegImageFile): PILのイメージ

    Returns:
        Image: 二値化してコントラストを上げたPILイメージ
    """
    # グレースケールにしてコントラストを上げる
    img_g = img.convert('L')
    enhancer = ImageEnhance.Contrast(img_g)
    img_con = enhancer.enhance(2.0)
    return img_con

def preprocess(img:np.ndarray) -> Image.Image:
    """OCR処理をかける前に前処理を行う関数.

    Args:
        img (np.ndarray): 元の画像

    Returns:
        Image.Image: 前処理後の画像
    """
    img = Image.fromarray(img)
    # 解像度を上げるためバイリニア補間
    img = img.resize((img.size[0] * 4, img.size[1] * 4), resample=Image.BILINEAR)
    # エッジを強調するための膨張処理
    img = img.filter(ImageFilter.MaxFilter())
    img = img.filter(ImageFilter.MaxFilter())

    return img


if __name__ == '__main__':
    tool_path = '/usr/local/bin/tesseract'
    file_name = 'test_heian_cut.png'

    # 抽出対象
    keywords = ['縁談', '学業', '商業', '願望', '失物', '病気']
    
    # 画像の読み込みと対照箇所の分割
    img = Image.open(DATA_PATH.joinpath(file_name))
    imgs = split(enhance(img))
    
    # OCRの処理
    tool, builder = setup_ocr_tool(tool_path)
    texts = []
    for img in imgs:
        # 前処理(リサイズ, 膨張)
        img = preprocess(img)
        text = tool.image_to_string(img, lang='jpn_vert', builder=builder)
        texts.append(text)
    
    # 特定のカテゴリを抽出
    oracles = {}
    texts = sum([text.split('\n') for text in texts], [])  # flatten
    for text in texts:
        for key in keywords:
            if key in text:
                # おみくじは「⚪︎{カテゴリ名} {内容}」のフォーマット
                oracles[key] = text.split(' ')[1]
    print(oracles)
