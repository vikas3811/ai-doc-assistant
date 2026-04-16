import { useRef, useEffect } from "react";

function Player({ timestamp }) {
  const videoRef = useRef();

  useEffect(() => {
    if (videoRef.current) {
      videoRef.current.currentTime = timestamp;
    }
  }, [timestamp]);

  return (
    <div>
      <h3>Player</h3>
      <video
        ref={videoRef}
        width="400"
        controls
        src="sample.mp4"
      />
    </div>
  );
}

export default Player;