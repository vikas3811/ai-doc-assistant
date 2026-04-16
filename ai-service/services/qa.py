from langchain_openai import ChatOpenAI

def ask_question(vector_store, question):
    docs = vector_store.similarity_search(question)

    context = docs[0].page_content if docs else ""

    llm = ChatOpenAI()

    response = llm.invoke(f"Context: {context}\nQuestion: {question}")

    return response.content