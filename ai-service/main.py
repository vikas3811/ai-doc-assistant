from fastapi import FastAPI, UploadFile
import shutil
import os

from services.transcription import transcribe
from services.embeddings import create_vector_store
from services.qa import build_qa
from utils.timestamp import find_timestamp

app = FastAPI()

vector_store = None
qa_chain = None
segments_store = []

# create temp folder if not exists
if not os.path.exists("temp"):
    os.makedirs("temp")


@app.post("/process")
async def process(file: UploadFile):
    global vector_store, qa_chain, segments_store

    file_path = f"temp/{file.filename}"

    # save uploaded file
    with open(file_path, "wb") as buffer:
        shutil.copyfileobj(file.file, buffer)

    # transcription (audio/video/pdf text)
    text, segments = transcribe(file_path)
    segments_store = segments

    # create embeddings + vector DB
    vector_store = create_vector_store(text)

    # build QA system
    qa_chain = build_qa(vector_store)

    return {"message": "File processed successfully"}


@app.post("/ask")
async def ask(q: dict):
    global qa_chain, segments_store

    if not qa_chain:
        return {"error": "Upload file first!"}

    question = q.get("question")

    # get answer
    answer = qa_chain(question)

    # find timestamp
    timestamp = find_timestamp(segments_store, question)

    return {
        "answer": answer,
        "timestamp": timestamp
    }