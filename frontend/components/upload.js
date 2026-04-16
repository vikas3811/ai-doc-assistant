import axios from "axios";

function Upload() {

  const uploadFile = async (e) => {
    const file = e.target.files[0];

    const formData = new FormData();
    formData.append("file", file);

    await axios.post("http://localhost:8080/api/files/upload", formData);

    await axios.post("http://localhost:8001/process", formData);
  };

  return <input type="file" onChange={uploadFile} />;
}

export default Upload;