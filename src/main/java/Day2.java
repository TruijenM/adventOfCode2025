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

    public long getInvalidSumPart1() {
        ranges.forEach(range -> {
            final var stringParts = range.split("-");
            handleRangePart1(Long.parseLong(stringParts[0]), Long.parseLong(stringParts[1]));
        });

        return invalidIdSum;
    }

    public void handleRangePart1(final long start, final long end) {
        for (long i = start; i <= end; i++) {
            final var numberAsString = String.valueOf(i);
            final var firstHalf = numberAsString.substring(0, numberAsString.length() / 2);
            final var secondHalf = numberAsString.substring(numberAsString.length() / 2);

            if (firstHalf.equals(secondHalf)) {
                invalidIdSum += i;
            }
        }
    }
    public long getInvalidSumPart2() {
        ranges.forEach(range -> {
            final var stringParts = range.split("-");
            handleRangePart2(Long.parseLong(stringParts[0]), Long.parseLong(stringParts[1]));
        });
        return invalidIdSum;
    }

    public void handleRangePart2(final long start, final long end) {
        for (long i = start; i <= end; i++) {
            final var numberAsString = String.valueOf(i);

            for (int j = 0; j <= numberAsString.length()/2; j++) {
                    final var partialString = numberAsString.substring(0, j);
                    final var regexString = "^(" + partialString + ")+$";
                    if (numberAsString.matches(regexString)) {
                        invalidIdSum += i;
                        break;
                }
            }
        }
    }



}
