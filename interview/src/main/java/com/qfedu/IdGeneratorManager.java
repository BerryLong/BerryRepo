package com.qfedu;

import java.io.*;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class IdGeneratorManager {
    private static Map<String, IdGenerator> map = null;

    static {
        try (InputStream in = new FileInputStream("generators")) {
            ObjectInputStream ois = new ObjectInputStream(in);
            map = (Map<String, IdGenerator>) ois.readObject();
        } catch (FileNotFoundException e) {
            map = new ConcurrentHashMap<>();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    static {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try (OutputStream out = new FileOutputStream("generators")) {
                ObjectOutputStream oos = new ObjectOutputStream(out);
                oos.writeObject(map);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }));
    }

    private IdGeneratorManager() {
        throw new AssertionError();
    }

    public static IdGenerator get(String name) {
        return map.get(name);
    }

    public static void save(String name, IdGenerator generator) {
        map.put(name, generator);
    }

    public static void delete(String name) {
        map.remove(name);
    }
}
