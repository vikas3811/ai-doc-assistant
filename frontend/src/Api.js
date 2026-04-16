const BASE_URL = "http://localhost:8080";

export const uploadFile = async (file) => {
  const formData = new FormData();
  formData.append("file", file);

  return fetch(`${BASE_URL}/upload`, {
    method: "POST",
    body: formData,
  });
};

export const askQuestion = async (question) => {
  return fetch(`${BASE_URL}/chat`, {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify({ question }),
  }).then(res => res.text());
};