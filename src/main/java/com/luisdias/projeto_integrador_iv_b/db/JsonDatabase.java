package com.luisdias.projeto_integrador_iv_b.db;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.locks.ReentrantLock;

// Classe genérica que implementa operações CRUD sobre o arquivo JSON
// Utilização do padrão Singleton para gerenciar o acesso único ao arquivo
@Component
public class JsonDatabase<T extends Identificador<K>, K>{
    private final ObjectMapper objectMapper;
    private final ReentrantLock lock;

    // Instância Singleton
    private final static JsonDatabase<?, ?> instance = new JsonDatabase<>();

    // Construtor privado para Singleton
    private JsonDatabase() {
        this.objectMapper = new ObjectMapper();
        this.lock = new ReentrantLock();
    }

    // Método para obter a instância Singleton
    @SuppressWarnings("unchecked")
    public synchronized JsonDatabase<T, K> dbConnection() {
        return (JsonDatabase<T, K>) instance;
    }

    // Método para encontrar um objeto por ID
    public T find(K key, Class<T> clazz) {
        lock.lock();
        try {
            List<T> allData = readFromFile(clazz);
            return allData.stream()
                    .filter(item -> item.getId().equals(key))
                    .findFirst().orElse(null);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }

    // Método para retornar todos os objetos do arquivo
    public List<T> findAll(Class<T> clazz) {
        lock.lock();
        try {
            return readFromFile(clazz);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }

    // Método para verificar se um objeto existe
    @SuppressWarnings("unchecked")
    public boolean exists(T t) {
        lock.lock();
        try {
            List<T> allData = readFromFile((Class<T>) t.getClass());
            return allData.stream().anyMatch(item -> item.equals(t));
        } catch (IOException e) {
            System.out.println("Erro ao verificar a existência no arquivo JSON");
            return false;
        } finally {
            lock.unlock();
        }
    }

    // Método para inserir um novo objeto no arquivo
    @SuppressWarnings("unchecked")
    public T insert(T t) {
        lock.lock();
        try {
            Class<T> clazz = (Class<T>) t.getClass();
            List<T> allData = readFromFile((clazz));
            allData.add(t);
            writeToFile(allData, clazz);
            return t;

        } catch (IOException e) {
            System.out.println("Erro ao inserir no arquivo JSON");
            throw new RuntimeException("Falha ao inserir o item", e);
        } finally {
            lock.unlock();
        }
    }

    // Método para atualizar um objeto existente no arquivo
    @SuppressWarnings("unchecked")
    public T update(T t) {
        lock.lock();
        try {
            Class<T> clazz = (Class<T>) t.getClass();
            List<T> allData = readFromFile(clazz);

            for (int i = 0; i < allData.size(); i++) {
                if (allData.get(i).equals(t)) {
                    allData.set(i, t); // Atualiza o item existente
                    writeToFile(allData, (clazz));
                    return t;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Falha ao atualizar o item", e);
        } finally {
            lock.unlock();
        }
        throw new NoSuchElementException("Registro nao encontrado");
    }

    // Método para deletar um objeto pelo ID
    public boolean delete(K key, Class<T> clazz) {
        lock.lock();
        try {
            List<T> allData = readFromFile(clazz);
            boolean removed = allData.removeIf(item -> item.getId().equals(key));

            if (removed) {
                writeToFile(allData, clazz);
            }
            return removed;
        } catch (IOException e) {
            System.out.println("Erro ao deletar do arquivo JSON");
            return false;
        } finally {
            lock.unlock();
        }
    }

    // Método auxiliar para ler a lista do arquivo JSON
    private List<T> readFromFile(Class<T> clazz) throws IOException {
        File jsonFile = new File("src/main/resources/db/" + clazz.getSimpleName().toLowerCase() + ".json");

        if (!jsonFile.exists() || Files.size(jsonFile.toPath()) == 0) {
            return new ArrayList<>();
        }

        // Utiliza TypeFactory para construir um TypeReference com a classe fornecida
        return objectMapper.readValue(jsonFile, objectMapper.getTypeFactory().constructCollectionType(List.class, clazz));
    }

    // Método auxiliar para salvar a lista no arquivo JSON
    private synchronized void writeToFile(List<T> data, Class<T> clazz) throws IOException {
        File jsonFile = new File("src/main/resources/db/" + clazz.getSimpleName().toLowerCase() + ".json");

        if (!jsonFile.exists()) {
            // Cria os diretórios necessários, caso não existam
            jsonFile.getParentFile().mkdirs();

            // Cria o arquivo JSON vazio
            jsonFile.createNewFile();
        }

        objectMapper.writerWithDefaultPrettyPrinter().writeValue(jsonFile, data);
    }
}
