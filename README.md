🚀 Built as part of SDE-1 Assignment demonstrating full-stack + AI integration skills


# 🤖 AI-Powered Document & Multimedia Q&A Web App

An intelligent full-stack web application that allows users to upload **PDFs, audio, and video files** and interact with them using an AI-powered chatbot.

---

## 🚀 Features

* 📄 Upload PDF documents
* 🎧 Upload audio & video files
* 🧠 AI-based Question Answering
* 📝 Automatic Summarization
* ⏱️ Timestamp extraction for media
* ▶️ Play relevant section of audio/video
* 🔍 Semantic search using vector embeddings

---

## 🏗️ Architecture

```
Frontend (React)
        ↓
Backend (Spring Boot)
        ↓
AI Service (FastAPI + LangChain + Whisper)
```

---

## 🛠️ Tech Stack

### Backend

* Java, Spring Boot
* REST APIs
* WebClient for microservice communication

### AI Service

* FastAPI (Python)
* LangChain (LLM orchestration)
* OpenAI API
* Whisper (speech-to-text)
* FAISS (vector search)

### Frontend

* React.js
* Axios
* HTML5 Video/Audio player

---

## ⚙️ Setup Instructions

### 🔹 1. Clone Repository

```
git clone https://github.com/your-username/ai-doc-assistant.git
cd ai-doc-assistant
```

---

### 🔹 2. Start AI Service

```
cd ai-service
pip install -r requirements.txt
python -m uvicorn main:app --reload --port 8001
```

---

### 🔹 3. Start Backend

```
cd backend
mvn spring-boot:run
```

---

### 🔹 4. Start Frontend

```
cd frontend
npm install
npm start
```

---

## 📡 API Endpoints

| Endpoint   | Method | Description             |
| ---------- | ------ | ----------------------- |
| `/process` | POST   | Upload and process file |
| `/ask`     | POST   | Ask question            |

---

## 🧪 How It Works

1. User uploads file (PDF/audio/video)
2. AI service extracts text (Whisper for media)
3. Text is converted to embeddings (FAISS)
4. User asks question
5. System retrieves relevant context
6. LLM generates answer + timestamp

---

## 🎥 Demo Video

👉 [Add your YouTube / Google Drive link here]

---

## 📌 Highlights

* Microservices architecture
* Real-time AI interaction
* Semantic search with embeddings
* Timestamp-based media navigation
* Scalable design

---

## 🚀 Future Improvements

* Authentication (JWT/OAuth)
* Cloud deployment (AWS/GCP)
* Real-time streaming responses
* Multi-user support

---

## 👨‍💻 Author

**Vikas Kumar**
📧 [vikaskr3811@gmail.com](mailto:vikaskr3811@gmail.com)
🔗 LinkedIn: https://linkedin.com/in/vikas3811
🔗 GitHub: https://github.com/vikas3811

---

## ⭐ If you like this project, give it a star!
