from langchain_community.vectorstores import FAISS
from langchain_openai import OpenAIEmbeddings

def create_vector_store(text):
    embedding = OpenAIEmbeddings()
    return FAISS.from_texts([text], embedding)