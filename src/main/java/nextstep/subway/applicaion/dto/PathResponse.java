package nextstep.subway.applicaion.dto;

import nextstep.subway.domain.Path;

import java.util.List;
import java.util.stream.Collectors;

public class PathResponse {
    private List<StationResponse> stations;
    private int distance;
    private int duration;
    private int cost;

    public PathResponse(List<StationResponse> stations, int distance, int duration, int cost) {
        this.stations = stations;
        this.distance = distance;
        this.duration = duration;
        this.cost = cost;
    }


    public PathResponse(List<StationResponse> stations, int distance, int duration) {
        this.stations = stations;
        this.distance = distance;
        this.duration = duration;
    }

    public static PathResponse of(Path path, int cost) {
        List<StationResponse> stations = path.getStations().stream()
                .map(StationResponse::of)
                .collect(Collectors.toList());
        int distance = path.distance();
        int duration = path.duration();

        return new PathResponse(stations, distance, duration, cost);
    }

    public List<StationResponse> getStations() {
        return stations;
    }

    public int getDistance() {
        return distance;
    }

    public int getDuration() {
        return duration;
    }

    public int getCost() {
        return cost;
    }
}
