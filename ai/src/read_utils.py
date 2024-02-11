import os
from pathlib import Path

import pyocr

DATA_PATH = Path(__file__).parents[1].joinpath('data')

def setup_ocr_tool(tool_path: str) -> list[object]:
    """OCRツールのTesseractのセットアップを行う

    Args:
        tool_path (Path): Tesseractへのパス

    Returns:
        list[object]: OCRのモデルとコンフィグクラス
    """
    TESSERACT_PATH = tool_path
    TESSDATA_PATH = '/usr/local/Cellar/tesseract/5.3.4/share/tessdata/'

    os.environ['PATH'] += os.pathsep + TESSERACT_PATH
    os.environ['TESSDATA_PREFIX'] = TESSDATA_PATH

    # Tesseactのモデル読み込みとパラメータ設定
    tool = pyocr.get_available_tools()[0]
    builder = pyocr.builders.TextBuilder(tesseract_layout=5)  # 縦書きは5, 横書きは6

    return tool, builder

if __name__ == '__main__':
    pass
