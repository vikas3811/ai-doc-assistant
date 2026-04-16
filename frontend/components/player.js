import ReactPlayer from "react-player";

function Player({ url, timestamp }) {

  return (
    <ReactPlayer
      url={url}
      controls
      onReady={(player) => player.seekTo(timestamp || 0)}
    />
  );
}

export default Player;