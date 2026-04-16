import { useState } from "react";
import axios from "axios";

function Chat() {

  const [q, setQ] = useState("");
  const [res, setRes] = useState(null);

  const ask = async () => {
    const response = await axios.post("http://localhost:8080/api/chat", {
      question: q
    });

    setRes(response.data);
  };

  return (
    <>
      <input onChange={(e) => setQ(e.target.value)} />
      <button onClick={ask}>Ask</button>

      {res && (
        <>
          <p>{res.answer}</p>
          <p>Timestamp: {res.timestamp}</p>
        </>
      )}
    </>
  );
}

export default Chat;