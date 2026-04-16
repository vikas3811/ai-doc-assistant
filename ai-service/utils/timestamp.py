def find_timestamp(segments, query):
    for segment in segments:
        if query.lower() in segment["text"].lower():
            return segment["start"]
    return 0