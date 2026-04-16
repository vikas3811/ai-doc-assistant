from fastapi import FastAPI, UploadFile, File
from pydantic import BaseModel
import shutil
import os

app = FastAPI()
os.makedirs("temp", exist_ok=True)


class Question(BaseModel):
    question: str


@app.post("/process")
async def process(file: UploadFile = File(...)):
    print("Received file:", file.filename)

    file_path = f"temp/{file.filename}"
    with open(file_path, "wb") as buffer:
        shutil.copyfileobj(file.file, buffer)

    return {"message": "ok"}


# ✅ VERY IMPORTANT CHANGE
@app.post("/ask")
async def ask(data: Question):
    print("Question:", data.question)

    # 🔥 RETURN STRING (NOT JSON)
    return f"Answer: {data.question}"