from langchain_community.chat_models import ChatOpenAI

def build_qa(vector_store):
    llm = ChatOpenAI(model="gpt-4o-mini")

    def ask(question):
        docs = vector_store.similarity_search(question)
        context = " ".join([doc.page_content for doc in docs])

        prompt = f"Answer based on context:\n{context}\n\nQuestion: {question}"

        return llm.predict(prompt)

    return ask