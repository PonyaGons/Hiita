import json
from pathlib import Path

import openai
openai.api_key = "your-api-key"

PROMPT_PATH = Path(__file__).parents[1].joinpath('scripts')

with open(PROMPT_PATH.joinpath('sys_prompt.txt', 'r')) as f:
    sys_prompt = f.read()

with open(PROMPT_PATH.joinpath('prompt.txt'), 'r') as f:
    query = f.read()

response = openai.ChatCompletion.create(
    model="gpt-3.5-turbo",
    messages=[
        {"role": "system", "content": "あなたはおみくじの専門家です．おみくじの結果に基づいて，自分の意見を述べてください"},
        {"role": "user", "content": query},
    ],
)
s = json.loads(response["choices"][0]["message"]["content"])
print(s)