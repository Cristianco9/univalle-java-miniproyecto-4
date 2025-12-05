package app.model;

import java.io.*;
import java.nio.file.*;
import java.util.*;

/**
 * Maneja persistencia simple en archivos: usuarios y puntajes.
 */
public class ScoreManager {
    private static final String DATA_DIR = "data";
    private static final String USERS_FILE = DATA_DIR + "/users.txt";
    private static final String SCORES_FILE = DATA_DIR + "/scores.txt";

    public ScoreManager() {
        try {
            Files.createDirectories(Paths.get(DATA_DIR));
            Files.createFile(Paths.get(USERS_FILE));
        } catch (FileAlreadyExistsException ex) {
            // ok
        } catch (IOException e) {
            e.printStackTrace();
        }
        // ensure scores file exists
        try {
            Files.createFile(Paths.get(SCORES_FILE));
        } catch (FileAlreadyExistsException ex) {
            // ok
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean userExists(String name) {
        try (BufferedReader br = new BufferedReader(new FileReader(USERS_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.trim().equalsIgnoreCase(name)) return true;
            }
        } catch (IOException e) { /* ignore */ }
        return false;
    }

    public boolean registerUser(String name) {
        if (userExists(name)) return false;
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(USERS_FILE, true))) {
            bw.write(name);
            bw.newLine();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void saveScore(String name, int score, String category, int level) {
        String record = String.format("%s;%d;%s;level%d;%s", name, score, category, level, new Date().toString());
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(SCORES_FILE, true))) {
            bw.write(record);
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public OptionalInt getBestScore(String name) {
        int best = -1;
        try (BufferedReader br = new BufferedReader(new FileReader(SCORES_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length >= 2 && parts[0].equalsIgnoreCase(name)) {
                    try {
                        int s = Integer.parseInt(parts[1]);
                        if (s > best) best = s;
                    } catch (NumberFormatException ignored) {}
                }
            }
        } catch (IOException e) { /* ignore */ }
        return best >= 0 ? OptionalInt.of(best) : OptionalInt.empty();
    }
}
