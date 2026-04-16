import whisper
import os

model = whisper.load_model("base")

async def transcribe(file):
    file_path = "temp_audio.wav"

    with open(file_path, "wb") as f:
        f.write(await file.read())

    result = model.transcribe(file_path)

    return result["text"], result["segments"]