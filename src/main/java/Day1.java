import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Day1 {
    private final List<String> lines;
    private int position = 50;
    private int timesHitZero=0;


    public Day1() throws IOException {
        this.lines = Files.readAllLines(Paths.get("src/resources/dayOneInput"));
    }

    public int getPassword() {
        lines.forEach(line -> {
            final var count = Integer.parseInt(line.substring(1));
            if (line.startsWith("R")) {
                handleIncrease(count);
            } else {
                handleDecrease(count);
            }
        });
        return timesHitZero;
    }

    public void handleIncrease(final int count) {
        position+=count;
        while(position>99){
            timesHitZero++;
            position-=100;
        }
    }

    public void handleDecrease(final int count) {
        position-=count;
        while(position<0){
            timesHitZero++;
            position+=100;}
    }
}
