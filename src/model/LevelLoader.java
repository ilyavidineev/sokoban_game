package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static model.Model.FIELD_CELL_SIZE;

public class LevelLoader {

    private Path levels;

    public LevelLoader(Path levels) {
        this.levels = levels;
    }

    public GameObjects getLevel(int level) {

        int currentLevel = (level % 60 == 0) ? 60 : level % 60;
        String stringLevel = "Maze: " + currentLevel;
        List<String> levelInfo = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(levels.toFile()))) {
            String line = "";
            while (!line.equals(stringLevel)) {
                line = reader.readLine();
            }
            for (int i = 0; i < 7; i++) {
                line = reader.readLine();
            }
            while (!"".equals(line)) {
                levelInfo.add(line);
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Set<Box> boxes = new HashSet<>();
        Set<Wall> walls = new HashSet<>();
        Set<Home> homes = new HashSet<>();
        Player player = null;
        for (int i = 0; i < levelInfo.size(); i++) {
            String wight = levelInfo.get(i);
            for (int j = 0; j < wight.length(); j++) {
                int x = (j == 0) ? FIELD_CELL_SIZE / 2 : (FIELD_CELL_SIZE / 2) + j * FIELD_CELL_SIZE;
                int y = (i == 0) ? FIELD_CELL_SIZE / 2 : (FIELD_CELL_SIZE / 2) + i * FIELD_CELL_SIZE;
                char symbol = wight.charAt(j);
                switch (symbol) {
                    case 'X':
                        walls.add(new Wall(x, y));
                        break;
                    case '*':
                        boxes.add(new Box(x, y));
                        break;
                    case '.':
                        homes.add(new Home(x, y));
                        break;
                    case '&':
                        boxes.add(new Box(x, y));
                        homes.add(new Home(x, y));
                        break;
                    case '@':
                        player = new Player(x, y);
                        break;
                }
            }
        }
        return new GameObjects(walls, boxes, homes, player);
    }
}
