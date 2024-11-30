package com.luisdias.projeto_integrador_iv_b.api.model.sgbd;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.locks.ReentrantLock;

/**
 * SGBD JsonDatabase.
 * Classe genérica que implementa operações CRUD sobre o arquivo JSON.
 * Utilização do padrão Singleton, sincronização e File Lock para
 * gerenciar o acesso único ao arquivo.
 * A entidade a ser persistida deve implementar a interface {@link Identificador}.
 *
 * @param <T> Tipo da entidade persistida.
 * @param <K> Tipo da ID da entidade.
 */
@Component
public class JsonDatabase<T extends Identificador<K>, K> {
    private final ObjectMapper objectMapper;
    private final ReentrantLock lock;

    // Instância Singleton
    private final static JsonDatabase<?, ?> instance = new JsonDatabase<>();

    // Construtor privado para Singleton
    private JsonDatabase() {
        this.objectMapper = new ObjectMapper();
        this.lock = new ReentrantLock();
    }

    /**
     * Método para obter a instância Singleton.
     *
     * @return Conexão com o banco de dados.
     */
    @SuppressWarnings("unchecked")
    public synchronized JsonDatabase<T, K> dbConnection() {
        return (JsonDatabase<T, K>) instance;
    }

    /**
     * Busca um registro no arquivo JSON com referência no ID.
     *
     * @param key   ID a ser buscado.
     * @param clazz Classe da entidade, usada como referência para criação e recuperação
     *              do arquivo JSON.
     * @return Em caso de sucesso retorna um objeto do tipo especificado
     * ou {@code null} caso contrário.
     */
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

    /**
     * Busca todos o registros da classe especificada no arquivo JSON.
     *
     * @param clazz Classe da entidade, usada como referência para criação e recuperação
     *              do arquivo JSON.
     * @return Lista dos registros encontrados. Pode retornar uma lista vazia.
     */
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

    /**
     * Verifica a existência de um registro do objeto passado como parâmetro.
     *
     * @param t Objeto à verificar.
     * @return Retorna {@code True} caso encontre um registro ou {@code False} caso contrário.
     */
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

    /**
     * Insere um novo registro no arquivo da classe de referência.
     *
     * @param t Objeto à ser inserido no arquivo.
     * @return Retorna o objeto.
     */
    @SuppressWarnings("unchecked")
    public T insert(T t) {
        lock.lock();
        try {
            Class<T> clazz = (Class<T>) t.getClass();
            List<T> allData = readFromFile((clazz));
            if (allData.stream().anyMatch(item -> item.equals(t))) {
                throw new IOException("Registro já existe no banco de dados");
            }
            allData.add(t);
            writeToFile(allData, clazz);
            return t;

        } catch (IOException e) {
            throw new RuntimeException("Falha ao inserir o item", e);
        } finally {
            lock.unlock();
        }
    }

    /**
     * Atualiza um registro no arquivo JSON.
     *
     * @param t Objeto à ser atualizado.
     * @return Objeto atualizado.
     */
    @SuppressWarnings("unchecked")
    public T update(T t) {
        lock.lock();
        try {
            Class<T> clazz = (Class<T>) t.getClass();
            List<T> allData = readFromFile(clazz);

            for (int i = 0; i < allData.size(); i++) {
                if (allData.get(i).equals(t)) {
                    allData.set(i, t);
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

    /**
     * Deleta um registro com base no ID.
     *
     * @param key ID do registro à ser deletado.
     * @param clazz Classe da entidade, usada como referência para criação e recuperação
     *      do arquivo JSON.
     * @return Retorna {@code True} em caso de sucesso ou {@code False} caso contrário.
     */
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
