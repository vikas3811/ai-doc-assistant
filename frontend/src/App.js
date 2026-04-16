import React from "react";
import Upload from "./components/Upload";
import Chat from "./components/Chat";

function App() {
  return (
    <div style={{ padding: "20px" }}>
      <h1>AI Doc Assistant 🚀</h1>

      <Upload />
      <hr />
      <Chat />
    </div>
  );
}

export default App;