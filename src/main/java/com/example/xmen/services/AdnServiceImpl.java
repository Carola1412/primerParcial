package com.example.xmen.services;


import com.example.xmen.entities.Adn;
import com.example.xmen.repositories.AdnRepository;
import com.example.xmen.repositories.BaseRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AdnServiceImpl extends BaseServiceImpl<Adn, Long> implements AdnService {

    @Autowired
    private AdnRepository adnRepository;

    public AdnServiceImpl(BaseRepository<Adn, Long> baseRepository) {

        super(baseRepository);
    }

    private static final int SEQUENCE_LENGTH = 4;

    @Override
    public boolean isMutant(String[] adnSequence) {
        // Verificar que la matriz sea cuadrada
        int n = adnSequence.length;
        if (!esMatrizCuadrada(adnSequence, n)) {
            throw new IllegalArgumentException("La matriz de ADN debe ser cuadrada.");
        }

        // Verificar que las letras sean válidas
        validarLetrasADN(adnSequence, n);

        // Contar secuencias encontradas
        int sequencesFound = 0;

        // Buscar secuencias horizontales, verticales y oblicuas
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (checkHorizontal(adnSequence, i, j) || checkVertical(adnSequence, i, j) ||
                        checkDiagonal(adnSequence, i, j) || checkAntiDiagonal(adnSequence, i, j)) {
                    sequencesFound++;
                }
                if (sequencesFound > 1) {
                    return true; // Es mutante si encuentra más de una secuencia
                }
            }
        }
        return false; // Si no encuentra más de una secuencia, es humano
    }

    // Verifica si la matriz es cuadrada
    private boolean esMatrizCuadrada(String[] adn, int n) {
        for (String row : adn) {
            if (row.length() != n) {
                return false;
            }
        }
        return true;
    }

    // Valida que las letras del ADN sean A, T, C o G
    private void validarLetrasADN(String[] adn, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                char base = adn[i].charAt(j);
                if (base != 'A' && base != 'T' && base != 'C' && base != 'G') {
                    throw new IllegalArgumentException("El ADN contiene letras inválidas. Solo se permiten A, T, C, G.");
                }
            }
        }
    }

    // Métodos para las diferentes verificaciones
    private boolean checkHorizontal(String[] adn, int row, int col) {
        if (col + SEQUENCE_LENGTH - 1 >= adn.length) return false;
        char base = adn[row].charAt(col);
        for (int i = 1; i < SEQUENCE_LENGTH; i++) {
            if (base != adn[row].charAt(col + i)) return false;
        }
        return true;
    }

    private boolean checkVertical(String[] adn, int row, int col) {
        if (row + SEQUENCE_LENGTH - 1 >= adn.length) return false;
        char base = adn[row].charAt(col);
        for (int i = 1; i < SEQUENCE_LENGTH; i++) {
            if (base != adn[row + i].charAt(col)) return false;
        }
        return true;
    }

    private boolean checkDiagonal(String[] adn, int row, int col) {
        if (row + SEQUENCE_LENGTH - 1 >= adn.length || col + SEQUENCE_LENGTH - 1 >= adn.length) return false;
        char base = adn[row].charAt(col);
        for (int i = 1; i < SEQUENCE_LENGTH; i++) {
            if (base != adn[row + i].charAt(col + i)) return false;
        }
        return true;
    }

    private boolean checkAntiDiagonal(String[] adn, int row, int col) {
        if (row + SEQUENCE_LENGTH - 1 >= adn.length || col - SEQUENCE_LENGTH + 1 < 0) return false;
        char base = adn[row].charAt(col);
        for (int i = 1; i < SEQUENCE_LENGTH; i++) {
            if (base != adn[row + i].charAt(col - i)) return false;
        }
        return true;
    }


    @Transactional
    public Map<String, Object> getStats() { //En este metodo uso Map porque es similar a un JSON

        float countMutantAdn = adnRepository.countBymutanteTrue();
        float countHumanAdn = adnRepository.countBymutanteFalse();


        Map<String, Object> stats = new HashMap<>();
        stats.put("count_mutant_adn", countMutantAdn);
        stats.put("count_human_dna", countHumanAdn);
        stats.put("ratio", countHumanAdn == 0 ? 0 : countMutantAdn / countHumanAdn);

        return stats;
    }
}
