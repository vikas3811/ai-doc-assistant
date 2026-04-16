from langchain_community.embeddings import OpenAIEmbeddings
from langchain_community.vectorstores import FAISS

embedding = OpenAIEmbeddings()

def create_vector_store(text):
    return FAISS.from_texts([text], embedding)