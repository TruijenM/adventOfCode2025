import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class Day2 {
    private final List<String> ranges;
    private long invalidIdSum = 0;


    public Day2() throws IOException {
        var line = Files.readAllLines(Paths.get("src/resources/dayTwoInput"));
        ranges = Arrays.asList(line.get(0).split(","));
    }

    public long getInvalidSum() {
        ranges.forEach(range -> {
            final var stringParts = range.split("-");
            handleRange(Long.parseLong(stringParts[0]), Long.parseLong(stringParts[1]));
        });

        return invalidIdSum;
    }

    public void handleRange(final long start, final long end) {
        for (long i = start; i <= end; i++) {
            final var numberAsInt = String.valueOf(i);
            final var firstHalf = numberAsInt.substring(0, numberAsInt.length() / 2);
            final var secondHalf = numberAsInt.substring(numberAsInt.length() / 2);

            if (firstHalf.equals(secondHalf)) {
                invalidIdSum += i;
            }
        }
    }

}
