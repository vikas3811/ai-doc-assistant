import React, { useState } from "react";
import axios from "axios";

function Chat() {
  const [question, setQuestion] = useState("");
  const [response, setResponse] = useState("");

  const askQuestion = async () => {
  try {
    const res = await axios.post(
      "http://localhost:8081/api/chat",
      question
    );

    console.log(res.data);

    // ✅ HANDLE JSON RESPONSE
    setResponse(res.data.answer);

  } catch (err) {
    console.error(err);
    alert("Error getting response");
  }
};


  return (
    <div>
      <h3>Ask Question</h3>

      <input
        type="text"
        placeholder="Ask something..."
        value={question}
        onChange={(e) => setQuestion(e.target.value)}
      />

      <button onClick={askQuestion}>Ask</button>

      <p><strong>Answer:</strong> {response}</p>
    </div>
  );
}

export default Chat;