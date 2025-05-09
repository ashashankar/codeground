package com.myplayground.playground;

import lombok.Getter;
import lombok.Setter;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;

public class LowestOfAllStreams_MyVest implements Stream {
    private final List<Stream> streams;
    PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(Pair::getStreamValue));
    LowestOfAllStreams_MyVest(List<Stream> streams) {
        this.streams = streams;
        for (int i=0; i<streams.size(); i++) {
            if (streams.get(i) != null) {
                pq.offer(new Pair(i, streams.get(i).pop()));
            }
        }
    }

    @Override
    public int pop() {
        if (pq.isEmpty()) {
            throw new NoSuchElementException("queue is empty");
        }
        Pair p = pq.poll();
        int streamIdx = p.getStreamIndex();
        Stream s = streams.get(streamIdx);
        if (s != null) {
            int nextValue = s.pop();
            pq.offer(new Pair(streamIdx, nextValue));
        }
        return p.streamValue;
    }
}

interface Stream {
    int pop();
}

@Getter
@Setter
class Pair {
    int streamIndex;
    int streamValue;
    Pair(int idx, int value) {
        this.streamIndex = idx;
        this.streamValue = value;
    }
}
